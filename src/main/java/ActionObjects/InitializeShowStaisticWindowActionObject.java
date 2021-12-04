package ActionObjects;

public class InitializeShowStaisticWindowActionObject implements ActionObject {
    private String functionCall;
    private String userID;

    public InitializeShowStaisticWindowActionObject(String userID) {
        functionCall = "initialize";
        this.userID = userID;

    }

    @Override
    public String getFunctionCall() {
        return functionCall;
    }

    public String getUserID(){
        return this.userID;
    }
}
