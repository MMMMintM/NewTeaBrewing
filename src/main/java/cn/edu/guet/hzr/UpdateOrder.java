/*
 * Created by JFormDesigner on Fri May 13 21:29:38 CST 2022
 */

package cn.edu.guet.hzr;

import cn.edu.guet.zt.statistics.bean.OrderInfo;
import cn.edu.guet.zt.statistics.dao.Order;
import cn.juntai.wxpaydemo.util.ConnectionHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 * @author 1
 */
public class UpdateOrder extends JFrame {
    OrderInfo orderInfo;
    public UpdateOrder(OrderInfo orderInfo) {
        this.orderInfo=orderInfo;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5546\u54c1ID\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 45), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(85, 45, 95, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u91d1\u989d\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(25, 95), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(90, 90, 90, textField2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u4e0b\u5355\u65f6\u95f4\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(25, 140), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(95, 140, 90, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=textField1.getText();
                String data=textField1.getText();
                String order_price=textField1.getText();
                Connection conn = null;
                // 拼sql，容易有注入攻击
                ResultSet rs = null;//结果集：内存，存储了查询到的数据；内存区有一个游标，执行完查询的时候，不指向任何记录
                ResultSet rs1 = null;
                try {
                    conn= ConnectionHandler.getConnection();
                    Statement stmt = conn.createStatement();
                    String sql = "INSERT INTO  order_info (id,order_time,order_price) VALUES(?,?,?)";
                    PreparedStatement pstmt=conn.prepareStatement(sql);

                    pstmt.setString(1, id);
                    pstmt.setString(2, data);
                    pstmt.setString(3, order_price);
                    pstmt.executeUpdate();//执行sql语句
                    System.out.println("修改成功");
                    Order order=new Order();
                    order.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        button1.setText("\u4fdd\u5b58\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(100, 205), button1.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        this.setBounds(600, 300, 480, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
