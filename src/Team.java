import java.util.ArrayList;

public class Team {
    public static ArrayList<Team> teamList = new ArrayList<>();
    private String teamName;
    private ArrayList<Member> members;
    private Member leader;
    private ArrayList<Project> projects;


    public Team(String teamName, Member leader){
        this.leader = leader;
        this.teamName = teamName;
        teamList.add(this);
    }

    public Team(String teamName, Member leader, ArrayList<Project> projects){
        this.teamName = teamName;
        this.members = members;
        this.leader = leader;
        this.projects = projects;
    }
    
    public ArrayList<Project> getProjects() {
        return projects;
    }
}
