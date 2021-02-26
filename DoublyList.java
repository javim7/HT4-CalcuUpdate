//importando clases externas
import java.util.*;

/**
 * @author Marco Orozco
 * @author Javier Mombiela SinglyList.java hereda las funciones de abstract
 * SinglyList.java extiendo los metodos de abstracts lsit
 */

public class DoublyList<E> extends AbstractList<E> {

  //creando variables
  LinkedList<E> lista;
  int count;

    public DoublyList()
   // post: generates an empty list
   {
    lista = new LinkedList<E>();

   }

    @Override
    public int size() {
     // post: returns number of elements in list
    return lista.size();
  }

    @Override
    public boolean isEmpty() {
        // post: returns true iff list has no elements
        boolean vacia = false;
        if(lista.isEmpty()) {
            vacia = true;
        } else{
            vacia = false;
        }
        return vacia;
    }

    @Override
    public void add(E value){
        // post: value is added to beginning of list
        lista.add(value);
     
  }

    @Override
    public E getLast() {
        // pre: list is not empty
   // post: returns last value in list
        return lista.getLast();
    }

    @Override
    public E remove() {
        // pre: list has at least one element
   // post: removes last value found in list
        return lista.removeLast();
    }

    
    
}