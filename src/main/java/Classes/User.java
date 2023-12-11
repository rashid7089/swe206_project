package Classes;

public class User {
    private String user_name, password;
    private int id;

    public User(String user_name, String password, int id){
        this.user_name = user_name;
        this.password = password;
        this.id = id;
    }

    public boolean login(String user, String pass) {
        return user.equals(user_name) & pass.equals(password);
    }

    public int getId() {
        return id;
    }
}