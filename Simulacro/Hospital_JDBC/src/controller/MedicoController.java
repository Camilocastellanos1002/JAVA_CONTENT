package controller;

import entity.Medico;
import model.MedicoModel;

import javax.swing.*;

public class MedicoController {
    public static void getAll(){
        MedicoModel objModel = new MedicoModel();
        String listMedico = "Lista de medicos: \n";
        for (Object i: objModel.findAll()){
            Medico objMedico = (Medico) i;
            listMedico+=objMedico.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listMedico);
    }

    public static void create(){
        MedicoModel objMedicoModel = new MedicoModel();
        String nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del nuevo medico: ");
        String apellidos = JOptionPane.showInputDialog(null,"Ingrese los apellidos del nuevo medico: ");
        int id_esp = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el id de la especialidad: "));

        Medico objMedico = new Medico();
        objMedico.setNombre(nombre);
        objMedico.setApellidos(apellidos);
        objMedico.setId_especialidad(id_esp);

        objMedico = (Medico) objMedicoModel.create(objMedico);
        JOptionPane.showMessageDialog(null,objMedico.toString());
    }
}
