/**
 * @author Marco Orozco
 * @author Javier Mombiela
 *  List.java es la interface de las listas
 */

public interface List<E> {

    public int size();
    // pre: 0 <= i < size()
   // post: returns object found at that location

    public boolean isEmpty();
    // post: returns true iff list has no elements

    public void add(E value);
    // post: value is added to tail of list
    
    public E getLast();
     // pre: list is not empty
   // post: returns last value in list

    public E remove();
      // pre: list has at least one element
   // post: removes last value found in list
    
}
