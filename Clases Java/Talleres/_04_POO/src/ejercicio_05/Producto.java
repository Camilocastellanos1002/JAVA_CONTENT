package ejercicio_05;

import java.util.ArrayList;

public class Producto {
    ArrayList <String> descripcion= new ArrayList<>();
    private int id;
    private double cantidad;

    public Producto() {
    }

    public Producto(ArrayList<String> descripcion, int id, double cantidad) {
        this.descripcion = descripcion;
        this.id = id;
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Producto{" +
                "descripcion=" + descripcion +
                ", id=" + id +
                ", cantidad=" + cantidad +
                '}';
    }
}
