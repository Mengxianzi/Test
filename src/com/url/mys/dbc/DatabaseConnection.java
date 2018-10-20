package com.url.mys.dbc;
import java.sql.*;

public class DatabaseConnection {
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String Url = "jdbc:mysql://localhost:3306/link";
    private static final String User = "root";
    private static final String Password = "root";
    private Connection conn;

    /**
     * 初始化连接
     */
    public DatabaseConnection(){
        try {
            Class.forName(Driver);
            this.conn = DriverManager.getConnection(Url,User,Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接对象
     * @return Connection连接对象
     */
    public Connection getConnection() {
        return this.conn;
    }

    /**
     * 关闭连接
     */
    public void close(){
        if(this.conn!=null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
