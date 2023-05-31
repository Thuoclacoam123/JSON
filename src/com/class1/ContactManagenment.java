package com.class1;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ContactManagenment {
    Scanner input = new Scanner(System.in);
    public void addContact() throws Exception{
        try {
            Contact contact = new Contact();
            contact.inputData();
            Connection connection = DBUtil.getConnection();
            PreparedStatement ptsm = connection.prepareStatement("insert into Address(Name, Company, Email, Phone) values (?, ?, ?, ?)");
            //
            ptsm.setString(1,contact.name);
            ptsm.setString(2,contact.company);
            ptsm.setString(3,contact.email);
            ptsm.setString(4,contact.phone);

            if (ptsm.executeUpdate()>0){
                System.out.println("contact added!");

            }
            ptsm.close();
            connection.close();

        }catch (Exception e){

        }
    }
    public void  findContactByName(){
        System.out.println("find contact by name");
       try {
           System.out.print("enter name to find: ");
           String kName = input.nextLine();
           Connection connection = DBUtil.getConnection();

           PreparedStatement ptsm = connection.prepareStatement("SELECT * from Address WHERE name = ?");
           ptsm.setString(1,kName);
           ResultSet resultSet = ptsm.executeQuery();
           if (resultSet.next()){
               Contact contact = new Contact(
                       resultSet.getString(2),
                       resultSet.getString(3),
                       resultSet.getString(4),
                       resultSet.getString(5)

               );
               System.out.println("Contact found:");
               System.out.printf("");
               contact.display();
           }else {
               System.out.println("contact not found!");
           }
           ptsm.close();
           connection.close();
        }catch (Exception e){

       }
    }

    public void displayContact(){
        System.out.println(" Diplay contact");
      try {
          Connection connection = DBUtil.getConnection();
          PreparedStatement ptsm = connection.prepareStatement("SELECT * from Address");
          ResultSet resultSet = ptsm.executeQuery();
          while (resultSet.next()){
              Contact contact = new Contact(
                      resultSet.getString(1),
                      resultSet.getString(2),
                      resultSet.getString(3),
                      resultSet.getString(4)

              );
              contact.display();
          }
          ptsm.close();
          connection.close();
      }catch (Exception e){

      }
    }
    public Contact checkNull(Contact contact) throws Exception{
        if (contact.getName()== null){
            throw new Exception("Name is empty,can not add contact!");
        }else {
            return contact;
        }
    }

}
