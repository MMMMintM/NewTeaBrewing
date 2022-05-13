package cn.edu.guet.zt.manager.util;

import cn.edu.guet.zt.manager.bean.Item;
import cn.juntai.wxpaydemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetItemTable {
    public static Object[][] queryDate(Object[][] data,String head[]){
        java.util.List<Item> list = new ArrayList<Item>();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM item";

        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setTitle(rs.getString(2));
                item.setPrice(rs.getInt(3));
                item.setDes(rs.getString(4));
                item.setSales(rs.getInt(5));
                item.setImgUrl(rs.getString(6));
                list.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        data = new Object[list.size()][head.length];

        for (int i = 0;i < list.size();i ++)
            for(int j = 0;j < head.length;j ++){
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getTitle();
                data[i][2] = list.get(i).getPrice();
                data[i][3] = list.get(i).getDes();
                data[i][4] = list.get(i).getSales();
                data[i][5] = list.get(i).getImgUrl();
            }
        return data;
    }
}
