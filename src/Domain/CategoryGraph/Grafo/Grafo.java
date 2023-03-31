package Domain.CategoryGraph.Grafo;

public interface Grafo {

	// Eliminar el grafo
	public void anular();
	
	// true si el grafo está vacío
	public boolean isEmpty();
	
	// Devuelve el número de vértices que tiene el grafo
	public int getSize() throws GrafoException;
	
	// Devuelve true si existe un vértice
	public boolean existsVertex(Object element) throws GrafoException;
	
	// Devuelve true si existe una arista que une los 2 vértices indicados
	public boolean existsEdge(Object v1, Object v2) throws GrafoException;
	
	// Agrega un vertice al grafo
	public void insertVertex(Object elemento) throws GrafoException;
	
	// Agrega una lista que permita unir 2 vertices
	public void insertEdge(Object v1, Object v2) throws GrafoException;
	
	public void insertEdgeAndWeight(Object v1, Object v2, int peso) throws GrafoException;
	
	// 2) Recorre el grafo utilizando el algoritmo de búsqueda de amplitud/anchura
	public String  bfs()  throws GrafoException;
	
} // Fin de interface


