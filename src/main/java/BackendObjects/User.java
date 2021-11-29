package BackendObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty id;
    private final StringProperty title;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty birthdate;
    private final StringProperty street;
    private final StringProperty postcode;
    private final StringProperty city;
    private final StringProperty bankAccount;
    private final StringProperty isAdmin;

    public User(
            String id, String title, String firstName, String lastName, String username, String password,
            String birthdate, String street, String postcode, String city, String bankAccount, String isAdmin
    ) {
        this.id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.password = new SimpleStringProperty(password);
        this.city = new SimpleStringProperty(city);
        this.birthdate = new SimpleStringProperty(birthdate);
        this.bankAccount = new SimpleStringProperty(bankAccount);
        this.isAdmin = new SimpleStringProperty(isAdmin);
        this.street = new SimpleStringProperty(street);
        this.postcode = new SimpleStringProperty(postcode);
        this.username = new SimpleStringProperty(username);
        this.title = new SimpleStringProperty(title);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public String getPostcode() {
        return postcode.get();
    }

    public StringProperty postcodeProperty() {
        return postcode;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getBirthdate() {
        return birthdate.get();
    }

    public StringProperty birthdateProperty() {
        return birthdate;
    }

    public String getBankAccount() {
        return bankAccount.get();
    }

    public StringProperty bankAccountProperty() {
        return bankAccount;
    }

    public String getIsAdmin() {
        return isAdmin.get();
    }

    public StringProperty isAdminProperty() {
        return isAdmin;
    }

    public String getTitle(){
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }
}
