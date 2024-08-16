/*
 *  Calcular el volumen de una esfera. Recordar que para calcular el volumen 
 * se debe utilizar la siguiente formula V =43∗ π ∗ r siendo r3el radio de la esfera. 
 */
package code.tp2;
import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el radio de la esfera: ");
        double r = scanner.nextDouble();
        scanner.close();
        double V = (4.0/3.0) * Math.PI * Math.pow(r, 3);     
        System.out.println("El volumen de la esfera es: " + V);   
    }
}
