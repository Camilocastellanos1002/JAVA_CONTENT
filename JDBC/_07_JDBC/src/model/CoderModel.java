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
        return null;
    }

    @Override
    public boolean update(Object object0) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
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
    public Object findById(int d) {
        return null;
    }
}
