package Frontend;

import ActionObjects.ActionObject;
import ActionObjects.LoginActionObject;
import Backend.TestBackend;
import BackendObjects.User;
import Middlewear.LoginHeandler;
import Middlewear.LoginMiddelwear;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginWindow extends Application implements LoginFrontend {
    private LoginWindowController controller;
    private LoginMiddelwear middlewear;
    private Mediator mediator;


    @Override
    public void start(Stage stage) throws Exception {
    }

    @Override
    public void start(Stage stage, Mediator mediator) throws Exception {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/LoginWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 500, 230));
        stage.show();

        controller = loader.getController();
        controller.setEnterKeyHandler(new LoginAction());
        controller.setLoginButtonHandler(new LoginAction());
        controller.setRegisterButtonHandler(new RegisterButtonHandler());

        middlewear = new LoginHeandler(this, mediator.getBackend());
    }

    @Override
    public void showUserNotFoundMessage() {
        controller.showUserNotFoundError();
    }

    @Override
    public void goToMainWindow(User aktiveUser) {
        mediator.setUser(aktiveUser);
        try{
            this.mediator.startMain();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void goToRegisterWindow() {
        try {
            this.mediator.startRegistration();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionObject action) {
       middlewear.heandleAction(action);
    }

    public void tryToLogin(){
        LoginActionObject action = new LoginActionObject("login", controller.getUsername(), controller.getPassword());
        actionPerformed(action);
    }

    public class LoginAction implements EventHandler {

        @Override
        public void handle(Event event) {
            tryToLogin();
        }
    }

    public class RegisterButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            goToRegisterWindow();
        }
    }

}
