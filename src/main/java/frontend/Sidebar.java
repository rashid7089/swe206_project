package frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Sidebar extends VBox {

    public Sidebar(String currentPage) {
        String[] Titles = {"Home Page", "Projects", "Teams", "Logout"};
        getStyleClass().add("sidebar");

        Label titleLabel = new Label("SIDEBAR");
        titleLabel.getStyleClass().add("title");
        titleLabel.getStyleClass().add("sidebar__title");
        titleLabel.setAlignment(Pos.TOP_LEFT);

        getChildren().add(titleLabel);
        for(String a : Titles) {
            Button sidebarButton = new Button(a); // TODO: change page to choosed a
            sidebarButton.getStyleClass().add("sidebar__button");
            sidebarButton.getStyleClass().add("btn");
            if (a == currentPage) {
                sidebarButton.getStyleClass().add("sidebar__button--active");
            }

            getChildren().add(sidebarButton);
        }
        setAlignment(Pos.TOP_CENTER);
        setSpacing(10);
        setMinWidth(300);
        setMaxWidth(300);

    }
}
