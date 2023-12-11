package Classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    public static enum Status{inProgress, finished, canceled};
    private String projectName;
    private Status status;
    private HashMap<Machine, ArrayList<Reservation>> machines;
    Team team;


    public Project(String projectName, Team team){
        this.projectName = projectName;
        this.team = team;
        machines = new HashMap<>();
        status = Status.inProgress;
    }

    public void reserve(Machine machine, Reservation r) {
        if(!machines.containsKey(machine))
            machines.put(machine,new ArrayList<>());
        machines.get(machine).add(r);
    }

    public HashMap<Machine, ArrayList<Reservation>> getMachines() {
        return machines;
    }
}