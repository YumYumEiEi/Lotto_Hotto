package Frontend;

import Backend.Backend;
import BackendObjects.User;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class LoginAndRegistarationTests extends ApplicationTest {
    Mediator mediator = new Mediator();
    Backend testBackend;

    @Override
    public void start(Stage stage) throws Exception{
        testBackend = mediator.getBackend();
        mediator.start(stage);
    }

    @Test
    public void shouldOpenMainWindowIfITryToLoginWithExistingAccount(){
        User testUser = createTestAccount();

        Parent parent = mediator.getScene().getRoot();
        clickOn(NodeFinder.findeNode(parent, "usernameField"));
        write("Peter");

        clickOn(NodeFinder.findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(NodeFinder.findeNode(parent, "loginButton"));

        assertEquals(mediator.getPrimaryStage().getTitle(), "Lotto Hotto");

        deleteTestAccount(testUser);

    }

    @Test
    public void shouldShowUserNotFoundDialogWhenIfLoginFaild(){
        Parent parent = mediator.getScene().getRoot();
        clickOn(NodeFinder.findeNode(parent, "usernameField"));
        write("Susanne");

        clickOn(NodeFinder.findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(NodeFinder.findeNode(parent, "loginButton"));

        verifyThat("Benutzer nicht gefunden" , NodeMatchers.isVisible());
    }

    @Test
    public void sholdOpenRegisterWindowIfIClickOnTheRegisterButton(){
        Parent parent = mediator.getScene().getRoot();
        clickOn(NodeFinder.findeNode(parent, "registerButton"));

        assertEquals(mediator.getPrimaryStage().getTitle(), "Registration");
    }

    @Test
    public void shouldRegistrateAUserSoHeCanBeFoundInTheDatabase(){
        Parent parent = mediator.getScene().getRoot();
        clickOn(NodeFinder.findeNode(parent, "registerButton"));

        parent = mediator.getScene().getRoot();
        clickOn(NodeFinder.findeNode(parent, "usernameField"));
        write("Susanne");

        clickOn(NodeFinder.findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(NodeFinder.findeNode(parent, "secondPasswordField"));
        write("1234wasd");

        clickOn(NodeFinder.findeNode(parent, "firstNameField" ));
        write("Susanne");

        clickOn(NodeFinder.findeNode(parent, "secondNameField"));
        write("Potrokolla");

        clickOn(NodeFinder.findeNode(parent, "birthdateTextField"));
        write("07.08.1994");

        clickOn(NodeFinder.findeNode(parent, "streetField"));
        write("Auchsbacher Weg 85");

        clickOn(NodeFinder.findeNode(parent, "cityField"));
        write("Berlin");

        clickOn(NodeFinder.findeNode(parent, "plzField"));
        write("12345");

        clickOn(NodeFinder.findeNode(parent, "ibanField"));
        write("DE123450000293920");

        clickOn(NodeFinder.findeNode(parent, "titelComboBox"));
        clickOn("Frau");

        clickOn(NodeFinder.findeNode(parent, "acceptButton"));

        assertEquals( false, testBackend.isUsernameUnique("Susanne"));

    }

    private User createTestAccount() {
        User testUser = new User(testBackend.getNextUserID(), "Herr", "Peter" ,"Peterson", "1234wasd",
                "Berlin", "01.01.1000", "DE900005000300201", "false", "Berliner Straße 33",
                "12345", "Peter");
        testBackend.saveNewUser(testUser);

        return testUser;
    }

    private void deleteTestAccount(User testUser) {
        testBackend.deleteUser(testUser);
    }



}
