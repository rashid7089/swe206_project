package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private String user_name, password;
    private static HashMap<String,String> userAuth = new HashMap<>(); //
    public static HashMap<String,User> userObjects = new HashMap<>(); //

    public User(String user_name, String password){
        this.user_name = user_name;
        this.password = password;
    }

    public static User login(String user, String pass) {
        if (userAuth.containsKey(user) && userAuth.get(user).equals(pass)) return userObjects.get(user);
        return null;
    }
    public boolean isAdmin() {
        return false;
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