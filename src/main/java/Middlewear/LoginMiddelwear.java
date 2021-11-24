package Middlewear;

import ActionObjects.LoginActionObject;
import Backend.Backend;
import Frontend.LoginFrontend;

public abstract class LoginMiddelwear implements Middlewear {

     protected LoginFrontend frontend;
     protected Backend backend;

     protected abstract void login(LoginActionObject loginData);
}
