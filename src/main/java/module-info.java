module com.example.gra {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gra to javafx.fxml;
    exports com.example.gra;
    exports com.example.gra.trader1;
    opens com.example.gra.trader1 to javafx.fxml;
    exports com.example.gra.leszy;
    opens com.example.gra.leszy to javafx.fxml;
    exports com.example.gra.ghul;
    opens com.example.gra.ghul to javafx.fxml;
    exports com.example.gra.bies;
    opens com.example.gra.bies to javafx.fxml;
    exports com.example.gra.utopiec;
    opens com.example.gra.utopiec to javafx.fxml;
    exports com.example.gra.strzyga;
    opens com.example.gra.strzyga to javafx.fxml;
    exports com.example.gra.miasto;
    opens com.example.gra.miasto to javafx.fxml;
}