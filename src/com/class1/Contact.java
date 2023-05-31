package com.class1;

import java.util.Scanner;

public class Contact {

    String name;
    String company;
    String email;
    String phone;
    public Contact(String name,String company,String email, String phone){
        this.name=name;
        this.company=company;
        this.email=email;
        this.phone=phone;

    }
    public Contact(){}

    Scanner input = new Scanner(System.in);

    public void inputData(){
        System.out.print("Enter name:");
        name = input.nextLine();

        System.out.print("Enter company:");
        name = input.nextLine();
        System.out.print("Enter email:");
        name = input.nextLine();
        System.out.print("Enter phone:");
        phone = input.nextLine();


    }
    public  void display(){
        System.out.println(name + ", " + company + ", " + email +", " + phone);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
