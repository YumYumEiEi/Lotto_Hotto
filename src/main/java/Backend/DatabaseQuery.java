package Backend;

import BackendObjects.Drawing;
import BackendObjects.Tipp;
import BackendObjects.TippTableView;
import BackendObjects.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseQuery implements Backend {
    @Override
    public User getUser(String username, String password) {
        String sql = "SELECT * FROM Person WHERE username=? AND password=?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
            connection.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return null;
    }

    @Override
    public void saveNewUser(User user) {

        String sql = "INSERT INTO PERSON(username, title, firstname, lastname, password, birthdate, street, postcode, city, bankaccount, isAdmin)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = null;
        Connection connection = DatabaseConnection.getConnection();
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            System.out.println(user.getUsername());
            ps.setString(2, user.getTitle());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getBirthdate());
            ps.setString(7, user.getStreet());
            ps.setString(8, user.getPostcode());
            ps.setString(9, user.getCity());
            ps.setString(10, user.getBankAccount());
            ps.setString(11, user.getIsAdmin());

            ps.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isUsernameUnique(String username) {
        String sql = "SELECT * FROM Person WHERE username=?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            connection.close();
            if(rs.next()){

                System.out.println("TEST");
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("FALSCH");
        return true;
    }

    @Override
    public Drawing getNextDrawing() {
        String sql ="SELECT * FROM Ziehung ORDER BY id DESC LIMIT 1";
        try {
        Connection connection = DatabaseConnection.getConnection();
        ResultSet rs = connection.createStatement().executeQuery(sql);
        String[] allNumbers = rs.getString(2).split(",");
        Drawing drawing = new Drawing(rs.getString(1), allNumbers, rs.getString(3), rs.getString(4));
        connection.close();
        return drawing;
         } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveTipp(Tipp givenTipp) {
        String sql = "INSERT INTO Tipp(winningClass, person_id, numbers, draw_id, bonusNumber)" +
                "VALUES(?,?,?,?,?)";
        System.out.println(" saveTipp");
        PreparedStatement ps = null;
        Connection connection = DatabaseConnection.getConnection();
        Arrays.sort(givenTipp.getAllTippedNumbers());
        String numbers = String.join(",", givenTipp.getAllTippedNumbers());
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, givenTipp.getUserID());
            ps.setString(3, numbers);
            ps.setString(4, givenTipp.getDrawID());
            ps.setString(5, givenTipp.getBonusNumber());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isTippAlreaddyGiven(Tipp givenTipp, String userID) {
        String sql = "SELECT * FROM Tipp WHERE numbers=? AND person_id=?";
        String numbers = String.join(",", givenTipp.getAllTippedNumbers());
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, numbers);
            ps.setString(2, givenTipp.getUserID());
            ResultSet rs = ps.executeQuery();
            connection.close();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getNextUserID() {
        return null;
    }

    @Override
    public TippTableView[] getAllTippsFromUser(String id) {
        List<TippTableView> ttv = new ArrayList<>();
        String sql = "SELECT z.drawDate, t.numbers, t.bonusNumber, z.numbers, z.bonusNumber, t.winningClass FROM Ziehung AS z JOIN Tipp AS t ON z.id = t.draw_id WHERE t.person_id =?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                ttv.add(new TippTableView(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),"0"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TippTableView[] allTips = new TippTableView[ttv.size()];
        allTips = ttv.toArray(allTips);

        return allTips;
    }

}
