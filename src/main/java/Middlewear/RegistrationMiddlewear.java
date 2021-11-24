package Middlewear;

import ActionObjects.RegisterActionObject;
import Backend.Backend;
import Frontend.RegistrationFrontend;

public abstract class RegistrationMiddlewear implements Middlewear{

    protected RegistrationFrontend frontend;
    protected Backend backend;

    protected abstract void registrate (RegisterActionObject registerInfo);
}
