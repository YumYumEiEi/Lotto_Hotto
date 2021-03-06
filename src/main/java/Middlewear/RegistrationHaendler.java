package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.RegisterActionObject;
import Backend.Backend;
import BackendObjects.User;
import Frontend.RegistrationFrontend;

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
            User newUser = new User(backend.getNextUserID(), registerInfo.getTitle(), registerInfo.getFirstName(), registerInfo.getSecondName(), registerInfo.getPassword(),
                    registerInfo.getTown(), registerInfo.getBirthdate(), registerInfo.getIban(), "false", registerInfo.getStreet(),
                    registerInfo.getPlz(), registerInfo.getUsername());
            backend.saveNewUser(newUser);
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
