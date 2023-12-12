package Classes;

public class Statistics {
    Member mostActive;
    Machine mostUsed;
    Project mostUsing;
    public Statistics() {
        mostActive = mostActive();
        mostUsed = mostUsed();
    }

    public static Member mostActive() {
        Member mostActive = null;
        for(Member m: Member.memberList.values()) {
            if(mostActive == null)
                mostActive = m;
            else if(m.getTeams().size() > mostActive.getTeams().size())
                mostActive = m;
        }
        return mostActive;
    }

    public static Machine mostUsed() {
        Machine mostUsed = null;
        for(Machine m: Machine.machineList.values()) {
            if(mostUsed == null)
                mostUsed = m;
            else if(m.getMachineSchedule().size() > mostUsed.getMachineSchedule().size())
                mostUsed = m;
        }
        return mostUsed;
    }

    public static Project mostUsing() {
        Project mostUsing = null;
        for(Project p: Project.projects.values()) {
            if(mostUsing == null)
                mostUsing = p;
            else if(p.getMachineCount() > mostUsing.getMachineCount())
                mostUsing = p;
        }
        return mostUsing;
    }
}
