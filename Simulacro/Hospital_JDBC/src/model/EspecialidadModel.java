package model;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadModel implements CRUD {
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
        List<Object> listEspecialidad = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM especialidad;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Especialidad objEspecialidad = new Especialidad();
                objEspecialidad.setId(objResult.getInt("id"));
                objEspecialidad.setNombre(objResult.getString("nombre"));
                objEspecialidad.setDescripcion(objResult.getString("descripcion"));

                listEspecialidad.add(objEspecialidad);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }

        ConfigDB.closeConnection();
        return listEspecialidad;
    }
}
