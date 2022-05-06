package cn.edu.guet.zt.statistics.dao.impl;

import cn.edu.guet.zt.statistics.bean.OrderInfo;
import cn.edu.guet.zt.statistics.bean.SalesVolume;
import cn.edu.guet.zt.statistics.dao.MonthlySalesDao;
import cn.edu.guet.zt.statistics.util.SalesConnectionHandler;

import java.sql.*;

public class MonthlySalesDaoImpl implements MonthlySalesDao {
    @Override
    public void updateMonthlySales(OrderInfo orderInfo, java.util.Date date) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        try {
            conn = SalesConnectionHandler.getConnection();

            stmt = conn.createStatement();
            String nowMonth = date.toString().substring(0,7);

            String sql_1 = "SELECT * FROM monthly_sales WHERE day = '" + nowMonth + "'";

            rs = stmt.executeQuery(sql_1);

            if(!rs.next()){
                String sql = "INSERT INTO monthly VALUES (?,?)";
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1,orderInfo.getDate().toString().substring(0,7));
                pstmt.setInt(2,orderInfo.getOrder_price());

                pstmt.executeUpdate();
            }else {
                String sql = "UPDATE daily_sales SET sales = Sales + ? WHERE date = ?;";

                pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1,orderInfo.getOrder_price());
                pstmt.setString(2,orderInfo.getDate().toString().substring(0,7));

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }
}
