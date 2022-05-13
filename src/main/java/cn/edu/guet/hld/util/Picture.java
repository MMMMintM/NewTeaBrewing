/*
 * Created by JFormDesigner on Sun May 01 16:16:02 CST 2022
 */

package cn.edu.guet.hld.util;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

/**
 * @author 1
 */
public class Picture extends JFrame {

    public Picture(String url) {
        initComponents(url);
    }


    public void initComponents(String url) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        //BufferedInputStream bis = null;
        contentPane.setPreferredSize(new Dimension(370, 370));
        pack();
        setLocationRelativeTo(getOwner());
        JLabel path_q = new JLabel(new ImageIcon(url));
        path_q.setBounds(0, 0, 370, 370);
        this.add(path_q, new byte[1024]);
        this.setVisible(true);
        this.setResizable(false);


        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
