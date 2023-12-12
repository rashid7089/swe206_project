package frontend;

import Classes.Project;
import Classes.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Teams extends BorderPane {


    public Teams(ArrayList<Team> all_teams) {

        // ---------- Teams Left menu -----------------------------
        ListView<Team> data_listView = new ListView<>();

        ObservableList<Team> teams = FXCollections.observableArrayList(all_teams);

        data_listView.setItems(teams);
        data_listView.setCellFactory(param -> new DataListCell());
        data_listView.setMinHeight(Constants.laptopHeight);
        // -----------------------------------------------------------

        // Sidebar ------- No need to modify anything here  -------------------------------
        VBox sub_sidebar = new VBox(data_listView);
        Sidebar sidebar = new Sidebar("Teams");

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sidebar, sub_sidebar);
        splitPane.setDividerPositions(0.7);
        // Sidebar ------- -  --- -------------------------------------------------------

        setCenter(splitPane);
    }

    private static class DataListCell extends ListCell<Team> {
        @Override
        protected void updateItem(Team team, boolean empty) {
            super.updateItem(team, empty);

            if (empty || team == null) {
                setText(null);
                setGraphic(null);
            } else {
                VBox hbox = new VBox(10);
                Label titleLabel = new Label(team.getName());
                Label statusLabel = new Label("Leader: " + team.getLeader());
                Label teamLabel = new Label("Projects: " + team.getNumberOfProjects());
                Button detailsButton = new Button("More Details");

                // Styles ----------------- Do not touch -----------------
                titleLabel.getStyleClass().add("list__item__title");
                statusLabel.getStyleClass().add("list__item__text");
                teamLabel.getStyleClass().add("list__item__text");
                detailsButton.getStyleClass().add("list__item__button");
//                detailsButton.getStyleClass().add("btn");

//                errorLabel.getStyleClass().add("error-label");
                // ------------------------- Do not touch -----------------


                detailsButton.setOnAction(event -> {
                    // Handle button click, e.g., show more details
                    System.out.println("Details for " + team.getName());
                });


                // Layout the cell content
                BorderPane cellPane = new BorderPane();
                cellPane.setTop(titleLabel);
                hbox.getChildren().addAll(statusLabel, teamLabel);
                cellPane.setLeft(hbox);
                cellPane.setRight(detailsButton);

                setText(null);
                setGraphic(cellPane);
            }
        }
    }

}
