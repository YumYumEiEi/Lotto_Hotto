package Frontend;

public interface RegistrationFrontend extends FrontendWithController {

    void showUsernameNotUniqueMessage();

    void showDifferentPasswordMessage();

    void showMissingFieldMessage();
}
