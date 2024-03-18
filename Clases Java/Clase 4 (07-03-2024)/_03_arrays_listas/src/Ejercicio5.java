import javax.swing.*;
import java.util.ArrayList;

public class Ejercicio5 {
    public static void main(String[] args) {

        /*Creacion de lista dinamica*/

        ArrayList <String> playList = new ArrayList<>();

        int cancionActual =0;
        int option =0;

        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("PLAYLIST \n" +
                        "1.Agregar cancion\n"+
                        "2.Remover cancion\n"+
                        "3.Mostrar cancion actual y siguientes en la lista\n"+
                        "4.Saltar a la siguiente cancion\n"+
                        "5.Salir \n"+
                        "Ingrese una opcion: "));
                switch (option){
                    case 1:
                        //añadir una cancion
                        String nuevaCancion = JOptionPane.showInputDialog("Ingrese el nombre de la cancion a agregar: ");
                        //agracion cancion a la playlist
                        playList.add(nuevaCancion.toLowerCase());
                        JOptionPane.showMessageDialog(null, nuevaCancion + " Agregada correctamente");
                    break;
                    case 2:
                        //eliminar una cancion
                        String cancionEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la cancion que desea eliminar");
                        //eliminar cancion de la playlist
                        if (playList.remove(cancionEliminar.toLowerCase())){
                            JOptionPane.showMessageDialog(null,cancionEliminar + " Eliminada correctamente");
                        }else {
                            JOptionPane.showMessageDialog(null,cancionEliminar + " No se encuentra en la playlist");
                        }
                    break;
                    case 3:
                          //mostrar la cancion actual y la siguiente de la lista
                        //preguntar si la lista esta vacia
                        if (playList.isEmpty()){
                            JOptionPane.showMessageDialog(null,"La playlist esta vacia");
                        }else {
                            //crear una variable en texto todas las canciones mayores a la actual
                            String listaTotal ="";
                            listaTotal+="Cancion actual \n"+playList.get(cancionActual)+"\n"+"\nSiguiente en la lista\n";
                            for (int i = cancionActual+1; i < playList.size(); i++){
                                //por cada iteracion concatenamos a la variable listaTotal
                                listaTotal+= playList.get(i)+"\n";
                            }
                            JOptionPane.showMessageDialog(null,listaTotal);
                        }
                    break;
                    case 4:
                        //Saltar a la cancion siguiente

                        //validar si hay una siguiente cancion
                        if(cancionActual+1 < playList.size()){
                            cancionActual++;
                            JOptionPane.showMessageDialog(null,playList.get(cancionActual)+" Reproducida correctamente");
                        }else {
                            JOptionPane.showMessageDialog(null," PlayList finalizada");
                            cancionActual=0;
                        }
                    break;

                };
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Caracter erroneo");
            }


        }while (option!=5);
    }
}
