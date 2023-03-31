package Domain.Button;

import java.io.IOException;
import Domain.AudioVisualContent;
import Domain.TDAListas.Nodo;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class FilmButton extends Button{

	private Nodo serieOrFilmNode;
	
	public FilmButton(Nodo audioVisualContent, int positionX, int positionY) throws IOException {
		super(positionX, positionY);
		this.image = ((AudioVisualContent)audioVisualContent.getElement()).getCoverImage();
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
		this.hitBox = new Rectangle (this.positionX, this.positionY, this.width, this.height);

		this.serieOrFilmNode = audioVisualContent;
	} // Fin del constructor

	public void draw (GraphicsContext gc) {
		gc.drawImage(this.getAudioVisualContent().getCoverImage(), this.positionX, this.positionY);
	} // Fin de draw
	
	public Nodo getNodo() {
		return serieOrFilmNode;
	} // Fin de getNodo

	public void setNodo(Nodo nodeCategory) {
		this.serieOrFilmNode = nodeCategory;
		this.setAudioVisualContent(((AudioVisualContent)(this.serieOrFilmNode.getElement())));
	} // Fin de setNodo
	
	public void getNextContent () {
		
		if (this.serieOrFilmNode.getNext() != null) {
			this.serieOrFilmNode = this.serieOrFilmNode.getNext();
		} // if
		
	} // Fin de getNextContent
	
	public void getBeforeContent () {
		
		if (this.serieOrFilmNode.getBefore() != null) {
			this.serieOrFilmNode = this.serieOrFilmNode.getBefore();
		} // Fin de if
		
	} // Fin de getBeforeContent

	public AudioVisualContent getAudioVisualContent() {
		return (AudioVisualContent)this.serieOrFilmNode.getElement();
	} // Fin de getAudioVisualContent

	public void setAudioVisualContent(AudioVisualContent category) {
		this.serieOrFilmNode.setElement(category);
	} // Fin de setAudioVisualContent
	
} // Fin de clase
