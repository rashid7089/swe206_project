package Classes;

import java.util.ArrayList;

public class Member extends User {

    private ArrayList<Team> myTeam;
    private ArrayList<Team> leaderIn;

    public Member(String user_name, String password, int id) {
        super(user_name, password, id);
        
    }
        public Member(String user_name, String password, int id, ArrayList<Team> myTeam) {
        super(user_name, password, id);
        this.myTeam = myTeam;
    }
        public Member(String user_name, String password, int id, ArrayList<Team> myTeam, ArrayList<Team> leaderIn) {
        super(user_name, password, id);
        this.myTeam = myTeam;
        this.leaderIn = leaderIn;
    }
    
    public ArrayList<Team> getTeams() {
        return myTeam;
    }

    public ArrayList<Team> getLeaderIn() {
        return leaderIn;
    }
}
