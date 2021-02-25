public class StackFactory {
    // lista que va a devolver pero no se ha iniciado
    AbstractSack<String> stackString;
    AbstractSack<Float> stackFloat;

    // Metodo que se encarga de generar el stack de String
    public AbstractSack<String> generateStackString(int opcion){
        if(opcion == 1){
            stackString = new StackArrayList<String>();
        }

        return stackString;
    }

    // Metodo que se encarga de generar el stack de float
    public AbstractSack<Float>generateStackFloat(int opcion){
        if(opcion == 1){
            stackFloat = new StackArrayList<Float>();
        }

        return stackFloat;
    }
}
