
package ge.mziuri.contest.dao;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import ge.mziuri.contest.exception.ContestException;
import ge.mziuri.daotest.model.Test;
import java.util.List;

public interface TestDAO {
     void addTest(Test test);
     void deleteTest(int testid);
     Test getquestionbyid(Integer contestid,Integer questionid)throws ContestException ;
     List<Test> getquestionbyContest_id(Integer contestid); 
      
    
}
