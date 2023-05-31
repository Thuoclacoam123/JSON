package com.class2;

import com.class2.model.Post;
import com.class2.postControl.PostControl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductManagement {
    String apiUrl = "https://jsonplaceholder.typicode.com/posts";
    public void readJSONFromAPI() throws Exception {
        try {
            URL url = new URL(apiUrl);

            // Create connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

//            System.out.println(response.toString());

            Product products = new Product();
            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject product
                        = (org.json.JSONObject) jsonArray.get(i);
                products.setUserId(Integer.parseInt(product.get("userId").toString()));
                products.setId(Integer.parseInt(product.get("id").toString()));
                products.setTitle(product.get("title").toString());
                products.setBody(product.get("body").toString());

                System.out.println(products.toString());

            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    public void insertDB() throws Exception {
        PostControl postControl = new PostControl();
        try {
            URL url = new URL(apiUrl);

            // Create connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject product
                        = (org.json.JSONObject) jsonArray.get(i);

                Post post = new Post(
                        Integer.parseInt(product.get("id").toString()),
                        Integer.parseInt(product.get("userId").toString()),
                        product.get("title").toString(),
                        product.get("body").toString()
                );
                System.out.println("Inserting.......");
                postControl.insertNewPost(post);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
