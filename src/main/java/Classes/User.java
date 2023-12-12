package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class User {
    private String user_name, password, id;

    public User(String user_name, String password, String id){
        this.user_name = user_name;
        this.password = password;
        this.id = id;
    }

    public boolean login(String user, String pass) {
        return user.equals(user_name) & pass.equals(password);
    }

    public String getId() {
        return id;
    }

    public static void load() throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/users.txt"));
        new Admin(in.next(), in.next(), in.next());
        while(in.hasNext())
            new Member(in.next(), in.next(), in.nextLine().trim(), in.nextLine());
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