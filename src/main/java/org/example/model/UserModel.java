package org.example.model;


import org.example.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public boolean register(String userName, String pass ,String profileURL) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO user (userName,password,profilePicUrl) VALUES(?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, pass);
        pstm.setString(3, profileURL);
        return pstm.executeUpdate() > 0;
    }
    public boolean exists (String userName) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE userName = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userName);
        return pstm.executeQuery().next();
    }
    public boolean login(String userName, String pass) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, pass);
        return pstm.executeQuery().next();
    }
    public ResultSet getImageURL(String userName) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT profilePicUrl FROM user WHERE userName = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userName);
        return pstm.executeQuery();
    }
}
