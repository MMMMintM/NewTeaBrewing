/*
 * Created by JFormDesigner on Fri May 13 18:53:46 CST 2022
 */

package cn.edu.guet.zt.manager;

import cn.edu.guet.hld.util.SelectInterface;
import cn.edu.guet.wzx.Login;
import cn.edu.guet.zt.manager.util.GetItemTable;
import cn.edu.guet.zt.statistics.StatisticsGUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author 1
 */
public class ManagerGUI extends JFrame {
    public ManagerGUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        data = GetItemTable.queryDate(data,head);
        int iLength = 0;
        if(data.length%4 == 0){
            iLength = data.length/4;
        }else{
            iLength = data.length/4 + 1;
        }

        //获取路径
        String[][] path = new String[iLength][4];
        int k = 0;
        for(int i = 0;i < path.length;i ++)
            for (int j = 0 ;j < path[i].length;j ++)
            {
                path[i][j] = data[k][5].toString();
                k ++;
            }

        for(int i = 0;i < path.length;i ++)
        {
            for(int j = 0;j < labels1[i].length;j ++){
                ImageIcon icon = new ImageIcon(path[i][j]);
                icon.setImage(icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH));
                labels1[i][j] = new JLabel(icon);
            }

        }
        //获取商品名
        String[][] name = new String[iLength][4];
        int k1 = 0;
        for(int i = 0;i < name.length;i ++)
            for (int j = 0 ;j < name[i].length;j ++)
            {
                name[i][j] = data[k1][1].toString();
                k1 ++;
            }
        for(int i = 0;i < name.length;i ++){
            for(int j = 0 ;j < labels2[i].length;j ++)
            {
                labels2[i][j] = new JLabel();
            }
        }
        //获取价格
        String[][] price = new String[3][4];
        int k2 = 0;
        for(int i = 0;i < price.length;i ++)
            for (int j = 0 ;j < price[i].length;j ++)
            {
                price[i][j] = data[k2][2].toString();
                k2 ++;
            }
        for(int i = 0;i < name.length;i ++){
            for(int j = 0 ;j < labels3[i].length;j ++)
            {
                labels3[i][j] = new JLabel();
            }
        }



        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //========labels=========
        int y1 = 20;
        for(int i = 0;i < labels1.length;i ++){
            int x = 180;
            for(int j = 0;j < labels1[i].length;j ++)
            {
                labels1[i][j].setText("");
                contentPane.add(labels1[i][j]);
                labels1[i][j].setBounds(x,y1,150,150);
                x += 200;
            }
            y1 += 200;
        }

        int y2 = 180;
        for(int i = 0;i < labels2.length;i ++){
            int x = 180;
            for(int j = 0;j < labels2[i].length;j ++)
            {
                labels2[i][j].setText(name[i][j]);
                contentPane.add(labels2[i][j]);
                labels2[i][j].setBounds(x,y2,120, labels2[i][j].getPreferredSize().height);
                x += 200;
            }
            y2 += 200;
        }

        int y3 = 180;
        for(int i = 0;i < labels3.length;i ++){
            int x = 250;
            for(int j = 0;j < labels3[i].length;j ++)
            {
                labels3[i][j].setText("单价：" + price[i][j]);
                contentPane.add(labels3[i][j]);
                labels3[i][j].setBounds(x,y3,120, labels3[i][j].getPreferredSize().height);
                x += 200;
            }
            y3 += 200;
        }

        //---- button1 ----
        button1.setText("\u8ba2\u5355\u7ba1\u7406");
        contentPane.add(button1);
        button1.setBounds(35, 40, 115, button1.getPreferredSize().height);


        //---- button2 ----
        button2.setText("\u5546\u54c1\u7ba1\u7406");
        contentPane.add(button2);
        button2.setBounds(35, 105, 115, button2.getPreferredSize().height);
        button2.addActionListener(
                e -> {
                    SelectInterface selectInterface = new SelectInterface();
                    selectInterface.setVisible(true);
                    this.setVisible(false);
                }
        );

        //---- button3 ----
        button3.setText("\u9500\u91cf\u7edf\u8ba1");
        contentPane.add(button3);
        button3.setBounds(35, 180, 115, button3.getPreferredSize().height);
        button3.addActionListener(
                e -> {
                    StatisticsGUI statisticsGUI = new StatisticsGUI();
                    statisticsGUI.setVisible(true);
                    this.setVisible(false);
                }
        );

        //---- button4 ----
        button4.setText("\u7528\u6237\u4fe1\u606f\u7ba1\u7406");
        contentPane.add(button4);
        button4.setBounds(35, 245, 115, button4.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(1000, 700));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Login login=new Login();
                login.setVisible(true);
                dispose();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel[][] labels1 = new JLabel[3][4];
    private JLabel[][] labels2 = new JLabel[3][4];
    private JLabel[][] labels3 = new JLabel[3][4];
    private Object[][] data = null;
    private String[] head = {"商品id","商品名称","商品价格","商品描述","商品折扣","商品路径"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new ManagerGUI();
    }
}
