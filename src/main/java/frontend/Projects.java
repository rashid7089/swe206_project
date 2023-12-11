package frontend;

import Classes.Project;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Projects extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(Constants.laptopWidth);
        primaryStage.setHeight(Constants.laptopHeight);

        // ---------- Projects Left menu -----------------------------
        ListView<Project> projectListView = new ListView<>();

        ObservableList<Project> projects = FXCollections.observableArrayList(
                new Project("Project A"),
                new Project("Project B"),
                new Project("Project C")
        );

        projectListView.setItems(projects);
        projectListView.setCellFactory(param -> new ProjectListCell());
        projectListView.setMinHeight(Constants.laptopHeight);
        // -----------------------------------------------------------



        // Sidebar ------- No need to modify anything here  -------------------------------
        VBox sub_sidebar = new VBox(projectListView);
        Sidebar sidebar = new Sidebar("Projects");

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sidebar, sub_sidebar);
        splitPane.setDividerPositions(0.7);
        // Sidebar ------- -  --- -------------------------------------------------------

        BorderPane root = new BorderPane();
        root.setCenter(splitPane);
        Scene scene = new Scene(root, 400, 300);

        // Styles ------- DON't TOUCH --------------------------
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("sidebar.css").toExternalForm());
        // Styles ------- DON't TOUCH --------------------------

        primaryStage.setTitle("Project Menu List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class ProjectListCell extends ListCell<Project> {
        @Override
        protected void updateItem(Project project, boolean empty) {
            super.updateItem(project, empty);

            if (empty || project == null) {
                setText(null);
                setGraphic(null);
            } else {
                VBox hbox = new VBox(10);
                Label titleLabel = new Label(project.getName());
                Label statusLabel = new Label("Status: " + project.getStatus());
                Label teamLabel = new Label("Team: " + project.getTeam());
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
                    System.out.println("Details for " + project.getName());
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

    public static void main(String[] args) {
        launch(args);
    }
}
