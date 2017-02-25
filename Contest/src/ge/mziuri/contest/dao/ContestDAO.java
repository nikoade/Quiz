
package ge.mziuri.contest.dao;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import ge.mziuri.daotest.model.Contest;
import ge.mziuri.daotest.model.User;
import java.util.List;


public interface ContestDAO {
   List <Contest> getAllContest ();
   void addContest (Contest contest);
   void getcontesetbyid (Integer contesetid);
 
   
}
