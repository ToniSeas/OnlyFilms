package application;
	
import GUI.StageLogin;
import Utility.ResourcesPath;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	public static void main(String[] args) {
			
		launch(args);
		
	} // Fin del main

	@Override
	public void start(Stage primaryStage) throws Exception {		

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		}); 
		
		Image imageIcon=new Image(getClass().getResource(ResourcesPath.WINDOWICON).toExternalForm());
		primaryStage.getIcons().setAll(imageIcon);
		
		primaryStage.setResizable(false);
		new StageLogin(primaryStage);
				
	} // Fin de start
	
} // Fin de la clase