package code.tp3;
import java.util.Scanner;

public class Ahorcado {
    public String palabraSecreta; // Palabra que el jugador debe adivinar
    public char[] palabraAdivinada; // Palabra que el jugador va adivinando
    public int cantMaxIntentos; // Cantidad máxima de intentos (depende de la palabra)
    public int cantIntentos; // Cantidad de intentos realizados por el jugador
    public boolean juegoFinalizado; // Indica si el juego finalizó
    public int letrasEncontradas; // Cantidad de letras encontradas en la palabra secreta

    // Constructor
    public Ahorcado(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.palabraAdivinada = new char[palabraSecreta.length()];
        this.cantMaxIntentos = palabraSecreta.length() + 3;
        this.cantIntentos = 0;
        this.juegoFinalizado = false;
        this.letrasEncontradas = 0;
        
        for(int i =0;i<palabraSecreta.length(); i++){
            this.palabraAdivinada[i] = '_';
        }
    }  
    //Getters y Setters
    public char[] getPalabraAdivinada(){
        return this.palabraAdivinada;
    }
    public int getCantIntentos(){
        return this.cantIntentos;
    }
    public int getCantMaxIntentos(){
        return this.cantMaxIntentos;
    }
    public boolean getJuegoFinalizado(){
        return this.juegoFinalizado;
    }
    public void setCantIntentos(int cantIntentos){
        this.cantIntentos = cantIntentos;
    }
    public void setJuegoFinalizado(boolean juegoFinalizado){
        this.juegoFinalizado = juegoFinalizado;
    }

    //Método para determinar si una letra se encuentra en la palabra secreta
    public boolean estaLetra(char letra){
        boolean letraEnPalabra = false;
        int i =0; 
        while (!letraEnPalabra && i <this.palabraSecreta.length()){
            if(this.palabraSecreta.charAt(i) == letra){
                letraEnPalabra = true;
                this.letrasEncontradas++;
            }
            i++;
        }
        return letraEnPalabra;
    }
    //Método para actualizar la palabra adivinada con la letra ingresada
    public void actualizarPalabraAdivinada(char letra){
        for(int i =0; i<this.palabraSecreta.length(); i++){
            if(this.palabraSecreta.charAt(i) == letra){
                this.palabraAdivinada[i] = letra;
            }
        }
    }
    
    //Metodo para verificar si el juego finalizó
    public boolean juegoFinalizado(){
        if(this.letrasEncontradas == this.palabraSecreta.length()){
            this.juegoFinalizado = true;
            System.out.println("¡Felicitaciones! Has adivinado la palabra secreta: " + this.palabraSecreta);
        }else if(this.cantIntentos == this.cantMaxIntentos){
            this.juegoFinalizado = true;
            System.out.println("¡Lo siento! Has superado la cantidad máxima de intentos. La palabra secreta era: " + this.palabraSecreta);
        }
        return this.juegoFinalizado;
    }

    //Metodo para informar error o acierto 
    public void informarEstado(boolean acierto, char letra){
        if(acierto){
            System.out.println("La letra " + letra + " está en la palabra");
        }else{
            System.out.println("La letra " + letra + " no está en la palabra");
        }
    }
    //Metodo para mostrar cantidad de intentos restantes 
    public void mostrarIntentosRestantes(){
        System.out.println("Tiene " + (this.cantMaxIntentos - this.cantIntentos) + " intentos restantes");
    }
    //Mostrar estado Actual del juego 
    public void mostrarEstadoActual(boolean acierto, char letra){
        informarEstado(acierto, letra);
        System.out.println("Número de letras: (encontradas,faltantes)" + this.letrasEncontradas + "," + (this.palabraSecreta.length() - this.letrasEncontradas));
        mostrarIntentosRestantes();
        System.out.println("Estado actual: ");
        
        for(int i =0; i<this.palabraAdivinada.length; i++){
            System.out.print(this.palabraAdivinada[i] + " ");
        }
    }
    //Metodo para jugar
    public void jugar(char letra){
        boolean acierto;
        acierto = estaLetra(letra);
        this.cantIntentos++;
        if(acierto){
            actualizarPalabraAdivinada(letra);
        }
        mostrarEstadoActual(acierto, letra);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letra;
        Ahorcado ahorcado = new Ahorcado("Rocio");
        
        while(!ahorcado.juegoFinalizado() && ahorcado.getCantIntentos() < ahorcado.getCantMaxIntentos()){
            System.out.println("Ingrese una letra: "); 
            letra = scanner.next().charAt(0);
            ahorcado.jugar(letra);
        }
        scanner.close();
        

    }

}
