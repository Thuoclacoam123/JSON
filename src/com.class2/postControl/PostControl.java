package com.class2.postControl;

import com.class2.DBUtil.DBUtil;
import com.class2.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PostControl {
    String INSERT = "INSERT INTO post VALUES(?,?,?,?)";

    public boolean insertNewPost(Post post)throws Exception{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DBUtil.getConnection();
            preparedStatement = conn.prepareStatement(INSERT);

            preparedStatement.setInt(1,post.getId());
            preparedStatement.setInt(2,post.getUserId());
            preparedStatement.setString(3,post.getTitle());
            preparedStatement.setString(4,post.getBody());

            return (preparedStatement.executeUpdate() >0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                preparedStatement.close();
                conn.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
