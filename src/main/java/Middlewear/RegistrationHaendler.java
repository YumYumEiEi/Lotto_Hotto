package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.RegisterActionObject;
import Backend.Backend;
import BackendObjects.Adress;
import BackendObjects.BankAccount;
import BackendObjects.User;
import Frontend.Frontend;
import Frontend.RegistrationFrontend;
import Frontend.LoginFrontend;

import java.lang.reflect.Field;

public class RegistrationHaendler extends RegistrationMiddlewear {
    private RegistrationFrontend frontend;
    private Backend backend;

    public RegistrationHaendler(RegistrationFrontend frontend, Backend backend){
        this.frontend = frontend;
        this.backend = backend;
    }

    @Override
    protected void registrate(RegisterActionObject registerInfo) {
        if(!backend.isUsernameUnique(registerInfo.getUsername())) {
            frontend.showUsernameNotUniqueMessage();
        }else if(!registerInfo.getPassword().equals(registerInfo.getConfirmedPassword())){
            frontend.showDifferentPasswordMessage();
        }else if(registerInfo.hasEmptyField()) {
            frontend.showMissingFieldMessage();
        }else{
            backend.saveNewUser(
                    new User(registerInfo.getTitle(),registerInfo.getFirstName(), registerInfo.getSecondName(),
                            registerInfo.getUsername(), registerInfo.getPassword(), "registerInfo.getBirthdate",
                            registerInfo.getStreet(), registerInfo.getPlz(), "registerInfo.getCity", "registerInfo.getBankAccount()",
                            "registerInfo.getIsAdmin()"));
        }
    }

    @Override
    public void heandleAction(ActionObject performedAction) {
        String calledFunction = performedAction.getFunctionCall();

        switch(calledFunction){
            case "register":
                registrate((RegisterActionObject) performedAction);
                break;
        };
    }
}
