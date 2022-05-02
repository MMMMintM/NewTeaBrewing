package cn.edu.guet.hld.MilkeTeaServer.Impl;

import cn.edu.guet.hld.MilkeTeaDao.Impl.MilkeTeaImpl;
import cn.edu.guet.hld.MilkeTeaDao.MilkeTeaDao;
import cn.edu.guet.hld.MilkeTeaServer.MilkeTeaServer;
import cn.edu.guet.hld.bean.MilkeTea;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MilkeTeaServerImpl implements MilkeTeaServer {

    @Override
    public ResultSet ServerSelect(MilkeTea milkeTea) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        MilkeTeaDao milkeTeaDao = new MilkeTeaImpl();

        if (milkeTea.getTitle() == null && String.valueOf(milkeTea.getId()) == null) {
            resultSet = milkeTeaDao.Select();
        } else {
            resultSet = milkeTeaDao.Select(milkeTea);
        }
        return resultSet;
    }

    @Override
    public String ServerInsert(MilkeTea milkeTea) throws SQLException, ClassNotFoundException {

        String results = null;
        MilkeTeaDao milkeTeaDao = new MilkeTeaImpl();

        results = milkeTeaDao.Insert(milkeTea);//操作返回是否成功

        return results;
    }

    @Override
    public String ServerDelete(MilkeTea milkeTea) throws SQLException, ClassNotFoundException {
        String results = null;
        MilkeTeaDao milkeTeaDao = new MilkeTeaImpl();
        results = milkeTeaDao.Delete(milkeTea.getTitle());

        return results;
    }

    @Override
    public String ServerUpdate(MilkeTea milkeTea, String name) throws SQLException, ClassNotFoundException {


        String results = null;
        MilkeTeaDao milkeTeaDao = new MilkeTeaImpl();

        results = milkeTeaDao.UnDate(milkeTea, name);

        return results;
    }
}