/*
 * Created by JFormDesigner on Sat Apr 30 16:32:49 CST 2022
 */

package cn.edu.guet.hld.util;

import cn.juntai.wxpaydemo.util.ConnectionHandler;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class GetCommit extends JFrame {
    public GetCommit() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u662f\u5426\u63d0\u4ea4\uff1f");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(115, 60), label1.getPreferredSize()));

        //---- button1 ----
        button1.setText("Yes");
        button1.addActionListener(e -> {
            ConnectionHandler connectionHandler = new ConnectionHandler();
            try {
                connectionHandler.getConnection().commit();
                Succeed succeed = new Succeed();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(30, 120), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText(" No ");
        button2.addActionListener(e -> {
            ConnectionHandler connectionHandler = new ConnectionHandler();
            Succeed succeed = new Succeed();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
            try {
                connectionHandler.getConnection().rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(185, 120), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(295, 210));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton button1;
    private JButton button2;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new GetCommit();
    }
}
