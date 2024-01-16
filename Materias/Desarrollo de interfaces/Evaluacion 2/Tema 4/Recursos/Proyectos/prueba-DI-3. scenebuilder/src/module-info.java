module c3 {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	
	exports c3;
	exports controllers;
	opens controllers; 	//Para que funcione la reflexión
	
}