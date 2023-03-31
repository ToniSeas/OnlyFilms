package Domain.TDAPilaEnlazada;

import java.io.Serializable;

public class PilaEnlazada implements Pila, Serializable{

	private static final long serialVersionUID = 1L;
	private Nodo top;//Representa el inicio de la lista
	private int cont;//Nos permite saber el num de elementos que tiene la pila
	
	
	public PilaEnlazada() {
		this.top=null;//inicializamos la pila
		this.cont=0;//Aun no hay valores en la pila
		
	}//Consturctor()


	@Override
	public void cancel() {
		this.top=null;
		this.cont=0;
	} // Fin de cancel


	@Override
	public int getSize() {
		return this.cont;
	} // Fin de getSize


	@Override
	public boolean isEmpty() {
		return this.cont==0;
	} // Fin de isEmpty


	@Override
	public Object top() throws PilaExceptions{
		if(isEmpty()) {
			throw new PilaExceptions("No hay tope, la pila vacia");
		} // Fin de if
		
		return top.element;
	} // Fin de top


	@Override
	public void push(Object element) {
		Nodo nuevoNodo=new Nodo(element);
		
		if(top==null) {
			top=nuevoNodo;
		}else {
			nuevoNodo.next=top;
			top=nuevoNodo;
		} // Fin de else
		cont++;
	} // Fin de push


	@Override
	public Object pop() throws PilaExceptions{
		if(isEmpty()) {
			throw new PilaExceptions("Pila vacia, no se puede hacer POP");
		} // Fin de if
		Object element=top.element;
		top=top.next;
		cont--;//restamos un valor
		
		return element;
	} // Fin de pop
	
	
	public String toString() {
		
		Nodo aux=top;
		String result="Informacion de la pila";
		
		while(aux!=null) {
			result+="\n"+aux.element;
			aux=aux.next;
		} // Fin de while
		
		return result;
	} // Fin de toString

}//Fin de la clase
