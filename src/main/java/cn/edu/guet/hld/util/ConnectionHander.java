package cn.edu.guet.hld.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHander {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();

        if (connection == null) {


            String url = "jdbc:mysql://@123.57.42.220:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String sqlUserName = "root";
            String sqlPassword = "LYHWYZZNSB.wan1/";
            connection = DriverManager.getConnection(url, sqlUserName, sqlPassword);

            connection.setAutoCommit(false);
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void colseConnectoin() {

        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        threadLocal.remove();
    }


}
