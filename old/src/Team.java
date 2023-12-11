import java.util.ArrayList;

public class Team {

    private String teamName;
    private ArrayList<Member> members;
    private Member leader;
    private ArrayList<Project> projects;


    public Team(String teamName){
        this.teamName = teamName;
    }

    public Team(String teamName,ArrayList<Member> members, Member leader, ArrayList<Project> projects){
        this.teamName = teamName;
        this.members = members;
        this.leader = leader;
        this.projects = projects;
    }
    
}
