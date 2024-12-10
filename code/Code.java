package code;

// Clase 1: Superclass (package-private, no es pública)
class superclass {
    static void print() {
        System.out.println("print() in superclass is called");
    }
}

// Clase 2: Subclass que extiende de superclass
class subclass extends superclass {
    static void print() {
        System.out.println("print() in subclass is called");
    }
}

// Clase principal con main()
public class Code {
    public static void main(String[] args) {
        // Uso de referencias y objetos
        superclass A = new superclass();
        superclass B = new subclass();

        A.print(); // Llama a print() de superclass (ocultamiento, no override)
        B.print(); // Llama a print() de superclass (por el tipo de la referencia)
        
        // Llamada explícita a los métodos estáticos de cada clase
        superclass.print(); // Llama a print() de superclass
        subclass.print(); // Llama a print() de subclass
    }
}
