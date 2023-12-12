package Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Member extends User {
    private ArrayList<Team> myTeam;
    private ArrayList<Team> leaderIn;
    private String name;
    public static HashMap<String, Member> memberList = new HashMap<>();

    public Member(String user_name, String password, String name) {
        super(user_name, password);
        myTeam = new ArrayList<>();
        leaderIn = new ArrayList<>();

        this.name = name;
        memberList.put(user_name, this);
    }

    public ArrayList<Team> getTeams() {
        return myTeam;
    }

    public ArrayList<Team> getLeaderIn() {
        return leaderIn;
    }

    public void addTeam(Team t) {
        myTeam.add(t);
    }

    public void removeTeam(Team t) {
        myTeam.remove(t);
    }

    public void addLeader(Team t) {
        leaderIn.add(t);
    }

    public void removeLeader(Team t) {
        leaderIn.remove(t);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        for(Team t: myTeam)
            projects.addAll(t.getProjects());
        return projects;
    }
    @Override
    public String toString(){
        return name;
    }
}