package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Project {
    public static HashMap<String, Project> projects = new HashMap<>();
    public static enum Status{inProgress, finished, canceled};
    private String projectName;
    private Status status;
    private HashMap<Machine, ArrayList<Reservation>> machines;
    private Team team;



    public Project(String projectName){ // for creating project without team, delete it later
        this.projectName = projectName;
        machines = new HashMap<>();
        status = Status.inProgress;
    }

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

    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/projects.txt"));
        while(in.hasNext())
            new Project(in.nextLine(), Team.teamList.get(in.nextLine()));
        Machine.load();
    }
}