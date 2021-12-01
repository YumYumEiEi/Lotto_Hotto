package BackendObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tipp {
    private final String[] allTippedNumbers;
    private final StringProperty bonusNumber;
    private final StringProperty userID;
    private final StringProperty drawID;


    public Tipp(String[] allTippedNumbers, String bonusNumber, String userID, String drawID) {
        this.allTippedNumbers = allTippedNumbers;
        this.bonusNumber = new SimpleStringProperty(bonusNumber);
        this.userID = new SimpleStringProperty(userID);
        this.drawID = new SimpleStringProperty(drawID);
    }
    public String[] getAllTippedNumbers() {
        return allTippedNumbers;
    }

    public String getBonusNumber() {
        return bonusNumber.get();
    }

    public StringProperty bonusNumberProperty() {
        return bonusNumber;
    }

    public String getUserID() {
        return userID.get();
    }

    public StringProperty userIDProperty() {
        return userID;
    }

    public String getDrawID() {
        return drawID.get();
    }

    public StringProperty drawIDProperty() {
        return drawID;
    }

}