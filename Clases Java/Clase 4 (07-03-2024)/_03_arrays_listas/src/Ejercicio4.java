import javax.swing.*;
import java.util.ArrayList;

public class Ejercicio4 {
    public static void main(String[] args) {
        /*Planificacion de viajes*/

        int ciudadActual =0;
        int option =0;
        int sumaDistancia=0;

        ArrayList <String> intinerarioCiudad = new ArrayList<>();
        ArrayList <Integer> distanciaCiudades = new ArrayList<>();
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(null,"Planifica tu viaje\n"+
                        "1.Añadir ciudad al intinerario\n"+
                        "2.Eliminar ciudad del intinerario\n"+
                        "3.Mostrar lista completa de ciudades a visitar\n"+
                        "4.Calcular distancia del viaje\n"+
                        "5.Salir\n"+
                        "Ingrese una opcion: "));

                switch (option){
                    case 1:
                        String nuevaCiudad = JOptionPane.showInputDialog("Ingrese la nueva ciudad al intinerario");
                        intinerarioCiudad.add(nuevaCiudad.toLowerCase());
                        JOptionPane.showMessageDialog(null,"Ciudad "+ nuevaCiudad+" Agragada satisfactoriamente");
                    break;
                    case 2:
                        String eliminarCiudad = JOptionPane.showInputDialog("Ingrese la ciudad para eliminar del intinerario");
                        if (intinerarioCiudad.remove(eliminarCiudad.toLowerCase())) {
                            JOptionPane.showMessageDialog(null, "Ciudad " + eliminarCiudad + "  Eliminada satisfactoriamente");
                        }else {
                            JOptionPane.showMessageDialog(null,"La ciudad "+eliminarCiudad+" No se encuentra en el intinerario");
                        }
                    break;
                    case 3:
                        if (intinerarioCiudad.isEmpty()){
                            JOptionPane.showMessageDialog(null," Intinerario Vacio");
                        }else {
                            String listaIntinerario ="";
                            listaIntinerario += "Ciudad actual: \n"+intinerarioCiudad.get(ciudadActual)+"\n"+"\nSiguientes ciudades:\n";
                            for (int i = ciudadActual+1; i < intinerarioCiudad.size(); i++) {
                                listaIntinerario+= intinerarioCiudad.get(i)+"\n";
                            }
                            JOptionPane.showMessageDialog(null,listaIntinerario);
                            for (int i = 0; i < intinerarioCiudad.size() -1; i++) {
                                int distancia = (int) Math.floor(Math.random() * 10000);
                                distanciaCiudades.add(distancia);
                            }
                        }
                    break;
                    case 4:
                        if (intinerarioCiudad.isEmpty()){
                            JOptionPane.showMessageDialog(null," Intinerario Vacio, distancia 0 Km");
                        }else {
                            String mensaje ="Intinerario completo:\n";
                            for (int i = ciudadActual; i < distanciaCiudades.size(); i++) {
                                sumaDistancia+=distanciaCiudades.get(i);
                                mensaje+="\n"+intinerarioCiudad.get(i)+"-"+intinerarioCiudad.get(i+1)+": "+distanciaCiudades.get(i)+" Km \n";
                            }
                            mensaje +="\ndistancia total: "+sumaDistancia +" Km";
                            JOptionPane.showMessageDialog(null,mensaje);
                        }

                    break;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Opcion erronea");
            }
        }while (option!=5);
    }
}
