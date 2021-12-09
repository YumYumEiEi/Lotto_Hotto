package Backend;

import Backend.Backend;
import BackendObjects.*;
import Middlewear.WinnChecker;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestBackend implements Backend {

    ArrayList<User> allUsers = new ArrayList<User>();
    private ArrayList<Tipp> allTipps = new ArrayList<>();
    private ArrayList<Drawing> allDrawings = new ArrayList<>();

    public TestBackend(){
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
        for(Drawing drawing : allDrawings){
            if(drawing.getBonusNumber().equals("")){
                return drawing;
            }
        }
        return null;
    }

    @Override
    public void saveDrawing(Drawing drawing){
        this.allDrawings.add(drawing);
    }

    @Override
    public void deleteDrawing(String id) {
        for(Drawing drawing : allDrawings){
            if(drawing.getId().equals(id)){
                allDrawings.remove(drawing);
                break;
            }
        }
    }

    @Override
    public void saveTipp(Tipp givenTipp) {
        allTipps.add(givenTipp);
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

    @Override
    public TippTableView[] getAllTippsFromUser(String id){
        ArrayList<TippTableView> allFoundTipps = new ArrayList<>();
        for(Tipp tipp : allTipps){
            if(tipp.getUserID().equals(id)){
                allFoundTipps.add(createTippTableView(tipp));
            }
        }

        return allFoundTipps.toArray(new TippTableView[allFoundTipps.size()]);
    }

    @Override
    public void deleteUser(User userThatShouldBeDeleted) {
        allUsers.remove(userThatShouldBeDeleted);
    }

    @Override
    public void deleteAllTippsFrom(User user) {
        ArrayList<Tipp> userTipps = new ArrayList<>();
        for(Tipp tipp : allTipps){
            if(tipp.getUserID().equals(user.getId())){
                userTipps.add(tipp);
            }
        }
        for (Tipp tipp : userTipps){
            allTipps.remove(tipp);
        }
    }

    @Override
    public void saveNewUserWithId(User user){}

    @Override
    public void saveDrawingWithId(Drawing drawing){}



    private TippTableView createTippTableView(Tipp tipp) {
        for(Drawing drawing : allDrawings){
            if (drawing.getId() == tipp.getDrawID()){
                return new TippTableView(drawing.getDrawDate(), createNumberString(tipp.getAllTippedNumbers()), tipp.getBonusNumber(),
                        createNumberString(drawing.getNumbers()), drawing.getBonusNumber(), WinnChecker.getWinnerClass(tipp, drawing), "0");
            }
        }
        return null;
    }

    private String createNumberString(String[] allTippedNumbers) {
        String allTippedNumbersInOneString = "";

        if(allTippedNumbers.length == 0){
            return "";
        }

        for(String number : allTippedNumbers){
            allTippedNumbersInOneString = allTippedNumbersInOneString + number + ", ";
        }

        return allTippedNumbersInOneString.substring(0, allTippedNumbersInOneString.length() - 2);
    }

}
