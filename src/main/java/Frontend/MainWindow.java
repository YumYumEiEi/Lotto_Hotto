package Frontend;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainWindow extends Application implements MainFrontend {
    private Mediator mediator;
    private MainWindowController controller;

    @Override
    public void start(Stage stage, Mediator mediator) throws Exception {
        this.mediator = mediator;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/MainWindow.fxml"));
        Parent root = loader.load();
        stage.setTitle("Lotto Hotto");
        stage.setScene(new Scene(root, 500, 230));
        stage.show();

        controller = loader.getController();
        controller.addTippButtonHandler(new TipButtonHandler());
        controller.addProfileButtonHandler(new ProfielButtonHandler());
        controller.addStatisticButtonHandler(new StatisticButtonHandler());
    }

    private void startTippMain(){
        try {
            mediator.startTippsMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public class ProfielButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            mediator.startProfileOptions();
        }
    }

    public class StatisticButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            mediator.startStatistics();
        }
    }

    public class TipButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            startTippMain();
        }
    }
}
