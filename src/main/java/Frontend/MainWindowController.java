package Frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainWindowController {

    @FXML
    private Button profileButton;

    @FXML
    private Button statisticButton;

    @FXML
    private Button tipButton;

    public void addTippButtonHandler(MainWindow.TipButtonHandler tipButtonHandler) {
        this.tipButton.setOnMouseClicked(tipButtonHandler);
    }

    public void addProfileButtonHandler(MainWindow.ProfielButtonHandler profielButtonHandler) {
        this.profileButton.setOnMouseClicked(profielButtonHandler);
    }

    public void addStatisticButtonHandler(MainWindow.StatisticButtonHandler statisticButtonHandler) {
        this.statisticButton.setOnMouseClicked(statisticButtonHandler);
    }
}
