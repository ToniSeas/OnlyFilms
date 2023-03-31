package Domain.CategoryGraph.Grafo;

import java.io.Serializable;
import Domain.AudioVisualContent;
import Domain.CategoryControl;
import Domain.TDAColaEnlazada.ColaEnlazada;
import Domain.TDAListas.CircularDoubleLinkedList;
import Domain.TDAPilaEnlazada.PilaEnlazada;


public class GrafoListaAdyacencia implements Grafo, Serializable {

	private static final long serialVersionUID = -5064845255755226238L;
	// Atributos
	private CircularDoubleLinkedList vertex;
	private ColaEnlazada queue;
	private PilaEnlazada pila;

	public GrafoListaAdyacencia() {
		this.vertex = new CircularDoubleLinkedList();
		this.queue = new ColaEnlazada();
		this.pila = new PilaEnlazada();
	} // Fin del constructor

	public void anular() {
		this.vertex.cancel();
	} // Fin de anular

	public boolean isEmpty() {
		return this.vertex.isEmpty();
	} // Fin de isEmpty

	public int getSize() throws GrafoException {
		return this.vertex.getSize();
	} // Fin de getSize

	public boolean existsVertex(Object element) throws GrafoException {

		if (isEmpty()) {
			throw new GrafoException("No existe el grafo");
		} // Fin de if

		for (int i = 1; i <= this.getSize(); i++) {
			if (((Vertice) this.vertex.getByPosition(i)).getElement().equals(element)) {
				return true;
			} // Fin de if
		} // Fin de for-i

		return false;
	} // Fin de existsVertex

	public Vertice getVertexByPosition(int position) throws GrafoException {

		return (Vertice) this.vertex.getByPosition(position);

	} // Fin de getVertexByPosition

	public boolean existsEdge(Object v1, Object v2) throws GrafoException {

		if (isEmpty()) {
			throw new GrafoException("No existe el grafo");
		} // Fin de if

		for (int i = 1; i <= this.vertex.getSize(); i++) {

			Vertice vertice = ((Vertice) this.vertex.getByPosition(i));

			for (int j = 1; j <= vertice.getEdgesList().getSize(); j++) {

				if (vertice.getEdgesList().getByPosition(j).equals(v1)
						|| vertice.getEdgesList().getByPosition(j).equals(v2)) {
					return true;
				} // Fin de if

			} // Fin de for-j

		} // Fin de for-i

		return false;
	} // Fin de existsEdge

	public void insertVertex(Object element) throws GrafoException {

		Vertice newVertex = new Vertice(element);
		this.vertex.insert(newVertex);

	} // Fin de insertVertex

	public void insertEdge(Object v1, Object v2) throws GrafoException {

		if (isEmpty()) {
			throw new GrafoException("No existe el grafo");
		} // Fin de if

		for (int i = 1; i <= this.vertex.getSize(); i++) {

			Vertice auxVertex = ((Vertice) this.vertex.getByPosition(i));

			if ((auxVertex.getElement()).equals(v1)) {
				auxVertex.getEdgesList().insert(v2);
			} // Fin de if

			// Para lo no dirigido
			if ((auxVertex.getElement()).equals(v2)) {
				auxVertex.getEdgesList().insert(v1);
			} // Fin de if

		} // Fin de for-i

	} // Fin de insertEdge

	public void insertEdgeAndWeight(Object v1, Object v2, int peso) throws GrafoException {

		if (isEmpty()) {
			throw new GrafoException("No existe el grafo");
		} // Fin de if

		for (int i = 1; i <= this.vertex.getSize(); i++) {

			Vertice auxVertex = ((Vertice) this.vertex.getByPosition(i));

			if ((auxVertex.getElement()).equals(v1)) {
				auxVertex.getEdgesList().insert(v2);
				auxVertex.getWeightList().insert(peso);
			} // Fin de if

			// Para lo no dirigido
			if ((auxVertex.getElement()).equals(v2)) {
				auxVertex.getEdgesList().insert(v1);
				auxVertex.getWeightList().insert(peso);
			} // Fin de if

		} // Fin de for-i

	} // Fin de insertEdgeAndWeight

