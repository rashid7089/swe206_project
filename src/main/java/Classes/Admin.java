package Classes;

public class Admin extends User {
    public static Admin admin;
    public Admin(String user_name, String password, String id) {
        super(user_name, password, id);
        admin = this;
    }

    public boolean createTeam(String name, Member leader) {
        if(Team.teamList.containsKey(name))
            return false;
        Team t = new Team(name, leader);
        leader.addTeam(t);
        leader.addLeader(t);
        return true;
    }

    public boolean createProject(String name, Team t) {
        if(Project.projects.containsKey(name))
            return false;
        Project p = new Project(name, t);
        t.addProject(p);
        return true;
    }

    public boolean removeProject(Project p) {
        if(!Project.projects.containsValue(p))
            return false;
        p.getTeam().removeProject(p);
        Project.projects.remove(p.getName());
        return true;
    }

    public boolean addMachine(String name) {
        if(Machine.machineList.containsKey(name))
            return false;
        new Machine(name);
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
            return true;
        }
        return false;
    }

    public boolean changeProjectTeam(Project p, Team oldTeam, Team newTeam) {
        if(!oldTeam.getProjects().contains(p))
            return false;
        oldTeam.removeProject(p);
        newTeam.addProject(p);
        return true;
    }
}