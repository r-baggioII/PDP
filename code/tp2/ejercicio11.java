package code.tp2;

public class ejercicio11 {

    public static class Arbol{
        private int altura;
        private String tipo;

        //Definimos los constructores de la clase
        //Constructor para altura y tipo
        public Arbol(int altura, String tipo){
            this.altura = altura;
            this.tipo = tipo;
            System.out.println("Se ha creado un objeto de la clase Arbol, de altura " + altura + " y del tipo " + tipo);

        } 
        //Constructor para altura
        public Arbol(int altura){
            this.altura = altura; 
            System.out.println("Se ha creado un objeto de la clase Arbol, de altura " + altura);
        }
        //Constructor para tipo
        public Arbol(String tipo){
            this.tipo = tipo; 
            System.out.println("Se ha creado un objeto de la clase Arbol, del tipo " + tipo);
        }
        //Constructor vacío
        public Arbol(){
            System.out.println("Se ha creado un objeto de la clase Arbol (genérico)");
        }

        //Definimos los métodos de la clase 
        //Método para obtener la altura del árbol
        public int getAltura(){
            return this.altura; 
        }
        //Método para obtener el tipo de árbol
        public String getTipo(){
            return this.tipo; 
        }
    }

    public static void main(String[] args) {
        Arbol arbol1 = new Arbol(10); 
        Arbol arbol2 = new Arbol("Roble");
        Arbol arbol3 = new Arbol();
        Arbol arbol4 = new Arbol(5,"Roble");
    }
    
}
