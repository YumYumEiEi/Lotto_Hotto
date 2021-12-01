package Frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TippMainWindowController {

    @FXML
    private Button showTippsButton;

    @FXML
    private Button makeATippButton;

    @FXML
    private Button backToMainPageButton;

    public void addGiveTippButtonListener(TippMainWindow.GoToGiveATippButtonHandler goToGiveATippButtonHandler) {

        this.makeATippButton.setOnMouseClicked(goToGiveATippButtonHandler);
    }

    public void addShowTippButtonListener(TippMainWindow.GoToShowTippsButonHandler goToShowTippsButonHandler) {

        this.showTippsButton.setOnMouseClicked(goToShowTippsButonHandler);
    }
}
