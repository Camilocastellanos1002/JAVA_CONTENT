import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*1. calculadora de promedios */
        double[] notas = new double[10];
        double sumaTotal = 0;
        Scanner objScanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese la nota del estudiante #"+(i+1));
           try {
               notas[i] = objScanner.nextDouble();
               sumaTotal+=notas[i];
           }catch (Exception e) {
               System.out.println("Nota no valida");
               break;
           }
        }
        double promedio = sumaTotal/notas.length;
        System.out.println("El promedio de todas las notas es: "+promedio);

    }
}