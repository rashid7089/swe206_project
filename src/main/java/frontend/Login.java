package frontend;

import Classes.User;
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

public class Login extends StackPane {

//    @Override

//    public boolean auth(String username, String password) {
//
//    }
    public Login() {

        // title
        Label titleLabel = new Label("Login");

        // username Field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        // password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        // sign in button
        Button signInButton = new Button("Sign In"); // call Auth


        // error label
        Label errorLabel = new Label("Error: username or password is wrong");
        errorLabel.setVisible(false);


        signInButton.setOnAction(event -> {
            User result = User.login(usernameField.getText(), passwordField.getText());
            if (result != null) {
                usernameField.setText("");
                passwordField.setText("");
                Main.loged_user = result;
                Main.setPage("Projects");
            }
            passwordField.setText("");
            errorLabel.setVisible(true);
        });

        // Styles ----------------- Do not touch -----------------
        titleLabel.getStyleClass().add("title");
        usernameField.getStyleClass().add("input__primary");
        passwordField.getStyleClass().add("input__primary");
        signInButton.getStyleClass().add("button__primary");
        errorLabel.getStyleClass().add("error-label");
        // ------------------------- Do not touch -----------------

        // Create layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, signInButton, errorLabel);
        layout.setPadding(new Insets(20));
        layout.getStyleClass().add("container");  // Style --- Do not touch

        getStyleClass().add("main-container"); // Style --- Do not touch
        getChildren().add(layout);
    }



}
