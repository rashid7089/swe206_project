package frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setWidth(Constants.laptopWidth);
        primaryStage.setHeight(Constants.laptopHeight);

        primaryStage.setTitle("Sign In Form");

        // title
        Label titleLabel = new Label("Login");

        // username Field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        // password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        // sign in button
        Button signInButton = new Button("Sign In");

        // error label
        Label errorLabel = new Label("Error: password is wrong");


        // Styles ----------------- Do not touch -----------------
        titleLabel.getStyleClass().add("login-title");
        usernameField.getStyleClass().add("input__primary");
        passwordField.getStyleClass().add("input__primary");
        signInButton.getStyleClass().add("button__primary");
        errorLabel.getStyleClass().add("error-label");
        // ------------------------- Do not touch -----------------


        // Create layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, signInButton, errorLabel);
        layout.setPadding(new Insets(20));
        layout.getStyleClass().add("container");

        // Create a resizable StackPane
        StackPane root = new StackPane();
        root.getStyleClass().add("main-container");
        root.getChildren().add(layout);

        // Create scene
        Scene scene = new Scene(root, Constants.laptopWidth, Constants.laptopHeight);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Set up stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
