package ui;

import java.util.Scanner;
import model.University;

public class RequestManagementApp{
    //Attributes
    private Scanner sk;

    //Relations
    private University controller;

    //Methods
    //CONSTRUCTOR
    public RequestManagementApp(){
        sk = new Scanner(System.in);
        controller = new University();
    }

    //MAIN
    public static void main(String[] args){
        RequestManagementApp objMain = new RequestManagementApp();

        boolean generalLoop = true;
        int option = 0;

        do{
            option = objMain.menu();

            switch (option) {
                case 1: //To register a collaborator
                    objMain.registerCollaborator();
                    break;

                case 2: //To end the program
                    generalLoop = false;
                    System.out.println("EXITING PROGRAM...");
                    break;
                    
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }

        }while(generalLoop);

    }

    //General methods
    public int menu(){
        System.out.println("General Menu:\n\t1. Register a collaborator\n\t2. Exit Program");
        System.out.print("Enter one of the options: ");
        int option = sk.nextInt();
        sk.nextLine();
        
        return option;
    }

    public void registerCollaborator(){
        System.out.println("REGISTERING A COLLABORATOR:");
        
    }
}