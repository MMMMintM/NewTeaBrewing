package cn.edu.guet.zt.statistics.dao;

import cn.edu.guet.zt.statistics.bean.OrderInfo;
import cn.edu.guet.zt.statistics.bean.SalesVolume;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Date;

public interface MonthlySalesDao {
    /**
     * 此接口提供表monthly_Sales跟随表sales_volum变动而变动的方法
     */
    void updateMonthlySales(OrderInfo orderInfo, Date date) throws SQLException;
}
