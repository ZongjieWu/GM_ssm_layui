package com.codegen;

import java.sql.*;

public class DBConn {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false";
    private static String username="root";
    private static String password="root";
    private static Connection conn=null;
    static{
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection openDB()
    {
        try
        {
            if(conn.isClosed())
            {
                conn = DriverManager.getConnection(url,username,password);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public void getTableNameByCon() {
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getTables(null, null, null,
                    new String[]{"TABLE"});
            while (rs.next()) {
                System.out.println("表名：" + rs.getString(3));
                System.out.println("表所属用户名：" + rs.getString(2));
                System.out.println("------------------------------");
            }
            conn.close();
        } catch (Exception e) {
            try {
                conn.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new DBConn().getTableNameByCon();
    }
}
