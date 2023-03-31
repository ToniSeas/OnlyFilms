package GUI;

import java.io.IOException;
import java.io.InputStream;

import Domain.Category;
import Domain.CategorySelection;
import Domain.SerieMovieList;
import Domain.SingletonCategorysAccess;
import Domain.SingletonUserAccountUse;
import Domain.VisualizationPriority;
import Domain.CategoryGraph.CategoryGraph;
import Utility.ResourcesPath;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageCategorySelection {

	private InputStream imageLoader;// obtiene la ruta de la imagen
	private Image backgroundImage;

	private CategorySelection categorySelection;

	public StageCategorySelection(Stage primaryStage) throws Exception {
		this.imageLoader = getClass().getResourceAsStream(ResourcesPath.WALLPAPER);
		this.backgroundImage = new Image(imageLoader);

		this.categorySelection = new CategorySelection();

		start(primaryStage);
	} // Fin del constructor

	public void start(Stage primaryStage) throws Exception {

		Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, 13);
		
		Canvas canvas = new Canvas(800, 600);
		Group root = new Group(canvas);

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
				mouseReleased(x, y, gc, primaryStage);
			}
		});
		Button btnChangeProfile = new Button("Cambiar Perfil");
		btnChangeProfile.setDefaultButton(true);
		btnChangeProfile.setPrefSize(100, 30);
		btnChangeProfile.setLayoutX(10);
		btnChangeProfile.setLayoutY(560);
		btnChangeProfile.setStyle("-fx-background-color: #00deffff");
		btnChangeProfile.setFont(font);
		btnChangeProfile.setOnMouseClicked(new javafx.event.EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				new StageChangeProfile(primaryStage);

			}
		});
		Button btnSignOff = new Button("Cerrar sesión");
		btnSignOff.setDefaultButton(true);
		btnSignOff.setPrefSize(100, 30);
		btnSignOff.setLayoutX(120);
		btnSignOff.setLayoutY(560);
		btnSignOff.setStyle("-fx-background-color: #00deffff");
		btnSignOff.setFont(font);
		btnSignOff.setOnMouseClicked(new javafx.event.EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				new StageLogin(primaryStage);
			}
		});
		root.getChildren().addAll(btnSignOff, btnChangeProfile);

		primaryStage.setResizable(false);
		primaryStage.setTitle("Selección de Categoría");
		primaryStage.setScene(new Scene(root));

	} // Fin de start

	public void drawInCanvas(GraphicsContext gc) throws IOException {

		gc.drawImage(this.backgroundImage, 0, 0);
		this.categorySelection.paint(gc);

	} // Fin de drawInCanvas

	public void mousePressed(int x, int y, GraphicsContext gc) {

		try {
			if (this.categorySelection.getNextButton().mouseOver(x, y)) {

				this.categorySelection.getNextButton().setSelecImagePath(ResourcesPath.NEXTBUTTOMSELEC);

			} else if (this.categorySelection.getBeforeButton().mouseOver(x, y)) {

				this.categorySelection.getBeforeButton().setSelecImagePath(ResourcesPath.BEFOREBUTTOMSELEC);

			} else if (this.categorySelection.getNodeLeft().mouseOver(x, y)) {

				this.categorySelection.getNodeLeft()
						.setSelecImage(this.categorySelection.getNodeLeft().getCategory().getCoverImageSelec());

			} else if (this.categorySelection.getNodeCenter().mouseOver(x, y)) {

				this.categorySelection.getNodeCenter()
						.setSelecImage(this.categorySelection.getNodeCenter().getCategory().getCoverImageSelec());

			} else if (this.categorySelection.getNodeRigth().mouseOver(x, y)) {

				this.categorySelection.getNodeRigth()
						.setSelecImage(this.categorySelection.getNodeRigth().getCategory().getCoverImageSelec());

			}
			this.drawInCanvas(gc);
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // Fin de mousePressed

	public void mouseReleased(int x, int y, GraphicsContext gc, Stage primaryStage) {

		try {

			if (this.categorySelection.getNextButton().mouseOver(x, y)) {

				this.categorySelection.getNextButton().setNormalImagePath(ResourcesPath.NEXTBUTTOM);
				this.categorySelection.getNextAll();

			} else if (this.categorySelection.getBeforeButton().mouseOver(x, y)) {

				this.categorySelection.getBeforeButton().setNormalImagePath(ResourcesPath.BEFOREBUTTOM);
				this.categorySelection.getBeforeAll();

			} else if (this.categorySelection.getNodeLeft().mouseOver(x, y)) {

				SingletonCategorysAccess.getInstance()
						.setCategoryInUse(this.categorySelection.getNodeLeft().getCategory());
				SerieMovieList contentList = this.categorySelection.getNodeLeft().getCategory().getSerieMovieList();

				this.categorySelection.getNodeLeft()
						.setSelecImage(this.categorySelection.getNodeLeft().getCategory().getCoverImage());

				if (contentList.getSize() > 0) {
					new StageFilmsSelection(primaryStage, contentList);
				} else {
					this.showAlert("Sin Contenido",
							"No hay contenido disponible en esta categoría con respecto a la edad del usuario");
				}

			} else if (this.categorySelection.getNodeCenter().mouseOver(x, y)) {

				SingletonCategorysAccess.getInstance()
						.setCategoryInUse(this.categorySelection.getNodeCenter().getCategory());

				SerieMovieList contentList = this.categorySelection.getNodeCenter().getCategory().getSerieMovieList();
				this.categorySelection.getNodeCenter()
						.setSelecImage(this.categorySelection.getNodeCenter().getCategory().getCoverImage());

				if (contentList.getSize() > 0) {
					new StageFilmsSelection(primaryStage, contentList);
				} else {
					this.showAlert("Sin Contenido",
							"No hay contenido disponible en esta categoría con respecto a la edad del usuario");
				}

			} else if (this.categorySelection.getNodeRigth().mouseOver(x, y)) {

				SingletonCategorysAccess.getInstance()
						.setCategoryInUse(this.categorySelection.getNodeRigth().getCategory());
				this.categorySelection.getNodeRigth()
						.setSelecImage(this.categorySelection.getNodeRigth().getCategory().getCoverImage());

				SerieMovieList contentList = this.categorySelection.getNodeRigth().getCategory().getSerieMovieList();

				if (contentList.getSize() > 0) {
					new StageFilmsSelection(primaryStage, contentList);
				} else {
					this.showAlert("Sin Contenido",
							"No hay contenido disponible en esta categoría con respecto a la edad del usuario");
				}

			} else if (this.categorySelection.getKeepWatching().mouseOver(x, y)) {
				VisualizationPriority visualizationPriority = SingletonUserAccountUse.getIntance().getUserAccount()
						.getProfileInUse().getVisualizationP();

				if (!visualizationPriority.isEmpty()) {

					new StageFilmsSelection(primaryStage, visualizationPriority);

				} else {

					this.showAlert("Sin Contenido", "No hay contenido pendiente para visualizar");

				} // if / else (interno)

			} else if (this.categorySelection.getRecommendedButton().mouseOver(x, y)) {

				CategoryGraph categoryGraph = SingletonUserAccountUse.getIntance().getUserAccount().getProfileInUse()
						.getCategoryGraph();
				if (categoryGraph.getSize() > 0) {
					Category category = categoryGraph.dfs();
					SingletonCategorysAccess.getInstance().setCategoryInUse(category);
					new StageFilmsSelection(primaryStage, category.getSerieMovieList());
				} else {

					this.showAlert("Sin Contenido", "No hay contenido recomendado");

				} // if / else (interno)

			} // if / else (externo)

			this.drawInCanvas(gc);
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // Fin de mouseReleased

	public void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	} // Fin de showAlert

} // Fin de clase
