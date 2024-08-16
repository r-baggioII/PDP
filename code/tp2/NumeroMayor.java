package code.tp2;

public class NumeroMayor {

    public NumeroMayor(){
        //Constructor de la clase 
        System.out.println("Se ha creado un objeto de la clase NumeroMayor");
    }


    //método para determinar cual es el número mayor 
    public static void determinaMayor(int num1, int num2){
        if (num1 > num2){
            System.out.println("El número mayor es:" + num1); 
        } else if (num1 < num2){
            System.out.println("El número mayor es:" + num2);
        } else {
            System.out.println("Los números son iguales");
        }
    }
    public static void main(String[]args) {
        NumeroMayor.determinaMayor(10,20);
    }
}
