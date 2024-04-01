package model;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    @Override
    public Object insert(Object object) {
        //1. Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();
        //2. Castear el objeto
        Coder objCoder = (Coder) object;

        try {
            //3. Crear el SQL
            String sql = "INSERT INTO coder(name,age,clan) VALUES(?,?,?);";
            //4. Preparar el statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //5. Asignar los ?

            objPrepare.setString(1, objCoder.getName());
            objPrepare.setInt(2, objCoder.getAge());
            objPrepare.setString(3, objCoder.getClan());

            //6. Ejecutamos el Query
            objPrepare.execute();

            //7. Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objCoder.setId(objResult.getInt(1));
            }

            //8. Cerramos el prepareStatement
            objPrepare.close();
            JOptionPane.showMessageDialog(null, " Coder insertion was successful.");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding Coder " + e.getMessage());
        }
        //9. Cerramos la conexión
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {
        //1.Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();
        //2. Convertir el objeto
        Coder objCoder = (Coder) object;
        //3.Variable bandera para saber si se actualizo
        boolean isUpdated = false;

        try {
            //4.Creamos la sentencia SQL
            String sql = "UPDATE coder SET name = ?, age = ?, clan =? WHERE id=?;";
            //5 Preparamos el statement
            PreparedStatement objPrepare =objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //6.Dar valor a los ? parametros de query
            objPrepare.setString(1,objCoder.getName());
            //7. Ejecutamos el query
            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected>0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The update was sucessfull");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {
        //1. Convertir el objeto a la entidad
        Coder objCoder = (Coder) object;

        //2. variable booleana para medir el estado de la eliminacion
        boolean isDeleted = false;

        //3.Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();
        try {
            //4.Escribir la sentencias SQL
            String sql = "DELETE FROM coder WHERE id =?;";

            //5 Preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //6.Asignamos el valor al ?
            objPrepare.setInt(1,objCoder.getId());

            //7. ExecuteUpdate devuelve la cantidad filas afectadas por la sentencia SQL ejecutada

            int totalAffecteRows = objPrepare.executeUpdate();
            if (totalAffecteRows>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"The delete was successful");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        //8.Cerrar la conexion
        ConfigDB.closeConnection();
        return isDeleted;
    }

    @Override
    public List<Object> findAll(){
        //1. abrir la conexion
        Connection objconnection = ConfigDB.openConnection();

        //2. inicializar la lista donde se guardan los resgistros que devuelve
        //la BD
        List<Object> listCoders = new ArrayList<>();
        try {
            //3 escribir ka sebtencia sql
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC";
            //4.Utilizar PrepareStatement
            PreparedStatement objPrepareStatement = objconnection.prepareStatement(sql);
            //5. Ejecturar el Query o el prepare
            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();
            while (objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setId( objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                //finalmente agregar el coder a la lista
                listCoders.add(objCoder);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data accquisition Error"+e.getMessage());
        }
        ConfigDB.closeConnection();

        return listCoders;
    }

    @Override
    public Object findById(int id) {
        //1. Abrir la conexion
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = null;
        try {
            //2.Sentencia SQL
            String sql = "SELECT * FROM coder WHERE id=?;";

            //3. Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //4.Dar valor al ?
            objPrepare.setInt(1,id);

            //traer los cambios de la base de datos ejecutando el query
            ResultSet objResult = objPrepare.executeQuery();

            //Mientras haya un registro siguiente entonces
            while (objResult.next()){
                objCoder = new  Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setAge(objResult.getInt("age"));

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        //7. Cerrar la conexion
        ConfigDB.closeConnection();
        return objCoder;
    }
}
