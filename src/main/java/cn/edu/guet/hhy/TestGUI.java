package cn.edu.guet.hhy;

import cn.edu.guet.hld.bean.MilkeTea;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import java.util.ArrayList;

public class TestGUI {

    public String[][] InittestGui() {

        JFrame f = new JFrame("购物清单");
        f.setSize(800, 900);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
        String[][] milkeTeaCar = new String[30][4];
        String[] columnNames = new String[] { "商品id", "名称", "单价", "数量" };
        for (int i = 0; i < list.milkeTeaAndNumbers.size(); i++) {
                String id = String.valueOf(list.milkeTeaAndNumbers.get(i).getId());
                String title = list.milkeTeaAndNumbers.get(i).getTitle();
                String prices = String.valueOf(list.milkeTeaAndNumbers.get(i).getPrice());
                String number = String.valueOf(list.milkeTeaAndNumbers.get(i).getNumber());
                milkeTeaCar[i][0] = id;
                milkeTeaCar[i][1] = title;
                milkeTeaCar[i][2] = prices;
                milkeTeaCar[i][3] = number;
        }
        return milkeTeaCar;
//        JTable table = new JTable(milkeTeaCar, columnNames);
//        table.setPreferredScrollableViewportSize(new Dimension(300, 400));
//
//        JScrollPane sp = new JScrollPane(table);
//
//        // 设置列宽度
//        table.getColumnModel().getColumn(0).setPreferredWidth(10);
//
//        f.add(sp, BorderLayout.CENTER);
//
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        f.setVisible(true);
    }

}
