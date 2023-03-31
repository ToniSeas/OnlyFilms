package GUI;

import Domain.SingletonUserAccountUse;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageProfileTools {
	private Label lblSelectProfile;
	private Button btnAddProfile, btnContinue;
	private Label lblTitle;
	private ComboBox<String> comboProfiles;

	public StageProfileTools(Stage primaryStage) {
		this.init(primaryStage);
	} // Fin del constructor

	public void init(Stage primaryStage) {

		Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20);

		StackPane root = new StackPane();
		Stage stage = new Stage();
		stage.getIcons().setAll(primaryStage.getIcons());

		VBox contLogin = new VBox();
		contLogin.setPrefSize(300, 300);
		contLogin.setStyle("-fx-background-color: #ffffffff");

		stage.setScene(new Scene(root));
		stage.setTitle("Herramientas de Perfil");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.setResizable(false);
		stage.initOwner(primaryStage);
		stage.setWidth(650);
		stage.setHeight(500);
		stage.show();

		this.lblSelectProfile = new Label("Selecione el perfil");
		this.lblSelectProfile.setFont(font);

		this.comboProfiles = new ComboBox<>();
		this.comboProfiles.setVisibleRowCount(3);
		this.comboProfiles.setStyle("-fx-background-color: #00deffff");

		this.comboProfiles.getItems()
				.add(SingletonUserAccountUse.getIntance().getUserAccount().getDefaultProfile().getNameProfile());
		for (int i = 0; i < SingletonUserAccountUse.getIntance().getUserAccount().sizeProfiles(); i++) {
			this.comboProfiles.getItems()
					.add(SingletonUserAccountUse.getIntance().getUserAccount().getProfile(i).getNameProfile());
		}
		comboProfiles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				SingletonUserAccountUse.getIntance().getUserAccount().selectProfile(newValue);
			}
		});
		this.lblTitle = new Label("Editar Perfil");
		this.lblTitle.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 40));
		VBox.setMargin(lblTitle, new Insets(0, 200, 0, 200));
		this.btnAddProfile = new Button("Agregar Perfil");
		this.btnAddProfile.setFont(font);
		this.btnAddProfile.setPrefWidth(100);
		this.btnAddProfile.setPrefHeight(20);
		this.btnAddProfile.setStyle("-fx-background-color: #00deffff");
		this.btnAddProfile.setMaxWidth(Double.MAX_VALUE);
		this.btnAddProfile.setCursor(Cursor.HAND);
		this.btnAddProfile.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event e) {
				new StageAddProfile(primaryStage);
				stage.close();
			}

		});
		this.btnContinue = new Button("Continuar");
		this.btnContinue.setFont(font);
		this.btnContinue.setPrefWidth(100);
		this.btnContinue.setPrefHeight(20);
		this.btnContinue.setStyle("-fx-background-color: #00deffff");
		this.btnContinue.setMaxWidth(Double.MAX_VALUE);
		this.btnContinue.setCursor(Cursor.HAND);
		this.btnContinue.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event e) {

				try {
					new StageCategorySelection(primaryStage);
					stage.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		VBox.setMargin(btnAddProfile, new Insets(20, 200, 0, 200));
		VBox.setMargin(btnContinue, new Insets(20, 200, 0, 200));
		VBox.setMargin(lblSelectProfile, new Insets(10, 0, 0, 0));
		VBox.setMargin(comboProfiles, new Insets(10, 0, 0, 0));
		contLogin.getChildren().addAll(lblTitle, lblSelectProfile, comboProfiles, btnAddProfile, btnContinue);
		contLogin.setAlignment(Pos.CENTER);

		root.getChildren().addAll(contLogin);

	} // Fin de init

} // Fin de clase
