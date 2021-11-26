package Frontend;

import BackendObjects.User;

public interface GiveTippsFrontend extends FrontendWithController {

    void startTippMainWindow();

    void startMainWindow();

    void showTippAlreaddyThereErrorMessage();

    void showNotSevenNumbersPickedErrorMessage();

    void showNoSuperzahlPickedErrorMessage();

    User getCurrendUser();
}
