package Domain;

import java.io.IOException;
import java.io.Serializable;
import Domain.Button.Button;
import Domain.Button.FilmButton;
import Domain.Button.QueueButton;
import Utility.ResourcesPath;
import Utility.TypeList;
import javafx.scene.canvas.GraphicsContext;

public class FilmSelection implements Serializable{

	private static final long serialVersionUID = 1L;

	private FilmButton nodeFilm;
	
	private QueueButton queueButton;

	private boolean filmList;
	private boolean queueList;

	private Button nextButton;
	private Button beforeButton;
	private Button playButton;

	private Button returnCategorySelect;

	public FilmSelection(SerieMovieList serieMovieList) throws IOException {
		this.init();
		
		this.nodeFilm = new FilmButton (serieMovieList.getFirstContent(), 60, 10);
		
		this.filmList = true;
		this.queueList = false;
	} // Fin del constructor

	public FilmSelection(VisualizationPriority visualizationPriority) throws IOException {
		this.init();

		this.queueButton = new QueueButton(visualizationPriority, 60, 10);

		this.queueList = true;
		this.filmList = false;
	} // Fin del constructor

	public void init () throws IOException {
		this.nextButton = new Button(ResourcesPath.NEXTBUTTOM, 398, 258, 29.999, 30.001);
		this.beforeButton = new Button(ResourcesPath.BEFOREBUTTOM, 19, 258, 29.999, 30.001);
		this.playButton = new Button(ResourcesPath.PLAYBUTTOM, 610, 385);
		this.returnCategorySelect = new Button(ResourcesPath.RETURNCATEGORYSELECT, 435, 385);
	} // Fin de init
	
	public void paint(GraphicsContext gc) {

		this.returnCategorySelect.paint(gc);
		
		if(this.filmList) {
			
			this.nodeFilm.draw(gc);
			this.beforeButton.paint(gc);
			
		}else if(this.queueList) {
			
			this.queueButton.draw(gc);
		}
		
		this.nextButton.paint(gc);
		this.playButton.paint(gc);
	} // Fin de paint

	public String getDataFilm() {
		
		String data = "";
		
		if (this.filmList) {
			
			data = "Nombre: " + this.nodeFilm.getAudioVisualContent().getName() + "\n\n"
					+ "Categoria: " + this.nodeFilm.getAudioVisualContent().getGender()
					+ "\n\n" + "Edad recomendad: "
					+ this.nodeFilm.getAudioVisualContent().getRecommendedAge() + " Años"
					+ "\n\n" + "Director: "
					+ this.nodeFilm.getAudioVisualContent().getDirectorName() + "\n\n"
					+ "Contenido: " + this.nodeFilm.getAudioVisualContent().getContentType()
					+ "\n\n" + "Duracion: "
					+ this.nodeFilm.getAudioVisualContent().getDurationMinutes() + " Mins"
					+ "\n\n" + "Año: "
					+ this.nodeFilm.getAudioVisualContent().getYearIssue();
			
		} else if (this.queueList) {
			
			data = "Nombre: " + this.queueButton.getAudioVisualContent().getName() + "\n\n" + "Categoria: "
					+ this.queueButton.getAudioVisualContent().getGender() + "\n\n" + "Edad recomendad: "
					+ this.queueButton.getAudioVisualContent().getRecommendedAge() + " Años" + "\n\n"
					+ "Director: " + this.queueButton.getAudioVisualContent().getDirectorName() + "\n\n"
					+ "Contenido: " + this.queueButton.getAudioVisualContent().getContentType() + "\n\n"
					+ "Duracion: " + this.queueButton.getAudioVisualContent().getDurationMinutes() + " Mins"
					+ "\n\n" + "Año: " + this.queueButton.getAudioVisualContent().getYearIssue();
		
		} // if / else
		
		return data; 
	} // Fin de setDataFilm

	public String getSypnosisText() {
		
		if (this.filmList) {
			 
			return this.nodeFilm.getAudioVisualContent().getSynopsis();
			
		 } else if (this.queueList) {
			
			return this.queueButton.getAudioVisualContent().getSynopsis();
			
		} // if / else
		 
		return null;
	} // Fin de setText

	public void getNextAll() {
		
		if (this.filmList) {
			 
			this.nodeFilm.getNextContent();
			
		 } else if (this.queueList) {
			 
			this.queueButton.getNextContent();
			
		} // if / else
		 
	} // Fin de getNextAll

	public void getBeforeAll() {
		
		this.nodeFilm.getBeforeContent();
		
	} // Fin de getBeforeAll

	public AudioVisualContent getSerieOrMovie() {
		
		if (this.filmList) {
			
			return this.nodeFilm.getAudioVisualContent();

		} else if (this.queueList) {
			
			return this.queueButton.getAudioVisualContent();
			
		} // if / else 
		
		return null;
		
	} // Fin de getSerieOrMovie
	
	public Enum<?> getTypeList () {
		
		if (this.filmList) {
			return TypeList.LIST;
		} else if (this.queueList) {
			return TypeList.QUEUE;
		} // if / else
		
		return null;
		
	} // Fin de getTypeList
	
	public Button getPlayButton() {
		return playButton;
	}

	public void setPlayButton(Button playButton) {
		this.playButton = playButton;
	}

	public Button getNodeFilm() {
		return nodeFilm;
	}

	public Button getNextButton() {
		return nextButton;
	}

	public Button getBeforeButton() {
		return beforeButton;
	}

	public void setNodeFilm(FilmButton nodeFilm) {
		this.nodeFilm = nodeFilm;
	}

	public void setNextButton(Button nextButton) {
		this.nextButton = nextButton;
	}

	public void setBeforeButton(Button beforeButton) {
		this.beforeButton = beforeButton;
	}

	public Button getReturnCategorySelect() {
		return returnCategorySelect;
	}

	public void setReturnCategorySelect(Button returnCategorySelect) {
		this.returnCategorySelect = returnCategorySelect;
	}

} // Fin de la clase
