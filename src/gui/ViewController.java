package gui;


import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class ViewController {

    @FXML
    private Button btTest;

    @FXML
    private TextField field1;

    @FXML
    private TextField field2;

    @FXML
    private Label result;


    @FXML
    public void onBtTestAction(){
        Locale.setDefault(Locale.US);
        try{

            Double sum = Double.parseDouble(field1.getText()) + Double.parseDouble(field2.getText());
            result.setText(String.format("Result = %.2f", sum));
        }catch (Exception e){
            Alerts.showAlert(
                    "Error",
                    null,
                    e.getMessage(),
                    AlertType.ERROR
            );
        }

    }

}
