package Domain.CategoryGraph;
import java.io.IOException;
import java.io.Serializable;
import Domain.AudioVisualContent;
import Domain.Category;
import Domain.CategoryList;
import Domain.SingletonCategorysAccess;
import Domain.CategoryGraph.Grafo.GrafoListaAdyacencia;
import Domain.CategoryGraph.Grafo.Vertice;

public class CategoryGraph implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private GrafoListaAdyacencia graph;
	private Vertice previousVertex;
	
	public CategoryGraph () {
		this.graph = new GrafoListaAdyacencia();
		this.previousVertex = null;
	} // Fin del constructor
	
	public void insertVertex (AudioVisualContent audioVisualContent) {

		this.graph.insertVertex(audioVisualContent);
		
		if (this.graph.getSize()>1) {
			this.previousVertex = this.graph.getVertexByPosition(this.graph.getSize()-1);
			this.insertEdgeAndWeight((AudioVisualContent)this.previousVertex.getElement(), audioVisualContent, 0);
		} // Fin de if 
		
	} // Fin de insertVertex
	
	public void insertEdgeAndWeight(AudioVisualContent v1, AudioVisualContent v2, int peso) {
		
		if (this.previousVertex!=null) {
			this.graph.insertEdge(v1, v2);
		} // Fin de if
		
	} // Fin de insertEdgeAndWeight
	
	public Category dfs () throws IOException {
	
		CategoryList temp = SingletonCategorysAccess.getInstance().getCategoryList();	
		
		String recommendedGender = "";
		
			recommendedGender = this.graph.dfs();
		
		for (int i = 1; i <= temp.getSize(); i++) {
			
			Category category = temp.getByPosition(i);
			if (category.getGender().equals(recommendedGender)) {
				return category;
			} // Fin de if
			
		} // Fin de for-i
		
		return null; 
	} // Fin de dfs

	public boolean isEmpty () {
		return this.graph.isEmpty();
	} // Fin de isEmpty
	
	public int getSize () {
		return this.graph.getSize();
	} // Fin de getSize
	
	//----------------------------------------getters----------------------------------------
	public GrafoListaAdyacencia getGraph() {return graph;}
	public Vertice getPreviousVertex() {return previousVertex;}
	
	//----------------------------------------setters----------------------------------------	
	public void setGraph(GrafoListaAdyacencia graph) {this.graph = graph;}
	public void setPreviousVertex(Vertice previousVertex) {this.previousVertex = previousVertex;}

	public String toString () {
		return this.graph.toString();
	} // Fin de toString
	
} // Fin de clase
