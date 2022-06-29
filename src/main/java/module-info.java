module com.example.ordinacija {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.ordinacija.model to javafx.base;
    exports com.example.ordinacija.model to javafx.base;
    opens com.example.ordinacija to javafx.fxml;
    exports com.example.ordinacija;
    exports com.example.ordinacija.controller;
    opens com.example.ordinacija.controller to javafx.fxml;
}