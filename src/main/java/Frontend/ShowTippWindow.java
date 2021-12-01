package Frontend;

import ActionObjects.ActionObject;
import ActionObjects.InitializeShowTippsWindowActionObject;
import BackendObjects.Tipp;
import BackendObjects.TippTableView;
import Middlewear.ShowTippHandler;
import Middlewear.ShowTippMiddlewear;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShowTippWindow extends Application implements ShowTippFrontend {
   private Mediator mediator;
   private ShowTippMiddlewear middlewear;
   private  ShowTippWindowController controller;


    @Override
    public void start(Stage stage, Mediator mediator) throws Exception {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/ShowTippsWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Deine Tipps");
        stage.setScene(new Scene(root, 370, 430));
        stage.show();

        controller = loader.getController();

        middlewear = new ShowTippHandler(this, mediator.getBackend());

        actionPerformed(new InitializeShowTippsWindowActionObject(mediator.getActiveUser().getId()));
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    @Override
    public void actionPerformed(ActionObject action) {
        middlewear.heandleAction(action);
    }

    @Override
    public void fillTippTabel(TippTableView[] tippsFromUser) {
        controller.fillTippTable(tippsFromUser);
    }
}
