module com.example.newcmmande {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    opens com.example.newcmmande.Controls.Client to javafx.fxml;
    opens com.example.newcmmande to javafx.fxml;
    opens com.example.newcmmande.Controls to javafx.fxml;
    exports com.example.newcmmande;
    exports com.example.newcmmande.Controls ;
    exports com.example.newcmmande.Controls.Admin;
    exports com.example.newcmmande.Controls.Client;
    exports com.example.newcmmande.Models;
    exports com.example.newcmmande.Views;
}
