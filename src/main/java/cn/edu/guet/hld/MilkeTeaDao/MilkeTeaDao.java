package cn.edu.guet.hld.MilkeTeaDao;

import cn.edu.guet.hld.bean.MilkeTea;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface MilkeTeaDao {
    public ResultSet Select(MilkeTea milkeTea) throws SQLException, ClassNotFoundException;
    public ResultSet Select() throws SQLException, ClassNotFoundException;
    public String Insert(MilkeTea milkeTea) throws SQLException, ClassNotFoundException;
    public String Delete(String name) throws SQLException, ClassNotFoundException;
    public String UnDate(MilkeTea milkeTea,String name) throws SQLException, ClassNotFoundException;
}
