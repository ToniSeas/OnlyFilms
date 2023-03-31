package Utility;

import java.io.InputStream;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LoadGlobalFont {
			
	public static Font potanoSans (int size) {
		
	try {
		InputStream is = LoadGlobalFont.class.getResourceAsStream("/resources/TextFont/PontanoSans-Regular.tff");
		System.out.println("llega");
		return Font.loadFont(is, size);
    } catch (Exception ex) {
        //Si existe un error se carga fuente por defecto
    	return Font.font("Marguerite", FontWeight.LIGHT, FontPosture.REGULAR, size);
    }
	
	} // Fin de loadFont
	
	public static Font meadow (int size) {
		
	try {
		InputStream is = LoadGlobalFont.class.getResourceAsStream("/resources/TextFont/Meadow.otf");
		return Font.loadFont(is, size);
    } catch (Exception ex) {
        //Si existe un error se carga fuente por defecto
    	return Font.font("Marguerite", FontWeight.LIGHT, FontPosture.REGULAR, size);
    }
	
	} // Fin de loadFont
	
} // Fin de clase
