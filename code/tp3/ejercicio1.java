package code.tp3;

public class ejercicio1 {
    public static class Auto{
        private String marca; 
        private String modelo; 
        private int anioFabricacion; 
        private boolean estaEncendido;
        private String color;
        private String paisOrigen; 
        //Constructor 
        public Auto(String marca, String modelo, int anioFabricacion, boolean estaEncendido, String color, String paisOrigen){
            this.marca = marca;
            this.modelo = modelo;
            this.anioFabricacion = anioFabricacion;
            this.estaEncendido = estaEncendido;
            this.color = color;
            this.paisOrigen = paisOrigen;
        }
        //Getters y setters 
        public String getMarca(){
            return marca;
        }
        public void setMarca(String marca){
            this.marca = marca;
        }
        public String getModelo(){
            return modelo;
        }
        public void setModelo(String modelo){
            this.modelo = modelo;
        }
        public int getAnioFabricacion(){
            return anioFabricacion;
        }
        public void setAnioFabricacion(int anioFabricacion){
            this.anioFabricacion = anioFabricacion;
        }
        public boolean getEstaEncendido(){
            return estaEncendido;
        }
        public void setEstaEncendido(boolean estaEncendido){
            this.estaEncendido = estaEncendido;
        }
        public String getColor(){
            return color;
        }
        public void setColor(String color){
            this.color = color;
        }
        public String getPaisOrigen(){
            return paisOrigen;
        }
        public void setPaisOrigen(String paisOrigen){
            this.paisOrigen = paisOrigen;
        }
        //Metodos 
        public void encdender(){
            if(!estaEncendido){
                estaEncendido = true;
                System.out.println("El auto esta encendido");
            }else{
                System.out.println("El auto ya esta encendido");
            }
        }
        public void apagar(){
            if (estaEncendido){
                estaEncendido = false;
                System.out.println("El auto esta apagado");
            }else{
                System.out.println("El auto ya esta apagado");
            }
        }
        //Otros metodos
        //...
    }
    public static void main(String[] args) {
        
    }
}
