package Backend;

import Backend.Backend;
import BackendObjects.*;

import java.util.ArrayList;

public class TestBackend implements Backend {

    ArrayList<User> allUsers = new ArrayList<User>();

    public TestBackend(){
        initializeUsers();
    }

    private void initializeUsers() {
        allUsers.add(new User ("0", "Herr",  "Peter",
                "Kalinzki", "1234wasd", "Berlin", "07.08.1994", "3",
                "false", "Goselstraße 33", "12345", "Peter"));
    }

    @Override
    public User getUser(String username, String password) {
        for(User user : allUsers){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveNewUser(User user) {
        allUsers.add(user);
    }

    @Override
    public boolean isUsernameUnique(String username) {
        for(User user : allUsers){
            if(user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Drawing getNextDrawing() {
        return new Drawing("0", "", "", "11.11.2021");
    }

    @Override
    public void saveTipp(Tipp givenTipp) {

    }

    @Override
    public boolean isTippAlreaddyGiven(Tipp givenTipp, String userID) {
        return false;
    }

    @Override
    public String getNextUserID() {
        String returnValue = "" + allUsers.size();
        return returnValue;
    }

}
