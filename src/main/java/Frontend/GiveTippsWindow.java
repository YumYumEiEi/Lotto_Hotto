package Frontend;

import ActionObjects.ActionObject;
import BackendObjects.User;
import Middlewear.GiveTippsHandler;
import Middlewear.GiveTippsMiddlewear;
import Middlewear.LoginHeandler;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GiveTippsWindow implements GiveTippsFrontend {
    private final String GREEN = "-fx-background-color: #00ff00";

    Mediator mediator;
    GiveTippsWindowController controller;
    GiveTippsMiddlewear middlewear;

    @Override
    public void start(Stage stage, Mediator mediator) throws Exception {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/GiveTippWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Tippen");
        stage.setScene(new Scene(root, 500, 230));
        stage.show();

        controller = loader.getController();
        controller.addConfirmButtonActionHandler( new ConfirmButtonActionHandler());
        controller.addNumberButtonHandler(new NumberbuttonHandler());

        middlewear = new GiveTippsHandler(this, mediator.getBackend());
    }

    @Override
    public void startTippMainWindow() {

    }

    @Override
    public void startMainWindow() {

    }

    @Override
    public void showTippAlreaddyThereErrorMessage() {
        controller.showTippAlreaddyThereErrorMessage();
    }

    @Override
    public void showNotSevenNumbersPickedErrorMessage() {
        controller.showNotSevenNumbersPickedErrorMessage();
    }

    @Override
    public void showNoSuperzahlPickedErrorMessage() {
        controller.showSuperzahlNotPickedErrorMessage();
    }

    @Override
    public User getCurrendUser() {
        return mediator.getActiveUser();
    }

    @Override
    public void actionPerformed(ActionObject action) {
        middlewear.heandleAction(action);
    }

    public class ConfirmButtonActionHandler implements EventHandler {

        @Override
        public void handle(Event event) {
        }
    }

    public class NumberbuttonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Button button = (Button) event.getSource();
            button.setStyle(GREEN);
        }
    }
}
