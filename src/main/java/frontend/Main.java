package frontend;

import Classes.Machine;
import Classes.Member;
import Classes.Project;
import Classes.Team;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends Application {


    // Create the scene
    private static Scene login_scene;
    private static Scene projectPage_scene;
    private static Scene teamsPage_scene;
    private static Scene ourmachinesPage_scene ;
    private static Scene machinesPage_scene ;
    private static Scene editpage_scene;
    private static Scene editpage_machine_scene;
    private static Stage primaryStage;

    public static void setPage(String page) {
        if(page.equals("Projects")){
            primaryStage.setScene(projectPage_scene);

        }
        else if (page.equals("Teams")){
            primaryStage.setScene(teamsPage_scene);

        }
        else if (page.equals("Logout")){
            primaryStage.setScene(login_scene);

        }
        else if (page.equals("OurMachines")) {
            primaryStage.setScene(ourmachinesPage_scene);

        }
        else if(page.equals("Editpage")){
            primaryStage.setScene(editpage_scene);

        }
        else if (page.equals("Machines")) {
            primaryStage.setScene(machinesPage_scene);

        }
        else if(page.equals("Editpage_machines")){
            primaryStage.setScene(editpage_machine_scene);

        }

    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        primaryStage.setWidth(Constants.laptopWidth);
        primaryStage.setHeight(Constants.laptopHeight);

        // title of the window
        primaryStage.setTitle("Panel");

        // TODO: add user object here
//        Member user = new Member()




        // TODO: change the following function to get user teams (or all teams if user is admin)
        ArrayList<Team> teams_data = generateDumyTeamList();

        // demo data
        // TODO: change the following projects to what user can see
//        ArrayList<Project> projects_data = user.allProject(); EXAMPLE

        ArrayList<Project> projects_data = new ArrayList<>();
//        projects_data.add(new Project("Project A", teams_data.get(0)));
////        projects_data.add(new Project("Project B"));
////        projects_data.add(new Project("Project C"));

        ArrayList<Machine> machineArrayList = new ArrayList<>();
        machineArrayList.add(new Machine("Machine1"));
        machineArrayList.add(new Machine("Machine2"));
        machineArrayList.add(new Machine("Machine3"));


        //#region pages --------------------------------------------------------
        Login loginPage = new Login();
        Projects projectsPage = new Projects(projects_data);
        Teams teamsPage = new Teams(teams_data);
        Machines ourmachinesPage = new Machines(machineArrayList, "Our Reserved Machines");
        Machines machinesPage = new Machines(machineArrayList, "Machines");

        // edit pages
        EditPage editpage = new EditPage();
        EditPage_Machine editpage_machine = new EditPage_Machine();


        //#endregion

        // Create the scene
        login_scene = new Scene(loginPage, Constants.laptopWidth, Constants.laptopHeight);
        projectPage_scene = new Scene(projectsPage, Constants.laptopWidth, Constants.laptopHeight);
        teamsPage_scene = new Scene(teamsPage, Constants.laptopWidth, Constants.laptopHeight);
        ourmachinesPage_scene = new Scene(ourmachinesPage, Constants.laptopWidth, Constants.laptopHeight);
        machinesPage_scene = new Scene(machinesPage, Constants.laptopWidth, Constants.laptopHeight);
        editpage_scene = new Scene(editpage, Constants.laptopWidth, Constants.laptopHeight);
        editpage_machine_scene = new Scene(editpage_machine, Constants.laptopWidth, Constants.laptopHeight);


        System.out.println(projectPage_scene);
        String[] cssClasses = {getClass().getResource("styles.css").toExternalForm(), getClass().getResource("sidebar.css").toExternalForm()};

        // load Styles Files
        login_scene.getStylesheets().addAll(cssClasses);
        projectPage_scene.getStylesheets().addAll(cssClasses);
        teamsPage_scene.getStylesheets().addAll(cssClasses);
        ourmachinesPage_scene.getStylesheets().addAll(cssClasses);
        machinesPage_scene.getStylesheets().addAll(cssClasses);
        editpage_scene.getStylesheets().addAll(cssClasses);
        editpage_machine_scene.getStylesheets().addAll(cssClasses);
        // Set up the stage
        // TODO: make the scene page dynamic (changeable)
        primaryStage.setScene(projectPage_scene);
        primaryStage.show();
    }

    public ArrayList<Team> generateDumyTeamList() {
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
        launch();
    }
}
