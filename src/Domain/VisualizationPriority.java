package Domain;

import java.io.Serializable;

import Domain.TDAColaEnlazada.ColaEnlazada;

public class VisualizationPriority implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ColaEnlazada queue;

	public VisualizationPriority() {
		this.queue = new ColaEnlazada();
	}// Fin del constructor

	public int getSize() {
		return this.queue.getSize();
	}// Fin de getSize

	public boolean isEmpty() {
		return this.queue.isEmpty();
	} // Fin de isEmpty

	public void addContent(AudioVisualContent content) {
		this.queue.encolar(content);
	} // Fin de addContent
	
	public AudioVisualContent extract() {
		return (AudioVisualContent)this.queue.desencolar();
	} // Fin de extract
	
	public AudioVisualContent firstContent () {
		return (AudioVisualContent)this.queue.head();
	} // Fin de headImage
	
	public void removeContentIfExists (AudioVisualContent content) {
		
		for (int i = 0; i < this.queue.getSize(); i++) {
			AudioVisualContent aux = this.extract();
			
			if (!aux.getName().equals(content.getName())) {
				/* Si el aux es diferente al que se quiere extraer entonces se vuelve a insertar en la cola */
				this.addContent(aux);
			} else if (aux.getName().equals(content.getName())) {
				/*Si aux es igual al elemento que se quiere eliminar entonces se termina el ciclo aquí porque
				 ya se extrajo de la cola */
				break;
			} // if / else
			
		} // for i
				
	} // Fin de removeContentIfExists
	
	public void getNextContent () {
		this.queue.encolar(this.queue.desencolar());
	} // Fin de getNextContent
	
	public boolean exist(AudioVisualContent content) {
		if (!this.isEmpty()) {
			return this.queue.exists(content);
		}
		return false;
	} // Fin de exists
	
	public String toString() {
		return this.queue.toString();
	} // Fin de toString
	
}// Fin de la clase
