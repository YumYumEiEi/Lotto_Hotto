package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.LoginActionObject;
import Backend.Backend;
import BackendObjects.User;
import Frontend.Frontend;
import Frontend.LoginFrontend;

public class LoginHeandler extends LoginMiddelwear {
    private LoginFrontend frontend;
    private Backend backend;

    public LoginHeandler(LoginFrontend frontend, Backend backend){
        this.backend = backend;
        this.frontend = frontend;
    }

    @Override
    public void heandleAction(ActionObject performedAction) {
        String functionCall = performedAction.getFunctionCall();

        switch (functionCall){
            case "login":
                login((LoginActionObject) performedAction);
                break;
        }
    }

    @Override
    protected void login(LoginActionObject loginInfo) {
        User foundUser = backend.getUser(loginInfo.getUsername(), loginInfo.getPassword());

        if(foundUser == null){
            frontend.showUserNotFoundMessage();
        }else{
            frontend.goToMainWindow(foundUser);
        }
    }

}
