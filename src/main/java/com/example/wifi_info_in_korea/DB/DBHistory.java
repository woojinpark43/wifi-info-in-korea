package com.example.wifi_info_in_korea.DB;

import com.example.wifi_info_in_korea.dto.HistoryTableRow;

import java.sql.*;
import java.util.ArrayList;

public class DBHistory {

    String url = "jdbc:mariadb://192.168.2.11:3306/mission1";
    String dbUserId = "mission1_user";
    String dbPassword = "1234";

    public void deleteRow(String id) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            statement = connection.createStatement();

            String sql = " delete from history where ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            int affected = preparedStatement.executeUpdate();

            if(affected>0){
                System.out.println("  삭제 성공 ");
            }
            else{
                System.out.println(" 삭제 실패 ");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(statement != null && !statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public ArrayList<HistoryTableRow> selectRow() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        ArrayList<HistoryTableRow> arrayList = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            statement = connection.createStatement();

            String sql = "SELECT * FROM history";

            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);


            rs = preparedStatement.executeQuery();

            while(rs.next()){
                String ID = rs.getString("ID");
                String X = rs.getString("X");
                String Y = rs.getString("Y");
                String DATE = rs.getString("DATE");

                arrayList.add(new HistoryTableRow(ID,X,Y,DATE));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(statement != null && !statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return arrayList;
    }

    public void addRow(HistoryTableRow rowdata) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String X = rowdata.getX();
        String Y = rowdata.getY();
        String DATE = rowdata.getDATE();

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            statement = connection.createStatement();

            String sql = "insert into history (X, Y, DATE) values(?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, X);
            preparedStatement.setString(2, Y);
            preparedStatement.setString(3, DATE);

            int affected = preparedStatement.executeUpdate();

            if(affected>0){
                System.out.println(" add row ");
            }
            else{
                System.out.println(" add row fail ");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(statement != null && !statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
