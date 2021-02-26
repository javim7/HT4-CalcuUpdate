/**
 * @author Marco Orozco
 * @version 1.02 Esta interfaz es para usarla en Stackvector
 */
public interface Stack<E> {
    void push(E info);

    // post:Agregar el dato al stack
    E pop();

    // pre:revisar que no este vacio
    // pos: eliminar un elemento del stack
    E peek();

    // pre: revisar que el stack no este vacio
    // post: muestra el stack mas reciente
    int size();

    // post: regresa el tamano del stack
    boolean empty();
    // post: true si esta vacio el stack

}