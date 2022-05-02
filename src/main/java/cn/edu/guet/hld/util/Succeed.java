/*
 * Created by JFormDesigner on Mon May 02 13:14:25 CST 2022
 */

package cn.edu.guet.hld.util;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Succeed extends JFrame {
    public Succeed() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u64cd\u4f5c\u6210\u529f");
        contentPane.add(label1);
        label1.setBounds(80, 45, 120, 25);

        contentPane.setPreferredSize(new Dimension(220, 135));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setResizable(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
