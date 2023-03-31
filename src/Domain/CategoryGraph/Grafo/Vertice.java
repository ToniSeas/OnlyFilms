package Domain.CategoryGraph.Grafo;

import Domain.TDAListas.CircularDoubleLinkedList;

public class Vertice {

	//Atributos
	private Object element; // elemento almacenado en el vértice
	private boolean visited; // Algoritmos de recorrido
	private boolean destiny; // Algoritmo Dijkstra
	
	// ListaEnlazada para cuando trabajamos el grafo con Listas
	private CircularDoubleLinkedList edgesList, weightList;
	
	public Vertice(Object element) {
		this.element = element;
		this.destiny = false;
		this.visited = false;
		
		// Iniciar las listas
		this.edgesList = new CircularDoubleLinkedList(); 
		this.weightList = new CircularDoubleLinkedList();
	} // Fin del constructor
	
	//----------------------------------------getters----------------------------------------
	public Object getElement() {return element;}
	public boolean isVisited() {return visited;}
	public boolean isDestiny() {return destiny;}
	public CircularDoubleLinkedList getEdgesList() {return edgesList;}
	public CircularDoubleLinkedList getWeightList() {return weightList;}
	
	//----------------------------------------setters----------------------------------------	
	public void setElement(Object element) {this.element = element;}
	public void setVisited(boolean visited) {this.visited = visited;}
	public void setDestiny(boolean destiny) {this.destiny = destiny;}
	public void setEdgesList(CircularDoubleLinkedList edgesList) {this.edgesList = edgesList;}
	public void setWeightList(CircularDoubleLinkedList weightList) {this.weightList = weightList;}
	
} // Fin de clase
