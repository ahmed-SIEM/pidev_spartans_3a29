module test {

    requires javafx.controls;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires java.sql;
    requires sinch.sdk.java;


    opens test to javafx.fxml;
    exports test;
    exports services.GestionUser;
    exports models;
    opens services.GestionUser to javafx.fxml;
    exports test.Controllers;
    opens test.Controllers to javafx.fxml;
    exports test.Controllers.Common;
    opens test.Controllers.Common to javafx.fxml;

}
