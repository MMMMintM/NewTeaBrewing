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

    public Picture(String url){
        initComponents(url);
    }


    public void initComponents(String url) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        BufferedInputStream bis=null;
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        ByteArrayOutputStream baos=null;
        try {
            URL url1=new URL(url);
            bis=new BufferedInputStream(url1.openStream());
            baos=new ByteArrayOutputStream();
            int i=0;
            while ((i=bis.read())!=-1){
                baos.write(i);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        JLabel path_q=new JLabel(new ImageIcon(baos.toByteArray()));
        path_q.setBounds(100,50,200,200);
        this.add(path_q,new byte[1024]);
        this.setVisible(true);
        this.setResizable(false);



        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
