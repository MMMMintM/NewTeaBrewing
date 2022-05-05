package cn.edu.guet.zt.statistics.dao.impl;

import cn.edu.guet.hld.util.ConnectionHander;
import cn.edu.guet.zt.statistics.bean.OrderInfo;
import cn.edu.guet.zt.statistics.bean.SalesVolume;
import cn.edu.guet.zt.statistics.dao.DailySalesDao;
import cn.edu.guet.zt.statistics.util.SalesConnectionHandler;

import java.sql.*;
import java.util.Date;

import java.util.Date;

public class DailySalesDaoImpl implements DailySalesDao {
    @Override
    public void updateDailySales(OrderInfo orderInfo, Date date) throws SQLException{
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        try {
            conn  = ConnectionHander.getConnection();

            stmt = conn.createStatement();
            String nowDate = date.toString();

            String sql_1 = "SELECT * FROM daily_sales WHERE day = '" + nowDate + "'";

            rs = stmt.executeQuery(sql_1);

            if(!rs.next()){
                String sql = "INSERT INTO daily_sales VALUES (?,?)";
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1,orderInfo.getDate().toString());
                pstmt.setInt(2,orderInfo.getOrder_price());

                pstmt.executeUpdate();
            }else {
                String sql = "UPDATE daily_sales SET sales = Sales + ? WHERE date = ?;";

                pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1,orderInfo.getOrder_price());
                pstmt.setString(2,orderInfo.getDate().toString());

                pstmt.executeUpdate();
            }




        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }

    }
}
