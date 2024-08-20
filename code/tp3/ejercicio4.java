/*
 *  Crear una clase Libro con los métodos préstamo, devolución y transformarATexto. La clase métodos de acceso a las propiedades.
 */
package code.tp3;

public class ejercicio4 {
    public static class Libro{
        private String titulo;
        private String autor; 
        boolean prestado;

        //Constructor
        public Libro(String titulo, String autor){
            this.titulo = titulo;
            this.autor = autor;
            this.prestado = false;
        }
        //Getters y Setters 
        public String verTitulo(){
            return this.titulo;
            
        }
        
        public String verAutor(){
            return this.autor; 
        }
        
        public void prestamo(){
            if(prestado){
                System.out.println("El libro ya está prestado");
            }else{
                System.err.println("El libro ahoraa está prestado");
            }
        }
    }   

    public static void main(String[] args) {
        
    }
}
