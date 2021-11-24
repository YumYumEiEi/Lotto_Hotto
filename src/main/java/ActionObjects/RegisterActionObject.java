package ActionObjects;

import java.lang.reflect.Field;

public class RegisterActionObject implements ActionObject {

    private final String username;
    private final String password;
    private final String confirmedPassword;
    private final String title;
    private final String firstName;
    private final String secondName;
    private final String street;
    private final String town;
    private final String plz;
    private final String bankAccountName;
    private final String iban;
    private final String functionCall;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getPlz() {
        return plz;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String getFunctionCall() {
        return functionCall;
    }

    public RegisterActionObject(String functionCall, String username, String password, String confirmedPassword, String title, String firstName,
                                String secondName, String street, String town, String plz, String bankAccountName, String iban,
                                String bic) {
        this.functionCall = functionCall;
        this.username = username;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.title = title;
        this.firstName = firstName;
        this.secondName = secondName;
        this.street = street;
        this.town = town;
        this.plz = plz;
        this.bankAccountName= bankAccountName;
        this.iban = iban;

    }
    public boolean hasEmptyField() {
        Field[] allFields =  this.getClass().getDeclaredFields();
        for(Field field : allFields){
            try {
                if("" == (String) field.get(this)){
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }



}
