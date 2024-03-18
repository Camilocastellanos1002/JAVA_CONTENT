import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario objInventario = new Inventario();
        int option =0;
        int id=0;
        Scanner objScanner = new Scanner(System.in);
        do {
            System.out.println("Menu de opciones \n"+
                    "1.Agregar un nuevo producto \n"+
                    "2.Buscar un producto \n"+
                    "3.Eliminar un producto \n"+
                    "4.Listar el inventario \n"+
                    "5.Salir \n"+
                    "Seleccione una opcion:");
            option = objScanner.nextInt();
            switch (option){
                case 1:
                    id++;
                    System.out.println("Ingrese el producto");
                    String producto = objScanner.nextLine();
                    System.out.println("Ingrese el precio del producto: ");
                    double precio = objScanner.nextDouble();
                    objInventario.agregarProducto(id,producto,precio);
                break;
                case 2:

                break;
                case 3:

                break;
                case 4:

                break;

            }
        }while (option!=5);

    }
}