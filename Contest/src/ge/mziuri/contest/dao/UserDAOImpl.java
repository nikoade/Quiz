package ge.mziuri.contest.dao;

import ge.mziuri.daotest.metainfo.DatabaseMetaInfo;
import ge.mziuri.daotest.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public UserDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        try {
            pstmt = con.prepareStatement("INSERT INTO user (permission,name,username,surname,date,password) VALUES (?,?,?,?,?,?)");
            pstmt.setBoolean(1, user.isPermission());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getSurname());
            pstmt.setDate(5, user.getDate());
            pstmt.setString(6, user.getPassword());

            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   

    @Override
    public void checkUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
