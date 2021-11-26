package BackendObjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty id;
    private final StringProperty titel;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty city;
    private final StringProperty postcode;
    private final StringProperty street;
    private final StringProperty birthdate;
    private final StringProperty bankAccount;
    private final StringProperty isAdmin;

    public User(
            String id, String titel,  String firstName, String lastName,String password, String city, String birthdate,
            String bankAccount, String isAdmin, String street, String postcode, String username
    ) {
        this.id = new SimpleStringProperty(id);
        this.titel = new SimpleStringProperty(titel);
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
    }

    public static User getEmptyUser() {
        return new User("","", "", "", "", "", "", "", "" ,
                "", "", "");
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getTitel(){
        return this.titel.get();
    }

    public StringProperty titelProperty(){
        return this.titel;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName
        );
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getPostcode() {
        return postcode.get();
    }

    public StringProperty postcodeProperty() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode.set(postcode);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getBirthdate() {
        return birthdate.get();
    }

    public StringProperty birthdateProperty() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate.set(birthdate);
    }

    public String getBankAccount() {
        return bankAccount.get();
    }

    public StringProperty bankAccountProperty() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount.set(bankAccount);
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin.set(isAdmin);
    }

    public String getIsAdmin() {
        return isAdmin.get();
    }

    public StringProperty isAdminProperty() {
        return isAdmin;
    }
}
