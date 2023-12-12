package frontend;

import Classes.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static User loged_user;

    public static ArrayList<String> cssClasses;
    // Create the scene
    private static Scene login_scene;
    private static Scene projectPage_scene;
    private static Scene teamsPage_scene;
    private static Scene ourmachinesPage_scene ;
    private static Scene machinesPage_scene ;
    private static Scene editpage_scene;
    private static Scene editpage_machine_scene;
    private static Scene editpage_team_scene;
    private static Scene editpage_project_scene;
    private static Scene reserveMachine_scene;

    private static Stage primaryStage;

    public static void setPage(String page) {
        if(page.equals("Projects")){
            primaryStage.setScene(projectPage_scene);

        }
        else if (page.equals("Teams")){
            primaryStage.setScene(teamsPage_scene);

        }
        else if (page.equals("Our Reserved Machines")) {
            primaryStage.setScene(ourmachinesPage_scene);

        }
        else if (page.equals("Machines")) {
            primaryStage.setScene(machinesPage_scene);

        }
        else if(page.equals("Edit page")){
            primaryStage.setScene(editpage_scene);

        }
        else if(page.equals("Add a machine")){
            primaryStage.setScene(editpage_machine_scene);

        }
        else if(page.equals("Add a team")){
            primaryStage.setScene(editpage_team_scene);

        }
        else if(page.equals("Add a project")){
            primaryStage.setScene(editpage_project_scene);

        }
        else if(page.equals("Reserve a Machine")){
            primaryStage.setScene(reserveMachine_scene);

        }


    }


    public static void LoadPages() { // needed so pages can load after loged user initalized

        ArrayList<Team> teams_data = loged_user.getTeams();
        ArrayList<Project> projects_data = loged_user.getProjects();
        ArrayList<Machine> machineArrayList = loged_user.getMachines();

        Projects projectsPage = new Projects(projects_data);
        Teams teamsPage = new Teams(teams_data);
        Machines ourmachinesPage = new Machines(machineArrayList, "Our Reserved Machines");
        Machines machinesPage = new Machines(machineArrayList, "Machines");

        // edit pages
        EditPage editpage = new EditPage();
        EditPage_Machine editpage_machine = new EditPage_Machine();
        EditPage_Team editpage_team = new EditPage_Team();
        EditPage_Project editpage_project = new EditPage_Project();
        ReserverMachine reserverMachine = new ReserverMachine();

        // Create the scene
        projectPage_scene = new Scene(projectsPage, Constants.laptopWidth, Constants.laptopHeight);
        teamsPage_scene = new Scene(teamsPage, Constants.laptopWidth, Constants.laptopHeight);
        ourmachinesPage_scene = new Scene(ourmachinesPage, Constants.laptopWidth, Constants.laptopHeight);
        machinesPage_scene = new Scene(machinesPage, Constants.laptopWidth, Constants.laptopHeight);
        editpage_scene = new Scene(editpage, Constants.laptopWidth, Constants.laptopHeight);
        editpage_machine_scene = new Scene(editpage_machine, Constants.laptopWidth, Constants.laptopHeight);
        editpage_team_scene = new Scene(editpage_team, Constants.laptopWidth, Constants.laptopHeight);
        editpage_project_scene = new Scene(editpage_project, Constants.laptopWidth, Constants.laptopHeight);
        reserveMachine_scene = new Scene(reserverMachine, Constants.laptopWidth, Constants.laptopHeight);

        // load Styles Files
        projectPage_scene.getStylesheets().addAll(cssClasses);
        teamsPage_scene.getStylesheets().addAll(cssClasses);
        ourmachinesPage_scene.getStylesheets().addAll(cssClasses);
        machinesPage_scene.getStylesheets().addAll(cssClasses);
        editpage_scene.getStylesheets().addAll(cssClasses);
        editpage_machine_scene.getStylesheets().addAll(cssClasses);
        editpage_team_scene.getStylesheets().addAll(cssClasses);
        editpage_project_scene.getStylesheets().addAll(cssClasses);
        reserveMachine_scene.getStylesheets().addAll(cssClasses);

    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        primaryStage.setWidth(Constants.laptopWidth);
        primaryStage.setHeight(Constants.laptopHeight);

        // title of the window
        primaryStage.setTitle("Panel");

        cssClasses = new ArrayList<>(List.of(getClass().getResource("styles.css").toExternalForm(), getClass().getResource("sidebar.css").toExternalForm()));

        Login loginPage = new Login();
        login_scene = new Scene(loginPage, Constants.laptopWidth, Constants.laptopHeight);
        login_scene.getStylesheets().addAll(cssClasses);

        // Set up the stage
        primaryStage.setScene(login_scene);
        primaryStage.show();
    }

    public static ArrayList<Team> generateDumyTeamList() {
        // Dummy data
        Member member1 = new Member("user1", "password1",  "John Doe");
        Member member2 = new Member("user2", "password2",  "Jane Doe");

        Team team1 = new Team("Team1", member1);
        team1.addMember(member2);

        ArrayList<Team> teamArrayList = new ArrayList<>();
        teamArrayList.add(team1);
        return teamArrayList;
    }

    public static void main(String[] args) {
        try {
            User.load();
            launch();
        }
        catch (FileNotFoundException ex) {
            System.out.println("unexpected error happened");
        }
    }
}