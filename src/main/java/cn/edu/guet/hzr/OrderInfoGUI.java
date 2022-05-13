/*
 * Created by JFormDesigner on Fri May 13 22:37:53 CST 2022
 */

package cn.edu.guet.hzr;

import cn.edu.guet.hzr.util.GetOrderInfoTable;
import cn.edu.guet.zt.statistics.dao.Order;
import cn.edu.guet.zt.statistics.util.GetTable;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class OrderInfoGUI extends JFrame {
    public OrderInfoGUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        GetOrderInfoTable getOrderInfoTable = new GetOrderInfoTable();
        DefaultTableModel tableModel = new DefaultTableModel(GetOrderInfoTable.queryDate(sql[0],data,head[0]),head[0]){
            public boolean isCellEditable(int row,int colume){
                return false;
            }
        };

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(230, 5, 550, 335);

        //---- button1 ----
        button1.setText("\u5f53\u524d\u8ba2\u5355");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 15), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u5386\u53f2\u8ba2\u5355");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(40, 65), button2.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u7d22\u5f15");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(10, 155), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u8ba2\u5355\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(15, 190), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u7528\u6237ID\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(15, 225), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u8ba2\u5355\u65f6\u95f4\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(15, 260), label4.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(85, 185, 125, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(85, 220, 125, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(85, 255, 125, textField3.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u67e5\u8be2");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(80, 305), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u4fee\u6539\u8ba2\u5355");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(225, 365), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("\u5237\u65b0");
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(15, 365), button5.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private Object[][] data = null;
    private String head[][] = {
            {"订单ID","订单号","用户ID","订单时间","订单交易号","管理员ID","商品ID","商品单价","商品数量","总价"}
    };
    private String sql[] = {
            "SELECT id,out_trade_no,customer_id,order_time,transaction_id,user_id,item_id,item_price,amount,order_price FROM order_info;"
    };

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new OrderInfoGUI();
    }
}
