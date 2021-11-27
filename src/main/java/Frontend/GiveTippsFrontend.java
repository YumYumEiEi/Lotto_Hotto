package Frontend;

import BackendObjects.User;

public interface GiveTippsFrontend extends FrontendWithController {

    void startTippMainWindow();

    void startMainWindow();

    void showTippAlreaddyThereErrorMessage();

    void showNotSixNumbersPickedErrorMessage();

    void showNoSuperzahlPickedErrorMessage();

    User getCurrendUser();
}
