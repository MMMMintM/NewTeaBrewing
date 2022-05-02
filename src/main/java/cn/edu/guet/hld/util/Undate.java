/*
 * Created by JFormDesigner on Mon May 02 13:28:28 CST 2022
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
public class Undate extends JFrame {
    public Undate() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        label7 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u66f4\u65b0");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(230, 35), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u66f4\u65b0\u7684\u5976\u8336  id\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(80, 90), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(180, 80, 220, 40);

        //---- label3 ----
        label3.setText("\u66f4\u65b0\u7684\u5976\u8336\u540d\u5b57\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(80, 140), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(180, 130, 220, 40);

        //---- label4 ----
        label4.setText("\u66f4\u65b0\u7684\u5976\u8336\u4ef7\u683c\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(80, 190), label4.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(180, 180, 220, 40);

        //---- label5 ----
        label5.setText("\u66f4\u65b0\u7684\u5976\u8336\u7b80\u4ecb\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(80, 240), label5.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(180, 230, 220, 40);

        //---- label6 ----
        label6.setText("\u66f4\u65b0\u7684\u56fe\u7247\u4ecb\u7ecd\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(80, 290), label6.getPreferredSize()));
        contentPane.add(textField6);
        textField6.setBounds(180, 280, 220, 40);

        //---- label7 ----
        label7.setText("\u539f\u6765\u5976\u8336\u7684\u540d\u5b57\uff1a");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(80, 360), label7.getPreferredSize()));
        contentPane.add(textField7);
        textField7.setBounds(180, 350, 220, 40);

        //---- button1 ----
        button1.setText("\u66f4\u65b0 ");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(215, 410), button1.getPreferredSize()));
        button1.addActionListener(e ->{//监听
            int id;
            float price;
            if(textField2.getText().equals("")){
                textField2.setText("0");
                id=Integer.parseInt(textField2.getText());
            }else{
                id=Integer.parseInt(textField2.getText());
            }

            String title=textField3.getText();
            if(textField4.getText().equals("")){
                textField4.setText("0.00");
                price=Float.valueOf(textField4.getText());
            }else {
                price=Float.valueOf(textField4.getText());
            }
            String description=textField5.getText();
            String img_url=textField6.getText();
            String name=textField7.getText();

            MilkeTea milkeTea=new MilkeTea();
            milkeTea.setId(id);
            milkeTea.setTitle(title);
            milkeTea.setPrice(price);
            milkeTea.setDescription(description);
            milkeTea.setImg_url(img_url);

            MilkeTeaServer milkeTeaServer=new MilkeTeaServerImpl();

            try {
                milkeTeaServer.ServerUpdate(milkeTea,name);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            this.setVisible(false);
        });

        contentPane.setPreferredSize(new Dimension(510, 485));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setResizable(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JLabel label7;
    private JTextField textField7;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
