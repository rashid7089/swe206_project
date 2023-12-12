package frontend;

import Classes.Machine;
import Classes.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EditPage extends BorderPane {


    public EditPage() {

        //#region Form and DataField ----------------------------------
        // layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // title
        Label titleLabel = new Label("Login");
        layout.getChildren().add(titleLabel);

        Label subtitleLabel = new Label("a good description required a good grade");
        layout.getChildren().add(subtitleLabel);


        ArrayList<String> inputFields = new ArrayList<>();
        inputFields.add("Username");
        inputFields.add("Password");
        inputFields.add("Password");
        inputFields.add("Password");
        inputFields.add("Password");
        inputFields.add("Password");

        int counter = 1;
        HBox currentBox = new HBox(2);
        currentBox.setSpacing(20);

        for(String field: inputFields) {
            TextField uField = new TextField();
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
        // update button
        Button updateButton = new Button("Update");

        // error label
        Label errorLabel = new Label("Error: password is wrong");
        layout.getChildren().addAll(updateButton, errorLabel);

        // Styles ----------------- Do not touch -----------------
        titleLabel.getStyleClass().add("title__primary");
        updateButton.getStyleClass().add("button__primary");
        errorLabel.getStyleClass().add("error-label");
        subtitleLabel.getStyleClass().add("sub-title__primary");
        // ------------------------- Do not touch -----------------

        //#endregion


//        VBox sub_sidebar = new VBox(data_listView);

        //#region Sidebar ------------------------------------------------
        Sidebar sidebar = new Sidebar("Title");

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sidebar, layout);
        splitPane.setDividerPositions(0.7);
        //#endregion -------------------------------------------------------

        setCenter(splitPane);
    }

}
