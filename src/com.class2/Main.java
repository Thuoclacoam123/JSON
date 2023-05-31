package com.class2;

public class Main {
    public static void main(String[] args) {
        try {
            ProductManagement productManagement = new ProductManagement();
//            Chạy hàm đọc json
//           productManagement.readJSONFromAPI();
//            Chạy hàm insert database
//            productManagement.insertDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
