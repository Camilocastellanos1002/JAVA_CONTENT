package controller;

import entity.Especialidad;
import model.EspecialidadModel;

import javax.swing.*;

public class EspecialidadController {

    public static void getAll(){
        EspecialidadModel objModel = new EspecialidadModel();
        String listEspecialidad = "Lista de especialidades: \n";
        for (Object i: objModel.findAll()){
            Especialidad objEspecialidad = (Especialidad) i;
            listEspecialidad+=objEspecialidad.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listEspecialidad);
    }

    public static void create(){
        EspecialidadModel objEspecialidadModel = new EspecialidadModel();
        String nombre =JOptionPane.showInputDialog(null,"Ingrese nombre de la especialidad: \n");
        String descripcion= JOptionPane.showInputDialog(null,"Ingrese la descripcion de la especialidad: \n");

        Especialidad objEspecialidad = new Especialidad();
        objEspecialidad.setNombre(nombre);
        objEspecialidad.setDescripcion(descripcion);

        objEspecialidad = (Especialidad) objEspecialidadModel.create(objEspecialidad);

        JOptionPane.showMessageDialog(null,objEspecialidad.toString());
    }

    public static String getAllString(){
        EspecialidadModel objModel = new EspecialidadModel();
        String listEspecialidad = "Lista de especialidades: \n";
        for (Object i: objModel.findAll()){
            Especialidad objEspecialidad = (Especialidad) i;
            listEspecialidad+=objEspecialidad.toString()+"\n";
        }
        return listEspecialidad;
    }
    public static void delete(){
        EspecialidadModel objEspecialModel = new EspecialidadModel();
        String listEspecialidades = getAllString();
        int id =Integer.parseInt(JOptionPane.showInputDialog(null,listEspecialidades+"\nSeleccione el id de la especialidad para eliminar: "));
        Especialidad objEspecialidad = objEspecialModel.findById(id);
        if (objEspecialidad == null){
            JOptionPane.showMessageDialog(null,"Especialidad no encontrada");
        }else {
           int confirm = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar la especialidad: \n"+objEspecialidad.toString());
            if (confirm ==0){
                objEspecialModel.delete(objEspecialidad);
            }
        }
    }

    public static void getByName(){
        String name = JOptionPane.showInputDialog(null,"Ingrese el nombre a buscar: ");
        EspecialidadModel objEspecialidadModel = new EspecialidadModel();
        String listString = "Coincidencias: \n";
        for (Especialidad i:objEspecialidadModel.findByName(name)){
            listString+=i.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listString);
    }

    public static void update(){
        EspecialidadModel objEspecialidadModel = new EspecialidadModel();
        String listEspecialidad = getAllString();
        int idUpdate= Integer.parseInt(JOptionPane.showInputDialog(null,listEspecialidad+"\nIngrese el id de la especialidad para modificar: "));

        Especialidad objEspecialidad = objEspecialidadModel.findById(idUpdate);
        if (objEspecialidad == null){
            JOptionPane.showMessageDialog(null,"Especialidad no encontrada");
        }else {
            String nombre = JOptionPane.showInputDialog(null,"Ingrese el nuevo nombre: ",objEspecialidad.getNombre());
            String descripcion = JOptionPane.showInputDialog(null,"Ingrese la nueva descripcion: ",objEspecialidad.getDescripcion());
            objEspecialidad.setNombre(nombre);
            objEspecialidad.setDescripcion(descripcion);

            objEspecialidadModel.update(objEspecialidad);
        }

    }
}
