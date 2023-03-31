package Domain.Button;

import java.io.IOException;

import Domain.Category;
import Domain.TDAListas.Nodo;
import javafx.scene.shape.Rectangle;

public class CategoryButton extends Button {

	private Nodo nodeCategory;
	
	public CategoryButton(Nodo category, int positionX, int positionY) throws IOException {
		super(positionX, positionY);
		this.image = ((Category)category.getElement()).getCoverImage();
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
		this.hitBox = new Rectangle (this.positionX, this.positionY, this.width, this.height);


		this.nodeCategory = category;
	} // Fin del constructor
	
	//----------------------------------------getters----------------------------------------
	public Nodo getNodo() {return nodeCategory;}
	public Category getCategory() {return (Category)this.nodeCategory.getElement();}
	
	//----------------------------------------setters----------------------------------------	
	public void setNodo(Nodo nodeCategory) {
		this.nodeCategory = nodeCategory;
		this.setCategory(((Category)(this.nodeCategory.getElement())));
	} // Fin de setNodo
	public void setCategory(Category category) {this.nodeCategory.setElement(category);}
	
	
} // Fin de clase
