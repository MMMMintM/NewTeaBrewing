package cn.edu.guet.zt.statistics.dao.impl;

import cn.edu.guet.hld.bean.MilkeTea;
import cn.edu.guet.hld.util.ConnectionHander;
import cn.edu.guet.zt.statistics.bean.SalesVolume;
import cn.edu.guet.zt.statistics.dao.SalesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDaoImpl implements SalesDao {
    @Override
    /**
     * 用于item的数据增加
     */
    public void insertSales(MilkeTea milkeTea) throws SQLException{
        Connection conn = null;

        try {
            conn  = ConnectionHander.getConnection();

            String sql = "INSERT INTO sales_volume VALUES (?,?,0,0)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,milkeTea.getId());
            pstmt.setString(2,milkeTea.getTitle());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }


    }

    @Override
    /**
     * 用于item的数据删除
     */
    public void deleteSales(MilkeTea milkeTea) throws SQLException{
        Connection conn = null;

        try {
            conn  = ConnectionHander.getConnection();

            String sql = "DELETE FROM sales_volume WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,milkeTea.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }

    }

    @Override
    /**
     * 用于item的数据修改
     */
    public void updateSale(MilkeTea milkeTea,String name) throws SQLException{
        Connection conn = null;

        try {
            conn  = ConnectionHander.getConnection();

            String sql = "UPDATE item SET id = ?,title = ? WHERE name = ?;";
            String foreignKeySql = "SET foreign_key_checks = 1;";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement fpstmt = conn.prepareStatement(foreignKeySql);

            pstmt.setInt(1,milkeTea.getId());
            pstmt.setString(2,milkeTea.getTitle());
            pstmt.setString(3,name);


            pstmt.executeUpdate();
            fpstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }

    }

    @Override
    /**
     * 用于order_info的数据修改
     */
    public void updateSaleVolume() throws SQLException{

    }
}
