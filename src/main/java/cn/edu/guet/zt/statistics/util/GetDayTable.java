package cn.edu.guet.zt.statistics.util;

import cn.edu.guet.zt.statistics.bean.DailySales;
import cn.edu.guet.zt.statistics.bean.SalesVolume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetDayTable {
    /**
     *用于获取数据库表daily_sales的数据
     */
    public static Object[][] queryDate(String sql,Object[][] data, String head[]){
        java.util.List<DailySales> list= new ArrayList<DailySales>();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = SalesConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                DailySales ds = new DailySales();
                ds.setDay(rs.getString(1));
                ds.setSales(rs.getInt(2));
                list.add(ds);
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
                data[i][0] = list.get(i).getDay();
                data[i][1] = list.get(i).getSales();
            }

        return data;
    }

}
