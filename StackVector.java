import java.util.Vector;

/**
 * @author: Marco Orozco
 * @version 1.02 Esta clase es la implementaciond e un vector a mi estilo
 */

public class StackVector<E> extends AbstractSack<E> {

    public Vector<E> lista = new Vector<E>();

    //creando el vector
	protected Vector<E> data;


    /**
     * Metodo para crear un stack vacio
     * @param 
     */
	public StackVector()
	{
		data = new Vector<E>();
	}


    /**
     * Metodo para agregar un nuevo item al tope del stack
     * @param item
     */
    @Override
	public void push(E item)
	{
		data.add(item);
	}

    /**
     * Metodo para remover el item de hasta arriba
     * @param 
     * @return el elemento que saco del vector
     */
    @Override
	public E pop()
	{
		return data.remove(size()-1);
	}

    /**
     * Metodo para ver el elemento de hasta arriba
     * @param 
     * @return el elemento de hasta arriba de la stack
     */
    @Override
	public E peek()
	{
		return data.get(size() - 1);
	}
    
    /**
     * Metodo para ver el tamano del stack
     * @param 
     * @return un int con el numero de elementos en el stack
     */
    @Override
	public int size()
	// para ver el numero de elementos en el vector
	{
		return data.size();
	}
  
    /**
     * Metodo para ver si el stack esta vacio o no
     * @param 
     * @return se retorna true si stack esta vacia
     */
    @Override
	public boolean empty()
	
	{
		return size() == 0;
    }
    
}