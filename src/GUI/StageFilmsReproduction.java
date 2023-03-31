package GUI;

import java.io.IOException;
import java.io.InputStream;
import Domain.AudioVisualContent;
import Domain.Profile;
import Domain.SingletonCategorysAccess;
import Domain.SingletonUserAccountUse;
import Domain.VisualizationPriority;
import Utility.ResourcesPath;
import Utility.TypeList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageFilmsReproduction {

	private InputStream imageLoader;
	private Image imageGif;
	private ImageView imageViewGif;

	private AudioVisualContent audioVisualContent;

	private String typeList;

	public StageFilmsReproduction(Stage primaryStage, AudioVisualContent audioVisualContent, Enum<?> typeList) {

		this.audioVisualContent = audioVisualContent;

		this.typeList = typeList.toString();

		init(primaryStage);

	} // Fin del constructor

	public void init(Stage primaryStage) {

		Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20);
		
		VBox btnFilms = new VBox();
		Button btnBackSFilmsSelec = new Button("Volver");
		btnBackSFilmsSelec.setStyle("-fx-background-color: #00deffff");
		btnBackSFilmsSelec.setFont(font);
		backSFilmSelection(btnBackSFilmsSelec, primaryStage);
		VBox.setMargin(btnBackSFilmsSelec, new Insets(20, 0, 0, 20));

		Button btnFinalize = new Button("Finalizar");
		btnFinalize.setStyle("-fx-background-color: #00deffff");
		btnFinalize.setFont(font);
		finalizeReproduction(btnFinalize, primaryStage);
		VBox.setMargin(btnFinalize, new Insets(20, 0, 0, 20));

		btnFilms.getChildren().addAll(btnBackSFilmsSelec, btnFinalize);

		VBox gif = new VBox();

		this.imageLoader = getClass().getResourceAsStream(ResourcesPath.ONLYFILMSREPRODUCTION);
		this.imageGif = new Image(this.imageLoader);
		this.imageViewGif = new ImageView(this.imageGif);

		Label lblFilmName = new Label(this.audioVisualContent.getName());
		lblFilmName.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 25));

		VBox.setMargin(lblFilmName, new Insets(10, 0, 0, 60));
		VBox.setMargin(this.imageViewGif, new Insets(10, 0, 0, 60));

		gif.getChildren().addAll(lblFilmName, this.imageViewGif);

		HBox root = new HBox();
		root.getChildren().addAll(btnFilms, gif);
		root.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
		primaryStage.setScene(new Scene(root, 800, 600));
	} // Fin de init

	public void backSFilmSelection(Button btnBackSFilmsSelec, Stage primaryStage) {
		btnBackSFilmsSelec.setOnMouseClicked(new EventHandler<Event>() {
			// encola la pelicula y vuelve al listado de peliculas

			VisualizationPriority visualizationP = SingletonUserAccountUse.getIntance().getUserAccount()
					.getProfileInUse().getVisualizationP();

			@Override
			public void handle(Event e) {

				if (!visualizationP.exist(audioVisualContent)) {
					visualizationP.addContent(audioVisualContent);
				} // if

				try {

					if (typeList.equals(TypeList.LIST.toString())) {
						new StageFilmsSelection(primaryStage,
								SingletonCategorysAccess.getInstance().getCategoryInUse().getSerieMovieList());
					} else if (typeList.equals(TypeList.QUEUE.toString())) {
						new StageFilmsSelection(primaryStage, SingletonUserAccountUse.getIntance().getUserAccount()
								.getProfileInUse().getVisualizationP());
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});

	} // Fin de backSFilmSelection

	public void finalizeReproduction(Button btnFinalize, Stage primaryStage) {
		btnFinalize.setOnMouseClicked(new EventHandler<Event>() {
			/*
			 * finaliza la reproduccion si ya la pelicula esta en la cola la saca y vuelve
			 * al listado de peliculas, sino solo vuelve al listado de peliculas
			 */

			VisualizationPriority visualizationP = SingletonUserAccountUse.getIntance().getUserAccount()
					.getProfileInUse().getVisualizationP();

			@Override
			public void handle(Event e) {
				Profile profileInUse = SingletonUserAccountUse.getIntance().getUserAccount().getProfileInUse();
				profileInUse.getCategoryGraph().insertVertex(audioVisualContent);

				visualizationP.removeContentIfExists(audioVisualContent);

				if (typeList.equals(TypeList.LIST.toString())) {

					try {
						new StageFilmsSelection(primaryStage,
								SingletonCategorysAccess.getInstance().getCategoryInUse().getSerieMovieList());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else if (typeList.equals(TypeList.QUEUE.toString())) {

					if (visualizationP.isEmpty()) { // Si la cola está vacía

						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.initStyle(StageStyle.UTILITY);
						alert.setTitle("Sin Contenido");
						alert.setHeaderText(null);
						alert.setContentText("No hay contenido pendiente para visualizar");
						alert.showAndWait();

						try {
							new StageCategorySelection(primaryStage);
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} else { // Si la cola no está vacía

						try {
							new StageFilmsSelection(primaryStage, visualizationP);
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} // if/else (interno)

				} // if/else-if (externo)

			}

		});

	} // Fin de finalizeReproduction

}// Fin de la clase
