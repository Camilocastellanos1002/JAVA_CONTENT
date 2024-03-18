import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* 1. Contador simple */
        for (int i=1; i<=10; i++){
            System.out.println(i);
        }

        /* 2. Suma de numeros*/
        int contador =0;
        int sumaTotal = 0;

        while (contador<=100){
            sumaTotal+=contador;
            contador++;
        }
        /*3. Imprimir tablas de multiplicacion*/
        System.out.println(sumaTotal);
        for (int i = 0; i < 11; i++) {
            System.out.println("Tabla de "+i);
            for (int j = 0; j < 13; j++) {
                System.out.println(i+"X"+j+"="+(i*j));
            }
        }
        /*4. suma de numeros pares*/
        int sumaPares =0;
        for (int i = 1; i <=100; i++) {
            if (i % 2 == 0) {
                sumaPares += i;
            }
        }
        System.out.println("El resultado de la suma de los pares es: "+sumaPares);

        /*5. validacion de entrada de usuario*/
        Scanner datoIngresado = new Scanner(System.in);
        int edad=0;
        do{
            System.out.println("Ingrese su edad: ");
            edad = datoIngresado.nextInt();
        }while(edad<=120);


        /*Sistema de menu*/
        String option;
        double saldo = 0;
        do {
            option = JOptionPane.showInputDialog(null,"\n MENU DE OPCIONES \n"+
                    "1. Ver saldo \n"+
                    "2. Despositar dinero \n"+
                    "3. Retirar \n"+
                    "4. Salir \n"+
                    "Ingrese una opcion: ");

            switch (option){
                case "1":
                    JOptionPane.showMessageDialog(null, "Tu saldo es: "+saldo);
                break;
                case "2":
                    String precioString = JOptionPane.showInputDialog(null,"Ingrese el valor a depositar: \n"+ "$");
                    try {
                        double precio = Double.parseDouble(precioString);
                        saldo+=precio;
                        JOptionPane.showMessageDialog(null,"Dinero ingresado satisfactoriamente");
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Caracteres invalidos");
                    }
                break;
                case "3":
                    try {
                        double valorRetirar = Double.parseDouble(JOptionPane.showInputDialog(null,"Valor a retirar: "));
                        if (valorRetirar<=saldo){
                            saldo-=valorRetirar;
                            JOptionPane.showMessageDialog(null,"Retiro Satisfactorio");
                        }else {
                            JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Caracteres invalidos");
                    }
                break;



            }
        }while (!option.equals("4"));

    }
}