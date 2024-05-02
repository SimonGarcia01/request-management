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

    }
}