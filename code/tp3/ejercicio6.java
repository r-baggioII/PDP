/*
 * Definir la clase NumeroComplejo. Definir sus atributos y métodos
 */
package code.tp3;

public class ejercicio6 {
    public static class NumeroComplejo{
        private float parteReal; 
        private float parteImaginaria;
        
        //Constructor 
        public NumeroComplejo(float parteReal, float parteImaginaria){
            this.parteReal = parteReal;
            this.parteImaginaria = parteImaginaria;
        }
        
        //Getters y Setters 
        public float getParteReal(){
            return this.parteReal;
        }
        public float getParteImaginaria(){
            return this.parteImaginaria;
        }
        public void setParteReal(float parteReal){
            this.parteReal = parteReal;
        }
        public void setParteImaginaria(float parteImaginaria){
            this.parteImaginaria = parteImaginaria;
        }

        //Sumar dos números complejos
        public NumeroComplejo sumarComplejos(NumeroComplejo c1, NumeroComplejo c2){
           NumeroComplejo resultado = new NumeroComplejo(0, 0);
           resultado.setParteReal(c1.getParteReal() + c2.getParteReal());
           resultado.setParteImaginaria(c1.getParteImaginaria() + c2.getParteImaginaria());
           return resultado;
        }
        //Multiplicar dos números complejos
        public NumeroComplejo multiplicarComplejos(NumeroComplejo c1,NumeroComplejo c2){
            NumeroComplejo resultado = new NumeroComplejo(0, 0);
            resultado.setParteReal(c1.getParteReal() * c2.getParteReal() - c1.getParteImaginaria() * c2.getParteImaginaria());
            resultado.setParteImaginaria(c1.getParteReal() * c2.getParteImaginaria() + c1.getParteImaginaria() * c2.getParteReal());
            return resultado;
        }
    }
    
    public static void main(String[] args) {
        NumeroComplejo c1 = new NumeroComplejo(2, 3);
        NumeroComplejo c2 = new NumeroComplejo(4, 5);
        NumeroComplejo resultado = new NumeroComplejo(0, 0);
        resultado = resultado.sumarComplejos(c1, c2);
        System.out.println("La suma de los números complejos es: " + resultado.getParteReal() + " + " + resultado.getParteImaginaria() + "i");
        resultado = resultado.multiplicarComplejos(c1, c2);
        System.out.println("La multiplicación de los números complejos es: " + resultado.getParteReal() + " + " + resultado.getParteImaginaria() + "i");
    }
}
