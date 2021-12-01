package Frontend;

import BackendObjects.Tipp;
import BackendObjects.TippTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowTippWindowController {

    @FXML
    private TableView<TippTableView> tippTabel;

    @FXML
    private TableColumn<TippTableView, String> dateColumn;

    @FXML
    private TableColumn<TippTableView, String> numberColumn;

    @FXML
    private TableColumn<TippTableView, String> bonusnumberColumn;

    @FXML
    private TableColumn<TippTableView, String> drawingColumn;

    @FXML
    private TableColumn<TippTableView, String> drawingBonusnumber;

    @FXML
    private TableColumn<TippTableView, String> winnerclassColumn;

    @FXML
    private TableColumn<TippTableView, String> moneyColumn;

    public void fillTippTable(TippTableView[] tippsFromUser) {
        ObservableList<TippTableView> allTipps = FXCollections.observableArrayList(tippsFromUser);
        dateColumn.setCellValueFactory(new PropertyValueFactory<TippTableView, String>("drawingDate"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<TippTableView, String>("numbers"));
        bonusnumberColumn.setCellValueFactory(new PropertyValueFactory<TippTableView, String>("bonusnumber"));
        drawingColumn.setCellValueFactory(new PropertyValueFactory<TippTableView, String>("drawingNumbers"));
        drawingBonusnumber.setCellValueFactory(new PropertyValueFactory<TippTableView, String>("drawingBonusnumber"));
        winnerclassColumn.setCellValueFactory(new PropertyValueFactory<TippTableView, String>("winnerClass"));
        moneyColumn.setCellValueFactory(new PropertyValueFactory<TippTableView, String>("winnerMoney"));
        tippTabel.setItems(allTipps);

    }
}
