package controller;

import entity.Cita;
import model.CitaModel;

import javax.swing.*;

public class CitaController {
    public static void getAll(){
        CitaModel objModel = new CitaModel();
        String listCita = "Lista de citas: \n";
        for (Object i: objModel.findAll()){
            Cita objCita = (Cita) i;
            listCita+=objCita.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listCita);
    }
}
