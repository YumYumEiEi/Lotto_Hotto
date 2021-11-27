package Frontend;

import ActionObjects.ActionObject;
import BackendObjects.User;
import Middlewear.GiveTippsHandler;
import Middlewear.GiveTippsMiddlewear;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GiveTippsWindow implements GiveTippsFrontend {
    private final String MARKED = "-fx-background-color: #00ff00";
    private final String ERROR = "-fx-background-color: #ff0000";

    private final ArrayList<Button> allTippedNumber = new ArrayList<>();
    private Button selectedBousNumber = null;

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
        controller.addBonusNumberButoonHandler(new BonusNumberButtonHandler());

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
    public void showNotSixNumbersPickedErrorMessage() {
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
            if(button.getStyle().equals("")){
                button.setStyle(MARKED);
                allTippedNumber.add(button);

            }else{
                button.setStyle("");
                allTippedNumber.remove(button);
            }

            if(allTippedNumber.size() > 6) {
                for (Button markedButton : allTippedNumber) {
                    markedButton.setStyle(ERROR);
                }
            }else{
                for(Button errorMarkedButton : allTippedNumber){
                    errorMarkedButton.setStyle(MARKED);
                }
            }
        }
    }

    public class BonusNumberButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            Button button = (Button) event.getSource();
            if(button.getStyle().equals("")){
                button.setStyle(MARKED);

                if(selectedBousNumber != null){
                    selectedBousNumber.setStyle("");
                }
                selectedBousNumber = button;
            }else{
                button.setStyle("");
                selectedBousNumber = null;
            }
        }
    }
}
