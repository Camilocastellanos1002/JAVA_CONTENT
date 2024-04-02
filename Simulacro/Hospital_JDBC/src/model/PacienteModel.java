package model;

import database.CRUD;
import database.ConfigDB;
import entity.Paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteModel implements CRUD {
    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listPaciente = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM paciente;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Paciente objPaciente = new Paciente();
                objPaciente.setId(objResult.getInt("id"));
                objPaciente.setNombre(objResult.getString("nombre"));
                objPaciente.setApellidos(objResult.getString("apellidos"));
                objPaciente.setFecha_nacimiento(objResult.getDate("fecha_nacimiento"));
                objPaciente.setDocumento_identidad(objResult.getString("documento_identidad"));

                listPaciente.add(objPaciente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        return listPaciente;
    }
}
