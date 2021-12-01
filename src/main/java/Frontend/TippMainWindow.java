package Frontend;

import ActionObjects.ActionObject;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
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
        stage.setTitle("Tipp Main");
        stage.setScene(new Scene(root, 370, 430));
        stage.show();

        controller = loader.getController();
        controller.addGiveTippButtonListener(new GoToGiveATippButtonHandler());
        controller.addShowTippButtonListener( new GoToShowTippsButonHandler());
    }

    private void startGiveATippWindow(){
        try {
            mediator.startGiveTippWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startShowTippsWindow(){
        try{
            mediator.startShowTippWindow();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public class GoToGiveATippButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            startGiveATippWindow();
        }
    }

    public class GoToShowTippsButonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            startShowTippsWindow();
        }
    }
}
