import controller.CoderController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Java Database Connectivity

        CoderController objCoderController = new CoderController();
        String option="";
        do {
            option = JOptionPane.showInputDialog("""
                    MENU: 
                    1.list Coders
                    2.Insert Coder
                    3.Uptader Coder
                    4.Delete Coder
                    5.Get my name
                    6.exit
                    Chose an option: 
                    """);
            switch (option){
                case "1":
                    objCoderController.getAll();
                break;
                case "2":
                    objCoderController.create();
                break;
                case "3":
                    objCoderController.update();
                break;
                case "4":
                    objCoderController.delete();
                break;
                case "5":
                
                break;
            }
        }while (!option.equals("6"));

    }
}