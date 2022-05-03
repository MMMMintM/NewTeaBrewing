package cn.edu.guet.zt.statistics.dao;

import cn.edu.guet.zt.statistics.bean.SalesVolume;

public interface MonthlySalesDao {
    /**
     * 此接口提供表monthly_Sales跟随表sales_volum变动而变动的方法
     */
    void updateMonthlySales(SalesVolume salesVolume);
}
