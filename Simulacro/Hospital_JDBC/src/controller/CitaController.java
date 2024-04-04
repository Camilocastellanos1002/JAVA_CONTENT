package controller;

import entity.Cita;
import entity.Paciente;
import model.CitaModel;
import model.PacienteModel;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public static void create(){
        CitaModel objCitaModel = new CitaModel();
        int id_pac = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese id del paciente: "));
        int id_med = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese id del medico: "));
        String motivo = JOptionPane.showInputDialog(null,"Ingrese motivo de la cita: ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaConvertida = null;
        try {
            fechaConvertida = (Date) dateFormat.parse(JOptionPane.showInputDialog(null,"Ingrese la fecha de nacimiento del paciente (AAAA-MM-DD): "));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,"Error al recibir fecha: "+e.getMessage());
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        java.sql.Time horaConvertida = null;
        try {
            horaConvertida = (Time) timeFormat.parse(JOptionPane.showInputDialog(null,"Ingrese la hora de la cita: (HH:mm): "));
        }catch (ParseException e){
            JOptionPane.showMessageDialog(null,"Error al recibir hora: "+e.getMessage());
        }

        Cita objCita = new Cita();
        objCita.setId_paciente(id_pac);
        objCita.setId_medico(id_med);
        objCita.setMotivo(motivo);
        objCita.setFecha_cita(fechaConvertida);
        objCita.setHora_cita(horaConvertida);

        objCita = (Cita) objCitaModel.create(objCita);

        JOptionPane.showMessageDialog(null,objCita.toString());
    }
}
