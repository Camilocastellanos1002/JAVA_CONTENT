package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;
import java.util.List;

public class CoderController {

    CoderModel objCoderModel;
     public CoderController(){
        //crear instancia del model
        this.objCoderModel = new CoderModel();
    }
    //metodo para listar todos los coders
    public void getAll(){
        String list = "List Coders \n";
        //iteramos sobre la lista que devuelve el metodo find all
        for (Object obj: this.objCoderModel.findAll()){
            //convertimos o castemos el objeto tipo object a un coder
            Coder objCoder = (Coder) obj;
            list += objCoder.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,list);
    }
}
