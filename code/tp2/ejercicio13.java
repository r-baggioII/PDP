package code.tp2;
public class ejercicio13{
    
    public static class Punto{
        private double x;
        private double y; 

        //Constructor de la clase 
        public Punto(double x, double y){
            this.x = x; 
            this.y = y;
        }
        //Getters y setters 
        public double getX(){
            return this.x; 
        }
        public void setX(double x){
            this.x = x;
        }
        public double getY(){
            return this.y; 
        }
        public void setY(double y){
            this.y = y;
        }
        
        //Método para calcular la distancia entre dos puntos
        public double calculateDistance(Punto puntoA,Punto puntoB){
            double distance = Math.sqrt(Math.pow(puntoB.getX() - puntoA.getX(), 2) + Math.pow(puntoB.getY() - puntoA.getY(), 2));
            return distance;
        }
    }
    
    public static void main(String[] args) {
        Punto puntoA = new Punto(2,3);
        Punto puntoB = new Punto(5,7);
        System.out.println("La distancia entre los puntos es: " + puntoA.calculateDistance(puntoA, puntoB));
    }
}