package BackendObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TippTableView  {

    private final StringProperty drawingDate;
    private final StringProperty numbers;
    private final StringProperty bonusnumber;
    private final StringProperty drawingNumbers;
    private final StringProperty drawingBonusnumber;
    private final StringProperty winnerClass;
    private final StringProperty winnerMoney;

    public TippTableView(String drawingDate, String numbers, String bonusnumber, String drawingNumbers, String drawingBonusnumber,  String winnerClass, String winnerMoney) {
        this.drawingDate = new SimpleStringProperty(drawingDate);
        this.numbers = new SimpleStringProperty(numbers);
        this.bonusnumber = new SimpleStringProperty(bonusnumber);
        this.drawingNumbers = new SimpleStringProperty(drawingNumbers);
        this.drawingBonusnumber = new SimpleStringProperty(drawingBonusnumber);
        this.winnerClass = new SimpleStringProperty(winnerClass);
        this.winnerMoney = new SimpleStringProperty(winnerMoney);
    }

    public String getDrawingDate() {
        return this.drawingDate.get();
    }

    public String getNumbers(){
        return this.numbers.get();
    }

    public String getBonusnumber(){
        return this.bonusnumber.get();
    }

    public String getDrawingNumbers(){
        return this.drawingNumbers.get();
    }

    public String getDrawingBonusnumber(){
        return this.drawingBonusnumber.get();
    }

    public String getWinnerClass(){
        return this.winnerClass.get();
    }

    public String getWinnerMoney(){
        return this.winnerMoney.get();
    }
}

