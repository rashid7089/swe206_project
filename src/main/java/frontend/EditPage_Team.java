package frontend;

import Classes.Member;
import Classes.Project;
import Classes.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
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


        //#region fields generator ------------------ ---------

        TextField uField_1 = new TextField(); // field
        uField_1.setPromptText("TeamName");
        uField_1.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        layout.getChildren().add(uField_1);


        // Create a select boxs to select members
        ComboBox<String> leader = new ComboBox<>();
        ComboBox<String> member_1 = new ComboBox<>();
        ComboBox<String> member_2 = new ComboBox<>();
        ComboBox<String> member_3 = new ComboBox<>();


        //#region don't change ---------------------------------
        // styles Don't touch
        leader.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        member_1.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        member_2.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        member_3.getStyleClass().addAll("input__primary", "input__primary--mxWidth");

        // Create a list members names
        ObservableList<String> members_options = FXCollections.observableArrayList(Member.memberList.keySet());

        leader.setItems(members_options);
        leader.setValue("add a Leader");
        layout.getChildren().add(leader);

        member_1.setItems(members_options);
        member_1.setValue("add a Member");
        layout.getChildren().add(member_1);

        member_2.setItems(members_options);
        member_2.setValue("add a second Member");
        layout.getChildren().add(member_2);

        member_3.setItems(members_options);
        member_3.setValue("add a third Member");
        layout.getChildren().add(member_3);

        //#endregion

        // update button
        Button addButton = new Button("Add");

        // error label
        Label errorLabel = new Label("Error: team is already exists or memebers are duplicated");
        errorLabel.setVisible(false);
        layout.getChildren().addAll(addButton, errorLabel);
        //#endregion ------------------------------------------------------

        //#region Styles ----------------- Do not touch -----------------
        titleLabel.getStyleClass().add("title__primary");
        addButton.getStyleClass().add("button__primary");
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



        if (leader.equals(member_1) || leader.equals(member_2) || leader.equals(member_3)){
            errorLabel.setVisible(true);}
        else if (member_1.equals(member_2) || member_1.equals(member_3)){
                errorLabel.setVisible(true);
            }
        else if (member_2.equals(member_3)){
                errorLabel.setVisible(true);
            }
        else {
            Member mLeader = Member.memberList.get(leader.getValue());
            Member member1 = Member.memberList.get(member_1.getValue());
            Member member2 = Member.memberList.get(member_2.getValue());
            Member member3 = Member.memberList.get(member_3.getValue());

            addButton.setOnAction(e -> {
                String team = uField_1.getText();
                Team existingTeam = Team.teamList.get(team);

                if (existingTeam == null) {
                    errorLabel.setVisible(false);
                    Team newTeam = new Team(team, mLeader);
                    if (!member_1.equals("add a Member")) {
                        newTeam.addMember(member1);
                    }
                    if (!member_2.equals("add a second Member")) {
                        newTeam.addMember(member2);
                    }
                    if (!member_3.equals("add a third Member")) {
                        newTeam.addMember(member3);
                    }
                } else {
                    errorLabel.setVisible(true);
                }


            });
        }


        setCenter(splitPane);
    }



}

