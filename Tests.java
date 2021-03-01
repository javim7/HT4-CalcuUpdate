/**
 * @author Marco Orozco 
 * @author Javier Mombiela
 * clase Tests.java clase que hace los tests unitarios
 */
//importando clases
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
 
    
public class Tests {

    //instanciando clases
    Calculadora calculo = new Calculadora();
    StackVector<Integer> pila = new StackVector<Integer>();
    LinkedList<Integer> lista = new LinkedList<Integer>();

    //tests de la calculadora
    
    //test de calculo
    @Test
    public void testCalculo() {
        String expresion = "1+2*3";
        assertEquals("7", calculo.Calculo(expresion));
        
    }

    //test de infix a postfix
    @Test
    public void testInfixToPostfix() {
        String expresion = "1+2*3";
        assertEquals("12+3*", Calculadora.infixToPostfix(expresion));

    }



    //tests de stack


     // Test de  push y size
     @Test
     public void testPila1() {
         pila.push(7);
         assertEquals(pila.size(), 1);
     }
 
     // Test push y pop
     @Test
     public void testPila2() {
         pila.push(8);
         assertEquals(pila.pop(), "8");
     }
 
     // Test de push y peek
     @Test
     public void testPila3() {
         pila.push(5);
         assertEquals(pila.peek(), "5");
     }

     
     //tests de la lista
     // Test de  add y size
     @Test
     public void testLista1() {
         pila.push(7);
         assertEquals(lista.size(), 1);
     }
 
     // Test add y removeLast
     @Test
     public void testLista2() {
         pila.push(8);
         assertEquals(lista.remove(), "8");
     }
 
     // Test de add y getLast
     @Test
     public void testLista3() {
         pila.push(5);
         assertEquals(lista.getLast(), "5");
     }
   
}
    