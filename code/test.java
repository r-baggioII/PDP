package code;


class Alfa{
    void p(int x){
        System.out.println("Método p de Alfa");
    }  
    
    void q(int x){
        System.out.println("Método q de Alfa");
    }
    void r(int x){
        System.out.println("Método r de Alfa");
    }    
}

class Beta extends Alfa{
    void q(int x){
        System.out.println("M;etodo q en Beta");
    }

    void s(int x){
        System.out.println("Método s en Beta");
    }

}

class Delta extends Beta{

    void p(int x){
        System.out.println("Método p de Delta");
    }  
    
    void q(int x){
        System.out.println("Método q de Delta");
    }
    void s(String x){
        System.out.println("Método s en Delta");
    }

}

public class Test {
    public static void main(String[] args) {
        Alfa v1 = new Beta();
        Beta v2 = new Delta();
        Beta v3 = new Delta(); 

        v2.s(1);

    }
}
