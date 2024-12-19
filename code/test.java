package code;
/*
 *    void p(Double x){
        System.out.println("Método p  sobreescrito de Alfa");
    }

    public static void metodoEstatico(){
        System.out.println("Método ESTÁTICO EN ALFA");

    }

    void q(int x){
        System.out.println("Método q de Alfa");
    }
    void r(int x){
        System.out.println("Método r de Alfa");
    } 
 */

class Alfa{

    void p(int x){
        System.out.println("Método p de Alfa");
    }  
    
}

class Beta extends Alfa{
    @Override
    void p(int x){
        System.out.println("Método p de Beta");
    }  
    
    void p(double x){
        System.out.println("Método p de Alfa");
    }  
    
    void q(int x){
        System.out.println("M;etodo q en Beta");
    }

    void s(int x){
        System.out.println("Método s en Beta");
    }

}

public class Test {
    public static void main(String[] args) {
        Alfa v1 = new Beta();
        v1.p(7); 

    }
}
