package ejercicio_04;

public class Circulo  extends Figura{

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return   Math.pow(radio,2) * Math.PI;
    }
}
