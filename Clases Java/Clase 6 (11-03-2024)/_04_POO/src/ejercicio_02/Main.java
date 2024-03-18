package ejercicio_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empleado objEmpleado = new Empleado();
        Scanner objScanner = new Scanner(System.in);
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

    }
}
