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
    AbstractSack<String> sign;
    AbstractSack<Float> numbers;

    // Instancia de factory que creara las listas
    StackFactory creadorStacks = new StackFactory();

    // Constructor privado para Singleton
    Calculadora(){
        numero++;
    }

    
    /** 
     * @return Calculadora
     */
    // Metodo para devolver la unica instancia de calculadora
    static public Calculadora getInstance(){
        if(calculator == null){
            calculator = new Calculadora();
        }
        return calculator;
    }

    
    /** 
     * @param opcion
     */
    // Metodo para generar las listas
    public void generarStacks(int opcion){
        sign = creadorStacks.generateStackString(opcion);
        numbers = creadorStacks.generateStackFloat(opcion);
    }

    // Metodo para vaciar las listas y reutilizarlas para la siguiente operacion
    public void vaciarListas(){
        for (int i = 0; i < sign.size(); i++) {
            sign.pop();   
        }

        for (int j = 0; j < sign.size(); j++) {
            numbers.pop();   
        }
    }

    
    /** 
     * @return int
     */
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
                numbers.push(number);
            } catch (Exception ex) {// En caso de no ser un numero se activara la excepcion y se tomara el texto
                sign.push(ops.get(j));
                // Primero se comprueba que los numeros no excedan la capacidad de las
                // operaciones
                int verifier = numbers.size() - sign.size();
                if (verifier > 2) {
                    return "No se puede operar, hay demasiados numeros";
                }
                try {
                    // Extraer los numeros
                    float num1 = numbers.pop();
                    float num2 = numbers.pop();

                    // Extraer el signo que se acaba de detectar
                    String operando = sign.pop();
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
                    numbers.push(continuacion);
                } catch (Exception e) {// En caso de no haber numeros suficientes se agrega otro automaticamente
                    try {
                        float number = Float.parseFloat(ops.get(j));
                        numbers.push(number);
                    } catch (Exception r) {// Esta se activa por si ya no quedan numeros y tira el codigo de error
                        return "No se puede operar, hay un error de signos";
                    }
                }
            }
        }
        String resultado = String.valueOf(continuacion);
        return resultado;
    }

    
    /** 
     * @param ch
     * @return int
     */
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

    
    /** 
     * @param exp
     * @return String
     */
    static String infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = new String(""); 
          
        // initializing empty stack 
        AbstractSack<Character> stack = new StackArrayList<Character>(); 
          
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
                stack.push(c); 
              
            //  If the scanned character is an ')',  
            // pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.empty() &&  
                        stack.peek() != '(') 
                    result += stack.pop(); 
                  
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.empty() && Prec(c)  
                         <= Prec(stack.peek())){ 
                    
                    result += stack.pop(); 
             } 
                stack.push(c);
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.empty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
        return result; 
    }
}