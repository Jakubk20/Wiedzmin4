module com.example.gra {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gra to javafx.fxml;
    exports com.example.gra;
    exports com.example.gra.Bies;
    opens com.example.gra.Bies to javafx.fxml;
    exports com.example.gra.Leszy;
    opens com.example.gra.Leszy to javafx.fxml;
    exports com.example.gra.Utopiec;
    opens com.example.gra.Utopiec to javafx.fxml;
    exports com.example.gra.Ghul;
    opens com.example.gra.Ghul to javafx.fxml;
}