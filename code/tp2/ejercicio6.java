package code.tp2;

import java.util.Arrays;

/*
 * Implementar un programa que defina un vector de tamaño 10 y completar con números del 1 al 10
 */
public class ejercicio6 {
    public static void main(String[] args) {
        int[] vector = new int[10];
        for(int i = 0;i <10;i++){
            vector[i] = i + 1;
        }
        System.out.println("El vector es: ");
        System.out.println(Arrays.toString(vector));
    }
    
}

