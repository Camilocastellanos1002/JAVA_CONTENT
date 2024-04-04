package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cita;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaModel implements CRUD {
    @Override
    public Object create(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Cita objCita = (Cita) obj;
        try {
            String sql = "INSERT INTO paciente (nombre,apellidos,fecha_nacimiento,documento_identidad) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1,objCita.getId());
            objPrepare.setInt(2,objCita.getId_paciente());
            objPrepare.setInt(3,objCita.getId_medico());
            objPrepare.setDate(4,objCita.getFecha_cita());
            objPrepare.setTime(5,objCita.getHora_cita());
            objPrepare.setString(6,objCita.getMotivo());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objCita.setId(objResult.getInt("id"));
            }
            JOptionPane.showMessageDialog(null,"cita creada");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error creando cita: "+e.getMessage());
        }
        return objCita;
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
        List<Object> listaCita = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM cita;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Cita objCita = new Cita();
                objCita.setId(objResult.getInt("id"));
                objCita.setId_paciente(objResult.getInt("id_paciente"));
                objCita.setId_medico(objResult.getInt("id_medico"));
                objCita.setFecha_cita(objResult.getDate("fecha_cita"));
                objCita.setHora_cita(objResult.getTime("hora_cita"));
                objCita.setMotivo(objResult.getString("motivo"));

                listaCita.add(objCita);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        return listaCita;
    }
}
