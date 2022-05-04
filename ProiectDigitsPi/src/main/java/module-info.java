module com.example.proiectdigitspi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.proiectdigitspi to javafx.fxml;
    exports com.example.proiectdigitspi;
}