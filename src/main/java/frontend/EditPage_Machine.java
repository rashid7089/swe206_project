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

public class EditPage_Machine extends BorderPane {


    public EditPage_Machine() {

        // layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // title
        Label titleLabel = new Label("New Machine");
        layout.getChildren().add(titleLabel);

        Label subtitleLabel = new Label("add a new Machine");
        layout.getChildren().add(subtitleLabel);


        //#region fields generator ------------------ ---------

        TextField uField_1 = new TextField(); // field
        uField_1.setPromptText("machineName");
        uField_1.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        layout.getChildren().add(uField_1);


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
