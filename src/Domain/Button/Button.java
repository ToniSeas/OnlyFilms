package Domain.Button;

import java.io.IOException;
import java.io.InputStream;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;


public class Button {

	protected InputStream imageLoader;
	protected Image image;
	protected int positionX;
	protected int positionY;
	protected double width;
	protected double height;
	protected Rectangle hitBox;
	protected Object object;
	
	// Constructor default
	public Button(int positionX, int positionY) throws IOException {
		this.positionX = positionX;
		this.positionY = positionY;
	} // Fin del constructor
	
	// Botón normal
	public Button(String imagePath, int positionX, int positionY) throws IOException {
		this.imageLoader = getClass().getResourceAsStream(imagePath);
		this.image = new Image(this.imageLoader);
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
		this.hitBox = new Rectangle (this.positionX, this.positionY, this.width, this.height);
		this.object = null;
	} // Fin del constructor
	
	// Botón normal con ancho y alto personalizado
	public Button(String imagePath, int positionX, int positionY, double width, double height) throws IOException {
		this.imageLoader = getClass().getResourceAsStream(imagePath);
		this.image = new Image(this.imageLoader);
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.hitBox = new Rectangle (this.positionX, this.positionY, this.width, this.height);
		this.object = null;
	} // Fin del constructor
	
	public boolean mouseOver(int positionX, int positionY) throws IOException {
		if (this.hitBox.intersects(positionX, positionY, 1, 1)) {
			return true;
		}
		return false;
	} // Fin de mouseIntersecting	
	
	public void paint (GraphicsContext gc) {
		gc.drawImage(this.image, this.positionX, this.positionY, this.width, this.height);
	} // Fin de paint

	//----------------------------------------getters----------------------------------------
	public Image getNormalimage() {return image;}
	public Image getImage() {return image;}
	public Rectangle getHitBox() {return hitBox;}
	public Object getObject() {return object;}
	public int getPositionX() {return positionX;}
	public int getPositionY() {return positionY;}

		
		//----------------------------------------setters----------------------------------------	
	public void setImage(Image image) {this.image = image;}
	public void setHitBox(Rectangle hitBox) {this.hitBox = hitBox;}
	public void setObject(Object object) {this.object = object;}
	public void setPositionX(int positionX) {this.positionX = positionX;}
	public void setPositionY(int positionY) {this.positionY = positionY;}
		
	public void setNormalImagePath(String imagePath) {
		this.imageLoader = getClass().getResourceAsStream(imagePath);
		this.image = new Image(this.imageLoader);
		this.hitBox = new Rectangle(positionX, positionY, this.image.getWidth(), this.image.getHeight());
	} // Fin de setNormalImage

	public void setSelecImagePath(String imagePath) {
		this.imageLoader = getClass().getResourceAsStream(imagePath);
		this.image = new Image(this.imageLoader);
		this.hitBox = new Rectangle(positionX, positionY, this.image.getWidth(), this.image.getHeight());
	} // Fin de setSelecImage
		
	public void setNormalImage(Image normalImage) {
		this.image = normalImage;
		this.hitBox = new Rectangle(positionX, positionY, this.image.getWidth(), this.image.getHeight());
	} // Fin de setNormalImage

	public void setSelecImage(Image imageSelect) {
		this.image = imageSelect;
		this.hitBox = new Rectangle(positionX, positionY, this.image.getWidth(), this.image.getHeight());
	} // Fin de setSelecImage
	
	
} // Fin de clase
