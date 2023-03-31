package Domain.TDAColaEnlazada;

import java.io.Serializable;

public class ColaEnlazada implements Cola, Serializable {

	private static final long serialVersionUID = 1L;
	private Nodo posterior;
	private int size;
	
	public ColaEnlazada() {
		this.posterior  = null;
		this.size = 0;
	} // Fin del constructor
	
	public int getSize() {
		return this.size;
	} // Fin de getSize

	public boolean isEmpty() {
		return this.posterior==null ? true : false;
	} // Fin de isEmpty

	public void cancel() {
		this.posterior = null;
	} // Fin de cancel

	public void encolar(Object element) throws ColaException {
	
		Nodo newNodo = new Nodo(element);
		
		if (this.posterior == null) {
			this.posterior = newNodo;
		} else {
			
			Nodo aux = this.posterior;
			
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			
			aux.setNext(newNodo);
			
		} // if else
		
		this.size ++;
		
	} // Fin de encolar

	public Object desencolar() throws ColaException {
		
		if (isEmpty()) {
			throw new ColaException("ERROR: La cola está vacía");
		} else {
			Nodo aux = this.posterior;
			this.posterior = this.posterior.getNext();
			this.size--;
			return aux.getElement();
		} // if / else
		
	} // Fin de desencolar

	public Object head() {
		return this.posterior.getElement();
	} // Fin de head

	public boolean exists(Object element) throws ColaException{

		if (isEmpty()) {
			throw new ColaException("ERROR: La cola está vacía");
		} else {
			
			Nodo aux = this.posterior;
			
			while (aux != null) {
				if (aux.getElement().equals(element)) {
					return true;
				}
				aux = aux.getNext();
			} // while
			return false;
		} // if / else
		
	} // Fin de exists

	public int getPosition(Object element) throws ColaException{
		
		if (isEmpty()) {
			throw new ColaException("ERROR: La cola está vacía");
		} else {
			
			int contador = 1;
			Nodo aux = this.posterior;
			while (aux != null) {
				if (aux.getElement().equals(element)) {
					/* Se retorna la posición según lo que le falta para desencolar
					 Entonces si el que se busca es this.posterior, entonces la posición va a ser 1
					 sino, se va a ir sumando a partir de ahí hasta encontrar el elemento */
					return contador;
				}
				aux = aux.getNext();
				contador++;
			} // while
			
		} // if / else
		
		// Si retorna -1 es porque no existe
		return -1;
		
	} // Fin de getPosition
	
	public String toString() {

		if (isEmpty()) {
			throw new ColaException("ERROR: La cola está vacía");
		} else {

			Nodo aux = this.posterior;
			String result = "INFORMACIÓN DE LA COLA DINÁMICA: \nNota: Los nodos salen por la izquierda\n ";

			while (aux != null) {
				result += "<----" + aux.getNext();
				aux = aux.getNext();
			} // while

			return result;
		} // if / else
	} // Fin de toString

} // Fin de clase
