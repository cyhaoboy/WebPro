package com.example.test.JDBCUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static Connection conn = null;
    private static DataSource ds ;
    static {
        //加载配置文件和建立连接池
        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){

        return ds;
    }
    public static Connection getConn() {
        try {
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }

    public static void closeCon() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

}

//
//
//
//    public Connection getconnection() throws SQLException {
//        return ds.getConnection();
//
//    }



//    public static void close(Connection conn, ResultSet res, PreparedStatement pstmt){
//        if (conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (res!=null){
//            try {
//                res.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (pstmt!=null){
//            try {
//                pstmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public void closeCon(){
//        if (conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (pstmt!=null){
//            try {
//                pstmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
