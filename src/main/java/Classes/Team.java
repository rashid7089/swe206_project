package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Team {
    public static HashMap<String, Team> teamList = new HashMap<>();
    private String teamName;
    private ArrayList<Member> members;
    private Member leader;
    private ArrayList<Project> projects;

    public Team(String teamName, Member leader){
        this.leader = leader;
        leader.addLeader(this);
        leader.addTeam(this);
        this.teamName = teamName;
        members = new ArrayList<>();
        members.add(leader);
        projects = new ArrayList<>();
        teamList.put(teamName, this);
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
            leader.removeLeader(this);
            leader = m;
            leader.addLeader(this);
            return true;
        }
        return false;
    }

    public boolean addMember(Member m) {
        if(members.contains(m))
            return false;
        members.add(m);
        m.addTeam(this);
        return true;
    }

    public boolean removeMember(Member m) {
        if(m.equals(leader))
            return false;
        if(!members.contains(m))
            return false;
        members.remove(m);
        m.removeTeam(this);
        return true;
    }

    public void addProject(Project p) {
        projects.add(p);
    }

    public void removeProject(Project p) {
        projects.remove(p);
    }

    public int getNumberOfProjects() {
        return projects.size();
    }

    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/teams.txt"));
        while(in.hasNext()) {
            String name = in.nextLine();
            Scanner members = new Scanner(in.nextLine());
            String s = members.next();
            Team t = new Team(name, Member.memberList.get(s));
            while(members.hasNext())
                t.addMember(Member.memberList.get(members.next()));
        }
        Project.load();
    }

    public static void save() throws FileNotFoundException {

    }
    @Override
    public String toString(){
        return teamName;
    }
}