package Frontend;

import ActionObjects.ActionObject;
import ActionObjects.InitializeShowStaisticWindowActionObject;
import ActionObjects.InitializeShowTippsWindowActionObject;
import Middlewear.ShowTippHandler;
import Middlewear.StatisticHandler;
import Middlewear.StatisticMiddlewear;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StatisticWindow extends Application implements StatisticFrontend {
    Mediator mediator;
    StatisticMiddlewear middlewear;
    StatisticWindowController controller;

    @Override
    public void actionPerformed(ActionObject action) {

    }

    @Override
    public void start(Stage stage, Mediator mediator) throws Exception {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/StatisticWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Statistiken");
        stage.setScene(new Scene(root, 370, 430));
        stage.show();

        controller = loader.getController();

        middlewear = new StatisticHandler(this, mediator.getBackend());

        actionPerformed(new InitializeShowStaisticWindowActionObject(mediator.getActiveUser().getId()));
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
