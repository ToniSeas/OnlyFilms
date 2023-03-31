package Domain;

import java.io.IOException;

import Domain.TDAListas.CircularDoubleLinkedList;
import Domain.TDAListas.Nodo;

public class CategoryList {
	
	private CircularDoubleLinkedList categoryList;
	
	public CategoryList () {
		this.categoryList = new CircularDoubleLinkedList();
	} // Fin de clase
	
	public void addCategoryAndContent (String gender, String imagePath, String imageSelecPath, SerieMovieList serieMovieList) throws IOException {
		this.categoryList.insert(new Category(gender, imagePath, imageSelecPath, serieMovieList));
	} // Fin de addCategory
	
	public Nodo getFirstCategory () {
		return this.categoryList.getStart();
	} // Fin de getFirstCategory
	
	public Category getByPosition (int position) {
		
		return (Category) (this.categoryList.getByPosition(position));
		
	} // Fin de getByPosition
	
	public int getSize () {
		return this.categoryList.getSize();
	} // Fin de getSize
	
	public Nodo getNext (Nodo nodo) {
		return nodo.getNext();
	} // Fin de getNext
	
	public Nodo getBefore (Nodo nodo) {
		return nodo.getBefore();
	} // Fin de getNext
	
} // Fin de clase
