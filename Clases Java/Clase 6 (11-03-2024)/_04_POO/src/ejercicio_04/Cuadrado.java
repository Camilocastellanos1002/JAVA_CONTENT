package ejercicio_04;

public class Cuadrado extends Rectangulo{
    public  Cuadrado( double lado){
        super(lado,lado); //forma de disparar el constructor del Rectangulo para heredad atributos

        //No es nesesario sobreescribir calcularArea(), por que al implementarlo Rectangulo ya estamos obteniendo su funcionalidad



    }
}
