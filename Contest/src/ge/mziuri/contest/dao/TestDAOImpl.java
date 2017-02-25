
package ge.mziuri.contest.dao;

import ge.mziuri.contest.exception.ContestException;
import ge.mziuri.daotest.metainfo.DatabaseMetaInfo;
import ge.mziuri.daotest.metainfo.ProjectMetainfo;
import ge.mziuri.daotest.model.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestDAOImpl implements TestDAO {
      private Connection con;
    
    private PreparedStatement pstmt;
    
    public TestDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseMetaInfo.databaseURL, DatabaseMetaInfo.username, DatabaseMetaInfo.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addTest(Test test) {
         try {
            pstmt = con.prepareStatement("INSERT INTO test (question,ans1,ans2,ans3,ans4,correctanswer,contest_id) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, test.getQuestion());
            pstmt.setString(2, test.getAns1());
            pstmt.setString(3, test.getAns2());
            pstmt.setString(4, test.getAns3());
            pstmt.setString(5, test.getAns4());
            pstmt.setString(6, test.getCorrectanswer());
            pstmt.setInt(7, test.getContest_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteTest(int testid) {
         try {
            pstmt = con.prepareStatement("DELETE FROM test WHERE id = ?");
            pstmt.setInt(1, testid);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Test getquestionbyid(Integer contestid, Integer questionid)throws ContestException {
         Test test = null;
        try { 
            pstmt = con.prepareCall("SELECT * FROM Test WHERE contest_id = ? AND id = ?;");
            pstmt.setInt(1, contestid);
            pstmt.setInt(2, questionid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("country_id");
                String question=rs.getString("question");
                String ans1=rs.getString("ans1");
                String ans2=rs.getString("ans2");
                String ans3=rs.getString("ans3");
                String ans4=rs.getString("ans4");
                String correctanswer=rs.getString("correctanswer");
                int contest_id = rs.getInt("contest_id");
                test = new Test(id, question, ans1,ans2,ans3,ans4,correctanswer,contest_id);
            } else {
                throw new ContestException(ProjectMetainfo.cantFindtest);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return test;

}

    @Override
    public List<Test> getquestionbyContest_id(Integer contestid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
