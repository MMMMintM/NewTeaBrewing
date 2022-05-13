package cn.edu.guet.hhy.util;

import cn.edu.guet.hld.MilkeTeaDao.Impl.MilkeTeaImpl;
import cn.edu.guet.hld.MilkeTeaDao.MilkeTeaDao;
import cn.edu.guet.hld.bean.MilkeTea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MilkeTeaData {
    public List<MilkeTea> AllMilkeTeaData() throws SQLException, ClassNotFoundException {
        MilkeTeaDao milkeTeaDao = new MilkeTeaImpl();
        ResultSet resultSet = milkeTeaDao.Select();
        List<MilkeTea> milkeTeaList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            float price = resultSet.getFloat(3);
            String description = resultSet.getString(4);
            int sales = resultSet.getInt(5);
            String img_url = resultSet.getString(6);
            MilkeTea milkeTea = new MilkeTea();
            milkeTea.setId(id);
            milkeTea.setTitle(title);
            milkeTea.setDescription(description);
            milkeTea.setPrice(price);
            milkeTea.setSales(sales);
            milkeTea.setImg_url(img_url);
            milkeTeaList.add(milkeTea);
        }

//        for (int i = 0; i < milkeTeaList.size(); i++) {
//            System.out.println(milkeTeaList.get(i).toString());
//        }
        return milkeTeaList;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MilkeTeaData milkeTeaData = new MilkeTeaData();

    }
}
