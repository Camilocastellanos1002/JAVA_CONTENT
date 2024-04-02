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
}
