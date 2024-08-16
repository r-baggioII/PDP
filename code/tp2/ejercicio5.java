/*
 * Calcular el área de un triángulo a partir de la longitud de sus lados. 
 * El calculo de un semiperímetro es p =12∗ (a + b + c) siend a, b y c las longitudes
 */
package code.tp2;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la longitud del lado a: ");
        double a = scanner.nextDouble();
        System.out.println("Ingrese la longitud del lado b: ");
        double b = scanner.nextDouble();
        System.out.println("Ingrese la longitud del lado c: ");
        double c = scanner.nextDouble();
        scanner.close();
        double s = 0.5 * (a + b + c);
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("El área del triángulo es: " + area);
    }
    
}
