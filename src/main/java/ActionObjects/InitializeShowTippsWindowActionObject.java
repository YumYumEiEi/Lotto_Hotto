package ActionObjects;

public class InitializeShowTippsWindowActionObject implements ActionObject {

    private String functionCall;
    private String userID;

    public InitializeShowTippsWindowActionObject(String userID){
        this.functionCall = "initialize";
        this.userID = userID;
    }

    @Override
    public String getFunctionCall() {
        return functionCall;
    }

    public String getUserID() {
        return this.userID;
    }
}
