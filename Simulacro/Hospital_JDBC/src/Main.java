import controller.CitaController;
import controller.EspecialidadController;
import controller.MedicoController;
import controller.PacienteController;
import database.ConfigDB;
import entity.Especialidad;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*
        // prueba de conexion con el servidor SQL
        ConfigDB.openConnection();
        ConfigDB.closeConnection();*/

        String option ="";
        do {
            option = JOptionPane.showInputDialog("""
                    Menu Principal:
                    1.Menu Especialidades
                    2.Menu Medico
                    3.Menu Paciente
                    4.Menu Cita
                    5.Salir
                    Seleccione una opcion:
                    """);
            switch (option){
                case "1":
                    String option1 = "";
                    do {
                        option1= JOptionPane.showInputDialog("""
                            Menu: \n
                            1.Mostrar Especialidades
                            2.Crear Especialidad
                            3.Actualizar especialidad
                            4.Eliminar especialidad
                            5.Obtener especialidad por nombre
                            6.Salir
                            Seleccione una opcion: 
                            """);
                        switch (option1){
                            case "1":
                                EspecialidadController.getAll();
                                break;
                        }
                    }while (!option1.equals("6"));
                break;
                case "2":
                    String option2="";
                    do {
                        option2= JOptionPane.showInputDialog("""
                    Menu: \n
                    1.Mostrar Medicos
                    2.Insertar nuevo Medico
                    3.Actualizar Medico
                    4.Eliminar Medico
                    5.Obtener Medico por nombre
                    6.Salir
                    Seleccione una opcion: 
                    """);
                        switch (option2){
                            case "1":
                                MedicoController.getAll();
                                break;
                        }
                    }while (!option2.equals("6"));
                break;
                case "3":
                    String option3="";
                    do {
                        option3= JOptionPane.showInputDialog("""
                    Menu: \n
                    1.Mostrar pacientes
                    2.Insertar nuevo paciente
                    3.Actualizar paciente
                    4.Eliminar paciente
                    5.Obtener paciente por nombre
                    6.Salir
                    Seleccione una opcion: 
                    """);
                        switch (option3){
                            case "1":
                                PacienteController.getAll();
                                break;
                        }
                    }while (!option3.equals("6"));
                break;
                case "4":
                    String option4="";
                    do {
                        option4= JOptionPane.showInputDialog("""
                    Menu: \n
                    1.Mostrar pacientes
                    2.Insertar nuevo paciente
                    3.Actualizar paciente
                    4.Eliminar paciente
                    5.Obtener paciente por nombre
                    6.Salir
                    Seleccione una opcion: 
                    """);
                        switch (option4){
                            case "1":
                                CitaController.getAll();
                                break;
                        }
                    }while (!option4.equals("6"));
                break;

            }
        }while (!option.equals("5"));
    }
}