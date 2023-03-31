package Domain.TDAListas;

public class Nodo {

	// Atributos
	// 1) Información del nodo
	private Object element;
	
	// 2) Apuntador-Puntero-Referencia
	private Nodo next, before;
	
	public Nodo(Object element) {
		this.element = element;
		this.next = null;
		this.before = null;
	} // Fin del constructor
	
	//----------------------------------------getters----------------------------------------
	public Object getElement() {return element;}
	public Nodo getNext() {return next;}
	public Nodo getBefore() {return before;}
	
	//----------------------------------------setters----------------------------------------	
	public void setElement(Object element) {this.element = element;}
	public void setNext(Nodo next) {this.next = next;}
	public void setBefore(Nodo before) {this.before = before;}
	
} // Fin de clase
