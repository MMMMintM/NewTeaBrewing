package cn.edu.guet.zt.statistics.util;

import cn.edu.guet.zt.statistics.bean.SalesVolume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetTable {
    /**
     * 此类用于获得数据库的数据
     */
    public GetTable(){

    }

    public static Object[][] queryDate(String sql,Object[][] data, String head[]){
        java.util.List<SalesVolume> list= new ArrayList<SalesVolume>();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = SalesConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                SalesVolume sv = new SalesVolume();
                sv.setId(rs.getInt(1));
                sv.setTitle(rs.getString(2));
                sv.setVolume(rs.getInt(3));
                sv.setTotal_sales(rs.getInt(4));
                sv.setUpdate_time(rs.getTime(5));
                list.add(sv);
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
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getTitle();
                data[i][2] = list.get(i).getVolume();
                data[i][3] = list.get(i).getTotal_sales();
                data[i][4] = list.get(i).getUpdate_time();

            }

        return data;
    }


}
