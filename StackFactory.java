public class StackFactory {
    // lista que va a devolver pero no se ha iniciado
    Stack<String> stackString;
    Stack<Float> stackFloat;

    // Metodo que se encarga de generar el stack de String
    public Stack<String> generateStackString(int opcion){
        if(opcion == 1){
            stackString = new StackVector<String>();
        }

        return stackString;
    }

    // Metodo que se encarga de generar el stack de float
    public Stack<Float>generateStackFloat(int opcion){
        if(opcion == 1){
            stackFloat = new StackVector<Float>();
        }

        return stackFloat;
    }
}
