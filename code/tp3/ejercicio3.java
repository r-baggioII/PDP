/*
 * Crear una clase Contador con los métodos para incrementar y decrementar el contador. La clase debe tener un método que permita mostrar el valor actual del contador, 
 * volver a 0 el contador, definir el incremento del contador e incrementar el contado
 */
package code.tp3;

public class ejercicio3 {
    public static class Contador{
        private int contador;
        
        //Constructor 
        public Contador(int contador){
            this.contador = contador;
        }
        //Mostrar valor actual del contador
        public void mostrarValor(){
            System.err.println("El valor actual del contador es: " + contador);
        }
        //Volver a 0 el contador
        public void volverACero(){
            contador = 0; 
            System.err.println("El contador ha vuelto a 0");
        }
        //Definir incremento del contador
        public void definirIncremento(int incremento){
            System.err.println("El incremento del contador ha sido definido en: " + incremento);
        }
        //Incrementar contador
        public void incrementarContador(int incremento){
            contador += incremento;
            System.err.println("El contador ha sido incrementado en: " + incremento);
        }

    }
    public static void main(String[] args) {
        Contador contador1= new Contador(0);
        contador1.mostrarValor();
        contador1.definirIncremento(3);
        contador1.incrementarContador(3);
        contador1.mostrarValor();
        contador1.volverACero();
    }
}
