package Backend;

import Backend.Backend;
import BackendObjects.*;
import Middlewear.WinnChecker;

import java.util.ArrayList;

public class TestBackend implements Backend {

    ArrayList<User> allUsers = new ArrayList<User>();
    private ArrayList<Tipp> allTipps = new ArrayList<>();
    private ArrayList<Drawing> allDrawings = new ArrayList<>();

    public TestBackend(){
        initializeUsers();
    }

    private void initializeUsers() {
        allUsers.add(new User ("0", "Herr",  "Peter",
                "Kalinzki", "1234wasd", "Berlin", "07.08.1994", "3",
                "false", "Goselstraße 33", "12345", "Peter"));

        allTipps.add(new Tipp(new String[]{"1","2","3","4","5","6"}, "1", "0", "0"));
        allTipps.add(new Tipp(new String[]{"2","3","4","5","6","7"}, "1", "0", "1"));

        allDrawings.add(new Drawing("0", new String[]{"1", "3", "5", "17", "35", "40"}, "2", "11.11.1111"));
        allDrawings.add(new Drawing("1", new String[]{}, "", "12.11.1111"));
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
        return new Drawing("1", new String[]{}, "", "12.11.1111");
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

        return allTippedNumbersInOneString.substring(0, allTippedNumbersInOneString.length() - 3);
    }

}
