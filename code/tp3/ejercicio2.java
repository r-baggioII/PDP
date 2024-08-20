package code.tp3;

public class ejercicio2 {
    public static class Circunferencia{
        float radio; 
        
        //Constructor 
        public Circunferencia(int radio){
            this.radio = radio;
        }
        //Getters y setters 
        public void setRadio(float radio){ //modificar radio 
            this.radio = radio;
        }   
        public float getRadio(){ //consultar radio
            return radio;
        }
        //Calcular perimetro 
        public double calcularPerimetro(){
            double perimetro; 
            perimetro = 2 * Math.PI * radio; 
            return perimetro; 
        }
        //Calcular area 
        public double calcularArea(){
            double area; 
            area = Math.PI * Math.sqrt(radio); 
            return area; 
        }
    }
    public static void main(String[] args) {
        
    }
}
