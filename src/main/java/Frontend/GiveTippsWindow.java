package Frontend;

import ActionObjects.ActionObject;
import Middlewear.GiveTippsHandler;
import Middlewear.GiveTippsMiddlewear;
import Middlewear.LoginHeandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GiveTippsWindow implements GiveTippsFrontend {

    Mediator mediator;
    GiveTippsWindowController controller;
    GiveTippsMiddlewear middlewear;

    @Override
    public void start(Stage stage, Mediator mediator) throws Exception {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/GiveTippWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 500, 230));
        stage.show();

        controller = loader.getController();

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
    public void actionPerformed(ActionObject action) {

    }
}
