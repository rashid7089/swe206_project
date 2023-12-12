package frontend;

import Classes.Admin;
import Classes.Member;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


public class Sidebar extends VBox {

    public Sidebar(String currentPage) {
        ArrayList<String> Titles = Main.loged_user.allowedPages();

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
            sidebarButton.setOnAction(e-> Main.setPage(a)); //call setScence function based on the buttios pressed
            getChildren().add(sidebarButton);
        }
        setAlignment(Pos.TOP_CENTER);
        setSpacing(10);
        setMinWidth(300);
        setMaxWidth(300);

    }
}
