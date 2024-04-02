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
}
