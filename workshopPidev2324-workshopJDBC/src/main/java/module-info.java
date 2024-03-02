module test {

    requires javafx.controls;
    requires javafx.fxml;


    requires java.sql;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;


    opens test to javafx.fxml;
    exports test;
    exports services.GestionEvenement;
    exports models;

    exports test.Controllers;
    opens test.Controllers to javafx.fxml;


}
