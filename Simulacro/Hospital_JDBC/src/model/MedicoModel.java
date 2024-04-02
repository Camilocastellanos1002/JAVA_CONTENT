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
