public class StackLinkedList<E> extends AbstractSack<E>{

    AbstractList<E> lista;

    // En el constructor se define que tipo de LinkedList Utilizara
    public StackLinkedList(int opcion){
        if(opcion == 1){
            lista = new SinglyList<E>();
        } else if(opcion == 2){
            lista = new DoublyList<E>();
        }
    }

    @Override
    public void push(E item) {
        // TODO Auto-generated method stub
        lista.add(item);
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        return lista.remove();
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        return lista.getLast();
    }

    @Override
    public boolean empty() {
        // TODO Auto-generated method stub
        return lista.isEmpty();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return lista.size();
    }
}
