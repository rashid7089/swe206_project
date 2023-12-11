package Classes;

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
        this.leader = leader;
        this.projects = projects;
    }
    
    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Member> getMembers () {
        return members;
    }

    public String getName() {
        return teamName;
    }

    public Member getLeader() {
        return leader;
    }

    public boolean setLeader(Member m) {
        if(members.contains(m)) {
            leader = m;
            return true;
        }
        return false;
    }
}