/*
 * Declarar cuatro variables enteras A, B, C y D y asignarle un valor diferente a cada una. A continuación, 
 * realizar las instrucciones necesarias para que: B tome el valor de C, C tome el valor de A, A tome el valor de D, 
 * D tome el valor de B. Mostrar los valores iniciales y los valores finales de cada variable. 
 */
package code.tp2;
public class ejercicio3{
    public static void main(String[]args) {
        int A = 1; 
        int B = 2; 
        int C = 3; 
        int D = 4; 
        System.out.println("Valores iniciales: " + A + " " + B + " " + C + " " + D);
        B = C;
        C = A;
        A = D;
        D = B;
        System.out.println("Valores Finales: " + A + " " + B + " " + C + " " + D);
    }
}
