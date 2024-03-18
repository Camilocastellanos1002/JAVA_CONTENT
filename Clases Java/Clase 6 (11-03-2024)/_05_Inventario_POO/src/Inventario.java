import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    //metodo para añadir producto
    public void agregarProducto(Producto producto){
        this.listaProductos.add(producto);
    }

    //metodo para eliminar producto
    public  boolean  eliminarProducto(int id){
        return listaProductos.removeIf(producto -> producto.getId() == id);
    }

    //metodo para buscar producto por nombre
    public Producto buscarPorNombre(String nombreBuscar){
        for (Producto objProducto : this.listaProductos){
            if (objProducto.getNombre().equalsIgnoreCase(nombreBuscar)){
                return objProducto;
            }
        }
        return null;
    }

    //metodo para listar los productos
    public void listarProductos(){
        for (Producto producto : this.listaProductos){
            System.out.println("ID: "+producto.getId()+"\n"+
                    "Nombre: "+producto.getNombre()+"\n"+
                    "Precio: "+producto.getPrecio());
        }
    }

}
