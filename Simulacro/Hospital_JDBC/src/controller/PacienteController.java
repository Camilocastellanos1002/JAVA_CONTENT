package controller;

import entity.Paciente;
import model.PacienteModel;

import javax.swing.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public static void create(){
        PacienteModel objPacienteModel = new PacienteModel();
        String nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del nuevo paciente: ");
        String apellidos = JOptionPane.showInputDialog(null,"Ingrese los apellidos del nuevo paciente: ");
        String doc = JOptionPane.showInputDialog(null,"Ingrese documento del paciente: ");
        String fechaN = JOptionPane.showInputDialog(null,"Ingrese fecha de nacimiento: ");

        Paciente objPaciente = new Paciente();
        /*
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaN = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(JOptionPane.showInputDialog(null,"Ingrese la fecha de nacimiento: \n",dateFormat.format(objPaciente.getFecha_nacimiento())));
            objPaciente.setFecha_nacimiento(fechaN);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,"Error al crear paciente: "+e.getMessage());
        }*/
        objPaciente.setNombre(nombre);
        objPaciente.setApellidos(apellidos);
        objPaciente.setDocumento_identidad(doc);
        objPaciente.setFecha_nacimiento(fechaN);

        objPaciente = (Paciente) objPacienteModel.create(objPaciente);

        JOptionPane.showMessageDialog(null,objPaciente.toString());
    }
}
