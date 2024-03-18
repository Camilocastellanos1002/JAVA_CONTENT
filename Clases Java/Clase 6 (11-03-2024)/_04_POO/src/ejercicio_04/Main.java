package ejercicio_04;

public class Main {
    public static void main(String[] args) {

        //Test #1 calcular area de un circulo
        Circulo objCirculo = new Circulo(10);
        System.out.println("El area del circulo es: "+objCirculo.calcularArea());

        //Test #2 calcular area de un rectangulo
        Rectangulo objRectangulo = new Rectangulo(20,40);
        System.out.println("El area del rectangulo es: "+objRectangulo.calcularArea());

        //Test 3 Calcular el area de un cuadrado
        Cuadrado objCuadrado = new Cuadrado(40);
        System.out.println("El area del cuadrado es: "+objCuadrado.calcularArea());
    }
}
