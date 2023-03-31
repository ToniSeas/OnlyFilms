package GUI;

import java.io.IOException;
import Business.UserAcountBusiness;
import Domain.UserAccount;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageUserAccount {

	private Label lblNameUser, lblPassword, lblCardNumber, lblAccountRegion;
	private Label lbltitle;
	private TextField txfNameUser, txfCardNumber, txfAccountRegion;
	private PasswordField txfPassword;
	private Button btnRegistrar;
	private Button btnToReturn;
	private UserAccount userAccount;

	public StageUserAccount(Stage primaryStage) {
		this.init(primaryStage);
	} // Fin del constructor

	private void init(Stage primaryStage) {

		Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, 12);

		StackPane root = new StackPane();
		VBox contLogin = new VBox();
		contLogin.setStyle("-fx-background-color: #ffffffff");
		contLogin.setPrefSize(400, 400);
		this.lbltitle = new Label("Cuenta de Usuario");
		this.lbltitle.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 18));
		VBox.setMargin(lbltitle, new Insets(0, 150, 0, 150));
		
		Stage stage = new Stage();
		stage.getIcons().setAll(primaryStage.getIcons());
		
		stage.setScene(new Scene(root));
		stage.setTitle("Registrarse");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		stage.setWidth(550);
		stage.setHeight(500);
		stage.show();

		this.lblNameUser = new Label("Usuario:");
		this.lblNameUser.setFont(font);

		this.lblPassword = new Label("Contraseña: ");
		this.lblPassword.setFont(font);

		this.lblCardNumber = new Label("Tarjeta de credito");
		this.lblCardNumber.setFont(font);

		this.lblAccountRegion = new Label("Región");
		this.lblAccountRegion.setFont(font);

		this.txfNameUser = new TextField();
		this.txfNameUser.setFont(font);
		this.txfNameUser.setPromptText("Ingrese su nombre de usuario");
		this.txfNameUser.setPrefWidth(250);
		this.txfNameUser.setPrefHeight(24);

		this.txfPassword = new PasswordField();
		this.txfPassword.setFont(font);
		this.txfPassword.setPromptText("Ingrese su contraseña");
		this.txfPassword.setPrefWidth(250);
		this.txfPassword.setPrefHeight(24);

		this.txfCardNumber = new TextField();
		this.txfCardNumber.setFont(font);
		this.txfCardNumber.setPromptText("Ingrese su tarjeta de credito");
		this.txfCardNumber.setPrefWidth(250);
		this.txfCardNumber.setPrefHeight(24);

		this.txfAccountRegion = new TextField();
		this.txfAccountRegion.setFont(font);
		this.txfAccountRegion.setPromptText("Ingrese su región");
		this.txfAccountRegion.setPrefWidth(250);
		this.txfAccountRegion.setPrefHeight(24);

		this.btnRegistrar = new Button("Registar Cuenta");
		this.btnRegistrar.setFont(font);
		this.btnRegistrar.setStyle("-fx-background-color: #00deffff");
		this.btnRegistrar.setPrefWidth(370);
		this.btnRegistrar.setPrefHeight(44);
		this.btnRegistrar.setMaxWidth(Double.MAX_VALUE);
		this.btnRegistrar.setCursor(Cursor.HAND);
		this.btnRegistrar.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				if (!txfNameUser.getText().equals("") && !txfPassword.getText().equals("")
						&& !txfCardNumber.getText().equals("") && !txfAccountRegion.getText().equals("")) {
					userAccount = new UserAccount(txfNameUser.getText(), txfPassword.getText(), txfCardNumber.getText(),
							txfAccountRegion.getText());
					try {
						UserAcountBusiness userAccountBusiness = new UserAcountBusiness();
						if (userAccountBusiness.registerAccountNotEquals(userAccount)) {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.initStyle(StageStyle.UTILITY);
							alert.setTitle("Se agregó la cuenta correctamente");
							alert.setHeaderText(null);
							alert.setContentText("Su cuenta fue registrada correctamente.");
							alert.showAndWait();
						} else {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.initStyle(StageStyle.UTILITY);
							alert.setTitle("No se agregó la cuenta correctamente");
							alert.setHeaderText(null);
							alert.setContentText(
									"Su cuenta no fue registrada, el nombre de usuario ya esta registrado.");
							alert.showAndWait();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.initStyle(StageStyle.UTILITY);
					alert.setTitle("Error registrar el usuario");
					alert.setHeaderText(null);
					alert.setContentText("No se pudo crear la cuenta, datos erróneos.");
					alert.showAndWait();
				} // if / else
			} // Fin de handle
		});

		this.btnToReturn = new Button("Volver");
		this.btnToReturn.setFont(font);
		this.btnToReturn.setStyle("-fx-background-color: #00deffff");
		this.btnToReturn.setPrefWidth(370);
		this.btnToReturn.setPrefHeight(44);
		this.btnToReturn.setMaxWidth(Double.MAX_VALUE);
		this.btnToReturn.setCursor(Cursor.HAND);
		this.btnToReturn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				new StageLogin(primaryStage);
				stage.close();
			} // Fin de handle
		});

		VBox.setMargin(lblNameUser, new Insets(10, 0, 0, 0));
		VBox.setMargin(txfNameUser, new Insets(10, 200, 0, 200));
		VBox.setMargin(lblPassword, new Insets(10, 0, 0, 0));
		VBox.setMargin(txfPassword, new Insets(10, 200, 0, 200));
		VBox.setMargin(lblCardNumber, new Insets(10, 0, 0, 0));
		VBox.setMargin(txfCardNumber, new Insets(10, 200, 0, 200));
		VBox.setMargin(lblAccountRegion, new Insets(10, 0, 0, 0));
		VBox.setMargin(txfAccountRegion, new Insets(10, 200, 0, 200));
		VBox.setMargin(btnRegistrar, new Insets(20, 200, 0, 200));
		VBox.setMargin(btnToReturn, new Insets(20, 200, 0, 200));

		contLogin.getChildren().addAll(lbltitle, lblNameUser, txfNameUser, lblPassword, txfPassword, lblCardNumber,
				txfCardNumber, lblAccountRegion, txfAccountRegion, btnRegistrar, btnToReturn);
		contLogin.setAlignment(Pos.CENTER);

		root.getChildren().addAll(contLogin);

	} // Fin de init

	public TextField getTxfNameUser() {
		return txfNameUser;
	}

	public TextField getTxfCardNumber() {
		return txfCardNumber;
	}

	public TextField getTxfAccountRegion() {
		return txfAccountRegion;
	}

	public PasswordField getTxfPassword() {
		return txfPassword;
	}// fin del init

}// fin de clase
