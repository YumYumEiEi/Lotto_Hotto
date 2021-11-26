package Frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistrationWindowController {


    @FXML
    private ComboBox<String> titelComboBox;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField secondPasswordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField secondNameField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField plzField;

    @FXML
    private TextField ibanField;

    @FXML
    private Button backToLoginButton;

    @FXML
    private Button acceptButton;

    @FXML
    private TextField birthdateTextField;

    public void setBackToLoginHandler(RegistrationWindow.BackToLoginButtonHandler backToLoginButtonHandler) {
        this.backToLoginButton.setOnMouseClicked(backToLoginButtonHandler);
    }

    public void setConfirmRegistrationHandler(RegistrationWindow.ConfirmRegistrationButtonHandler confirmRegistrationButtonHandler) {
        this.acceptButton.setOnMouseClicked(confirmRegistrationButtonHandler);
    }

    public void initializeTitelBox() {
        this.titelComboBox.getItems().addAll("Herr", "Frau","Keine Angabe" );
    }

    public void showUserNotUniqueMessage() {
        Alert userNotFoundAllert = new Alert(Alert.AlertType.INFORMATION);
        userNotFoundAllert.setHeaderText("Benutzername bereits vorhanden");
        userNotFoundAllert.setContentText("Der eingegebene Benutzername ist leider schon vergeben. Bitte wählen sie " +
                "einen anderen Benutzernamen!");
        userNotFoundAllert.show();
    }

    public void showDifferentPasswordMessage() {
        Alert userNotFoundAllert = new Alert(Alert.AlertType.INFORMATION);
        userNotFoundAllert.setHeaderText("Das eingegebene Passwort stimmt nicht übereein");
        userNotFoundAllert.setContentText("Die beiden eingegebenen Passwörter stimmen nicht überein. Bitte überprüfen " +
                "sie die Eingabe!");
        userNotFoundAllert.show();
    }

    public String getUsername() {
        return this.usernameField.getText();
    }

    public String getPassword() {
        return this.passwordField.getText();
    }

    public String getConfirmedPassword() {
        return this.secondPasswordField.getText();
    }

    public String getTitel() {
        return this.titelComboBox.getValue();
    }

    public String getFirstName() {
        return this.firstNameField.getText();
    }

    public String getLastName() {
        return this.secondNameField.getText();
    }

    public String getStreet() {
        return this.streetField.getText();
    }

    public String getTown() {
        return this.cityField.getText();
    }

    public String getPlz() {
        return this.plzField.getText();
    }

    public String getIban() {
        return this.ibanField.getText();
    }

    public String getBirthdate() {
        return this.birthdateTextField.getText();
    }


    public void showMissingFieldErrorMessage() {
        Alert missingField = new Alert(Alert.AlertType.INFORMATION);
        missingField.setHeaderText("Eins oder mehrere Felder sind leer.");
        missingField.setContentText("Bitte füllen sie alle Felder aus bevor sie die Registrierung bestätigen!");
        missingField.show();
    }
}
