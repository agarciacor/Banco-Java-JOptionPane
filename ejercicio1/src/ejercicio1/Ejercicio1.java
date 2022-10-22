
package ejercicio1;

import java.awt.HeadlessException;
import java.time.Instant;
import javax.swing.JOptionPane;

public class Ejercicio1 {
    public static void main(String[] args) {
        
        String separator = ("-".repeat(85)), bankName = ("BBVA" + " Banca en linea");
        String goodbye = (bankName + "  |  \"Creando oportunidades\"\n" + separator +"\nGracias por su preferencia. Vuelve pronto.\n¡Estamos para servirte!");
        int inputPassword, password = 1235, loopPassword = 3, loopHome = 1, loopHomeCase2 = 3, homeSelection, questionForQuit;
        float balance = 1000.0f, withdraw;
        String history = "FECHA Y HORA                      MONTO\n";
        Instant instant = Instant.now();

        try{
            JOptionPane.showMessageDialog(null, "Bienvenido a " + bankName + "\n"+ separator +"\nIngrese su tarjeta para continuar", "Bienvenido a " + bankName, JOptionPane.WARNING_MESSAGE);
            for(int i=1; i<=loopPassword; i++){
                inputPassword = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a " + bankName + "  |  SERVICIO DE CAJERO\n"+ separator +"\nUse el teclado numerico para digitar su NIP\ny presiona ENTER para continuar:", "Bienvenido cliente", JOptionPane.WARNING_MESSAGE));
                
                if(inputPassword == password){
                    loopPassword = 1;
                    for(int j=1; j==loopHome;){
                        homeSelection = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a " + bankName + "  |  MENU DE OPERACION\n"+ separator +"\n  [1] - Balance\n  [2] - Retiro de efectivo\n  [3] - Historico de movimientos\n  [4] - Salir\n"+ separator +"\n\n Ingresa el numero de opcion", bankName + " - Home", JOptionPane.INFORMATION_MESSAGE));
                    
                        switch(homeSelection){
                            case 1:
                                JOptionPane.showMessageDialog(null, bankName + "  |  BALANCE\n"+ separator +"\nTu balance total es de:  $" + balance + "0 MXN", "BALANCE", JOptionPane.INFORMATION_MESSAGE); 
                                break;

                            case 2:
                                for(int k=1; k<=loopHomeCase2; k++){
                                    withdraw = Float.parseFloat(JOptionPane.showInputDialog(null, "Tu balance es de: $" + balance + "0 MXN\n"+ separator +"\nPuedes hacer un retiro de\n$20.00 MXN hasta $50,000.00 MXN\n\nCuanto desea retirar?", "RETIROS", JOptionPane.INFORMATION_MESSAGE));

                                    if(withdraw>=20.0f && withdraw<=50000.0f && withdraw<=balance){
                                        balance -= withdraw;
                                        loopHomeCase2 = 1;
                                        String fecha= ""+instant;
                                        history += fecha.substring(0, 19) + "         - $" + withdraw + "0 MXN\n";
                                        JOptionPane.showMessageDialog(null, "Operacion exitosa...\nEl retiro es de: $" + withdraw + "0 MXN\n"+ separator +"\nPor favor toma tu dinero de la bandeja", "RETIROS", JOptionPane.INFORMATION_MESSAGE); 
                                    } else{
                                        JOptionPane.showMessageDialog(null, "Lo sentimos el monto de retiro es invalido!\n"+ separator +"\nSolo puedes retirar desde\n$20.00 MXN a $50,000.00 MXN\n" + separator +"\nTu balance total es de:  $" + balance + "0 MXN" + "\n Tu tienes: " + (3 - k) + "/3 intentos restantes", "DATA ERROR", JOptionPane.ERROR_MESSAGE);
                                        if (k == loopHomeCase2) {
                                            JOptionPane.showMessageDialog(null, "Lo sentimos, ya no tienes mas intentos disponibles", "CASH OUT - ERROR", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                                loopHomeCase2 = 3;
                                break;
                                
                            case 3:
                                JOptionPane.showMessageDialog(null, bankName + "  |  HISTORICO\n"+ separator +"\nTus ultimos movimientos son:\n" + history, "BALANCE", JOptionPane.INFORMATION_MESSAGE); 
                                break;
                                
                            case 4:
                                JOptionPane.showMessageDialog(null, goodbye, "Hasta luego", JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "E R R O R:\n" + "Esta opcion es invalida o no existe", "KEY ERROR", JOptionPane.ERROR_MESSAGE); 
                            }
                        
                        questionForQuit = Integer.parseInt(JOptionPane.showInputDialog(null, "Te podemos ayudar con algo más?\n"+ separator +"\n  [0] - Salir\n  [1] - Regresar al menu\n" + separator, "Es todo por el momento?", JOptionPane.QUESTION_MESSAGE));
                        if(questionForQuit == 0){ loopHome = 0; } else{ loopHome = 1; }
                    }
                } else{
                    if(i==loopPassword){
                        JOptionPane.showMessageDialog(null, "Su codigo NIP es incorrecto!\n"+ separator +"\nLo sentimos, ya no tienes mas intentos disponibles", "PIN IS WRONG", JOptionPane.ERROR_MESSAGE);
                    } else{
                    JOptionPane.showMessageDialog(null, "Su codigo NIP es incorrecto!!\n"+ separator +"\nTienes: " + (3 - i) + "/3 intentos restantes\nIntentalo nuevamente", "PIN IS WRONG", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, goodbye, "Hasta luego", JOptionPane.INFORMATION_MESSAGE);
            
        } catch(HeadlessException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "E R R O R:\n" + "Este valor no es numerico", "DATA ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
