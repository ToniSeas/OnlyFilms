package Domain.TDAColaEnlazada;

public interface Cola {

	public int getSize();
	public boolean isEmpty();
	public void cancel();
	
	// Encola un elemento por el extremo posterior/anterior
	public void encolar(Object element) throws ColaException;
	
	//Desencolar un elemento por uno de los extremos de la cola
	public Object desencolar() throws ColaException;
	
	//Devuelve el elemento de frente/Inicio de la cola
	public Object head();
	
	// Devuelve true si existe el elemento
	public boolean exists(Object element) throws ColaException;
	
	// Indica la posición de un elemento de la cola
	public int getPosition(Object element) throws ColaException;
	
} // Fin de interface
