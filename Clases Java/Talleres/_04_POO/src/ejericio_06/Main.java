package ejericio_06;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner objScanner = new Scanner(System.in);
        int opcion =0;
        int nota =0;
        int contador=0;
        Estudiante objEstudiante = new Estudiante();
        ArrayList <Double> notas = new ArrayList<>();

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Menu: \n"+
            "1.Ingresar el nombre del estudiante \n"
            +"2.Añadir notas del Estudiante \n"+
            "3.Calcular promedio del Estudiante \n"
            +"4.Salir \n"
            +"Selecione una opcion: "));
            switch (opcion){
                case 1:
                    System.out.println("Ingrese nombre del estudiante");
                    objEstudiante.setNombre(objScanner.next());
                    System.out.println("El nombre de "+objEstudiante.getNombre()+" ha sido ingresado satisfacotriamente");
                break;
                case 2:
                    do {
                        objEstudiante.calificaciones.add(Double.parseDouble(JOptionPane.showInputDialog(null,"Ingres nota #"+contador+1+"del estudiante: "+
                        "Ingresa * para salir \n")));
                    }while (nota!='*');
                    JOptionPane.showMessageDialog(null,"Notas ingresadas correctamente");
                break;
                case 3:
                    objEstudiante.setPromedio();
                    System.out.println("El promedio del estudiante "+objEstudiante.getNombre()+ " es de: "+objEstudiante.getPromedio());
                break;
            }
        }while (opcion!=4);
    }
}
