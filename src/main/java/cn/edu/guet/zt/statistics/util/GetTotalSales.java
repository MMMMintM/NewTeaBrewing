package cn.edu.guet.zt.statistics.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTotalSales {
    /**
     * 此类用于获得销售总额
     */
    public static String getSales(){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sales = null;
        String sql = "SELECT SUM(total_sales) FROM sales_volume;";
        try {
            conn = SalesConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                sales = rs.getString(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }
}
