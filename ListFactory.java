public class ListFactory {
    // lista que va a devolver pero no se ha iniciado
    AbstractList<String> listString;
    AbstractList<Float> listFloat;

    // Metodo que se encarga de generar el stack de String
    public AbstractList<String> generateListkString(int opcion){
        if(opcion == 1){
            listString = new SinglyList<String>();
        }
        if(opcion == 2){
            listString = new DoublyList<String>();
        }

        return listString;
    }

    // Metodo que se encarga de generar el stack de float
    public AbstractList<Float>generateLIstFloat(int opcion){
        if(opcion == 1){
            listFloat = new SinglyList<Float>();
        }

        if(opcion == 2){
            listFloat = new DoublyList<Float>();
        }

        return listFloat;
    }
}

