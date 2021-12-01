package Frontend;

import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

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

    @Test
    public void shouldMarkANumberIfKlickOnIt(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));

        String style = NodeFinder.findeNode(parent, "bt_01").getStyle();
        assertEquals("-fx-background-color: #00ff00", style );
    }

    @Test
    public void shouldUnmarkAMarkedNumberIfKlicked(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));
        clickOn(NodeFinder.findeNode(parent, "bt_01"));

        String style = NodeFinder.findeNode(parent, "bt_01").getStyle();
        assertEquals("", style);
    }

    @Test
    public void shouldMarkNumbersInANewWayIfTooManyAreSelected(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));
        clickOn(NodeFinder.findeNode(parent, "bt_02"));
        clickOn(NodeFinder.findeNode(parent, "bt_03"));
        clickOn(NodeFinder.findeNode(parent, "bt_04"));
        clickOn(NodeFinder.findeNode(parent, "bt_05"));
        clickOn(NodeFinder.findeNode(parent, "bt_06"));
        clickOn(NodeFinder.findeNode(parent, "bt_07"));

        String style = NodeFinder.findeNode(parent, "bt_01").getStyle();
        assertEquals("-fx-background-color: #ff0000", style);
    }

    @Test
    public void shouldMarkButtonsNormalIfTheyWereSpecialyMarkedAndEnoughtButtonsWereUnselected(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));
        clickOn(NodeFinder.findeNode(parent, "bt_02"));
        clickOn(NodeFinder.findeNode(parent, "bt_03"));
        clickOn(NodeFinder.findeNode(parent, "bt_04"));
        clickOn(NodeFinder.findeNode(parent, "bt_05"));
        clickOn(NodeFinder.findeNode(parent, "bt_06"));
        clickOn(NodeFinder.findeNode(parent, "bt_07"));
        clickOn(NodeFinder.findeNode(parent, "bt_07"));

        String style = NodeFinder.findeNode(parent, "bt_01").getStyle();
        assertEquals("-fx-background-color: #00ff00", style);
    }

    @Test
    public void shouldMarkBonusNumberIfSelected(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bts_01"));

        String style = NodeFinder.findeNode(parent, "bts_01").getStyle();
        assertEquals("-fx-background-color: #00ff00", style);
    }

    @Test
    public void shouldMarkAnotherBonusnumberButtonIfSelectedAndDemarkThePreviousSelectedOne(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bts_01"));
        clickOn(NodeFinder.findeNode(parent, "bts_02"));

        String style = NodeFinder.findeNode(parent, "bts_01").getStyle();
        assertEquals("", style);
    }

    @Test
    public void shouldShowErrorMessageIfTooManyNumbersArePickedAndITryToConfirm(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));
        clickOn(NodeFinder.findeNode(parent, "bt_02"));
        clickOn(NodeFinder.findeNode(parent, "bt_03"));
        clickOn(NodeFinder.findeNode(parent, "bt_04"));
        clickOn(NodeFinder.findeNode(parent, "bt_05"));
        clickOn(NodeFinder.findeNode(parent, "bt_06"));
        clickOn(NodeFinder.findeNode(parent, "bt_07"));

        clickOn(NodeFinder.findeNode(parent, "bts_01"));

        clickOn(NodeFinder.findeNode(parent, "confirmButton"));

        verifyThat("Es müssen 6 Zahlen ausgewählt sein" , NodeMatchers.isVisible());
    }

    @Test
    public void shouldShowErrorMessageIfTooLessNumbersArePicked(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));
        clickOn(NodeFinder.findeNode(parent, "bt_02"));
        clickOn(NodeFinder.findeNode(parent, "bt_03"));
        clickOn(NodeFinder.findeNode(parent, "bt_04"));
        clickOn(NodeFinder.findeNode(parent, "bt_05"));

        clickOn(NodeFinder.findeNode(parent, "bts_01"));

        clickOn(NodeFinder.findeNode(parent, "confirmButton"));

        verifyThat("Es müssen 6 Zahlen ausgewählt sein" , NodeMatchers.isVisible());
    }

    @Test
    public void shouldShowAnErrorMessageIfNoBonusnumberWasOickedAndITryToConfirm(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));
        clickOn(NodeFinder.findeNode(parent, "bt_02"));
        clickOn(NodeFinder.findeNode(parent, "bt_03"));
        clickOn(NodeFinder.findeNode(parent, "bt_04"));
        clickOn(NodeFinder.findeNode(parent, "bt_05"));
        clickOn(NodeFinder.findeNode(parent, "bt_06"));


        clickOn(NodeFinder.findeNode(parent, "confirmButton"));

        verifyThat("Keine Superzahl ausgewählt" , NodeMatchers.isVisible());
    }

    @Test
    public void shouldReturnToTippMainWindowIfTippWasAlright(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "makeATippButton"));

        parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "bt_01"));
        clickOn(NodeFinder.findeNode(parent, "bt_02"));
        clickOn(NodeFinder.findeNode(parent, "bt_03"));
        clickOn(NodeFinder.findeNode(parent, "bt_04"));
        clickOn(NodeFinder.findeNode(parent, "bt_05"));
        clickOn(NodeFinder.findeNode(parent, "bt_06"));

        clickOn(NodeFinder.findeNode(parent, "bts_01"));

        clickOn(NodeFinder.findeNode(parent, "confirmButton"));

        assertEquals("Tipp Main", mediator.getPrimaryStage().getTitle());


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
