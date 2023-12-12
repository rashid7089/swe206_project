package frontend;

import Classes.Machine;
import Classes.Member;
import Classes.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.time.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ReserverMachine extends BorderPane {


    public ReserverMachine() {

        // layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // title
        Label titleLabel = new Label("Reserve A Machine");
        layout.getChildren().add(titleLabel);

        Label subtitleLabel = new Label("reserve a machine to your team");
        layout.getChildren().add(subtitleLabel);
        //#region fields generator ------------------ ---------

        // Create a select boxs to select members
        ComboBox<String> machine = new ComboBox<>();
        ComboBox<String> team = new ComboBox<>();
        ComboBox<Integer> Year = new ComboBox<>();
        ComboBox<Integer> Month = new ComboBox<>();
        ComboBox<Integer> Day = new ComboBox<>();

        //#region don't change ---------------------------------

        // styles Don't touch
        machine.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        team.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        Year.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        Month.getStyleClass().addAll("input__primary", "input__primary--mxWidth");
        Day.getStyleClass().addAll("input__primary", "input__primary--mxWidth");


        // Create a list members names
        ObservableList<String> teams_options = FXCollections.observableArrayList(Team.teamList.keySet());
        ObservableList<String> machines_options = FXCollections.observableArrayList(Machine.machineList.keySet());

        int currentYear = LocalDate.now().getYear();
        ArrayList<Integer> possibleYears = new ArrayList<>();
        for (int i = 0; i < 5; i++) possibleYears.add(currentYear+i);
        ObservableList<Integer> years_options = FXCollections.observableArrayList(possibleYears);

        int currentMonth = LocalDate.now().getMonthValue();
        ArrayList<Integer> possibleMonths = new ArrayList<>();
        for (int i = currentMonth; i <= 12; i++) possibleMonths.add(i);
        ObservableList<Integer> months_options = FXCollections.observableArrayList(possibleMonths);

        int currentDay = LocalDate.now().getDayOfMonth();
        ArrayList<Integer> possibleDays = new ArrayList<>();
        System.out.println(LocalDate.now().lengthOfMonth());
        for (int i = currentDay; i <= LocalDate.now().lengthOfMonth(); i++) possibleDays.add(i);
        ObservableList<Integer> days_options = FXCollections.observableArrayList(possibleDays);


        team.setItems(machines_options);
        team.setValue("select the machine");
        layout.getChildren().add(machine);

        team.setItems(teams_options);
        team.setValue("select the team");
        layout.getChildren().add(team);

        Year.setItems(years_options);
        Year.setValue(currentYear);
        layout.getChildren().add(Year);

        Month.setItems(months_options);
        Month.setValue(currentMonth);
        layout.getChildren().add(Month);

        Day.setItems(days_options);
        Day.setValue(currentDay);
        layout.getChildren().add(Day);

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


        setCenter(splitPane);
    }



}

