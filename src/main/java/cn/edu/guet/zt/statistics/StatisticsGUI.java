/*
 * Created by JFormDesigner on Fri Apr 29 19:52:01 CST 2022
 */

package cn.edu.guet.zt.statistics;

import cn.edu.guet.hld.MilkeTeaServer.Impl.MilkeTeaServerImpl;
import cn.edu.guet.hld.MilkeTeaServer.MilkeTeaServer;
import cn.edu.guet.hld.bean.MilkeTea;
import cn.edu.guet.zt.statistics.util.GetTable;

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
        button4 = new JButton();

        GetTable getTable = new GetTable();

        DefaultTableModel tableModel = new DefaultTableModel(GetTable.queryDate(sql[0],data,head),head){
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
        label1.setText("\u6392\u5e8f\u65b9\u5f0f");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(10, 10), label1.getPreferredSize()));

        //---- button1 ----
        button1.setText("销售量");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 35), button1.getPreferredSize()));
        button1.addActionListener(
                e->{
                    DefaultTableModel tableModelV = new DefaultTableModel(GetTable.queryDate(sql[1],data,head),head){
                        public boolean isCellEditable(int row,int colume){
                            return false;
                        }
                    };
                    table1.setModel(tableModelV);
                }
        );

        //---- button2 ----
        button2.setText("销售额");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(40, 75), button2.getPreferredSize()));
        button2.addActionListener(
                e->{
                    DefaultTableModel tableModelV = new DefaultTableModel(GetTable.queryDate(sql[2],data,head),head){
                        public boolean isCellEditable(int row,int colume){
                            return false;
                        }
                    };
                    table1.setModel(tableModelV);
                }
        );

        //---- label2 ----
        label2.setText("\u7d22\u5f15");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(10, 220), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5546\u54c1ID\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 255), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u5546\u54c1\u540d\u79f0\uff1a");
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


        //---- label5 ----
        label5.setText("\u603b\u9500\u552e\u989d\uff1a");
        contentPane.add(label5);
        label5.setBounds(210, 430, 120, label5.getPreferredSize().height);

        //---- button4 ----
        button4.setText("刷新");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(5, 450), button4.getPreferredSize()));

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
    private JButton button4;
    private Object[][] data = null;
    private String head[] = {"商品ID","总销售量","总销售额"};
    private String sql[] = {
            "SELECT * FROM sales_volume",
            "SELECT * FROM sales_volume ORDER BY volume DESC",
            "SELECT * FROM sales_volume ORDER BY total_sales DESC"
    };

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new StatisticsGUI();
    }
}
