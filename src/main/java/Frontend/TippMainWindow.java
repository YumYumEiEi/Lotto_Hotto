package Frontend;

import ActionObjects.ActionObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TippMainWindow extends Application implements TippMainFrontend {

    Mediator mediator;
    TippMainWindowController controller;
    @Override
    public void start(Stage stage, Mediator mediator) throws Exception {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/TippMainWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Lotto Hotto");
        stage.setScene(new Scene(root, 500, 230));
        stage.show();

        controller = loader.getController();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
