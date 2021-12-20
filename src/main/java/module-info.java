module com.example.fileparsergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.example.fileparsergui to javafx.fxml;
    exports com.example.fileparsergui;
}