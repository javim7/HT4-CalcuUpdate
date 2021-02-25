import java.util.ArrayList;

/**
 * @author: Marco Orozco
 * @version 1.02 Esta clase se encarga de constituir el metodo calculo y en esta
 *          se operan las expresiones
 */

public class Calculadora implements CalculadoraGeneral {

    // Este numero se utilizara para indicar cuantas calculadoras se han instanciado
    static private int numero = 0;

    // Variable en la que se almacenara la instancia de calculadora
    // su fin es iniciar una calculadora en esta variable y asi ejecutar singleton
    private static Calculadora calculator;

    // Listas para el trabajo de los numeros
    Stack<String> sign;
    Stack<Float> numbers;

    // Instancia de factory que creara las listas
    StackFactory creadorStacks = new StackFactory();

    // Constructor privado para Singleton
    private Calculadora(){
        numero++;
    }

    // Metodo para devolver la unica instancia de calculadora
    static public Calculadora getInstance(){
        if(calculator == null){
            calculator = new Calculadora();
        }
        return calculator;
    }

    // Metodo para generar las listas
    public void generarStacks(int opcion){
        sign = creadorStacks.generateStackString(opcion);
        numbers = creadorStacks.generateStackFloat(opcion);
    }

    // Metodo para vaciar las listas y reutilizarlas para la siguiente operacion
    public void vaciarListas(){
        for (int i = 0; i < sign.Size(); i++) {
            sign.Pop();   
        }

        for (int j = 0; j < sign.Size(); j++) {
            numbers.Pop();   
        }
    }

    public int getNumero() {
        return numero;
    }
    
    /**
     * @pre Recibe un Stirng que proviene del documento de DAtos.txt
     * @post Devuelve un String que es el valor de la operacion
     * @param expresion
     * @return String
     */
    public String Calculo(String expresion){
        // Esta variable es para guardar el progreso de la operacion
        float continuacion = 0;

        // Array para guardar los valores uno por uno
        ArrayList<String> ops = new ArrayList<String>();

        

        // Se separa la expresion y se mete a la lista de ops
        String[] separado = expresion.split("");
        for (int i = 0; i < separado.length; i++) {
            // System.out.println(separado[i]);
            ops.add(separado[i]);
        }

        // Comienza el proceso de calculo
        // Este for guarda los valores
        for (int j = 0; j < ops.size(); j++) {
            try {// En caso de ser un numero lo convertiraa y lo metera a los numeros
                float number = Float.parseFloat(ops.get(j));
                numbers.Push(number);
            } catch (Exception ex) {// En caso de no ser un numero se activara la excepcion y se tomara el texto
                sign.Push(ops.get(j));
                // Primero se comprueba que los numeros no excedan la capacidad de las
                // operaciones
                int verifier = numbers.Size() - sign.Size();
                if (verifier > 2) {
                    return "No se puede operar, hay demasiados numeros";
                }
                try {
                    // Extraer los numeros
                    float num1 = numbers.Pop();
                    float num2 = numbers.Pop();

                    // Extraer el signo que se acaba de detectar
                    String operando = sign.Pop();
                    // Verificar cual es el signo
                    if (operando.equalsIgnoreCase("+")) {
                        continuacion = num2 + num1;
                    } else if (operando.equalsIgnoreCase("-")) {
                        continuacion = num2 - num1;
                    } else if (operando.equalsIgnoreCase("*")) {
                        continuacion = num2 * num1;
                    } else if (operando.equalsIgnoreCase("/")) {
                        continuacion = num2 / num1;
                    }
                    numbers.Push(continuacion);
                } catch (Exception e) {// En caso de no haber numeros suficientes se agrega otro automaticamente
                    try {
                        float number = Float.parseFloat(ops.get(j));
                        numbers.Push(number);
                    } catch (Exception r) {// Esta se activa por si ya no quedan numeros y tira el codigo de error
                        return "No se puede operar, hay un error de signos";
                    }
                }
            }
        }
        String resultado = String.valueOf(continuacion);
        return resultado;
    }

    // Codigo para convertir a Postfix
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    }

    static String infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = new String(""); 
          
        // initializing empty stack 
        Stack<Character> stack = new StackVector<Character>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
            // If the scanned character is an 
            // operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(',  
            // push it to the stack. 
            else if (c == '(') 
                stack.Push(c); 
              
            //  If the scanned character is an ')',  
            // pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.Empty() &&  
                        stack.Peek() != '(') 
                    result += stack.Pop(); 
                  
                    stack.Pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.Empty() && Prec(c)  
                         <= Prec(stack.Peek())){ 
                    
                    result += stack.Pop(); 
             } 
                stack.Push(c);
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.Empty()){ 
            if(stack.Peek() == '(') 
                return "Invalid Expression"; 
            result += stack.Pop(); 
         } 
        return result; 
    }
}