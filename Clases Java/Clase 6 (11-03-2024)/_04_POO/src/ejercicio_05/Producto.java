package ejercicio_05;

import java.util.ArrayList;

public class Producto {
    ArrayList <String> descripcion= new ArrayList<>();
    private int id;
    private double cantidad;

    public Producto() {
    }

    public void agregarProducto(String prod){
        this.descripcion.add(prod);
    }

    public void eliminarProducto(int prod){
        this.descripcion.remove(prod);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


}
