/*
 * Created by JFormDesigner on Fri Apr 29 19:08:38 CST 2022
 */

package cn.wzx;

import javax.swing.*;
import java.awt.*;

/**
 * @author 1
 */
public class Password extends JFrame {
    public Password() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- radioButton1 ----
        radioButton1.setText("\u7528\u6237");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(80, 125), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("\u7ba1\u7406\u5458");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(170, 125), radioButton2.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u8eab\u4efd\u9009\u62e9\u6d4b\u8bd5");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(140, 35), label1.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u6d4b\u8bd5");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(145, 200), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Password();
    }
}
