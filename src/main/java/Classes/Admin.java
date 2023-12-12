package Classes;

import java.io.FileNotFoundException;

public class Admin extends User {
    public static Admin admin;
    public Admin(String user_name, String password) {
        super(user_name, password);
        admin = this;
        userObjects.put(user_name, this);
    }

    public boolean isAdmin() {
        return true;
    }

    public boolean createTeam(String name, Member leader) {
        if(Team.teamList.containsKey(name))
            return false;
        Team t = new Team(name, leader);
        leader.addTeam(t);
        leader.addLeader(t);
        try {
            User.save();
        } catch (FileNotFoundException ex) {}
        return true;
    }

    public boolean createProject(String name, Team t) {
        if(Project.projects.containsKey(name))
            return false;
        Project p = new Project(name, t);
        t.addProject(p);
        try {
            User.save();
        } catch (FileNotFoundException ex) {}
        return true;
    }

    public boolean removeProject(Project p) {
        if(!Project.projects.containsValue(p))
            return false;
        p.getTeam().removeProject(p);
        Project.projects.remove(p.getName());
        try {
            User.save();
        } catch (FileNotFoundException ex) {}
        return true;
    }

    public boolean addMachine(String name) {
        if(Machine.machineList.containsKey(name))
            return false;
        new Machine(name);
        try {
            User.save();
        } catch (FileNotFoundException ex) {}
        return true;
    }

    public boolean deleteMachine(Machine m) {
        if(Machine.machineList.containsKey(m.getMachineName())) {
            Machine.machineList.remove(m.getMachineName());
            for(Team t: Team.teamList.values()) {
                for(Project p: t.getProjects())
                    if(p.getMachines().containsKey(m))
                        p.getMachines().remove(m);
            }
            try {
                User.save();
            } catch (FileNotFoundException ex) {}
            return true;
        }
        return false;
    }

    public boolean changeProjectTeam(Project p, Team oldTeam, Team newTeam) {
        if(!oldTeam.getProjects().contains(p))
            return false;
        oldTeam.removeProject(p);
        newTeam.addProject(p);
        try {
            User.save();
        } catch (FileNotFoundException ex) {}
        return true;
    }
}