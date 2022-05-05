package cn.edu.guet.zt.statistics.dao;

import cn.edu.guet.zt.statistics.bean.OrderInfo;
import cn.edu.guet.zt.statistics.bean.SalesVolume;
import java.util.Date;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public interface DailySalesDao {
    /**
     * 此接口提供表daily_Sales跟随表sales_volum变动而变动的方法
     */
    void updateDailySales(OrderInfo orderInfo, Date date) throws SQLException;


}
