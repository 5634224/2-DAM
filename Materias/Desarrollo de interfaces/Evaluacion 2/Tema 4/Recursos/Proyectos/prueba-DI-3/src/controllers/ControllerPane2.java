package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ControllerPane2 {

    @FXML
    private ComboBox<Label> myCombo;

    @FXML
    private Button bCerrar;
    
    private String dato = "dato inicial";
    
    @FXML
    void initialize() {
        myCombo.setPromptText(dato);
    }
    
    public void setDato (String l) {
    	myCombo.setPromptText(l);
    }

    @FXML
    void cerrarAction(ActionEvent event) {
    	System.out.println("CERRAR");
    }

}
