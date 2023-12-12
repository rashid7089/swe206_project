package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private String user_name, password;
    private static HashMap<String,String> userAuth = new HashMap<>(); //

    public User(String user_name, String password){
        this.user_name = user_name;
        this.password = password;
        userAuth.put(user_name, password);
    }

    public static boolean login(String user, String pass) {
        if (userAuth.containsKey(user)) return userAuth.get(user).equals(pass);
        return false;
    }

    public boolean isAdmin() {
        return false;
    }


    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/users.txt"));
        new Admin(in.next(), in.next(), in.next());
        while(in.hasNext())
            new Member(in.next(), in.nextLine().trim(), in.nextLine());
        in.close();
        Team.load();
    }

    public static void main(String[] args) {
        try{
            load();
        } catch (FileNotFoundException ex) {
            System.out.println("error");
        }
    }
}