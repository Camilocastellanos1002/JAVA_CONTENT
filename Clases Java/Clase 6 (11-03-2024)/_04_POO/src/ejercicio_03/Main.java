package ejercicio_03;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);

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
