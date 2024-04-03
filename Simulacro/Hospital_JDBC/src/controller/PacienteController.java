package controller;

import entity.Paciente;
import model.PacienteModel;

import javax.swing.*;

public class PacienteController {
    public static void getAll(){
        PacienteModel objModel = new PacienteModel();
        String listPaciente = "Lista de pacientes: \n";
        for (Object i: objModel.findAll()){
            Paciente objPaciente = (Paciente) i;
            listPaciente+=objPaciente.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listPaciente);
    }
}
