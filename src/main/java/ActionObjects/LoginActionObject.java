package ActionObjects;

import ActionObjects.ActionObject;

public class LoginActionObject implements ActionObject {

    private final String functionCall;
    private final String username;
    private final String password;

    public LoginActionObject(String functionCall, String username, String password) {
        this.functionCall = functionCall;
        this.username = username;
        this.password = password;
    }

    @Override
    public String getFunctionCall() {
        return this.functionCall;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}
