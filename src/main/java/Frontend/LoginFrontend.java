package Frontend;

import BackendObjects.User;

public interface LoginFrontend extends FrontendWithController {

    void showUserNotFoundMessage();

    void goToMainWindow(User user);

    void goToRegisterWindow();
}
