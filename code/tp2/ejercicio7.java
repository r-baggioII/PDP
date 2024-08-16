/*
 * Reutilizando el código anterior, definir un programa que muestre la tabla del 3, luego la del 4 y finalmente la del 8. 
 */
package code.tp2;

import java.util.Arrays;
public class ejercicio7 {
    public static void main(String[] args) {
        int[] tabla3 = tablaMultiplicar(10,3);
        int[] tabla4 = tablaMultiplicar(10,4);
        int[] tabla8 = tablaMultiplicar(10,8);
        System.out.println("Tabla del 3: ");
        System.out.println(Arrays.toString(tabla3));        
        System.out.println("Tabla del 4: ");
        System.out.println(Arrays.toString(tabla4));
        System.out.println("Tabla del 8: ");
        System.out.println(Arrays.toString(tabla8));
    }
    public static int[] tablaMultiplicar(int size,int n){
        int[] vector = new int[10];
        for(int i = 0;i <10;i++){
            vector[i] = n*(i+1);
        }
        return vector;
    }   
}
