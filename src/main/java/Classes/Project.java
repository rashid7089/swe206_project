package Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    public static HashMap<String, Project> projects = new HashMap<>();
    public static enum Status{inProgress, finished, canceled};
    private String projectName;
    private Status status;
    private HashMap<Machine, ArrayList<Reservation>> machines;
    private Team team;


    public Project(String projectName, Team team){
        this.projectName = projectName;
        this.team = team;
        machines = new HashMap<>();
        status = Status.inProgress;
        projects.put(projectName, this);
    }

    public void reserve(Machine machine, Reservation r) {
        if(!machines.containsKey(machine))
            machines.put(machine,new ArrayList<>());
        machines.get(machine).add(r);
    }

    public HashMap<Machine, ArrayList<Reservation>> getMachines() {
        return machines;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status s) {
        status = s;
    }

    public String getName() {
        return projectName;
    }

    public Team getTeam() {
        return team;
    }
}