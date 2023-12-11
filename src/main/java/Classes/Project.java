package Classes;

import java.sql.Date;
import java.util.HashMap;

public class Project {
    
    private String projectName, status;
    private HashMap<Machine, Date> machines;
    Team team;


    public Project(String projectName, Team team, HashMap<Machine, Date> machines, String status){
        this.projectName = projectName;
        this.team = team;
        this.machines = machines;
        this.status = status;
    }
}

