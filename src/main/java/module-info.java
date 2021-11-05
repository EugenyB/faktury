module com.bogdan.faktury {

    requires java.sql;
    requires lombok;
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bogdan.faktury to javafx.fxml;
    exports com.bogdan.faktury;
}