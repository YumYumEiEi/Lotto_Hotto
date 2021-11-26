package Backend;

import BackendObjects.Adress;
import BackendObjects.BankAccount;
import BackendObjects.Tipp;
import BackendObjects.User;
import BackendObjects.Drawing;

public interface Backend {
    User getUser(String username, String password);

    void saveNewUser(User user);

    boolean isUsernameUnique(String username);

    Drawing getNextDrawing();

    void saveTipp(Tipp givenTipp);

    boolean isTippAlreaddyGiven(Tipp givenTipp);
}