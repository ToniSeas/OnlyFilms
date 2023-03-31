package GUI;

import java.io.IOException;


import Business.UserAcountBusiness;
import Domain.Profile;
import Domain.SingletonUserAccountUse;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageAddProfile {
	private Label lblNameProfile,lblAge,lblGenderProfile, lblAccountRegion;
	private Label lbltitle; 
	private TextField txfNameProfile, txfGenderProfile, txfAccountRegion, txfAge;
	private Button btnRegistrar;
	private Button btnToReturn;
	
	public StageAddProfile(Stage primaryStage) {
		this.init(primaryStage);
	} // Fin del constructor
	
	private void init(Stage primaryStage) {

		Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20);
		
		StackPane root = new StackPane();
		VBox contLogin=new VBox();
		contLogin.setPrefSize(400, 400);
		contLogin.setStyle("-fx-background-color: #ffffffff");
		this.lbltitle=new Label("Agregar Perfil");
		this.lbltitle.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 30));
		VBox.setMargin(lbltitle, new Insets(0,150,0,150));
		
		Stage stage = new Stage();
		stage.getIcons().setAll(primaryStage.getIcons());
		
		stage.setScene(new Scene(root));
		stage.setTitle("Añadir Perfil");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		stage.setResizable(false);
		stage.setWidth(550);
		stage.setHeight(500);
		stage.show();
		
		this.lblNameProfile=new Label("Nombre Perfil:");
		this.lblNameProfile.setFont(font);
		
		this.lblAge=new Label("Edad: ");
		this.lblAge.setFont(font);
		
		this.lblGenderProfile=new Label("Genero: ");
		this.lblGenderProfile.setFont(font);
		
		this.lblAccountRegion=new Label("Región");
		this.lblAccountRegion.setFont(font);
		
		this.txfNameProfile=new TextField();
		this.txfNameProfile.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 15));
		this.txfNameProfile.setPromptText("Ingrese su nombre de usuario");
		this.txfNameProfile.setPrefWidth(241);
		this.txfNameProfile.setPrefHeight(24);
		
		this.txfAge=new TextField();
		this.txfAge.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 15));
		this.txfAge.setPromptText("Ingrese su contraseña");
		this.txfAge.setPrefWidth(241);
		this.txfAge.setPrefHeight(24);
		
		this.txfGenderProfile=new TextField();
		this.txfGenderProfile.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 15));
		this.txfGenderProfile.setPromptText("Ingrese su tarjeta de credito");
		this.txfGenderProfile.setPrefWidth(241);
		this.txfGenderProfile.setPrefHeight(24);
		
		this.txfAccountRegion=new TextField();
		this.txfAccountRegion.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 15));
		this.txfAccountRegion.setPromptText("Ingrese su región");
		this.txfAccountRegion.setPrefWidth(241);
		this.txfAccountRegion.setPrefHeight(24);
		this.btnRegistrar=new Button("Registar Perfil");
		this.btnRegistrar.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 12));
		this.btnRegistrar.setPrefWidth(370);
		this.btnRegistrar.setPrefHeight(44);
		this.btnRegistrar.setStyle("-fx-background-color: #00deffff");
		this.btnRegistrar.setMaxWidth(Double.MAX_VALUE);
		this.btnRegistrar.setCursor(Cursor.HAND);
		this.btnRegistrar.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				try {
					Integer.parseInt(txfAge.getText()); 
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.initStyle(StageStyle.UTILITY);
					alert.setTitle("Éxito al agregar el perfil");
					alert.setHeaderText(null);
					alert.setContentText("Formato de edad no válido.");
					alert.showAndWait();	
					return; 
				}
				if (!txfNameProfile.getText().equals("")&&!txfGenderProfile.getText().equals("")&&!txfAccountRegion.getText().equals("")&&!txfAge.getText().equals("")) {
					Profile newProfle = new Profile(txfNameProfile.getText(),Integer.parseInt(txfAge.getText()), txfGenderProfile.getText(), txfAccountRegion.getText());
					if(SingletonUserAccountUse.getIntance().getUserAccount().addProfile(newProfle)) {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.initStyle(StageStyle.UTILITY);
						alert.setTitle("Éxito al agregar el perfil");
						alert.setHeaderText(null);
						alert.setContentText("Se agregó el perfil correctamente, su cuenta fue actualizada.");
						alert.showAndWait();	
						try {
							UserAcountBusiness userAccountBusiness = new UserAcountBusiness();
							userAccountBusiness.upDateAccount(SingletonUserAccountUse.getIntance().getUserAccount());
						} catch (IOException | ClassNotFoundException e) {
							e.printStackTrace();
						} 
						}else {
							if (SingletonUserAccountUse.getIntance().getUserAccount().validateNameProfile(newProfle)) {
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.initStyle(StageStyle.UTILITY);
								alert.setTitle("Error al agregar el perfil");
								alert.setHeaderText(null);
								alert.setContentText("No se agregó el perfil correctamente, su cuenta ya tiene un perfil con ese nombre de usuario. ");
								alert.showAndWait();
							}else if (SingletonUserAccountUse.getIntance().getUserAccount().validateAge(newProfle)) {
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.initStyle(StageStyle.UTILITY);
								alert.setTitle("Error al agregar el perfil");
								alert.setHeaderText(null);
								alert.setContentText("No se agregó el perfil correctamente, la edad digitada no es válida.");
								alert.showAndWait();
							}
						}
					
				}else {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.initStyle(StageStyle.UTILITY);
					alert.setTitle("Error al agregar perfil");
					alert.setHeaderText(null);
					alert.setContentText("No se pudo agregar el perfil, datos erróneos.");
					alert.showAndWait();
				}
			}
		});
		this.btnToReturn=new Button("Volver");
		this.btnToReturn.setFont(font);
		this.btnToReturn.setPrefWidth(370);
		this.btnToReturn.setPrefHeight(44);
		this.btnToReturn.setStyle("-fx-background-color: #00deffff");
		this.btnToReturn.setMaxWidth(Double.MAX_VALUE);
		this.btnToReturn.setCursor(Cursor.HAND);
		this.btnToReturn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				new StageLogin(primaryStage).stageProfileTools(primaryStage);
				stage.close();
			}
		
	}); 
		VBox.setMargin(lblNameProfile, new Insets(10,0,0,0));
		VBox.setMargin(txfNameProfile, new Insets(10,200,0,200));
		VBox.setMargin(lblAccountRegion, new Insets(10,0,0,0));
		VBox.setMargin(txfAccountRegion, new Insets(10,200,0,200));
		VBox.setMargin(lblAge, new Insets(10,0,0,0));
		VBox.setMargin(txfAge, new Insets(10,200,0,200));
		VBox.setMargin(lblGenderProfile, new Insets(10,0,0,0));
		VBox.setMargin(txfGenderProfile, new Insets(10,200,0,200));
		VBox.setMargin(btnRegistrar, new Insets(20,200,0,200));
		VBox.setMargin(btnToReturn, new Insets(20,200,0,200));
		
		contLogin.getChildren().addAll(lbltitle,lblNameProfile,txfNameProfile,lblGenderProfile,txfGenderProfile,lblAge,
				txfAge,lblAccountRegion,txfAccountRegion, btnRegistrar, btnToReturn);
		contLogin.setAlignment(Pos.CENTER);
	
		root.getChildren().addAll(contLogin);
	
	} // Fin de init

} // Fin de clase 
