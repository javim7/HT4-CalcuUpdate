/**
 * @author Marco Orozco
 * @author Javier Mombiela
 * Implementacion de la hoja de Trabajo 04 Algoritmos
 * y Estructura de Datos - 23 de febrero 2021 - 
 * abstrac AbstractStack.java implementa los metodoos de stack
 */

public abstract class AbstractSack<E> implements Stack<E> {


    /**
     * Metodo push
     * @param item Parametro para ver que item se agrega a la fila
     */
   public abstract void push(E item);
   
   
   /**
    * Metodo pop, para remover el item de arriba del stack
    * @param 
    */
  public abstract E pop();
  
   /**
    * Metodo peek, para ver el item de arriba del stack
    * @param 
    */
  public abstract E peek();
 
   /**
    * Metodo empty, para ver si el stack esta vacio o no
    * @param 
    */
  public abstract boolean empty();
  
   /**
    * Metodo size, para ver el tamano del stack
    * @param 
    */
  public abstract int size();
    
}
