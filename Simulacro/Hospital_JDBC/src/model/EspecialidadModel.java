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
        Connection objConnection = ConfigDB.openConnection();
        Especialidad objEspecialidad = (Especialidad) obj;
        try {
            String sql ="INSERT INTO especialidad (nombre,descripcion) VALUES (?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1,objEspecialidad.getNombre());
            objPrepare.setString(2,objEspecialidad.getDescripcion());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objEspecialidad.setId(objResult.getInt("id"));
            }
            JOptionPane.showMessageDialog(null,"Especialidad creada satisfactoriamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error creando especialidad: "+e.getMessage());
        }
        ConfigDB.closeConnection();
        return objEspecialidad;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Especialidad objEspecialidad = (Especialidad) obj;

        boolean isUpdate = false;
        try {
            String sql = "UPDATE especialidad SET nombre = ?,descripcion= ? WHERE id= ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,objEspecialidad.getNombre());
            objPrepare.setString(2,objEspecialidad.getDescripcion());
            objPrepare.setInt(3,objEspecialidad.getId());

            int totalAffectedRow = objPrepare.executeUpdate();
            if (totalAffectedRow>0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,"Actualizacion generada correctamente");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al actualizar especialidad: "+e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {
        Especialidad objEspecialidad = (Especialidad) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean isDelete = false;
        try {
            String sql = "DELETE FROM especialidad WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objEspecialidad.getId());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows>0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"Eliminacion generada correctamente");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al eliminar especialidad: "+e.getMessage());

        }
        ConfigDB.closeConnection();
        return isDelete;
    }

    @Override
    public Especialidad findById(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Especialidad objEspecialidad = null;
        try {
            String sql = "SELECT * FROM especialidad WHERE id=?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()){
                objEspecialidad = new Especialidad();
                objEspecialidad.setId(objResult.getInt("id"));
                objEspecialidad.setNombre(objResult.getString("name"));
                objEspecialidad.setDescripcion(objResult.getString("descripcion"));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar especialidad: "+e.getMessage());
        }
        ConfigDB.closeConnection();
        return objEspecialidad;
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
    public List<Especialidad> findByName(String name){
        List<Especialidad> listEspecialidades = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM especialidad WHERE nombre like ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+name+"%");
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Especialidad objEspecialidad =new Especialidad();

                objEspecialidad.setId(objResult.getInt("id"));
                objEspecialidad.setNombre(objResult.getString("nombre"));
                objEspecialidad.setDescripcion(objResult.getString("descripcion"));

                listEspecialidades.add(objEspecialidad);
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al encontrar especialidad por nombre: "+e.getMessage());
        }

        ConfigDB.closeConnection();
        return listEspecialidades;
    }
}
