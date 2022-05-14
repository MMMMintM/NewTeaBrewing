package cn.edu.guet.sjl.util;

import cn.edu.guet.sjl.bean.MS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GETDATA {
    /**
     *用于获取数据库表daily_sales的数据
     */
    public static Object[][] queryDate(String sql,Object[][] data, String head[]){
        java.util.List<MS> list= new ArrayList<MS>();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                MS ds = new MS();
                ds.setId(rs.getInt(1));
                ds.setuser_id(rs.getInt(6));
                ds.setorder_time(rs.getString(4));
                ds.setamount(rs.getInt(9));
                ds.setorder_price(rs.getInt(10));
                //ds.settransaction_id(rs.getInt(5));
                list.add(ds);
            }
        } catch (SQLException e) {
            e.printStackTrace();}
        /*finally {
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
//        data = new Object[5][head.length];
        for(int i = 0;i < list.size();i++)
            for(int j = 0;j < head.length;j ++)
            {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getorder_price();
                data[i][2] = list.get(i).getamount();
                data[i][3] = list.get(i).getorder_time();
                data[i][4] = list.get(i).getorder_price();

            }

        return data;
    }

}