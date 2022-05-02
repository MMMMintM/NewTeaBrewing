/*
 * Created by JFormDesigner on Mon May 02 10:06:07 CST 2022
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
public class Insert extends JFrame {
    public Insert() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField5 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u65b0\u7684\u5976\u8336");
        contentPane.add(label1);
        label1.setBounds(220, 20, 105, 35);

        //---- label2 ----
        label2.setText("\u5976\u8336\u7684  ID\uff1a");
        contentPane.add(label2);
        label2.setBounds(65, 80, 75, 30);
        contentPane.add(textField1);
        textField1.setBounds(155, 70, 285, 45);

        //---- label3 ----
        label3.setText("\u5976\u8336\u7684\u540d\u5b57\uff1a");
        contentPane.add(label3);
        label3.setBounds(65, 135, 75, 30);
        contentPane.add(textField2);
        textField2.setBounds(155, 125, 285, 45);

        //---- label4 ----
        label4.setText("\u5976\u8336\u7684\u4ef7\u683c\uff1a");
        contentPane.add(label4);
        label4.setBounds(65, 190, 75, 30);
        contentPane.add(textField3);
        textField3.setBounds(155, 180, 285, 45);

        //---- label5 ----
        label5.setText("\u5976\u8336\u7684\u7b80\u4ecb\uff1a");
        contentPane.add(label5);
        label5.setBounds(65, 245, 75, 30);
        contentPane.add(textField4);
        textField4.setBounds(155, 235, 285, 45);

        //---- label6 ----
        label6.setText("\u5976\u8336\u7684\u56fe\u7247\uff1a");
        contentPane.add(label6);
        label6.setBounds(65, 300, 75, 30);
        contentPane.add(textField5);
        textField5.setBounds(155, 290, 285, 45);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(230, 375, 105, 50);
        button1.addActionListener(e ->{
            int id;
            float price;
            if(textField1.getText().equals("")){
                textField1.setText("0");
                id=Integer.parseInt(textField1.getText());
            }else{
                id=Integer.parseInt(textField1.getText());
            }

            String title=textField2.getText();
            if(textField3.getText().equals("")){
                textField3.setText("0.00");
                price=Float.valueOf(textField3.getText());
            }else {
                price=Float.valueOf(textField3.getText());
            }
            String description=textField4.getText();
            String img_url=textField5.getText();

            MilkeTea milkeTea=new MilkeTea();
            milkeTea.setId(id);
            milkeTea.setTitle(title);
            milkeTea.setPrice(price);
            milkeTea.setDescription(description);
            milkeTea.setImg_url(img_url);

            MilkeTeaServer milkeTeaServer=new MilkeTeaServerImpl();

            try {
                milkeTeaServer.ServerInsert(milkeTea);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            this.setVisible(false);
        });

        contentPane.setPreferredSize(new Dimension(590, 485));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponentset
        this.setVisible(true);
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField5;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args){
        new Insert();
    }
}
