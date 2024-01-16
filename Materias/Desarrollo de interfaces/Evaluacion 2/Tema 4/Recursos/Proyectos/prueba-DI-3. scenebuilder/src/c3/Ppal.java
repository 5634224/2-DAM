package c3;

import java.io.IOException;

import controllers.ControllerPpalPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.MyModel;

public class Ppal extends Application {

	
	public void start(Stage stage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/PpalPane.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        //Creamos y Asignamos MODELO
        MyModel m = new MyModel();
        ((ControllerPpalPane) loader.getController()).setModel (m);
        
        stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
