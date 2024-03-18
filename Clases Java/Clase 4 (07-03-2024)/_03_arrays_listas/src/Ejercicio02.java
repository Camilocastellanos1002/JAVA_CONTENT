import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args){
        /*Sistema de reservas de un teatro donde se represente con booleanos
        * asientos ocupados o disponibles */

        boolean [][] ListaAsientos = new boolean [5][10];
        Scanner objScanner = new Scanner(System.in);
        int option =0;

        do {
            objScanner.nextLine();
            System.out.println("Enter para Continuar");
            objScanner.nextLine();
            System.out.println("\nMenu de Teatro: \n1.Reservar asiento\n2.Cancelar asiento \n3.Mostrar asientos disponibles \n4.Contabilizar el total de asientos ocupados y disponibles \n5. Salir\nIngrese una opcion: ");
            option = objScanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Ingrese la fila (1-5)");
                    int fila = objScanner.nextInt()-1;
                    System.out.println("Ingrese el asiento (1-10)");
                    int asiento = objScanner.nextInt()-1;
                    if (!ListaAsientos[fila][asiento]) {
                        ListaAsientos[fila][asiento]=true;
                        System.out.println("Asiento reservado correctamente");
                    }else {
                        System.out.println("Oops! Este asiento ya se encuentra reservado");
                    }
                break;
                case 2:
                    System.out.println("Ingrese la fila (1-5)");
                    fila = objScanner.nextInt()-1;
                    System.out.println("Ingrese el asiento (1-10)");
                    asiento = objScanner.nextInt()-1;
                    if (ListaAsientos[fila][asiento]) {
                        ListaAsientos[fila][asiento]=false;
                        System.out.println("Asiento cancelado correctamente");
                    }else {
                        System.out.println("Oops! Este asiento ya esta libre");
                    }
                break;
                case 3:
                    System.out.println("Asientos disponibles (fila-asiento)");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (!ListaAsientos[i][j]) {
                                System.out.println("("+(i+1)+"-"+(j+1)+") ");
                            }
                        }
                    }
                break;
                case 4:
                    int ocupados=0, disponibles =0;
                    System.out.println("Asientos Ocupados");
                    System.out.println("Asientos disponibles (fila-asiento)");

                break;
            }

        }while (option !=5);
    }
}
