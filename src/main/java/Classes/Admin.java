package Classes;

public class Admin extends User {

    public Admin(String user_name, String password, int id) {
        super(user_name, password, id);
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
}