package Frontend;

import Backend.Backend;
import BackendObjects.Drawing;
import BackendObjects.Tipp;
import BackendObjects.User;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class TippingTests extends ApplicationTest {
    Mediator mediator = new Mediator();
    Backend testBackend;
    private User testUser;

    @Override
    public void start(Stage stage) throws Exception{
        testBackend = mediator.getBackend();
        mediator.start(stage);
    }

    @BeforeEach
    public void setUp(){
        createTestUser();
        login();
        goToTippMainWindow();
        createTestDrawing();
    }

    @AfterEach
    public void tearDown(){
        deleteAllTippsFromTestUser();
        deleteTestUser();
        deleteTestDrawings();
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
        clickOn(NodeFinder.findeNode(parent, "bt_03"));
        clickOn(NodeFinder.findeNode(parent, "bt_10"));
        clickOn(NodeFinder.findeNode(parent, "bt_30"));
        clickOn(NodeFinder.findeNode(parent, "bt_32"));
        clickOn(NodeFinder.findeNode(parent, "bt_46"));

        clickOn(NodeFinder.findeNode(parent, "bts_04"));

        clickOn(NodeFinder.findeNode(parent, "confirmButton"));

        assertEquals("Tipp Main", mediator.getPrimaryStage().getTitle());
    }

    @Test
    public void shouldOpenShowTippWindow(){
        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "showTippsButton"));

        assertEquals("Deine Tipps", mediator.getPrimaryStage().getTitle());
    }

    @Test
    public void shouldShowMyTipp(){
        makeATipp();

        Parent parent = mediator.getScene().getRoot();

        clickOn(NodeFinder.findeNode(parent, "showTippsButton"));

        verifyThat("1, 3, 10, 30, 32, 46", NodeMatchers.isVisible());
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

    private void makeATipp(){
        testBackend.saveTipp(new Tipp(new String[]{"1", "3", "10", "30", "32", "46"}, "4", testUser.getId(), "0"));
    }

    private void createTestUser() {
        User testUser = new User("0", "Herr", "Peter" ,"Peterson", "1234wasd",
                "Berlin", "01.01.1000", "DE900005000300201", "false", "Berliner Straße 33",
                "12345", "Peter");
        testBackend.saveNewUser(testUser);

        this.testUser = testUser;
    }

    private void createTestDrawing() {
        testBackend.saveDrawing(new Drawing("0", new String[]{}, "", "11.11.1111"));
    }

    private void deleteTestUser(){
        testBackend.deleteUser(this.testUser);
    }

    private void deleteAllTippsFromTestUser(){
        testBackend.deleteAllTippsFrom(this.testUser);
    }

    private void deleteTestDrawings() {
        testBackend.deleteDrawing("0");
    }
}
