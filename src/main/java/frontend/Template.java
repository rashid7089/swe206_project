package frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Template extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setWidth(Constants.laptopWidth);
        primaryStage.setHeight(Constants.laptopHeight);

        primaryStage.setTitle("JavaFX Button Template");

        // Create a Button
        Button myButton = new Button("Click me!");

        // Set an action when the button is clicked
        myButton.setOnAction(e -> {
            System.out.println("Button clicked!");
        });

        StackPane root = new StackPane();
        root.getChildren().add(myButton);

        // Create the scene
        Scene scene = new Scene(root, 300, 250);

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}