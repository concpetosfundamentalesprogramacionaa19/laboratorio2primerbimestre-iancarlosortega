/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetePrincipal;
import java.util.Scanner;
/**
 *
 * @author Ian Carlos Ortega
 */
public class ClasePrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        // Inicializacion y declaracion de variables
        
        String mensajeFinal;// Variable que acumulara todos los datos del reporte
        int i = 1;
        int j = 1;
        boolean bandera = true;
        boolean bandera2 = true;
        double total_pasajes = 0;
        double aux_pas = 0;
        double total_bares = 0;
        double aux_bar = 0;
        double total_salidas = 0;
        double aux_salidas = 0;
        
        // Uso de String.format para ir acumulando los mensajes
        mensajeFinal = String.format("Gastos semanales de padres de familia "
                + "en sus hijos");
        System.out.print("Gastos semanales de padres de familia en sus "
                + "hijos: ");
        
        /*
        Uso de la bandera y ciclo while para que el usuario determine hasta 
        cuando necesita el ingreso de datos
        */
        while(bandera==true){
            
            //Se le piden los datos al usuario
            System.out.println("Ingrese sus nombres y apellidos:\n ");
            String nombre = scan.nextLine();
            
            System.out.println("Ingrese su sueldo semanal:\n ");
            double sueldo = scan.nextDouble();
            
            System.out.println("Ingrese cuantos hijos tiene:\n ");
            int hijos = scan.nextInt();
            scan.nextLine();//Limpieza de buffer
            
            mensajeFinal = String.format("%s\n\nReporte N%d\n\nNombre: "
                    + "%s\nSueldo:%.2f\nHijos: %d\n\nPersonas   Pasajes\t"
                    + "Bares\tSalidas\n", mensajeFinal, i, nombre, 
                    sueldo, hijos);
            
            // Uso de ciclo while para los gastos de los hijos
            
            while(bandera2==true){
                
                System.out.printf("Gasto en pasajes del hijo %d: ",
                        j);
                double pasaje = scan.nextInt();
                
                // Se calcula el costo total de pasajes de los hijos
                total_pasajes = aux_pas + pasaje;
                aux_pas = pasaje;
                
                System.out.printf("Gasto en bares del hijo %d: ", 
                        j);
                double bar = scan.nextInt();
                
                // Se calcula el costo total de bares de los hijos
                total_bares = aux_bar + bar;
                aux_bar = bar;
                
                System.out.printf("Gasto en salidas del hijo %d: ", 
                        j);
                double salida = scan.nextInt();
                scan.nextLine();
                
                // Se calcula el costo total de salidas de los hijos
                total_salidas = aux_salidas + salida;
                aux_salidas = salida;
                
                mensajeFinal = String.format("%sHijo %d\t    %.2f\t%.2f\t%.2f"
                        + "\n", mensajeFinal, j, pasaje, bar, salida);
                
                // Operacion para controlar las repeticiones del ciclo
                bandera2 = j < hijos;
                j= j + 1;
            }
            
            // Se acumulan los totales en los costos
            mensajeFinal = String.format("%sTotal\t    %.2f\t%.2f\t%.2f\n",
                    mensajeFinal, 
                    total_pasajes, total_bares, total_salidas);
            
            // Se le pregunta al usuario si desea seguir ingresando datos
            System.out.print("En caso de querer ingresar los datos de "
                    + "otro padre de familia presione la tecla 's':\n");
            String opcion = scan.nextLine();
            
            if(opcion.equals("s")){
                i = i + 1;
                j = 1;
                bandera = true;
                bandera2 = true;
                total_pasajes = 0;
                total_bares = 0;
                total_salidas = 0;
                aux_pas = 0;
                aux_bar = 0;
                aux_salidas = 0;
                
            }else{
                bandera = false;
            }
            
        }
        
        // Mostrar en pantalla el reporte demo
        System.out.printf("%s", mensajeFinal);
    }
    
    
}
