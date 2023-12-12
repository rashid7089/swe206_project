package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class User {
    private String user_name, password;
    public static boolean loaded = false;
    private static HashMap<String,String> userAuth = new HashMap<>(); //
    public static HashMap<String,User> userObjects = new HashMap<>(); //

    public User(String user_name, String password){
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }
    public ArrayList<String> allowedPages() {
        return new ArrayList<>(List.of("Projects", "Teams", "Machines", "Our Reserved Machines", "Reserve a Machine"));
    }
    public static User login(String user, String pass) {
        if(user.equals(Admin.admin.getUser_name())) {
            if (pass.equals(Admin.admin.getPassword()))
                return Admin.admin;
        }
        if(Member.memberList.containsKey(user)) {
            if(Member.memberList.get(user).getPassword().equals(pass))
                return Member.memberList.get(user);
        }
        return null;
    }
    @Override
    public String toString() {
        return user_name + " " + password;
    }

    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/users.txt"));
        new Admin(in.next(), in.next());
        while(in.hasNext())
            new Member(in.next(), in.nextLine().trim(), in.nextLine());
        in.close();
        Team.load();
        loaded = true;
    }

    public static void save() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("data/users.txt"));
        pw.println(Admin.admin.toString());
        for(Member m: Member.memberList.values())
            pw.println(m.toString());
        pw.close();
        Team.save();
    }

    public static void main(String[] args) {
        try {
            load();
            save();
        } catch (FileNotFoundException ex) {
            System.out.println("error");
        }
    }
}