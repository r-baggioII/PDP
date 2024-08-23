/*
 * Crear una clase Fecha. La clase debe contener los métodos de acceso a los atributos.
También deberá comprobar una fecha dada es correcta y modificar la fecha actual que
tiene la clase definida
 */
package code.tp3;

import java.util.ArrayList;

public class ejercicio5 {
    public static class Fecha{
        private int dia; 
        private int mes; 
        private int anio; 
        
        //Constructor 
        public Fecha(int dia, int mes, int anio){
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        }
        
        public int getDia(){
            return this.dia;
        }
        public int getMes(){
            return this.mes;
        }
        public int getAnio(){
            return this.anio;
        }

        public void setDia(int dia){
            this.dia = dia;
        }
        public void setMes(int mes){
            this.mes = mes;
        }
        public void setAnio(int anio){
            this.anio = anio;
        }

        //Comprobar que la fecha sea correcta 
        public boolean esFechaCorrecta(){
            if (mes < 1 || mes > 12){
                return false; 
            }
            if (dia < 1 || dia > 31){
                return false; 
            }
            if (anio < 0){
                return false;
            }
            if ((anio % 4 == 0 && anio % 100 == 0 && anio % 400 == 0)|| (anio % 4 == 0 && anio % 100 != 0)){ //es bisiesto 
                if (mes == 2 && dia > 29){
                    return false; 
                }
            }else{
                if(mes == 2 && dia > 28){
                    return false; 
                }
            }
            
            if(mes == 4 || mes == 6 || mes == 9 || mes == 11){ //meses con solo treinta dias
                if(dia > 30){
                    return false; 
                }
            }else{ //meses con 31 días
                if(dia > 31){
                    return false; 
                }
            }
            return true; 
        }
        
    }
    public static void main(String[] args) {
        Fecha fecha = new Fecha(31, 4, 2023);
        System.out.println(fecha.esFechaCorrecta()); //true 
    }
}
