package frontend;

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


//    public void setPage(String page) {
//        if
//    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setWidth(Constants.laptopWidth);
        primaryStage.setHeight(Constants.laptopHeight);

        // title of the window
        primaryStage.setTitle("Panel");

        // TODO: add user object here
//        Member user = new Member()


        // demo data
        // TODO: change the following projects to what user can see
//        ArrayList<Project> projects_data = user.allProject(); EXAMPLE

        ArrayList<Project> projects_data = new ArrayList<>();
            projects_data.add(new Project("Project A"));
            projects_data.add(new Project("Project B"));
            projects_data.add(new Project("Project C"));

        // TODO: change the following function to get user teams (or all teams if user is admin)
//        ArrayList<Team> teams_data = generateDumyTeamList();


        // pages
        Login loginPage = new Login();
        Projects projectsPage = new Projects(projects_data);
//        Teams teamsPage = new Teams(teams_data);

        // Create the scene
        Scene login_scene = new Scene(loginPage, Constants.laptopWidth, Constants.laptopHeight);
        Scene projectPage_scene = new Scene(projectsPage, Constants.laptopWidth, Constants.laptopHeight);
        
        // load Styles Files
        login_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        login_scene.getStylesheets().add(getClass().getResource("sidebar.css").toExternalForm());
        projectPage_scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        projectPage_scene.getStylesheets().add(getClass().getResource("sidebar.css").toExternalForm());

        // Set up the stage
        // TODO: make the scene page dynamic (changeable)
        primaryStage.setScene(login_scene);
        primaryStage.show();
    }

    public ArrayList<Team> generateDumyTeamList() {
        // Dummy data
        Member member1 = new Member("user1", "password1", "1", "John Doe");
        Member member2 = new Member("user2", "password2", "2", "Jane Doe");

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