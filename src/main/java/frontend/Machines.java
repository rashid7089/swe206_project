package frontend;

import Classes.Machine;
import Classes.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Machines extends BorderPane {


    public Machines(ArrayList<Machine> all_machines, String Title) {

        // ---------- Machines Left menu -----------------------------
        ListView<Machine> data_listView = new ListView<>();

        ObservableList<Machine> machines = FXCollections.observableArrayList(all_machines);

        data_listView.setItems(machines);
        data_listView.setCellFactory(param -> new DataListCell());
        data_listView.setMinHeight(Constants.laptopHeight);
        // -----------------------------------------------------------

        // Sidebar ------- No need to modify anything here  -------------------------------
        VBox sub_sidebar = new VBox(data_listView);
        Sidebar sidebar = new Sidebar(Title);

        Label noPage = new Label("No Content to display");
        noPage.getStyleClass().add("title");
        if (all_machines.size() == 0) sub_sidebar = new VBox(noPage);

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sidebar, sub_sidebar);
        splitPane.setDividerPositions(0.7);
        // Sidebar ------- -  --- -------------------------------------------------------

        setCenter(splitPane);
    }

    private static class DataListCell extends ListCell<Machine> {
        @Override
        protected void updateItem(Machine machine, boolean empty) {
            super.updateItem(machine, empty);

            if (empty || machine == null) {
                setText(null);
                setGraphic(null);
            } else {
                Label titleLabel = new Label(machine.toString());
                Label machinesStatus = new Label("Reserved Status: Free");
                Button detailsButton = new Button("More Details");

                // Styles ----------------- Do not touch -----------------
                titleLabel.getStyleClass().add("list__item__title");
                machinesStatus.getStyleClass().add("list__item__text");
                detailsButton.getStyleClass().add("list__item__button");
                // ------------------------- Do not touch -----------------


                detailsButton.setOnAction(event -> {
                    // Handle button click, e.g., show more details
                    System.out.println("Details for " + machine);
                });


                // Layout the cell content
                BorderPane cellPane = new BorderPane();
                cellPane.setTop(titleLabel);
                cellPane.setLeft(machinesStatus);
                cellPane.setRight(detailsButton);

                setText(null);
                setGraphic(cellPane);
            }
        }
    }

}


