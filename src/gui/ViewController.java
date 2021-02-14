package gui;


import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import model.entities.Person;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;
    private ObservableList<Person> obsList;


    @FXML
    private Button btAll;

    @FXML
    public void onComboBoxPersonAction(){
        Person p = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(p);
    }

    @FXML
    public void onBtAllAction(){
        for (Person p : comboBoxPerson.getItems()){
            System.out.println(p);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();

        list.add(new Person(1, "Maria", "maria@gmail.com"));
        list.add(new Person(2, "Alex", "alex@gmail.com"));
        list.add(new Person(3, "Bob", "bob@gmail.com"));

        obsList = FXCollections.observableArrayList(list);

        comboBoxPerson.setItems(obsList);


        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }


}
