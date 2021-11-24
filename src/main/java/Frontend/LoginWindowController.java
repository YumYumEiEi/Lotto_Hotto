package Frontend;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private AnchorPane loginWindow;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginWindow.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'LoginWindow.fxml'.";

    }

    public void setEnterKeyHandler(LoginWindow.LoginAction loginHaendler) {
        this.loginWindow.setOnKeyPressed(loginHaendler);
    }

    public void setRegisterButtonHandler(LoginWindow.RegisterButtonHandler registerbuttonHandler){
        this.registerButton.setOnMouseClicked(registerbuttonHandler);
    }

    public String getUsername() {
        return this.usernameField.getText();
    }

    public String getPassword(){
        return this.passwordField.getText();
    }

    public void showUserNotFoundError() {
        Alert userNotFoundAllert = new Alert(Alert.AlertType.INFORMATION);
        userNotFoundAllert.setTitle("User not found");
        userNotFoundAllert.setHeaderText("Benutzer nicht gefunden");
        userNotFoundAllert.setContentText("Der eingegebene Benutzername oder das Passwort war falsch!");
        userNotFoundAllert.show();
    }

    public void setLoginButtonHandler(LoginWindow.LoginAction loginAction) {
        this.loginButton.setOnMouseClicked(loginAction);
    }
}
