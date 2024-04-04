package model;

import database.CRUD;
import database.ConfigDB;
import entity.Paciente;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteModel implements CRUD {
    @Override
    public Object create(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Paciente objPaciente = (Paciente) obj;
        try {
            String sql = "INSERT INTO paciente (nombre,apellidos,fecha_nacimiento,documento_identidad) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1,objPaciente.getId());
            objPrepare.setString(2,objPaciente.getNombre());
            objPrepare.setString(3,objPaciente.getApellidos());
            objPrepare.setDate(4, Date.valueOf((String)objPaciente.getFecha_nacimiento()));
            objPrepare.setString(5,objPaciente.getDocumento_identidad());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objPaciente.setId(objResult.getInt("id"));
            }
            JOptionPane.showMessageDialog(null,"paciente creado");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error creando paciente: "+e.getMessage());
        }
        return objPaciente;
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
                objPaciente.setFecha_nacimiento(objResult.getString("fecha_nacimiento"));
                objPaciente.setDocumento_identidad(objResult.getString("documento_identidad"));

                listPaciente.add(objPaciente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        return listPaciente;
    }
}
