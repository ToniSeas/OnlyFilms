package GUI;

import java.io.InputStream;

import Business.UserAcountBusiness;
import Domain.SingletonUserAccountUse;
import Utility.ResourcesPath;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageLogin {

	private Label lblTitle, lblUser, lblPassword;
	private TextField txfUser;
	private PasswordField txfPassword;
	private Button btnLogin;
	private Button btnRegister;

	private InputStream imageLoader;
	private Image image;
	private ImageView imageView;

	public StageLogin(Stage primaryStage) {
		this.init(primaryStage);
	} // Fin del constructor

	public void init(Stage primaryStage) {

		Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, 30);

		StackPane root = new StackPane();
		VBox contLogin = new VBox();
		contLogin.setPrefSize(400, 300);

		this.lblTitle = new Label("Iniciar Sesión");
		this.lblTitle.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 40));
		VBox.setMargin(lblTitle, new Insets(0, 200, 0, 200));

		this.lblUser = new Label("Usuario");
		this.lblUser.setFont(font);

		this.lblPassword = new Label("Contraseña");
		this.lblPassword.setFont(font);

		this.txfUser = new TextField();
		this.txfUser.setFont(font);
		this.txfUser.setPromptText("Ingrese su Usuario");
		this.txfUser.setPrefWidth(341);
		this.txfUser.setPrefHeight(44);

		this.txfPassword = new PasswordField();
		this.txfPassword.setFont(font);
		this.txfPassword.setPromptText("Ingrese su contraseña");
		this.txfPassword.setPrefWidth(341);
		this.txfPassword.setPrefHeight(44);

		this.btnLogin = new Button("Ingresar");
		this.btnLogin.setFont(font);
		this.btnLogin.setPrefWidth(370);
		this.btnLogin.setPrefHeight(44);
		this.btnLogin.setStyle("-fx-background-color: #00deffff");
		this.btnLogin.setMaxWidth(Double.MAX_VALUE);
		this.btnLogin.setCursor(Cursor.HAND);

		contLogin.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ENTER) {
					try {
						UserAcountBusiness userAccountBusiness = new UserAcountBusiness();
						if (userAccountBusiness.getUserAccount(txfUser.getText(), txfPassword.getText()) != null) {
							SingletonUserAccountUse.getIntance().addUserAccount(
									userAccountBusiness.getUserAccount(txfUser.getText(), txfPassword.getText()));
							new StageProfileTools(primaryStage);
						} else {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.initStyle(StageStyle.UTILITY);
							alert.setTitle("Error al iniciar sesión");
							alert.setHeaderText(null);
							alert.setContentText("No se pudo iniciar sesión, datos erroneos");
							alert.showAndWait();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} // if
			} // handle
		});
		this.btnLogin.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event e) {
				try {
					UserAcountBusiness userAccountBusiness = new UserAcountBusiness();
					if (userAccountBusiness.getUserAccount(txfUser.getText(), txfPassword.getText()) != null) {

						SingletonUserAccountUse.getIntance().addUserAccount(
								userAccountBusiness.getUserAccount(txfUser.getText(), txfPassword.getText()));
						stageProfileTools(primaryStage);
					} else {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.initStyle(StageStyle.UTILITY);
						alert.setTitle("Error al iniciar sesión");
						alert.setHeaderText(null);
						alert.setContentText("No se pudo iniciar sesión, datos erróneos");
						alert.showAndWait();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.btnRegister = new Button("Registrarse");
		this.btnRegister.setFont(font);
		this.btnRegister.setPrefWidth(370);
		this.btnRegister.setPrefHeight(44);
		this.btnRegister.setMaxWidth(Double.MAX_VALUE);
		this.btnRegister.setStyle("-fx-background-color: #00deffff");
		this.btnRegister.setCursor(Cursor.HAND);
		this.btnRegister.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event e) {
				new StageUserAccount(primaryStage);
			}
		});
		VBox.setMargin(lblUser, new Insets(10, 0, 0, 0));
		VBox.setMargin(txfUser, new Insets(10, 200, 0, 200));
		VBox.setMargin(lblPassword, new Insets(10, 0, 0, 0));
		VBox.setMargin(txfPassword, new Insets(10, 200, 0, 200));
		VBox.setMargin(btnLogin, new Insets(20, 200, 0, 200));
		VBox.setMargin(btnRegister, new Insets(20, 200, 0, 200));

		contLogin.getChildren().addAll(lblTitle, lblUser, txfUser, lblPassword, txfPassword, btnLogin, btnRegister);
		contLogin.setAlignment(Pos.CENTER);

		this.imageLoader = getClass().getResourceAsStream(ResourcesPath.LOGIN);
		this.image = new Image(imageLoader);
		this.imageView = new ImageView(image);

		root.getChildren().addAll(imageView, contLogin);

		primaryStage.setTitle("Iniciar Sesión");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();

	} // Fin de init

	public void stageProfileTools(Stage primaryStage) {
		new StageProfileTools(primaryStage);
	} // Fin de StageProfileTools

} // Fin de clase
