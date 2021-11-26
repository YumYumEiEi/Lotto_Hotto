package Frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.lang.reflect.Field;

public class GiveTippsWindowController {

    @FXML
    private Button bt_01;

    @FXML
    private Button bt_02;

    @FXML
    private Button bt_03;

    @FXML
    private Button bt_04;

    @FXML
    private Button bt_05;

    @FXML
    private Button bt_06;

    @FXML
    private Button bt_07;

    @FXML
    private Button bt_08;

    @FXML
    private Button bt_09;

    @FXML
    private Button bt_10;

    @FXML
    private Button bt_11;

    @FXML
    private Button bt_12;

    @FXML
    private Button bt_13;

    @FXML
    private Button bt_14;

    @FXML
    private Button bt_15;

    @FXML
    private Button bt_16;

    @FXML
    private Button bt_17;

    @FXML
    private Button bt_18;

    @FXML
    private Button bt_19;

    @FXML
    private Button bt_20;

    @FXML
    private Button bt_21;

    @FXML
    private Button bt_22;

    @FXML
    private Button bt_23;

    @FXML
    private Button bt_24;

    @FXML
    private Button bt_25;

    @FXML
    private Button bt_26;

    @FXML
    private Button bt_27;

    @FXML
    private Button bt_28;

    @FXML
    private Button bt_29;

    @FXML
    private Button bt_30;

    @FXML
    private Button bt_31;

    @FXML
    private Button bt_32;

    @FXML
    private Button bt_33;

    @FXML
    private Button bt_34;

    @FXML
    private Button bt_35;

    @FXML
    private Button bt_36;

    @FXML
    private Button bt_37;

    @FXML
    private Button bt_38;

    @FXML
    private Button bt_39;

    @FXML
    private Button bt_40;

    @FXML
    private Button bt_41;

    @FXML
    private Button bt_42;

    @FXML
    private Button bt_43;

    @FXML
    private Button bt_44;

    @FXML
    private Button bt_45;

    @FXML
    private Button bt_46;

    @FXML
    private Button bt_47;

    @FXML
    private Button bt_48;

    @FXML
    private Button bt_49;

    @FXML
    private Button bts_01;

    @FXML
    private Button bts_02;

    @FXML
    private Button bts_03;

    @FXML
    private Button bts_04;

    @FXML
    private Button bts_05;

    @FXML
    private Button bts_06;

    @FXML
    private Button bts_07;

    @FXML
    private Button bts_08;

    @FXML
    private Button bts_09;

    @FXML
    private Button confirmButton;

    @FXML
    private Button backButton;

    public void showTippAlreaddyThereErrorMessage() {
    }

    public void showNotSevenNumbersPickedErrorMessage() {
    }

    public void showSuperzahlNotPickedErrorMessage() {
    }

    public void addConfirmButtonActionHandler(GiveTippsWindow.ConfirmButtonActionHandler confirmButtonActionHandler) {
        this.confirmButton.setOnMouseClicked(confirmButtonActionHandler);
    }

    public void addNumberButtonHandler(GiveTippsWindow.NumberbuttonHandler numberbuttonHandler) {
        Field[] allFields =  this.getClass().getDeclaredFields();
        Button button = new Button();
        for(Field field : allFields){
            if(field.getClass().equals(Button.class)){
                try {
                    button = (Button) field.get(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                button.setOnMouseClicked(numberbuttonHandler);
            }
        }
    }
}
