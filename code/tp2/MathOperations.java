/*Declarar dos variables X e Y de tipo int, dos variables N y M de tipo double y asignar a cada una un valor. 
A continuación mostrar por pantalla el 
resultado de una serie de operaciones matematicas basicas entre ellas( las operaciones son a elección del alumno). */

package code.tp2;

public class MathOperations {
    int y = 10; 
    int x = 300;
    double n = 5.5;
    double m = 2.5;
    
    public static void main(String[] args) {
        // Create an instance of MathOperations to access non-static fields
        MathOperations ops = new MathOperations();

        // Correctly concatenate and print results
        System.out.println("Suma de x + y: " + (ops.x + ops.y));
        System.out.println("Resta de x - y: " + (ops.x - ops.y));
    }
}
