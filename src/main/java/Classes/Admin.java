package Classes;

public class Admin extends User {

    public Admin(String user_name, String password, int id) {
        super(user_name, password, id);
    }
    public boolean deleteMachine(Machine m) {
        if(Machine.machineList.contains(m)) {
            Machine.machineList.remove(m);
            for(Team t: Team.teamList) {
                for(Project p: t.getProjects())
                    if(p.getMachines().containsKey(m))
                        p.getMachines().remove(m);
            }
            return true;
        }
        return false;
    }
}