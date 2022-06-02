module com.sveps.svepsfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sveps.svepsfx to javafx.fxml;
    exports com.sveps.svepsfx;
}