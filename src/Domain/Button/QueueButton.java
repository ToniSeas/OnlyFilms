package Domain.Button;

import java.io.IOException;
import Domain.AudioVisualContent;
import Domain.VisualizationPriority;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class QueueButton extends Button{
	
	private VisualizationPriority visualizationPriority;
	
	public QueueButton (VisualizationPriority visualizationPriority, int positionX, int positionY) throws IOException {
		super(positionX, positionY);
		this.visualizationPriority = visualizationPriority;
		this.image = visualizationPriority.firstContent().getCoverImage();
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
		this.hitBox = new Rectangle (this.positionX, this.positionY, this.width, this.height);
	} // Fin del constructor

	public void draw (GraphicsContext gc) {
		gc.drawImage(this.visualizationPriority.firstContent().getCoverImage(), this.positionX, this.positionY);
	} // Fin de draw
	
	public void getNextContent () {
		
		this.visualizationPriority.getNextContent();
		this.image = this.visualizationPriority.firstContent().getCoverImage();
		
	} // Fin de getNextContent

	public AudioVisualContent getAudioVisualContent() {
		return (AudioVisualContent)this.visualizationPriority.firstContent();
	} // Fin de getAudioVisualContent

} // Fin de clase

