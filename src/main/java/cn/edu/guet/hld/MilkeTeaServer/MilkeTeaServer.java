package cn.edu.guet.hld.MilkeTeaServer;

import cn.edu.guet.hld.bean.MilkeTea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface MilkeTeaServer {

    public ResultSet ServerSelect(MilkeTea milkeTea) throws SQLException, ClassNotFoundException;

    public String ServerInsert(MilkeTea milkeTea) throws SQLException, ClassNotFoundException;

    public String ServerDelete(MilkeTea milkeTea) throws SQLException, ClassNotFoundException;

    public String ServerUpdate(MilkeTea milkeTea, String name) throws SQLException, ClassNotFoundException;
}
