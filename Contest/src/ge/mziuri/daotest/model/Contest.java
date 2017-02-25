
package ge.mziuri.daotest.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



public class Contest implements Serializable {
    
    private int id;
    private String name;
    private Date date;
    private Time time;
    private int duration;  //წამებში 
    private List<Test> tests = new ArrayList<>();
    private List<Result> results = new ArrayList<>();
    

   
}
