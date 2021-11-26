package ActionObjects;

import BackendObjects.User;

import java.util.ArrayList;

public class TippActionObject implements ActionObject {
    private final String[] tippedNumbers;
    private final String functionCall;
    private final String superzahl;
    private final User currendUser;

    public TippActionObject( String[] tippedNumbers, String superzahl, User currendUser) {
        this.tippedNumbers = tippedNumbers;
        this.functionCall = "giveTipp";
        this.superzahl = superzahl;
        this.currendUser = currendUser;
    }

    @Override
    public String getFunctionCall() {
        return this.functionCall;
    }

    public String[] getTippedNumbers(){
        return this.tippedNumbers;
    }

    public String getSuperzahl(){
        return this.superzahl;
    }

    public String getUserID() { return  currendUser.getId();}
}
