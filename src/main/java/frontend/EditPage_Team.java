package frontend;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EditPage_Team extends BorderPane {


    public EditPage_Team() {

        // layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // title
        Label titleLabel = new Label("New Team");
        layout.getChildren().add(titleLabel);

        Label subtitleLabel = new Label("add a new Team");
        layout.getChildren().add(subtitleLabel);


        ArrayList<String> inputFields = new ArrayList<>();
        inputFields.add("TeamName");


        //#region fields generator ------------------ ---------
        int counter = 1;
        HBox currentBox = new HBox(2);
        currentBox.setSpacing(20);

        for(String field: inputFields) {
            TextField uField = new TextField(); /// field
            uField.setPromptText(field);
            uField.getStyleClass().add("input__primary");
            uField.getStyleClass().add("input__primary--mxWidth");

            currentBox.getChildren().add(uField);
            if (counter%2==0) {
                layout.getChildren().add(currentBox);
                currentBox = new HBox(2);
                currentBox.setSpacing(20);
            }
            counter++;
        }
        layout.getChildren().add(currentBox);

        // update button
        Button updateButton = new Button("Update");

        // error label
        Label errorLabel = new Label("Error: password is wrong");
        layout.getChildren().addAll(updateButton, errorLabel);
        //#endregion ------------------------------------------------------

        //#region Styles ----------------- Do not touch -----------------
        titleLabel.getStyleClass().add("title__primary");
        updateButton.getStyleClass().add("button__primary");
        errorLabel.getStyleClass().add("error-label");
        subtitleLabel.getStyleClass().add("sub-title__primary");
        //#endregion ------------------------- Do not touch -----------------

        // ---------------------------------------------------------------------------------------

        //#region Sidebar ------------------------------------------------
        Sidebar sidebar = new Sidebar("Title");

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sidebar, layout);
        splitPane.setDividerPositions(0.7);
        //#endregion -------------------------------------------------------

        setCenter(splitPane);
    }



}
