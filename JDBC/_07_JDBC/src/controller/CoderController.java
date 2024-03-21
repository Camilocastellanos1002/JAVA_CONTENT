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

         /*
         String listCoderString = "Coder List \n";
         for (Object obj : this.objCoderModel.findAll()){
             //Castear
             Coder objCoder = (Coder) obj;
             listCoderString += objCoder.toString()+"\n";
         }*/
        //realizamos sobre carga y reemplazamos el codigo de arriba
        String listCoderString = this.getAll(this.objCoderModel.findAll());
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
         //realizamos sobrecarga
        String list = this.getAll(this.objCoderModel.findAll());
        //mostramos toda la lista
        JOptionPane.showMessageDialog(null,list);
    }

    public String  getAll(List <Object> listObject){
        String list = "List Coders \n";
        //iteramos sobre la lista que devuelve el metodo find all
        for (Object obj: listObject){
            //convertimos o castemos el objeto tipo object a un coder
            Coder objCoder = (Coder) obj;
            //concatenamos la informacion
            list += objCoder.toString()+"\n";
        }
        //mostramos la lista
        return list;
    }

    public  void update(){
         //listamos
         String listCoders = this.getAll(this.objCoderModel.findAll());
         //Pedimos el id
         int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listCoders+" Entrer the ID of the coder to edit: "));
         //Verificar el id
        Coder objCoder = (Coder) this.objCoderModel.findById(idUpdate);
        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"Coder not found");
        }else {
            String name = JOptionPane.showInputDialog(null,"Enter new name: ", objCoder.getName());
            String clan = JOptionPane.showInputDialog(null,"Enter new clan: ",objCoder.getClan());
            int age = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter new age: ",String.valueOf(objCoder.getAge())));

            //actualizamos el objeto coder con al nueva informacion
            objCoder.setName(name);
            objCoder.setClan(clan);
            objCoder.setAge(age);
            //actualizamos en la base de datos
            this.objCoderModel.update(objCoder);
        }
    }
}
