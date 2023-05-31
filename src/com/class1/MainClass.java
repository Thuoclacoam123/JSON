package com.class1;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws Exception {
        ContactManagenment contactManagenment = new ContactManagenment();
        System.out.println("Addres book program");
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("1.add new contact");
            System.out.println("2.find contact by name");
            System.out.println("3.display contact:");
            System.out.println("4. out!");
            System.out.println("Enter:");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    contactManagenment.addContact();
                    break;
                case 2:
                    contactManagenment.findContactByName();
                    break;
                case 3:
                    contactManagenment.displayContact();
                    break;
                case 4:
                    System.out.println("program ended!");
            }
        }while (true);
    }
}
