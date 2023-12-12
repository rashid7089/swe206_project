package frontend;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button classTransitionButton = new Button("Transition me");

        // Set CSS class
        classTransitionButton.getStyleClass().add("initial-style");

        // Create a Timeline for the transition
        Timeline timeline = new Timeline();

        // Define the keyframes for the transition
        KeyValue keyValue1 = new KeyValue(classTransitionButton.styleProperty(), "");
        KeyValue keyValue2 = new KeyValue(classTransitionButton.styleProperty(), "-fx-background-color: #3498db;");
        KeyFrame keyFrame1 = new KeyFrame(Duration.ZERO, keyValue1);
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(2), keyValue2);

        // Add the keyframes to the timeline
        timeline.getKeyFrames().addAll(keyFrame1, keyFrame2);

        // Set the animation to play on button click
        classTransitionButton.setOnAction(event -> timeline.playFromStart());

        StackPane root = new StackPane();
        root.getChildren().add(classTransitionButton);

        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Add your CSS file

        primaryStage.setTitle("Class Transition Button Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
