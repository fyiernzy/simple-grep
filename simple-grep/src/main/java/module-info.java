module com.fyiernzy.simplegrep.simplegrep {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;
    requires org.jetbrains.annotations;

    opens com.fyiernzy.simplegrep.simplegrep to javafx.fxml;
    exports com.fyiernzy.simplegrep.simplegrep;
}