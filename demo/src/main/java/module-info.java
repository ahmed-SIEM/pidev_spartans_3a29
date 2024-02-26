module o.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens o.demo to javafx.fxml;
    exports o.demo;
}