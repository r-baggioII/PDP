/*
 *  Definir una matriz de 2×2. Para cada posición (i,j), asignar el valor resultante de la ope ración valor = (2 ∗ i) + (j + 3).
 */
package code.tp2;

public class ejercicio9 {
    public static void main(String[] args) {
        int [][] matriz = new int[2][2];
        for (int i =0; i<2;i++){
            for(int j= 0; j <2; j++){
                matriz[i][j] = (2*i) + (j+3);
            }
        }
    }
    
}
