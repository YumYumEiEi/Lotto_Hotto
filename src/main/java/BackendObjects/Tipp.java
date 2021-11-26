package BackendObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tipp {
    private final String[] allTippedNumbers;
    private final StringProperty bonusNumber;
    private final StringProperty username;
    private final StringProperty drawDate;


    public Tipp(String[] allTippedNumbers, String bonusNumber, String username, String drawDate) {
        this.allTippedNumbers = allTippedNumbers;
        this.bonusNumber = new SimpleStringProperty(bonusNumber);
        this.username = new SimpleStringProperty(username);
        this.drawDate = new SimpleStringProperty(drawDate);
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

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getDrawDate() {
        return drawDate.get();
    }

    public StringProperty drawDateProperty() {
        return drawDate;
    }

}
