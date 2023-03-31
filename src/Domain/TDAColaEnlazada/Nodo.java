package Domain.TDAColaEnlazada;

import java.io.Serializable;

public class Nodo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Nodo next; // puntero al siguiente nodo
	private Object element; // información
	
	public Nodo(Object element) {
		this.next = null;
		this.element = element;
	} // Fin del constructor

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
	
} // Fin de clase