import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);
        /*
        //Ejericio #1

        //crear una instancia o objeto de una clase
        Libro objLibro = new Libro("100 años de soledad","Gabriel Garcia Marquez","01-05-1967",false);

       //forma de ingresar a un atributo de una clase desde otra
        System.out.println(objLibro.getTitulo());
        objLibro.setTitulo("El rastro de tu sangre en la nieve");
        System.out.println(objLibro.toString());

        //Ejercicio #2
        Empleado objEmpleado = new Empleado();
        int id=0;
        System.out.println("Ingrese el nombre del empleado: ");
        objEmpleado.setNombre(objScanner.nextLine());
        System.out.println("Ingrese el salario base del empleado: ");
        objEmpleado.setSalario(objScanner.nextDouble());
        System.out.println("Ingrese el cargo del empleado: ");
        objEmpleado.setCargo(objScanner.next());
        System.out.println("Ingrese el porcentaje de aumento (0-100):");
        objEmpleado.setAumento(objScanner.nextInt());
        objEmpleado.setId(id);
        id++;
        System.out.println("El nuevo salario de "+objEmpleado.getNombre()+" es de: "+objEmpleado.getSalario());

        */
        //Ejercicio #3
        CuentaBancaria objCuentaBancaria = new CuentaBancaria();
        String nombre = JOptionPane.showInputDialog(null,"Ingrese nombre del titular: ");
        objCuentaBancaria.setTitular(nombre);
        double montoInicial = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese monto inicial de la cuenta: "));
        objCuentaBancaria.setBalance(montoInicial);

        int option =0;
        do {
            option= Integer.parseInt(JOptionPane.showInputDialog(null,"Menu: \n"+
                    "1.Realizar Deposito \n"+
                    "2.Retirar dinero \n"+
                    "3.Mostrar balance actual \n"+
                    "4.Salir\n"+
                    "Ingrese una opcion: "));
            switch (option){
                case 1:
                    double deposito = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la cantidad a depositar: "));
                    objCuentaBancaria.setBalance(objCuentaBancaria.getBalance()+deposito);
                    JOptionPane.showMessageDialog(null,"Deposito realizado exitosamente");
                break;
                case 2:
                    double retiro = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la cantidad que desea retirar: "));
                    if (retiro< objCuentaBancaria.getBalance()) {
                        objCuentaBancaria.setBalance(objCuentaBancaria.getBalance() - retiro);
                        JOptionPane.showMessageDialog(null,"retiro realizado exitosamente");

                    }else {
                        JOptionPane.showMessageDialog(null,"Cantidad no permitida");

                    }
                break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Cantidad actual: $"+objCuentaBancaria.getBalance()+" COP");
                break;
            }
        }while (option!=4);
    }
}