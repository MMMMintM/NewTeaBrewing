package cn.edu.guet.zt.statistics.dao;

import cn.edu.guet.hld.bean.MilkeTea;
import cn.edu.guet.zt.statistics.bean.SalesVolume;

import java.sql.SQLException;

public interface SalesDao {
    /**
     * 此接口提供表sales_volume的分别因表item及表order_info变动而变动的增加，删除和修改方法
     */
    void insertSales(MilkeTea milkeTea) throws SQLException;

    void deleteSales(MilkeTea milkeTea) throws SQLException;

    void updateSale(MilkeTea milkeTea,String name) throws SQLException;

    void updateSaleVolume() throws SQLException;

}
