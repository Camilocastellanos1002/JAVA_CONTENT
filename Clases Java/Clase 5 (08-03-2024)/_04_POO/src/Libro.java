public class Libro {

    //atributos
    private String titulo;
    private String autor;
    private String publicacion;
    private boolean prestado;

    // Constructor

    public Libro(String titulo, String autor, String publicacion, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.prestado = prestado;
    }


    // Metodos Get y Set de cada atributo

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getPublicacion() {
        return publicacion;
    }
    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }
    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    //metodo toString() modificado ("Plomorfismo") para imprimr datos
    @Override   //decorador
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", publicacion='" + publicacion + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
