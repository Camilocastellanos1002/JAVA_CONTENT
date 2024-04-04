package controller;

import entity.Especialidad;
import entity.Medico;
import model.MedicoModel;
import utils.Utils;

import javax.swing.*;

public class MedicoController {
    public static void getAll(){
        MedicoModel objModel = new MedicoModel();
        String listMedico = "Lista de medicos: \n";
        for (Object i: objModel.findAll()){
            Medico objMedico = (Medico) i;
            listMedico+=objMedico.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listMedico);
    }

    public static void create(){

        //1. perdir valores
        String nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del nuevo medico: ");
        String apellidos = JOptionPane.showInputDialog(null,"Ingrese los apellidos del nuevo medico: ");

        //2. listar especialidades
        Object[] optionEspecialidad = Utils.listToArray(EspecialidadController.instanciarModelo().findAll());

        //3.selector
         Especialidad objEspecialidad =(Especialidad) JOptionPane.showInputDialog(  //la opcion seleccionada es casteada y guardada como objeto
                                                                                    //especialidad
                null,   //no tiene parentcomponent
                "Seleccione una especialidad: ",    //mensaje
                "",                                 //no tiene titulo
                JOptionPane.QUESTION_MESSAGE,       //ventana de pregunto
                null,                               //no tiene ningun icono
                optionEspecialidad,                 //opciones
                optionEspecialidad[0]               //opcion por defecto
        );

         //3. crear el modelo de medico asignando el objeto medico con los valores asignados y nesesarios en el constructor
         instanciaModeloMedico().create(new Medico(nombre,apellidos,objEspecialidad.getId(),objEspecialidad));

    }

    //metodo que crea la instancia de medico cada vez que es llamado
    public static MedicoModel instanciaModeloMedico(){
        return new MedicoModel();
    }
}
