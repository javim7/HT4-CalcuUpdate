import java.util.Vector;

/**
 * @author: Marco Orozco
 * @version 1.02 Esta clase es la implementaciond e un vector a mi estilo
 */

public class StackVector<E> implements Stack<E> {

    public Vector<E> lista = new Vector<E>();

    /**
     * @param info
     */
    // Metodo para meter elementos
    public void Push(E info) {
        // Se añade un valor
        lista.add(info);
    }

    /**
     * @return T
     */
    public E Pop() {

        // Se obtiene un elemento
        int index = lista.size() - 1;

        // Se guarda ese elemento en una variable para posteriormente eliminarlo y
        // devolverlo
        E elemento = lista.get(index);
        lista.remove(index);
        return elemento;
    }

    /**
     * @return boolean
     */
    public boolean Empty() {

        // Devuelve un false si la lista tiene un elemento

        return lista.isEmpty();
    }

    /**
     * @return T
     */
    public E Peek() {

        // Se devuelve el ultimo valor de la lista

        int index = lista.size() - 1;
        return lista.get(index);
    }

    /**
     * @return int
     */
    public int Size() {

        // Se devuelve el tamaño del almacenamiento del stackvector

        return lista.size();
    }

    @Override
    public void push(E info) {
        // TODO Auto-generated method stub

    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean empty() {
        // TODO Auto-generated method stub
        return false;
    }
}