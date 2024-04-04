package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cita;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaModel implements CRUD {
    @Override
    public Object create(Object obj) {
        //crear conexion
        Connection objConnection = ConfigDB.openConnection();
        //casting del objeto
        Cita objCita = (Cita) obj;
        //try
        try {
            //sentencia sql
            String sql = "INSERT INTO cita (fecha_cita,hora_cita,motivo,id_paciente,id_medico) VALUES (?,?,?,?,?);";
            //preparar statement y devolucion de llaves
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //dar valores a  ?
            objPrepare.setDate(1, Date.valueOf(objCita.getFecha_cita()));
            objPrepare.setTime(2,Time.valueOf(objCita.getHora_cita()));
            objPrepare.setString(3,objCita.getMotivo());
            objPrepare.setInt(4,objCita.getId_paciente());
            objPrepare.setInt(3,objCita.getId_medico());
            //ejecutar query
            objPrepare.execute();
            //obtener llaves generadas
            ResultSet objResult = objPrepare.getGeneratedKeys();
            //mientras haya un registro
            while (objResult.next()){
                //agregar id
                objCita.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"cita creada");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error creando cita: "+e.getMessage());
        }
        //cerrar conexion
        ConfigDB.closeConnection();
        //retornar objeto cita
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
        /*
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
        return listaCita;*/
        return null;
    }
}
