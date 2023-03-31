package Domain.TDAListas;

public class DoubleLinkedList implements Lista {

	// Atributos
	// 1) Refencia al principio de la lista
	private Nodo start;
	private int size; // lleva el control de la cantidad de nodos de la lista
	
	public DoubleLinkedList() {
		this.start = null; // Representa el principio y fin de la lista
		this.size = 0;
	} // Fin del constructor

	public int getSize() throws ListaException {
		return this.size;
	} // Fin de getSize

	public void cancel() {
		this.start = null;
		this.size = 0;
	} // Fin de cancel

	public boolean isEmpty() {
		return this.start == null ? true : false;
	} // Fin de isEmpty

	public void insert(Object element) {
		Nodo aux = this.start; // para moverme por la lista y no perder el inicio
		Nodo newNode = new Nodo(element); // nuevo nodo que estamos almacenando

		if (isEmpty()) { // Caso1: cuando la lista esta vacía
			this.start = newNode;

		} else {
			while (aux.getNext() != null) {
				aux = aux.getNext();// mueve el aux al siguiente nodo
			} // Fin de while
			aux.setNext(newNode);
			// almacenamos el nuevo nodo en la lista
			newNode.setBefore(aux); // hacemos el doble enlace
		} // Fin de else
		this.size++;
	} // Fin de insert

	public int getPosition(Object element) {

		if (isEmpty()) {
			throw new ListaException("Lista Vacía");
		} // Fin de if

		Nodo aux = this.start; // Para movernos por la lista
		int position = 1; // Indica la posición del elemento en la lista

		while (aux != null) {
			if (aux.getElement().equals(element)) {
				return position;
			} // Fin de if

			aux = aux.getNext();
			position++;
		} // Fin de while

		return -1; // -1 sirve como indicador de que no se encontró el elemento

	} // Fin de getPosition

	public Object getByPosition(int position) throws ListaException {

		if (this.size < position || position <= 0) {
			throw new ListaException("La posición " + position + " no es válida");
		} // Fin de if

		Nodo aux = this.start;
		int contador = 1;

		while (contador != position) {
			aux = aux.getNext();
			contador++;
		} // Fin dewhile

		return aux.getElement();

	} // Fin de getByPosition

	public void delete(Object element) {

		if (isEmpty()) {
			throw new ListaException("Lista Vacía");
		} // Fin de if

		if (this.size == 1 && this.start.getElement().equals(element)) { // Que pasa si sólo queda un nodo y es el que desea eliminar
			this.cancel(); // Se anula toda la lista
		} else if (this.start.getElement().equals(element)) {
			this.start = this.start.getNext();
			this.start.setBefore(null);
			this.size--;
		} else {
			Nodo aux = this.start;
			
			while (aux.getNext() != null) {
				if (aux.getNext().getElement().equals(element)) {
					aux.setNext(aux.getNext().getNext());
					aux.getNext().setBefore(aux); 
					this.size--;
					break;
				} else {
					aux = aux.getNext();
				} // Fin de else 
			} // fin de while
		} // Fin de else

	} // Fin de delete

	public void delete(int position) {
		
		if (this.size < position || position <= 0) {
			throw new ListaException("La posición " + position + " no es válida");
		} else if (this.size == 1 && position == 1) { // Que pasa si sólo queda un nodo y es el que desea eliminar
			this.cancel(); // Se anula toda la lista
		} else if (position == 1) {
			this.start = this.start.getNext();
			this.start.setBefore(null);
			this.size--;
		} else {
			Nodo aux = this.start.getNext();
			int contador = 2;

			while (contador != position) {
				aux = aux.getNext();
				contador++;
			} // Fin de while
			
			aux.getBefore().setNext(aux.getNext()); 
			aux.getNext().setBefore(aux.getBefore());
			
			this.size--;
		} // Fin de else
		
	}  // Fin de delete

	public boolean exists(Object element) {

		if (isEmpty()) {
			throw new ListaException("DoubleLinkedList is empty");
		} else if (this.start.getElement().equals(element)) {
			return true;
		} else {
			Nodo aux = this.start.getNext();
			while (aux != null) {

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

	@Override
	public Object lastInList() {
		return null;
	} // Fin de lastInList
	
	public String toString() {

		if (isEmpty()) {
			return "Lista vacía";
		} else {

			Nodo aux = this.start;
			String result = "VALORES DE LA LISTA DOBLEMENTE ENLAZADA\n";
			result += "----------------------------------------\n";
			while (aux != null) {
				result += aux.getElement() + "<--->";
				aux = aux.getNext();
			} // Fin de while

			return result;
		} // Fin de else
		
	} // Fin de toString

	public Nodo getStart() {
		return start;
	} // Fin de getStart

	public void setStart(Nodo start) {
		this.start = start;
	} // Fin de setStart

	public void setSize(int size) {
		this.size = size;
	} // Fin de setSize
	
	
} // Fin de clase
