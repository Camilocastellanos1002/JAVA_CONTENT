package ejericio_06;

import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    ArrayList<Double> calificaciones= new ArrayList<>();

    private Double promedio;

    public Estudiante() {
    }

    public Estudiante(String nombre, ArrayList<Double> calificaciones, Double promedio) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Double getPromedio() {
        return promedio;
    }

    public Double setPromedio() {
        Double suma=0.0;
        Double promedio =0.0;
        for (Object object : this.calificaciones){
            suma+=Double.parseDouble(object.toString());
        }
        promedio = suma/this.calificaciones.size();
        return promedio;
    }

    @Override
    public String toString() {
        return "Estudiantes{" +
                "nombre='" + nombre + '\'' +
                ", calificaciones=" + calificaciones +
                ", promedio=" + promedio +
                '}';
    }
}
