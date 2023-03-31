package GUI;

import java.io.IOException;
import java.io.InputStream;
import Domain.VisualizationPriority;
import Utility.ResourcesPath;
import Utility.LoadGlobalFont;
import Utility.TypeList;
import Domain.FilmSelection;
import Domain.SerieMovieList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class StageFilmsSelection {

	private InputStream imageLoader;
	private Image backgroundImage;

	private FilmSelection filmSelection;

	private TextArea txaSypsosis;
	private TextArea txaFilmData;

	public StageFilmsSelection(Stage primaryStage, SerieMovieList serieMovieList) {
		try {
			this.filmSelection = new FilmSelection(serieMovieList);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.init(primaryStage);
	} // Fin del constructor

	public StageFilmsSelection(Stage primaryStage, VisualizationPriority visualizationPriority) {
		try {
			this.filmSelection = new FilmSelection(visualizationPriority);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.init(primaryStage);
	} // Fin del constructor

	public void init(Stage primaryStage) {
		this.imageLoader = getClass().getResourceAsStream(ResourcesPath.WALLPAPERFILMS);
		this.backgroundImage = new Image(this.imageLoader);
		initScene(primaryStage);
	} // Fin de init

	public void initScene(Stage primaryStage) {

		Canvas canvas = new Canvas(800, 600);
		Group root = new Group(canvas);

		this.txaSypsosis = new TextArea();
		this.txaSypsosis.setPrefSize(790, 95);
		this.txaSypsosis.setLayoutX(5);
		this.txaSypsosis.setLayoutY(500);
		this.txaSypsosis.setWrapText(true);
		this.txaSypsosis.setEditable(false);
		this.txaSypsosis.setStyle("-fx-control-inner-background: #8af0ffff");
		this.txaSypsosis.setText(this.filmSelection.getSypnosisText());
		root.getChildren().add(txaSypsosis);

		this.txaFilmData = new TextArea();
		this.txaFilmData.setPrefSize(350, 350);
		this.txaFilmData.setLayoutX(445);
		this.txaFilmData.setLayoutY(5);
		this.txaFilmData.setWrapText(true);
		this.txaFilmData.setEditable(false);
		this.txaFilmData.setStyle("-fx-control-inner-background: #8af0ffff");
		this.txaFilmData.setFont(LoadGlobalFont.meadow(21));

		this.txaFilmData.setText(this.filmSelection.getDataFilm());
		root.getChildren().add(txaFilmData);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		this.drawInCanvas(gc);

		canvas.setOnMousePressed(event -> {
			int x = (int) event.getX(), y = (int) event.getY();
			if (event.getButton() == MouseButton.PRIMARY) {
				mousePressed(x, y, gc);
			}

		});

		canvas.setOnMouseReleased(event -> {
			int x = (int) event.getX(), y = (int) event.getY();
			if (event.getButton() == MouseButton.PRIMARY) {
				try {
					mouseReleased(x, y, gc, primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		primaryStage.setTitle("Content Selection");
		primaryStage.setScene(new Scene(root));

	} // Fin de init

	public void drawInCanvas(GraphicsContext gc) {

		gc.drawImage(this.backgroundImage, 0, 0);
		this.filmSelection.paint(gc);

	} // Fin de drawInCanvas

	public void mousePressed(int x, int y, GraphicsContext gc) {

		try {
			if (this.filmSelection.getNextButton().mouseOver(x, y)) {

				this.filmSelection.getNextButton().setSelecImagePath(ResourcesPath.NEXTBUTTOMSELEC);

			} else if (this.filmSelection.getBeforeButton().mouseOver(x, y)) {

				this.filmSelection.getBeforeButton().setSelecImagePath(ResourcesPath.BEFOREBUTTOMSELEC);

			} else if (this.filmSelection.getPlayButton().mouseOver(x, y)) {

				this.filmSelection.getPlayButton().setSelecImagePath(ResourcesPath.PLAYBUTTOMSELEC);
			}
			this.drawInCanvas(gc);
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // Fin de mousePressed

	public void mouseReleased(int x, int y, GraphicsContext gc, Stage primaryStage) throws Exception {

		try {

			if (this.filmSelection.getNextButton().mouseOver(x, y)) {

				this.filmSelection.getNextButton().setNormalImagePath(ResourcesPath.NEXTBUTTOM);
				this.filmSelection.getNextAll();
				this.txaFilmData.setText(this.filmSelection.getDataFilm());
				this.txaSypsosis.setText(this.filmSelection.getSypnosisText());

			} else if (this.filmSelection.getBeforeButton().mouseOver(x, y)) {

				if (this.filmSelection.getTypeList().equals(TypeList.LIST)) {
					this.filmSelection.getBeforeButton().setNormalImagePath(ResourcesPath.BEFOREBUTTOM);
					this.filmSelection.getBeforeAll();
					this.txaFilmData.setText(this.filmSelection.getDataFilm());
					this.txaSypsosis.setText(this.filmSelection.getSypnosisText());
				} // if

			} else if (this.filmSelection.getPlayButton().mouseOver(x, y)) {

				new StageFilmsReproduction(primaryStage, this.filmSelection.getSerieOrMovie(),
						this.filmSelection.getTypeList());

			} else if (this.filmSelection.getReturnCategorySelect().mouseOver(x, y)) {

				new StageCategorySelection(primaryStage);

			}
			this.drawInCanvas(gc);
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // Fin de mouseReleased

} // Fin de la clase
