package Frontend;

import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class FrontendTests extends ApplicationTest {
    Mediator mediator = new Mediator();

    @Override
    public void start(Stage stage) throws Exception{
        mediator.start(stage);
    }

    @Test
    public void shouldOpenMainWindowIfITryToLoginWithExistingAccount(){
        Parent parent = mediator.getScene().getRoot();
        clickOn(findeNode(parent, "usernameField"));
        write("Peter");

        clickOn(findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(findeNode(parent, "loginButton"));

        assertEquals(mediator.getPrimaryStage().getTitle(), "Lotto Hotto");

    }

    @Test
    public void shouldShowUserNotFoundDialogWhenIfLoginFaild(){
        Parent parent = mediator.getScene().getRoot();
        clickOn(findeNode(parent, "usernameField"));
        write("Susanne");

        clickOn(findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(findeNode(parent, "loginButton"));

        verifyThat("Benutzer nicht gefunden" , NodeMatchers.isVisible());
    }

    @Test
    public void sholdOpenRegisterWindowIfIClickOnTheRegisterButton(){
        Parent parent = mediator.getScene().getRoot();
        clickOn(findeNode(parent, "registerButton"));

        assertEquals(mediator.getPrimaryStage().getTitle(), "Registration");
    }

    @Test
    public void shouldRegistrateAUserSoHeCanLogin(){
        Parent parent = mediator.getScene().getRoot();
        clickOn(findeNode(parent, "registerButton"));

        parent = mediator.getScene().getRoot();
        clickOn(findeNode(parent, "usernameField"));
        write("Susanne");

        clickOn(findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(findeNode(parent, "secondPasswordField"));
        write("1234wasd");

        clickOn(findeNode(parent, "firstNameField" ));
        write("Susanne");

        clickOn(findeNode(parent, "secondNameField"));
        write("Potrokolla");

        clickOn(findeNode(parent, "streetField"));
        write("Auchsbacher Weg 85");

        clickOn(findeNode(parent, "cityField"));
        write("Berlin");

        clickOn(findeNode(parent, "plzField"));
        write("12345");

        clickOn(findeNode(parent, "bancAccountNameField"));
        write("Susanne Potrokolla");

        clickOn(findeNode(parent, "ibanField"));
        write("DE123450000293920");

        clickOn(findeNode(parent, "bicField"));
        write("Was weiß ich wie ne Bic aussieht");

        clickOn(findeNode(parent, "titelComboBox"));
        clickOn("Frau");

        clickOn(findeNode(parent, "acceptButton"));

        parent = mediator.getScene().getRoot();

        clickOn(findeNode(parent, "usernameField"));
        write("Susanne");

        clickOn(findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(findeNode(parent, "loginButton"));

        assertEquals( "Lotto Hotto", mediator.getPrimaryStage().getTitle());

    }



    private Node findeNode(Parent parent, String id){
        Node foundNode = null;
        for(Node node : parent.getChildrenUnmodifiable()){
            if(node.getId() != null){
                if(node.getId().equals(id)){
                    foundNode = node;
                }
            }
        }
        return foundNode;
    }
}