	public String dfs() throws GrafoException {
		
		CategoryControl categoryControl = new CategoryControl();

		if (this.getSize() > 1) {

			((Vertice) this.vertex.getByPosition(1)).setVisited(true);
			this.pila.push(1);
			categoryControl.addSumCategory(((AudioVisualContent) ((Vertice) this.vertex.getByPosition(1)).getElement()).getGender());

			while (!this.pila.isEmpty()) {

				int v = adjacentVertexNotVisited(Integer.parseInt(this.pila.top().toString()));

				if (v == -1) {
					this.pila.pop();
				} else {

					Vertice auxVertex = ((Vertice) this.vertex.getByPosition(v));
					auxVertex.setVisited(true);
					categoryControl.addSumCategory(((AudioVisualContent) auxVertex.getElement()).getGender());

					this.pila.push(v);

				} //  Fin de else

			} // Fin de while

			for (int i = 1; i <= this.getSize(); i++) {
				((Vertice) this.vertex.getByPosition(i)).setVisited(false);
			} // Fin de for-i
		}else {
			categoryControl.addSumCategory(((AudioVisualContent) ((Vertice) this.vertex.getByPosition(1)).getElement()).getGender());

		} // Fin de else
		return categoryControl.getMostVisited();
		
	} // Fin de dfs

	@Override
	public String bfs() throws GrafoException {
		
		CategoryControl categoryControl = new CategoryControl();

		if (this.getSize() >= 1) {
			((Vertice) this.vertex.getByPosition(1)).setVisited(true);
			this.queue.encolar(1);
			categoryControl.addSumCategory(((AudioVisualContent) ((Vertice) this.vertex.getByPosition(1)).getElement()).getGender());

			while (!this.queue.isEmpty()) {

				int v = adjacentVertexNotVisited(Integer.parseInt(this.queue.head().toString()));
				if (v == -1) {
					this.queue.desencolar();
				} else {

					Vertice auxVertex = ((Vertice) this.vertex.getByPosition(v));

					auxVertex.setVisited(true);

					System.out.println("cat-dfs: "+((AudioVisualContent) auxVertex.getElement()).getGender());
					categoryControl.addSumCategory(((AudioVisualContent) auxVertex.getElement()).getGender());


					this.queue.encolar(v);

				} // Fin de else

			} // Fin de while

			for (int i = 1; i <= this.getSize(); i++) {
				((Vertice) this.vertex.getByPosition(i)).setVisited(false);
			} // Fin de for-i
		}
		return categoryControl.getMostVisited();

	} // Fin de bfs

	public String toString() {

		String result = "INFORMACIÓN DEL GRAFO: \n";
		result += "Con Lista de Adyacencia \n";
		result += "---------------------------------\n";

		for (int i = 1; i <= this.vertex.getSize(); i++) {
			result += "El vértice en la Posición: " + i + " es: "
					+ ((AudioVisualContent) ((Vertice) this.vertex.getByPosition(i)).getElement()).getName() + "\n";
		} // Fin de for-i

		result += "\nAristas y pesos\n\n";

		for (int i = 1; i <= this.vertex.getSize(); i++) {

			for (int j = 1; j <= ((Vertice) this.vertex.getByPosition(i)).getEdgesList().getSize(); j++) {
				result += ((AudioVisualContent) ((Vertice) this.vertex.getByPosition(i)).getElement()).getName()
						+ "-------------";
				result += ((AudioVisualContent) ((Vertice) this.vertex.getByPosition(i)).getEdgesList()
						.getByPosition(j)).getName() + "\n";

				if (!((Vertice) this.vertex.getByPosition(i)).getWeightList().isEmpty()) {
					result += "--------- Peso: "
							+ ((Vertice) this.vertex.getByPosition(i)).getWeightList().getByPosition(j) + "\n\n";
				} // Fin de if

			} // Fin de for-j

		} // Fin de for-i

		return result;

	} // Fin de toString

	private int adjacentVertexNotVisited(int v) {
		for (int i = 1; i <= this.getSize(); i++) {

			if (((Vertice) this.vertex.getByPosition(i)).getEdgesList().exists(showVertex(v))
					&& ((Vertice) this.vertex.getByPosition(i)).isVisited() == false) {
				return i; // El indice del vertice por el que me puedo ir
			} // Fin de  if
		} // Fin de for-i

		return -1;

	} // Fin de adjacentVertexNotVisited

	private Object showVertex(int pos) {

		if (pos < 1 || pos > this.getSize()) {
			throw new GrafoException("No existe el vertice en el grafo");
		} // Fin de if

		return (((Vertice) this.vertex.getByPosition(pos)).getElement());

	} // Fin de showVertex

} // Fin de clase
