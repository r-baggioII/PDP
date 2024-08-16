/*
 * Diseñar una clase Sumatoria que tenga: una variable vector de tipo entero y dos métodos,
uno que permita mostrar la tabla de multiplicar para cada variable y otro que permita
devolver la suma. Debe tener un constructor por defecto que les asigne valores entre 1 y 10
o bien un constructor para ingresar los dos valores. En el main de prueba deberá generar
dos instancias de la clase Sumatoria, mostrar las tablas de multiplicar y finalmente mostrar
la suma de ambas variables por pantalla.
 */
package code.tp2;
import java.util.Random;

public class ejercicio14 {
    public static class Sumatoria{
        private int[] vector;
        
        //Constructor de la clase por defecto 
        public Sumatoria(){
            this.vector = new int[10]; 
            
            Random random = new Random();
            for(int i =0;i<10;i++){
                this.vector[i] = 1 + random.nextInt(1,10);	
            }

        }
        //Constructor de la clase con parámetros
        public Sumatoria(int[] vector){
            this.vector = vector;
        }
        //Metodos de la clase
        //Método para mostrar la tabla de multiplicar
        public void mostrarTabla(){
            for(int i = 0; i<10;i++){
                System.out.println("Tabla de multiplicar del elemento " + i + "(" + vector[i] + ")" + ": ");
                for(int j= 0; j <10;j++){
                    System.out.println(vector[i] + " x " + (j+1) + " = " + vector[i]*(j+1));
                }
            }
        }
        //Método para devolver la suma
        public int suma(){
            int sum =0; 
            for(int i =0; i<10;i++){
                sum += vector[i];
            }
            return sum;
        }
    }
    
    public static void main(String[] args) {
        Sumatoria sum1 = new Sumatoria();
        Sumatoria sum2 = new Sumatoria(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println("Tabla de multiplicar del primer vector: ");
        sum1.mostrarTabla();
        System.out.println("Tabla de multiplicar del segundo vector: ");
        sum2.mostrarTabla();
        System.out.println("La suma de los elementos del primer vector es: " + sum1.suma());
        System.out.println("La suma de los elementos del segundo vector es: " + sum2.suma());
    }
}
