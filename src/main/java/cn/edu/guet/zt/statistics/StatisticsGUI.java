/*
 * Created by JFormDesigner on Fri Apr 29 19:52:01 CST 2022
 */

package cn.edu.guet.zt.statistics;

import cn.edu.guet.hld.MilkeTeaServer.Impl.MilkeTeaServerImpl;
import cn.edu.guet.hld.MilkeTeaServer.MilkeTeaServer;
import cn.edu.guet.hld.bean.MilkeTea;
import cn.edu.guet.zt.statistics.util.*;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * 销量统计
 * 此类用于显示销量统计界面
 */
public class StatisticsGUI extends JFrame {
    public StatisticsGUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button3 = new JButton();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();

        GetTable getTable = new GetTable();

        DefaultTableModel tableModel = new DefaultTableModel(GetTable.queryDate(sql[0],data,head[0]),head[0]){
            public boolean isCellEditable(int row,int colume){
                return false;
            }
        };

        table1.setModel(tableModel);

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(210, 30, 480, 375);

        //---- label1 ----
        label1.setText("排序方式");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(10, 10), label1.getPreferredSize()));

        //---- button1 ----
        button1.setText("销售量");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 35), button1.getPreferredSize()));
        button1.addActionListener(
                e->{
                    table1.setModel(ResetTable.reset(GetTable.queryDate(sql[1],data,head[0]),head[0]));
                }
        );

        //---- button2 ----
        button2.setText("销售额");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(40, 75), button2.getPreferredSize()));
        button2.addActionListener(
                e->{
                    table1.setModel(ResetTable.reset(GetTable.queryDate(sql[2],data,head[0]),head[0]));
                }
        );

        //---- label2 ----
        label2.setText("索引");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(10, 220), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("商品ID：");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 255), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("商品名称");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(20, 295), label4.getPreferredSize()));

        contentPane.add(textField1);
        textField1.setBounds(85, 255, 105, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(85, 295, 105, textField2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("查询");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(65, 355), button3.getPreferredSize()));
        button3.addActionListener(
                e -> {
                    String ID = textField1.getText();
                    String name = textField2.getText();
                    String sql = "SELECT * FROM sales_volume WHERE INSTR(id,'" +
                            ID +
                            "')<>0 AND INSTR(title,'" +
                            name +
                            "') <> 0;";
                    table1.setModel(ResetTable.reset(GetTable.queryDate(sql,data,head[0]),head[0]));
                }
        );


        //---- label5 ----
        label5.setText("总销售额：" + GetTotalSales.getSales());
        contentPane.add(label5);
        label5.setBounds(560, 430, 120, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("当日销售额：" + GetDailySales.getSales());
        contentPane.add(label6);
        label6.setBounds(210, 430, 120, label6.getPreferredSize().height);

        //---- label7 ----
        label7.setText("当月销售额：" + GetMonthlySales.getSales());
        contentPane.add(label7);
        label7.setBounds(375, 430, 120, label7.getPreferredSize().height);

        //---- button4 ----
        button4.setText("刷新");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(5, 450), button4.getPreferredSize()));
        button4.addActionListener(
                e -> {
                    table1.setModel(ResetTable.reset(GetTable.queryDate(sql[0],data,head[0]),head[0]));
                }
        );

        //-----buttion5------
        button5.setText("往日销售额");
        contentPane.add(button5);
        button5.setBounds(210,450,100,26);
        button5.addActionListener(
                e ->{
                    table1.setModel(ResetTable.reset(GetDayTable.queryDate(sql[3],data,head[1]),head[1]));

                }
        );

        //-----button6-------
        button6.setText("往月销售额");
        contentPane.add(button6);
        button6.setBounds(375,450,100,26);
        button6.addActionListener(
                e ->{
                    table1.setModel(ResetTable.reset(GetMonthTable.queryDate(sql[4],data,head[2]),head[2]));
                }
        );

        contentPane.setPreferredSize(new Dimension(695, 520));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button3;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private Object[][] data = null;
    private String head[][] = {
            {"商品ID","商品名称","销售量","销售额","更新时间"},
            {"日期","销售额"},
            {"月份","销售额"}
    };
    private String sql[] = {
            "SELECT * FROM sales_volume;",
            "SELECT * FROM sales_volume ORDER BY volume DESC;",
            "SELECT * FROM sales_volume ORDER BY total_sales DESC;",
            "SELECT * FROM daily_sales;",
            "SELECT * FROM monthly_sales"
    };

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new StatisticsGUI();
    }
}
