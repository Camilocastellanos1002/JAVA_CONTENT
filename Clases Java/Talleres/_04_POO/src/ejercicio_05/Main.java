package ejercicio_05;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion =0;
        Producto objProducto = new Producto();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Control de Stock\n"+
                    "1.Añadir Producto\n"+
                    "2.Eliminar Producto"+
                    "3.Añadir stock de un producto \n"+
                    "4.Eliminar stock de un producto \n"+
                    "5.Ver cantidad de un producto \n"+
                    "6.Salir \n"+
                    "Ingresa una opcion: "));
            switch (opcion){
                case 1:
                    String nombre = JOptionPane.showInputDialog(null,"Ingrese nombre del producto: ");
                    objProducto.agregarProducto(nombre);
                    double stock = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese stock del producto: "));
                    objProducto.setCantidad(objProducto.getCantidad()+stock);
                    objProducto.setId(objProducto.getId()+1);
                    JOptionPane.showMessageDialog(null,nombre+" añadido satisfactoriamente");
                    break;
                case 2:
                    String elementoEliminiar = JOptionPane.showInputDialog(null,"Ingrese nombre del producto a eliminar: ");
                    if (objProducto.descripcion.contains(elementoEliminiar)){
                        int id = objProducto.getId();
                        objProducto.eliminarProducto(id);
                        JOptionPane.showMessageDialog(null,elementoEliminiar+" eliminado satisfactoriamente");

                    }else {
                        JOptionPane.showMessageDialog(null,"Producto no encontrado");
                    }
                break;
                case 3:
                    break;
            }
        }while (opcion!=6);
    }
}
