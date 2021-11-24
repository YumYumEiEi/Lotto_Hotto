package Frontend;

import ActionObjects.ActionObject;
import ActionObjects.RegisterActionObject;
import Backend.TestBackend;
import Middlewear.LoginHeandler;
import Middlewear.RegistrationHaendler;
import Middlewear.RegistrationMiddlewear;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationWindow extends Application implements RegistrationFrontend {

    Mediator mediator;
    RegistrationMiddlewear registrationMiddlewear;
    RegistrationWindowController controller;

    @Override
    public void start(Stage stage) throws Exception {

    }

    @Override
    public void start ( Stage stage, Mediator mediator) throws IOException {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/RegisterWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Registration");
        stage.setScene(new Scene(root, 500, 1000));
        stage.show();

        controller = loader.getController();
        controller.setBackToLoginHandler(new BackToLoginButtonHandler());
        controller.setConfirmRegistrationHandler(new ConfirmRegistrationButtonHandler());

        controller.initializeTitelBox();

        registrationMiddlewear = new RegistrationHaendler(this, mediator.getBackend());
    }

    @Override
    public void actionPerformed(ActionObject action) {
        registrationMiddlewear.heandleAction(action);
    }

    private void startLogin(){
        try {
            mediator.startLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showUsernameNotUniqueMessage() {
        controller.showUserNotUniqueMessage();
    }

    @Override
    public void showDifferentPasswordMessage() {
        controller.showDifferentPasswordMessage();
    }

    @Override
    public void showMissingFieldMessage() {
        controller.showMissingFieldErrorMessage();
    }

    public class ConfirmRegistrationButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            RegisterActionObject action =
                    new RegisterActionObject(
                            "register",
                            controller.getUsername(),
                            controller.getPassword(),
                            controller.getConfirmedPassword(),
                            controller.getTitel(),
                            controller.getFirstName(),
                            controller.getLastName(),
                            controller.getStreet(),
                            controller.getTown(),
                            controller.getPlz(),
                            controller.getBankAccountName(),
                            controller.getIban(),
                            controller.getBic()
                            );
            actionPerformed(action);
            startLogin();
        }
    }

    public class BackToLoginButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            startLogin();
        }
    }
}
