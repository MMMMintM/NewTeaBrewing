package cn.edu.guet.hzr.util;

import cn.edu.guet.hzr.bean.NewOrderInfo;
import cn.edu.guet.zt.statistics.bean.SalesVolume;
import cn.juntai.wxpaydemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetOrderInfoTable {
    /**
     * 此类用于获得数据库的数据
     */
    public static Object[][] queryDate(String sql,Object[][] data, String head[]){
        java.util.List<NewOrderInfo> list= new ArrayList<NewOrderInfo>();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                NewOrderInfo newOrderInfo = new NewOrderInfo();
                newOrderInfo.setID(rs.getString(1));
                newOrderInfo.setOutTradeNo(rs.getString(2));
                newOrderInfo.setCustomerID(rs.getInt(3));
                newOrderInfo.setOrderTime(rs.getDate(4));
                newOrderInfo.setTransactionID(rs.getString(5));
                newOrderInfo.setUserID(rs.getInt(6));
                newOrderInfo.setItemID(rs.getInt(7));
                newOrderInfo.setItemPrice(rs.getInt(8));
                newOrderInfo.setAmount(rs.getInt(9));
                newOrderInfo.setOrderPrice(rs.getInt(10));

                list.add(newOrderInfo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        data = new Object[list.size()][head.length];

        for(int i = 0;i < list.size();i++)
            for(int j = 0;j < head.length;j ++)
            {
                data[i][0] = list.get(i).getID();
                data[i][1] = list.get(i).getOutTradeNo();
                data[i][2] = list.get(i).getCustomerID();
                data[i][3] = list.get(i).getOrderTime();
                data[i][4] = list.get(i).getTransactionID();
                data[i][5] = list.get(i).getUserID();
                data[i][6] = list.get(i).getItemID();
                data[i][7] = list.get(i).getItemPrice();
                data[i][8] = list.get(i).getAmount();
                data[i][9] = list.get(i).getOrderPrice();
            }

        return data;
    }


}
