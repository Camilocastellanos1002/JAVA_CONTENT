package ejecicio_01;

public class Main {
    public static void main(String[] args) {
        //crear una instancia o objeto de una clase
        Libro objLibro = new Libro("100 años de soledad","Gabriel Garcia Marquez","01-05-1967",false);

        //forma de ingresar a un atributo de una clase desde otra
        System.out.println(objLibro.getTitulo());
        objLibro.setTitulo("El rastro de tu sangre en la nieve");
        System.out.println(objLibro.toString());
    }
}
