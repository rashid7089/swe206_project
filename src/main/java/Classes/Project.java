package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

    public Project(String projectName, Team team){
        this.projectName = projectName;
        this.team = team;
        team.addProject(this);
        machines = new HashMap<>();
        status = Status.inProgress;
        projects.put(projectName, this);
    }

    public void reserve(Machine machine, Reservation r) {
        if(!machines.containsKey(machine))
            machines.put(machine,new ArrayList<>());
        machines.get(machine).add(r);
        if(User.loaded) {
            try {
                User.save();
            } catch (FileNotFoundException ex) {}
        }
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

    public int getMachineCount() {
        int machineCount = 0;
        for(ArrayList<Reservation> machine: machines.values())
            machineCount += machine.size();
        return machineCount;
    }

    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/projects.txt"));
        while(in.hasNext())
            new Project(in.nextLine(), Team.teamList.get(in.nextLine()));
        Machine.load();
    }

    public static void save() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("data/projects.txt"));
        for(Project p: projects.values())
            pw.println(p);
        pw.close();
        Machine.save();
    }

    @Override
    public String toString(){
        return projectName + '\n' + team.getName();
    }
}