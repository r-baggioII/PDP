/*
 * Definir un vector y completar cada posición con números del 1 al 20. Una vez completado el vector sumar los valores generados. NO se debe realizar la misma operación de asignación del dato y 
 * suma en la misma estructura de repetición. NO utilizar una estructura for.
 */
package code.tp2;
import java.util.Arrays;

public class ejercicio8 {
    public static void main(String[] args) {
        int[] vector = new int[20];
        int suma = 0;
        int i = 0;
        while (i <20){
            vector[i] = i+1;
            i++;
        }
        i = 0;
        while (i<20){
            suma += vector[i];
            i++;
        }
        System.out.println("El vector es: ");
        System.out.print(Arrays.toString(vector));
        System.out.println("La suma de los elementos del vector es: " + suma);
    }
}
