module helloworldfx {
    requires javafx.fxml;
    requires javafx.controls;

    exports gui;

    opens sample;
    opens gui;
}