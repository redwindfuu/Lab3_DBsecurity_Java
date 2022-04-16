package com.app.Util;

import com.app.Constains.SQLConstant;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectSQL {
    public static Connection con;
    public static Connection getConnection( String Url , String username, String password) {
        try {
            Class.forName(SQLConstant.DRIVER);
            con = java.sql.DriverManager.getConnection(Url, username, password);
            if (con != null) {
                System.out.println("Connect to the database successfully!");
            }else {
                showAlertFail();
            }
        }catch (Exception e){
            showAlertFail();
            e.printStackTrace();
        }
        return con;
    }
    public static boolean LoginStatus(String username, String password){
        try {
            Statement stmt = con.createStatement();
            String sql = "EXEC SP_LOGIN_SINHVIEN @TENDN = '"+ username +"', @MATKHAU = '"+ password +"' ;";
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()){
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    private static void showAlertFail() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error alert");
        alert.setContentText("Connect to the database failed!");
        alert.showAndWait();
    }
}
