package com.example.wifi_info_in_korea.DB;

import com.example.wifi_info_in_korea.dto.Row;
import com.example.wifi_info_in_korea.dto.TableRow;

import java.sql.*;

public class DBHandler {

    String url = "jdbc:mariadb://192.168.2.11:3306/mission1";
    String dbUserId = "mission1_user";
    String dbPassword = "1234";

    public void wifiInfoInsert(Row rowdata) {
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

        String X_SWIFI_MGR_NO = rowdata.getX_SWIFI_MGR_NO();
        String X_SWIFI_WRDOFC = rowdata.getX_SWIFI_WRDOFC();
        String X_SWIFI_MAIN_NM = rowdata.getX_SWIFI_MAIN_NM();
        String X_SWIFI_ADRES1 = rowdata.getX_SWIFI_ADRES1();
        String X_SWIFI_ADRES2 = rowdata.getX_SWIFI_ADRES2();
        String X_SWIFI_INSTL_FLOOR = rowdata.getX_SWIFI_INSTL_FLOOR();
        String X_SWIFI_INSTL_TY = rowdata.getX_SWIFI_INSTL_TY();
        String X_SWIFI_INSTL_MBY = rowdata.getX_SWIFI_INSTL_MBY();
        String X_SWIFI_SVC_SE = rowdata.getX_SWIFI_SVC_SE();
        String X_SWIFI_CMCWR = rowdata.getX_SWIFI_CMCWR();
        String X_SWIFI_CNSTC_YEAR = rowdata.getX_SWIFI_CNSTC_YEAR();
        String X_SWIFI_INOUT_DOOR = rowdata.getX_SWIFI_INOUT_DOOR();
        String X_SWIFI_REMARS3 = rowdata.getX_SWIFI_REMARS3();
        String LAT = rowdata.getLAT();
        String LNT = rowdata.getLNT();
        String WORK_DTTM = rowdata.getWORK_DTTM();

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            statement = connection.createStatement();

            String sql = "insert into data (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM,\n" +
                    "X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR,\n" +
                    "X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE,\n" +
                    "X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR,\n" +
                    "X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM) \n" +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, X_SWIFI_MGR_NO);
            preparedStatement.setString(2, X_SWIFI_WRDOFC);
            preparedStatement.setString(3, X_SWIFI_MAIN_NM);
            preparedStatement.setString(4, X_SWIFI_ADRES1);
            preparedStatement.setString(5, X_SWIFI_ADRES2);
            preparedStatement.setString(6, X_SWIFI_INSTL_FLOOR);
            preparedStatement.setString(7, X_SWIFI_INSTL_TY);
            preparedStatement.setString(8, X_SWIFI_INSTL_MBY);
            preparedStatement.setString(9, X_SWIFI_SVC_SE);
            preparedStatement.setString(10, X_SWIFI_CMCWR);
            preparedStatement.setString(11, X_SWIFI_CNSTC_YEAR);
            preparedStatement.setString(12, X_SWIFI_INOUT_DOOR);
            preparedStatement.setString(13, X_SWIFI_REMARS3);
            preparedStatement.setString(14, LAT);
            preparedStatement.setString(15, LNT);
            preparedStatement.setString(16, WORK_DTTM);

            int affected = preparedStatement.executeUpdate();

            if(affected>0){
                System.out.println(" wifi_info 저장 성공 ");
            }
            else{
                System.out.println(" 저장 실패 ");
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
    
    public void wifiInfoDeleteAll() {
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

            String sql = "DELETE FROM data";

            preparedStatement = connection.prepareStatement(sql);

            int affected = preparedStatement.executeUpdate();

            if(affected>0){
                System.out.println(" wifi_info 모든 데이터 삭제 성공 ");
            }
            else{
                System.out.println(" wifi_info 모든 데이터 삭제 실패 ");
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

    public int countWifiInfo() {
        int ret = 0;
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

            String sql = "select count(*) as count from data";

            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                ret = rs.getInt("count");
            }

            rs.close();

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
        return ret;
    }

    public TableRow[] wifi_table_dbSelect(double lat, double lnt) {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        TableRow[] rowArr = new TableRow[20];

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            statement = connection.createStatement();

            String sql = "SELECT *, SQRT(POW(CAST(LAT AS DOUBLE) - ?, 2) + POW(CAST(LNT AS DOUBLE) - ?, 2)) AS DISTANCE " +
                    "FROM data " +
                    "ORDER BY DISTANCE " +
                    "LIMIT 20";

            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, lat);
            preparedStatement.setDouble(2, lnt);


            rs = preparedStatement.executeQuery();

            int index = 0;

            while(rs.next()){
                String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
                String LAT = rs.getString("LAT");
                String LNT = rs.getString("LNT");
                String WORK_DTTM = rs.getString("WORK_DTTM");
                String DISTANCE = rs.getString("DISTANCE");
                rowArr[index] = new TableRow(
                        X_SWIFI_MGR_NO,
                        X_SWIFI_WRDOFC,
                        X_SWIFI_MAIN_NM,
                        X_SWIFI_ADRES1,
                        X_SWIFI_ADRES2,
                        X_SWIFI_INSTL_FLOOR,
                        X_SWIFI_INSTL_TY,
                        X_SWIFI_INSTL_MBY,
                        X_SWIFI_SVC_SE,
                        X_SWIFI_CMCWR,
                        X_SWIFI_CNSTC_YEAR,
                        X_SWIFI_INOUT_DOOR,
                        X_SWIFI_REMARS3,
                        LAT,
                        LNT,
                        WORK_DTTM,
                        DISTANCE
                );
                index++;
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

        return rowArr;
    }
}
