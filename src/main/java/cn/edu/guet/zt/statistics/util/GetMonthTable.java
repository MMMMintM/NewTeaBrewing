package cn.edu.guet.zt.statistics.util;

import cn.edu.guet.zt.statistics.bean.DailySales;
import cn.edu.guet.zt.statistics.bean.MonthlySales;
import cn.juntai.wxpaydemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetMonthTable {
    /**
     *用于获取数据库表monthly_sales的数据
     */
    public static Object[][] queryDate(String sql,Object[][] data, String head[]){
        java.util.List<MonthlySales> list= new ArrayList<MonthlySales>();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                MonthlySales ms = new MonthlySales();
                ms.setMonth(rs.getString(1));
                ms.setSales(rs.getInt(2));
                list.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }/*finally {
            try {
                if(sql.equals("SELECT * FROM sales_volume")){
                    rs.close();
                    stmt.close();
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/

        data = new Object[list.size()][head.length];

        for(int i = 0;i < list.size();i++)
            for(int j = 0;j < head.length;j ++)
            {
                data[i][0] = list.get(i).getMonth();
                data[i][1] = list.get(i).getSales();
            }

        return data;
    }

}
