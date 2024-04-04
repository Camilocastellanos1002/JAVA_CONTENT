package controller;

import entity.Cita;
import entity.Medico;
import entity.Paciente;
import model.CitaModel;
import model.PacienteModel;
import utils.Utils;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

        //pedir valores
        String fecha= JOptionPane.showInputDialog(null,"Ingrese la fecha de la cita (YYYY-MM-DD): ");
        String tiempo = JOptionPane.showInputDialog(null,"Ingrese la hora de la cita: (HH:mm:ss): ");
        String motivo = JOptionPane.showInputDialog(null,"Ingrese motivo de la cita: ");

        //llamar instancia de la listas de pacientes y medicos
        Object[] optionPacientes = Utils.listToArray(PacienteController.instancePacienteModel().findAll());
        Object[] optionMedicos = Utils.listToArray(PacienteController.instancePacienteModel().findAll());

        //selector de pacientes
        Paciente pacienteSeleccionado = (Paciente) JOptionPane.showInputDialog(
                null,
                "Seleccione el paciente: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionPacientes,
                optionPacientes[0]
        );
        //selector de medicos
        Medico medicoSeleccionado = (Medico) JOptionPane.showInputDialog(
                null,
                "Seleccione el medico asignado a la cita: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionMedicos,
                optionMedicos[0]
        );
        //creando la instancia de la cita
        instanciaModeloCita().create(new Cita(pacienteSeleccionado.getId(),medicoSeleccionado.getId(),fecha,tiempo,motivo,medicoSeleccionado,pacienteSeleccionado));
    }
    public static CitaModel instanciaModeloCita(){
        return new CitaModel();
    }
}
