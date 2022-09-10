module com.example.gra {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gra to javafx.fxml;
    exports com.example.gra;
    exports com.example.gra.trader1;
    opens com.example.gra.trader1 to javafx.fxml;
    exports com.example.gra.test1;
    opens com.example.gra.test1 to javafx.fxml;
    exports com.example.gra.test2;
    opens com.example.gra.test2 to javafx.fxml;
    exports com.example.gra.test3;
    opens com.example.gra.test3 to javafx.fxml;
    exports com.example.gra.test4;
    opens com.example.gra.test4 to javafx.fxml;
}