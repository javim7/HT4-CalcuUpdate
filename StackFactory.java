import java.util.*;

public class StackFactory {
    // lista que va a devolver pero no se ha iniciado
    AbstractSack<String> stackString;
    AbstractSack<Float> stackFloat;


    // Scanner para elegir stack
    Scanner scan = new Scanner(System.in);

    // En esta varaible se guardara la opcion que el usuario elige por las linkedlist
    // Es para ahorrarse preguntar 2 veces jsjsjsj
    int opcionFloat = 0;

    
    /** 
     * @param opcion
     * @return AbstractSack<String>
     */
    // Metodo que se encarga de generar el stack de String
    public AbstractSack<String> generateStackString(int opcion){
        if(opcion == 1){
            stackString = new StackArrayList<String>();
        }
        if(opcion == 2){
            stackString = new StackVector<String>();
        }
        if(opcion == 3){
            System.out.println("Que LinkedList Deseas utilizar?");
            System.out.println("Singly");
            System.out.println("Doubly");
            int option = scan.nextInt();
            opcionFloat = option;
            if(option == 1){
                stackString = new StackLinkedList<String>(1);
            } else if (option == 2){
                stackString = new StackLinkedList<String>(2);
            }
        }

        return stackString;
    }

    
    /** 
     * @param opcion
     * @return AbstractSack<Float>
     */
    // Metodo que se encarga de generar el stack de float
    public AbstractSack<Float>generateStackFloat(int opcion){
        if(opcion == 1){
            stackFloat = new StackArrayList<Float>();
        }

        if(opcion == 2){
            stackFloat = new StackVector<Float>();
        }

        if(opcion == 3){
            if(opcionFloat == 1){
                stackFloat = new StackLinkedList<Float>(1);
            } else if(opcionFloat == 2){
                stackFloat = new StackLinkedList<Float>(2);
            }
        }
        return stackFloat;
    }
}
