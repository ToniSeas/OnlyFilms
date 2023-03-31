package Domain.TDAListas;

import java.io.Serializable;

public class CircularDoubleLinkedList implements Lista, Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	// 1) Refencia al principio de la lista y fin de la lista para hacer el enlace circular
	private Nodo start, end;
	private int cont; // lleva el control de la cantidad de nodos de la lista
	
	public CircularDoubleLinkedList() {
		this.start = this.end = null; // Representa el principio y fin de la lista
		this.cont = 0;
	} // Fin del constructor

	public int getSize() throws ListaException {
		return this.cont;
	} // Fin de getSize

	public void cancel() {
		this.start = this.end = null;
		this.cont = 0;
	} // Fin de cancel

	public boolean isEmpty() {
		return this.start == null ? true : false;
	} // Fin de isEmpty

	public void insert(Object element) {
		Nodo aux = this.start; // Define aux para moverme por la lista y no perder el inicio
		Nodo newNodo = new Nodo(element); // el nuevo nodo que estamos almacenando

		if (aux == null) {
			this.start = this.end = newNodo;
		} else {
			while (aux != this.end) {
				aux = aux.getNext(); // mueve el aux al siguiente nodo;
			} // Fin de while
			// Se sale cuando aux sea igual el this.end
			aux.setNext(newNodo); // almacenamos el nuevo nodo en la lista
			newNodo.setBefore(aux); // hacemos el double enlace
			this.end = newNodo; // Se actualiza el último nodo
		} // Fin de else
		// Se hace el double enlace circular
		this.end.setNext(this.start);
		this.start.setBefore(this.end);
		this.cont++;

	} // Fin de insert

	public int getPosition(Object element) {

		if (isEmpty()) {
			throw new ListaException("Lista Vacía");
		} // Fin de if

		Nodo aux = this.start; // Para movernos por la lista
		int position = 1; // Indica la posición del elemento en la lista

		while (aux != this.end) {
			if (aux.getElement().equals(element)) {
				return position;
			} // Fin de if

			aux = aux.getNext();
			position++;
		} // Fin de while

		if (this.end.getElement().equals(element)) {
			return position;
		} // Fin de if

		return -1; // -1 sirve como indicador de que no se encontró el elemento

	} // Fin de getPosition

	public Object getByPosition(int position) throws ListaException {

		if (this.cont < position || position <= 0) {
			throw new ListaException("La posición indicada no es válida");
		} // Fin de if

		Nodo aux = this.start;
		int contador = 1;

		while (contador != position) {
			aux = aux.getNext();
			contador++;
		} // Fin de while

		return aux.getElement();

	} // Fin de  getByPosition

	public void delete(Object element) {

		if (isEmpty()) {
			throw new ListaException("Lista Vacía");
		} // FIn de if

		if (this.start == this.end && this.start.equals(element)) { // Que pasa si sólo queda un nodo y es el que desea eliminar
			this.cancel(); // Se anula toda la lista
		} else if (this.start.getElement().equals(element)) {
			this.start = this.start.getNext();
			this.start.setBefore(this.end);
			this.end.setNext(this.start);
			this.cont--;
		} else {
			Nodo aux = this.start;
			
			while (aux != this.end) {
				if (aux.getNext().getElement().equals(element)) {
					aux.setNext(aux.getNext().getNext());
					aux.getNext().setBefore(aux); 
					if (aux.getNext() == this.start) {
						this.end = aux;
					} // Fin de if
					this.cont--;
					break;
				} else {
					aux = aux.getNext();
				} // Fin de else
			} // Fin de while
		} // Fin de else

	} // Fin de delete

	public void delete(int position) {
		
		if (this.cont < position || position <= 0) {
			throw new ListaException("La posición indicada no es válida");
		} else if (this.cont == 1 && position == 1) { // Que pasa si sólo queda un nodo y es el que desea eliminar
			this.cancel(); // Se anula toda la lista
		} else if (position == 1) {
			this.start = this.start.getNext();
			this.start.setBefore(this.end);
			this.end.setNext(this.start);
			this.cont--;
		} else {
			Nodo aux = this.start.getNext();
			int contador = 2;

			while (contador != position) {
				aux = aux.getNext();
				contador++;
			} // Fin de while
			
			aux.getBefore().setNext(aux.getNext()); 
			aux.getNext().setBefore(aux.getBefore());
			if (aux.getBefore().getNext() == this.start) {
				this.end = aux.getBefore();
			} // Fin de if
			this.cont--;
		} // Fin de else
		

	}  // Fin de delete

	public boolean exists(Object element) {

		if (isEmpty()) {
			throw new ListaException("CircularDoubleLinkedList is empty");
		} else if (this.start.getElement().equals(element) || this.end.getElement().equals(element)) {
			return true;
		} else {
			Nodo aux = this.start.getNext();
			while (aux != this.start) {

				if (aux.getElement().equals(element)) {
					return true;
				} else {
					aux = aux.getNext();
				} // Fin de else 

			} // Fin de while

			return false;

		} // Fin de else
	} // Fin de exists

	public Object firstInList() {
		return this.start.getElement();
	} // Fin de firstInList

	public Object lastInList() {
		return this.end.getElement();
	} // Fin de lastInList

	public String toString() {

		if (isEmpty()) {
			return "Lista vacía";
		} else {

			Nodo aux = this.start;
			String result = "VALORES DE LA LISTA CIRCULAR DOBLEMENTE ENLAZADA\n";
			result += "----------------------------------------\n";
			while (aux != this.end) {
				result += aux.getElement() + "<--->";
				aux = aux.getNext();
			} // Fin de while
			result += this.end.getElement() + "<---->";

			return result;
		} // Fin de else
		
	} // Fin de toString

	public Nodo getStart() {
		return start;
	} // Fin de getStart

	public void setStart(Nodo start) {
		this.start = start;
	} // Fin de setStart

	public Nodo getEnd() {
		return end;
	} // Fin de getEnd

	public void setEnd(Nodo end) {
		this.end = end;
	} // Fin de setEnd
		
} // Fin de clase
