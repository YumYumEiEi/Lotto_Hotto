package BackendObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Drawing {
    private final StringProperty id;
    private final StringProperty numbers;
    private final StringProperty bonusNumber;
    private final StringProperty drawDate;

    public Drawing(String id, String numbers, String bonusNumber, String drawDate) {
        this.id = new SimpleStringProperty(id);
        this.numbers = new SimpleStringProperty(numbers);
        this.bonusNumber = new SimpleStringProperty(bonusNumber);
        this.drawDate = new SimpleStringProperty(drawDate);

    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getNumbers() {
        return numbers.get();
    }

    public StringProperty numbersProperty() {
        return numbers;
    }

    public String getBonusNumber() {
        return bonusNumber.get();
    }

    public StringProperty bonusNumberProperty() {
        return bonusNumber;
    }

    public String getDrawDate() {
        return drawDate.get();
    }

    public StringProperty drawDateProperty() {
        return drawDate;
    }
}
