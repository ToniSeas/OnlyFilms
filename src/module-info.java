module Prueba_ProyectoFinal {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.base;
	requires javafx.base;
	requires java.desktop;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
