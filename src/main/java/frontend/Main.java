package frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setWidth(Constants.laptopWidth);
        primaryStage.setHeight(Constants.laptopHeight);

        // title of the window
        primaryStage.setTitle("JavaFX Button Template");

        // pages
        Login loginPage = new Login();
        Projects projectsPage = new Projects();


        // Create the scene
        Scene scene = new Scene(projectsPage, Constants.laptopWidth, Constants.laptopHeight);

        // load Styles Files
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("sidebar.css").toExternalForm());

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}