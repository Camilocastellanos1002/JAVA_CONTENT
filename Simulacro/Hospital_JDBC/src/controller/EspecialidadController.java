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

}
