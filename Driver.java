import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: Marco Orozco
 * @version 1.02 Esta clase es el driver del programa, lo corre.
 */

public class Driver {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<String> stack = new ArrayList<String>();
        try {
            FileReader f = new FileReader(
                    "C:\\Users\\sonic\\Desktop\\HT4-CalcuUpdate-master\\Datos.txt");
            BufferedReader r = new BufferedReader(f);

            String cadena;

            

            while ((cadena = r.readLine()) != null) {
                stack.add(cadena);
            }
            System.out.println(stack);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido abrir el archivo");
        }

        // Se almacena la unica instancia de calculadora en esta variable C
        // Con esto confirmamos que solo existe una instancia de calculadora
        Calculadora c = Calculadora.getInstance();

        

        for (int expresion = 0; expresion < stack.size(); expresion++) {
            c.generarStacks(1);
            System.out.println("\nExpresion pasada a postfix:");
            String expresionActual = c.infixToPostfix(stack.get(expresion));
            System.out.println(expresionActual + "\n");

            System.out.println("Expresion resuelta: ");
            System.out.println(c.Calculo(expresionActual));
        }
    }
}
