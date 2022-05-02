package cn.edu.guet.zt.statistics.util;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetMonthlySales {
    /**
     * 获取当月销售额
     * @return
     */
    public static String getSales(){
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sales = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        java.util.Date date = new Date(System.currentTimeMillis());

        String sql = "SELECT sales FROM monthly_sales WHERE month = ?;";
        try {
            conn = SalesConnectionHandler.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,simpleDateFormat.format(date));

            rs = pstmt.executeQuery();
            while(rs.next()){
                sales = rs.getString(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }
}
