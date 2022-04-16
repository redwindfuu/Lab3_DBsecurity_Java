package com.app.Constains;

public class SQLConstant {
    private static final String DBName = "QLSV";
    private static final String User = "sa";
    private static final String Pass = "1234";
    private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String URL = "jdbc:sqlserver://localhost:1433;database="+DBName+";encrypt=true;trustServerCertificate=true";
    public static String USER = User;
    public static String PASS = Pass;
    public static final String DRIVER = Driver;

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        SQLConstant.URL = URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        SQLConstant.USER = USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static void setPASS(String PASS) {
        SQLConstant.PASS = PASS;
    }
}

