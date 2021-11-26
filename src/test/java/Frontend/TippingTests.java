package Frontend;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TippingTests extends ApplicationTest {
    Mediator mediator = new Mediator();

    @Override
    public void start(Stage stage) throws Exception{
        mediator.start(stage);
    }

    @BeforeEach
    public void setUp(){
        login();
        goToTippMainWindow();
    }

    @Test
    public void shouldGoToTheTippMainWindow(){
        assertEquals("Tipp Main", mediator.getPrimaryStage().getTitle());
    }

    @Test
    public void shouldGoToTheGiveTippWindow(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        assertEquals("Tippen", mediator.getPrimaryStage().getTitle());
    }

    private void goToTippMainWindow() {
        Parent parent = mediator.getScene().getRoot();
        clickOn(NodeFinder.findeNode(parent, "tipButton"));
    }

    private void login() {
        Parent parent = mediator.getScene().getRoot();
        clickOn(NodeFinder.findeNode(parent, "usernameField"));
        write("Peter");

        clickOn(NodeFinder.findeNode(parent, "passwordField"));
        write("1234wasd");

        clickOn(NodeFinder.findeNode(parent, "loginButton"));

    }
}
