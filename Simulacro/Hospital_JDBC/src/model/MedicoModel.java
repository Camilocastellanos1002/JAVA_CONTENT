package model;

import database.CRUD;
import database.ConfigDB;
import entity.Medico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoModel implements CRUD {
    @Override
    public Object create(Object obj) {
        //1. abrir conexion
        Connection objConnection = ConfigDB.openConnection();
        //2. castear el objeto que viene como parametro
        Medico objMedico = (Medico) obj;
        //3. tod o puede fallar
        try {
            //4. sentencia sql
            String sql = "INSERT INTO medico (nombre,apellidos,id_especialidad) VALUES (?,?,?);";
            //5.preparar el statement y que genere llaves
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //6. dar valores al statemente
            objPrepare.setString(1,objMedico.getNombre());
            objPrepare.setString(2,objMedico.getApellidos());
            objPrepare.setInt(3,objMedico.getId_especialidad());
            //7. ejecutar el query
            objPrepare.execute();
            //8. obtener los dalores de las llaves
            ResultSet objResult = objPrepare.getGeneratedKeys();
            //9. por registro
            while (objResult.next()){
                objMedico.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null,"Medico creado");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error Creando medico: "+e.getMessage());
        }
        //10. cerrar conexion
        ConfigDB.closeConnection();
        //11. devolver objeto
        return objMedico;
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
        List<Object>  listMedico = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM medico;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Medico objMedico = new Medico();
                objMedico.setId(objResult.getInt("id"));
                objMedico.setNombre(objResult.getString("nombre"));
                objMedico.setApellidos(objResult.getString("apellidos"));
                objMedico.setId_especialidad(objResult.getInt("id_especialidad"));

                listMedico.add(objMedico);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        ConfigDB.closeConnection();
        return listMedico;
    }
}
