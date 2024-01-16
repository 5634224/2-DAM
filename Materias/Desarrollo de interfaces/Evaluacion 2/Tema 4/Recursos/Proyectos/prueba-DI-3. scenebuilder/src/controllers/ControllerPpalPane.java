package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.MyModel;

public class ControllerPpalPane {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button miBoton;
    
    
    MyModel myModel;
    
    public void setModel(MyModel m) {
    	myModel = m;
    	
    	miBoton.setText("Modelo: " + myModel.getSaludo() + " pulsa para abrir nueva ventana");
    }
    
    
    @FXML
    void myButtonMouseClicked(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/Pane2.fxml"));
        Parent root = loader.load();
        
        ControllerPane2 p = (ControllerPane2) loader.getController();
        p.setDato("Dato enviado");
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert miBoton != null : "fx:id=\"miBoton\" was not injected: check your FXML file 'PpalPane.fxml'.";

    }
}

