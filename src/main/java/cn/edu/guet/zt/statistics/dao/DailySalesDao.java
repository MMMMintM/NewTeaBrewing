package cn.edu.guet.zt.statistics.dao;

import cn.edu.guet.zt.statistics.bean.SalesVolume;

public interface DailySalesDao {
    /**
     * 此接口提供表daily_Sales跟随表sales_volum变动而变动的方法
     */
    void updateDailySales(SalesVolume salesVolume);


}
