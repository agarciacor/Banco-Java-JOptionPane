
package ejercicio1;

import java.util.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = "";
        int intento = 0;
        boolean login = false;
        
        do{
            intento++;
            System.out.println("Ingresa el PIN de acceso: ");
            pass = sc.nextLine();
            
            if(pass == "1235"){
                login = true;
            }
            
        }while(intento < 3 && !login);
        
        if(intento < 3){
            System.exit(0);
        }
        
        System.out.println("Bienvenido usuario" + pass);
        
        
    }
    
}
