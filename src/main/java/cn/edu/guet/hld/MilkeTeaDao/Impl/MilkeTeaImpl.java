package cn.edu.guet.hld.MilkeTeaDao.Impl;

import cn.edu.guet.hld.MilkeTeaDao.MilkeTeaDao;
import cn.edu.guet.hld.bean.MilkeTea;
import cn.edu.guet.hld.util.ConnectionHander;

import java.sql.*;

/**
 * 连接mysql数据库
 */
public class MilkeTeaImpl implements MilkeTeaDao {


    @Override
    public ResultSet Select(MilkeTea milkeTea) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(String.valueOf(milkeTea.getId()).equals("0")&&milkeTea.getTitle()==null){
            String sql = "select * from item";

            Connection connection = ConnectionHander.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        }else if (String.valueOf(milkeTea.getId()).equals("0")) {

            String sql = "select * from item where title=?";

            Connection connection = ConnectionHander.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, milkeTea.getTitle());
            resultSet = preparedStatement.executeQuery();

        }else if(milkeTea.getTitle()==null){
            String sql="select * from item where id=?";
            Connection connection = ConnectionHander.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, milkeTea.getId());
            resultSet = preparedStatement.executeQuery();
        } else{
            String sql = "select * from item where id=? AND title=?";

            Connection connection = ConnectionHander.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,milkeTea.getId());
            preparedStatement.setString(2, milkeTea.getTitle());
            resultSet = preparedStatement.executeQuery();
        }
        return resultSet;
    }

    @Override
    public ResultSet Select() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select * from item";
        Connection connection = ConnectionHander.getConnection();

        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        return resultSet;

    }

    @Override
    public String Insert(MilkeTea milkeTea) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        String sql = "insert into item values(?,?,?,?,?,?)";
        int count = 0;
        Connection connection = ConnectionHander.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, milkeTea.getId());
        preparedStatement.setString(2, milkeTea.getTitle());
        preparedStatement.setFloat(3, milkeTea.getPrice());
        preparedStatement.setString(4, milkeTea.getDescription());
        preparedStatement.setInt(5, milkeTea.getSales());
        preparedStatement.setString(6, milkeTea.getImg_url());

        count = preparedStatement.executeUpdate();

        return count > 0 ? "添加成功" : "添加失败";
    }

    @Override
    public String Delete(String name) throws SQLException, ClassNotFoundException {
        String sql = "delete from item where name=?";
        Connection connection = ConnectionHander.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        int count = preparedStatement.executeUpdate();
        return count > 0 ? "删除成功" : "删除失败";
    }

    @Override
    public String UnDate(MilkeTea milkeTea, String name) throws SQLException, ClassNotFoundException {
        String sql = "update item set id=?,title=?,price=?,description=?,sales=?,img_url=? where name=?";
        Connection connection = ConnectionHander.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, milkeTea.getId());
        preparedStatement.setString(2, milkeTea.getTitle());
        preparedStatement.setFloat(3, milkeTea.getPrice());
        preparedStatement.setString(4, milkeTea.getDescription());
        preparedStatement.setInt(5, milkeTea.getSales());
        preparedStatement.setString(6, milkeTea.getImg_url());
        preparedStatement.setString(7, name);

        int count = preparedStatement.executeUpdate();

        return count > 0 ? "更新成功" : "更新失败";
    }
}
