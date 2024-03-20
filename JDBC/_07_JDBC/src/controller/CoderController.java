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
    public void create(){
        Coder objCoder = new Coder();

        String name = JOptionPane.showInputDialog("Insert name: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age: "));
        String clan = JOptionPane.showInputDialog("Insert clan: ");

        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        objCoder = (Coder)  this.objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());


    }

    public  void  delete(){
         String listCoderString = "Coder List \n";
         for (Object obj : this.objCoderModel.findAll()){
             //Castear
             Coder objCoder = (Coder) obj;
             listCoderString += objCoder.toString()+"\n";
         }

         int confirm =1;
         int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCoderString+"Enter the ID of the coder to delete: "));
         Coder objCoder = (Coder) this.objCoderModel.findById(idDelete);
         if (objCoder == null){
             JOptionPane.showMessageDialog(null,"Coder not found");
         }else {
             confirm = JOptionPane.showConfirmDialog(null,"Are you Sure want to delete the Coder: \n"+objCoder.toString());

             //Si el usuario escogio que si entonces eliminamos
             if (confirm==0){
                 this.objCoderModel.delete(objCoder);
             }
         }
    }
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
