/*
 * Definir la clase Persona, reutilizando lo definido hasta el momento. Implementar al menos
4 métodos propios del comportamiento de la clase Persona y además los métodos getters
y setters. Finalmente, generar una instancia en el método main.
 */

package code.tp2;

public class ejercicio13 {
    
    public static class Persona{
        private String nombre;
        private int edad;
        
        //Constructor de la clase 
        private Persona(String nombre,int edad){
            this.nombre = nombre; 
            this.edad = edad;
        }
        
        //Getters y setters
        public String getNombre(){
            return this.nombre; 
        }
        
        public void setNombre(String nombre){
            this.nombre = nombre; 
        }
        
        public int getEdad(){
            return this.edad; 
        }
        
        public void setEdad(int edad){
            this.edad = edad; 
        }
        //Comportamientos propios de la clase persona 
        
        //Caminar 
        public void caminar(){
            System.out.println("La persona " + nombre + " está caminando");
        }
        //Hablar
        public void hablar(){
            System.out.println("La persona " + nombre + " está hablando");
        }
        //Comer 
        public void comer(){
            System.out.println("La persona " + nombre + " está comiendo");
        }
        //Dormir
        public void dormir(){
            System.out.println("La persona " + nombre + " está durmiendo");
        }

    }
    public static void main(String[] args) {
        Persona persona1 = new Persona("Rocio", 20);
        persona1.caminar();
        persona1.hablar();
        persona1.comer();
        persona1.dormir();
        persona1.setNombre("Taylor");
        System.out.println(persona1.getEdad()); 
        System.out.println(persona1.getNombre()); 
    }
}
