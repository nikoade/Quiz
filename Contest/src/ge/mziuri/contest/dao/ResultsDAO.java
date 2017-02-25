
package ge.mziuri.contest.dao;

import ge.mziuri.daotest.model.Result;
import java.util.List;

public interface ResultsDAO {
  List<Result>  getresultbycontest_id(Integer contestid);
}
