module frontend.softwareproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens frontend to javafx.fxml;
    exports frontend;
}