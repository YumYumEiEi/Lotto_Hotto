package Frontend;

import Backend.Backend;
import Backend.TestBackend;
import BackendObjects.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mediator extends Application {
    private Stage primaryStage;
    private LoginWindow loginWindow;
    private RegistrationWindow registrationWindow;
    private MainWindow mainWindow;
    private TippMainWindow tippMainWindow;
    private GiveTippsWindow giveTippsWindow;
    private ShowTippWindow showTippWindow;
    private StatisticWindow statisticWindow;

    private Backend backend;

    private User activeUser;

    public Mediator(){

        loginWindow = new LoginWindow();
        registrationWindow = new RegistrationWindow();
        mainWindow = new MainWindow();
        tippMainWindow = new TippMainWindow();
        giveTippsWindow = new GiveTippsWindow();
        showTippWindow = new ShowTippWindow();
        statisticWindow = new StatisticWindow();

        backend = new TestBackend();

    }

    public static void main(String[] args) {
         launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        loginWindow.start(primaryStage, this);
    }

    public void startRegistration() throws Exception {
        registrationWindow.start(primaryStage, this);
    }

    public void startLogin() throws Exception {
        loginWindow.start(primaryStage, this);
    }

    public void startMain() throws Exception {
        if(activeUser != null) {
            mainWindow.start(primaryStage, this);
        }
    }

    public void startProfileOptions() {
        //TODO hier muss was gamacht werden!
    }

    public void startStatistics() throws Exception {
        if(activeUser != null){
            statisticWindow.start(primaryStage, this);
        }

    }

    public void startTippsMain() throws Exception{
        if(activeUser != null){
            tippMainWindow.start(primaryStage, this);
        }
    }

    public void startGiveTippWindow()throws Exception{
        if(activeUser != null){
            giveTippsWindow.start(primaryStage, this);
        }
    }

    public void startShowTippWindow() throws Exception {
        if(activeUser != null){
            showTippWindow.start(primaryStage, this);
        }
    }

    public User getActiveUser() {
        return activeUser;
    }


    public void setUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public Scene getScene(){
        return primaryStage.getScene();
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }


    public Backend getBackend() {
        return this.backend;
    }

}
