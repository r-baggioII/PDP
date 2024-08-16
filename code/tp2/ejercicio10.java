/*
 * . Definir una matriz de 20×20 elementos. Completar dicha matriz con los valores generados por valor = f ila ∗ 20 + columna. 
 */
package code.tp2;

public class ejercicio10 {
    public static void main(String[] args) {
        int[][] matriz = new int[20][20];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                matriz[i][j] = i*20 + j;
            }
        }
    }
    
}
