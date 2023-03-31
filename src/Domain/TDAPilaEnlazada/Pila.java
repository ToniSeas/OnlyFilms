package Domain.TDAPilaEnlazada;

public interface Pila {
	//Cancela, anula o reinicia la pila
	public void cancel();
	
	//Nos permite obtener el numero de elementos en la pila
	public int getSize();
	
	//Devuelve true o false si la pila esta o no vacia
	public boolean isEmpty();
	
	//Devuelve el ultimo valor ingresado en la pila
	public Object top()throws PilaExceptions;
	
	//ingresa valores a la pila
	public void push(Object element);
	
	//elimina(retorna) el ultimo valor ingresado en la pila
	public Object pop()throws PilaExceptions;
	
}//Fin de la clase
