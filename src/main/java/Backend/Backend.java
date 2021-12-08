package Backend;

import BackendObjects.Tipp;
import BackendObjects.TippTableView;
import BackendObjects.User;
import BackendObjects.Drawing;

public interface Backend {
    User getUser(String username, String password);

    void saveNewUser(User user);

    void saveNewUserWithId(User user);

    boolean isUsernameUnique(String username);

    Drawing getNextDrawing();

    void saveTipp(Tipp givenTipp);


    boolean isTippAlreaddyGiven(Tipp givenTipp, String userID);

    String getNextUserID();

    TippTableView[] getAllTippsFromUser(String id);

    void deleteUser(User testUser);

    void deleteAllTippsFrom(User user);

    void saveDrawing(Drawing drawing);

    void saveDrawingWithId(Drawing drawing);

    void deleteDrawing(String id);
}