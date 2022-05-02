/*
 * Created by JFormDesigner on Mon May 02 12:07:52 CST 2022
 */

package cn.edu.guet.hld.util;

import cn.edu.guet.hld.MilkeTeaServer.Impl.MilkeTeaServerImpl;
import cn.edu.guet.hld.MilkeTeaServer.MilkeTeaServer;
import cn.edu.guet.hld.bean.MilkeTea;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class Delete extends JFrame {
    public Delete() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5220\u9664");
        contentPane.add(label1);
        label1.setBounds(160, 35, 45, 20);

        //---- label2 ----
        label2.setText("\u5976\u8336\u7684\u540d\u5b57\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(70, 90), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(145, 80, 170, 40);

        //---- button1 ----
        button1.setText("\u5220\u9664");
        contentPane.add(button1);
        button1.setBounds(140, 180, 90, 40);
        button1.addActionListener(e->{
            String title=textField1.getText();
            MilkeTeaServer milkeTeaServer=new MilkeTeaServerImpl();
            MilkeTea milkeTea=new MilkeTea();
            milkeTea.setTitle(title);
            try {
                milkeTeaServer.ServerDelete(milkeTea);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        contentPane.setPreferredSize(new Dimension(390, 285));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setResizable(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
