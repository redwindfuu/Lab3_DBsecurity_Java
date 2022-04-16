module com {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.app to javafx.fxml;
    exports com.app;
    exports com.app.Controller;
    opens com.app.Controller to javafx.fxml;
    exports com;
}