package frontend;

import Classes.Member;
import Classes.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class EditPage_Project extends BorderPane {


    public EditPage_Project() {

        // layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // title
        Label titleLabel = new Label("New Project");
        layout.getChildren().add(titleLabel);

        Label subtitleLabel = new Label("add a new Project");
        layout.getChildren().add(subtitleLabel);


        //#region fields generator ------------------ ---------

        TextField uField_1 = new TextField(); // field
        uField_1.setPromptText("projectName");
        uField_1.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        layout.getChildren().add(uField_1);


        // Create a select boxs to select team
        ComboBox<String> team_box = new ComboBox<>();


        //#region don't change ---------------------------------
        // styles Don't touch
        team_box.getStyleClass().addAll("input__primary", "input__primary--mxWidth");

        // Create a list teams names
        ObservableList<String> members_options = FXCollections.observableArrayList(Team.teamList.keySet());

        team_box.setItems(members_options);
        team_box.setValue("add a Team");
        layout.getChildren().add(team_box);


        //#endregion

        // update button
        Button updateButton = new Button("Create New");

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
