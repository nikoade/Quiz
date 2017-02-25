package ge.mziuri.contest.dao;

import ge.mziuri.daotest.metainfo.DatabaseMetaInfo;
import ge.mziuri.daotest.model.Contest;
import ge.mziuri.daotest.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ContestDAOImpl implements ContestDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public ContestDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Contest> getAllContest() {
        List<Contest> contests = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM contest");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                Contest contest = new Contest(id, date, time, name);
                contests.add(contest);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return contests;
    }

    /*  @Override
     public List<User> getUsersbyScore(Integer score) {
     List<User> users = new ArrayList<>();
     try {
     pstmt = con.prepareStatement("SELECT * FROM user WHERE score = ?");
     pstmt.setInt(1, score);
     ResultSet rs = pstmt.executeQuery();
     while (rs.next()) {
     Boolean permission = rs.getBoolean("permission");
     String name=rs.getString("name");
     String surname=rs.getString("surname");  
     Date date=rs.getDate("date");
     String password=rs.getString("password");
     String username=rs.getString("username");
            
     User user = new User(permission, name, surname, date, score,password,username);
     users.add(user);
     } 
     } catch (SQLException ex) {
     System.out.println(ex.getMessage());
     }
     return users;
     }*/
    @Override
    public void addContest(Contest contest) {

        try {
            pstmt = con.prepareStatement("INSERT INTO contest (name,date,time) VALUES (?,?,?)");
            pstmt.setString(1, contest.getName());
            pstmt.setDate(2, contest.getDate());
            pstmt.setTime(3, contest.getTime());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getcontesetbyid(Integer contesetid) {
        try {
            pstmt = con.prepareStatement("SELECT CONTEST WHERE ID = ?");
            pstmt.setInt(1, contesetid);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
