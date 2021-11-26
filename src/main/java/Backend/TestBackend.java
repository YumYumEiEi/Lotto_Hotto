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
        allUsers.add(new User("1","Peter","Mayer","test","Berlin","11.11.2011","DE3248423432","false","Berliner Straße 23","12345","peterchen","Herr"));
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
        return new Drawing("0", "1,2,3,4,5,6", "4", "11.11.2011");
    }

    @Override
    public void saveTipp(Tipp givenTipp) {

    }

    @Override
    public boolean isTippAlreaddyGiven(Tipp givenTipp) {
        return false;
    }

}
