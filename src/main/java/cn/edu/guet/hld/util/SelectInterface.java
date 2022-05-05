/*
 * Created by JFormDesigner on Sun May 01 12:06:30 CST 2022
 */

package cn.edu.guet.hld.util;

import cn.edu.guet.hld.MilkeTeaServer.Impl.MilkeTeaServerImpl;
import cn.edu.guet.hld.MilkeTeaServer.MilkeTeaServer;
import cn.edu.guet.hld.bean.MilkeTea;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class SelectInterface extends JFrame {
    public SelectInterface() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        panel2 = new JPanel();


        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("id\uff1a");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(25, 100), label1.getPreferredSize()));
            panel1.add(textField1);
            textField1.setBounds(70, 100, 140, textField1.getPreferredSize().height);

            //---- label2 ----
            label2.setText("\u5976\u8336\u540d\u5b57\uff1a");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(5, 140), label2.getPreferredSize()));
            panel1.add(textField2);
            textField2.setBounds(70, 140, 140, textField2.getPreferredSize().height);

            //---- button1 ----
            button1.setText("\u67e5\u8be2");
            panel1.add(button1);
            button1.setBounds(65, 200, 100, 50);

            button1.addActionListener(e -> {

                MilkeTea milkeTea = new MilkeTea();
                if (textField1.getText().equals("") && textField2.getText().equals("")) {

                    int i = 0;
                    ResultSet resultSet = null;
                    MilkeTeaServer milkeTeaServer = new MilkeTeaServerImpl();

                    try {
                        resultSet = milkeTeaServer.ServerSelect(milkeTea);

                        int h = 0;
                        System.out.println(resultSet.getFetchSize());
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String title = resultSet.getString(2);
                            float price = resultSet.getFloat(3);
                            String description = resultSet.getString(4);
                            int sales = resultSet.getInt(5);
                            String img_url = resultSet.getString(6);
                            button[i] = new JButton();
                            button[i].setText("<html>" +
                                    id + "<br>" +
                                    "<div style=\"text-align:center;\">" + title + "<br>" + price + "/杯</div></html>");
                            panel2.add(button[i]);

                            if (i % 2 == 0) {
                                button[i].setBounds(45, (35 + h * 125), 155, 85);
                            } else {

                                button[i].setBounds(230, (35 + h * 125), 155, 85);
                                h++;
                            }

                            button[i].addActionListener(l -> {
                                Picture picture = new Picture(img_url);
                                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            });
                            i++;
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                } else if (textField2.getText().equals("")) {
                    int id = Integer.parseInt(textField1.getText());
                    milkeTea.setId(id);
                    MilkeTeaServer milkeTeaServer = new MilkeTeaServerImpl();
                    ResultSet resultSet = null;
                    try {
                        resultSet = milkeTeaServer.ServerSelect(milkeTea);
                        int i = 0;
                        while (resultSet.next()) {
                            String title = resultSet.getString(2);
                            float price = resultSet.getFloat(3);
                            String description = resultSet.getString(4);
                            int sales = resultSet.getInt(5);
                            String img_url = resultSet.getString(6);
                            System.out.println(img_url);

                            if (isFirst == 0) {
                                button6.removeNotify();
                                button5 = new JButton();
                                button5.setDefaultCapable(true);
                                button5.setText("<html>" +
                                        id + "<br>" +
                                        "<div style=\"text-align:center;\">" + title + "<br>" + price + "/杯</div></html>");
                                panel2.add(button5);
                                button5.setBounds(45, 35, 155, 85);

                                button5.addActionListener(h -> {
                                    Picture picture = new Picture(img_url);
                                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                });
                                panel2.updateUI();
                                panel2.repaint();
                                isFirst = 1;
                            } else {
                                button5.removeNotify();
                                button6 = new JButton();
                                button6.setDefaultCapable(true);
                                System.out.println(isFirst);
                                button6.setText("<html>" +
                                        id + "<br>" +
                                        "<div style=\"text-align:center;\">" + title + "<br>" + price + "/杯</div></html>");
                                panel2.add(button6);
                                button6.setBounds(45, 35, 155, 85);
                                button6.addActionListener(h -> {
                                    Picture picture = new Picture(img_url);
                                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    panel2.updateUI();
                                    panel2.repaint();
                                    isFirst = 0;
                                });
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } finally {
                        try {
                            resultSet.close();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }


                } else if (textField1.getText().equals("")) {

                    String title = textField2.getText();

                    milkeTea.setTitle(title);
                    MilkeTeaServer milkeTeaServer = new MilkeTeaServerImpl();
                    ResultSet resultSet = null;
                    try {
                        resultSet = milkeTeaServer.ServerSelect(milkeTea);
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            float price = resultSet.getFloat(3);
                            String description = resultSet.getString(4);
                            int sales = resultSet.getInt(5);
                            String img_url = resultSet.getString(6);
                            if (isFirst == 0) {
                                button6.removeNotify();
                                button5 = new JButton();
                                button5.setDefaultCapable(true);
                                button5.setText("<html>" +
                                        id + "<br>" +
                                        "<div style=\"text-align:center;\">" + title + "<br>" + price + "/杯</div></html>");
                                panel2.add(button5);
                                button5.setBounds(45, 35, 155, 85);

                                button5.addActionListener(h -> {
                                    Picture picture = new Picture(img_url);
                                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                });
                                panel2.updateUI();
                                panel2.repaint();
                                isFirst = 1;
                            } else {
                                button5.removeNotify();
                                button6 = new JButton();
                                button6.setDefaultCapable(true);
                                System.out.println(isFirst);
                                button6.setText("<html>" +
                                        id + "<br>" +
                                        "<div style=\"text-align:center;\">" + title + "<br>" + price + "/杯</div></html>");
                                panel2.add(button6);
                                button6.setBounds(45, 35, 155, 85);
                                button6.addActionListener(h -> {
                                    Picture picture = new Picture(img_url);
                                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    panel2.updateUI();
                                    panel2.repaint();
                                    isFirst = 0;
                                });
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                } else {
                    int id = Integer.parseInt(textField1.getText());
                    String title = textField2.getText();
                    milkeTea.setId(id);
                    milkeTea.setTitle(title);
                    ResultSet resultSet = null;
                    MilkeTeaServer milkeTeaServer = new MilkeTeaServerImpl();
                    try {

                        resultSet = milkeTeaServer.ServerSelect(milkeTea);
                        while (resultSet.next()) {
                            float price = resultSet.getFloat(3);
                            String description = resultSet.getString(4);
                            int sales = resultSet.getInt(5);
                            String img_url = resultSet.getString(6);
                            if (isFirst == 0) {
                                button6.removeNotify();
                                button5 = new JButton();
                                button5.setDefaultCapable(true);
                                button5.setText("<html>" +
                                        id + "<br>" +
                                        "<div style=\"text-align:center;\">" + title + "<br>" + price + "/杯</div></html>");
                                panel2.add(button5);
                                button5.setBounds(45, 35, 155, 85);
                                button5.addActionListener(h -> {
                                    Picture picture = new Picture(img_url);
                                    //System.out.println(img_url);
                                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                });
                                panel2.updateUI();
                                panel2.repaint();
                                isFirst = 1;
                            } else {
                                button5.removeNotify();
                                button6 = new JButton();
                                button6.setDefaultCapable(true);
                                button6.setText("<html>" +
                                        id + "<br>" +
                                        "<div style=\"text-align:center;\">" + title + "<br>" + price + "/杯</div></html>");
                                panel2.add(button6);
                                button6.setBounds(45, 35, 155, 85);
                                button6.addActionListener(h -> {
                                    Picture picture = new Picture(img_url);

                                    //System.out.println(img_url);
                                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    panel2.updateUI();
                                    panel2.repaint();
                                    isFirst = 0;
                                });
                            }


                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
            });

            //---- button2 ----
            button2.setText("\u6dfb\u52a0");
            panel1.add(button2);
            button2.setBounds(65, 300, 100, 50);
            button2.addActionListener(e -> {
                Insert insert = new Insert();
                //insert.initComponents();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            });

            //---- button3 ----
            button3.setText("\u5220\u9664");
            panel1.add(button3);
            button3.setBounds(65, 385, 100, 50);
            button3.addActionListener(e -> {
                Delete delete = new Delete();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            });

            //---- button4 ----
            button4.setText("\u4fee\u6539");
            panel1.add(button4);
            button4.setBounds(65, 480, 100, 50);
            button4.addActionListener(e -> {
                Undate undate = new Undate();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            });

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 230, 600);

        //======== panel2 ========
        {
            panel2.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel2);
        panel2.setBounds(235, 0, 420, 600);

        contentPane.setPreferredSize(new Dimension(660, 610));
        pack();
        setLocationRelativeTo(getOwner());
        //JFormDesigner - End of component initialization  //GEN-END:initComponents
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, false, panel1, panel2);
        jSplitPane.setDividerLocation(232);

        jSplitPane.setOneTouchExpandable(false);
        jSplitPane.setDividerSize(2);
        jSplitPane.setEnabled(false);
        jSplitPane.setBackground(Color.CYAN);
        contentPane.add(jSplitPane);
        contentPane.add(panel1);
        String rpicture = "src/main/java/cn/edu/guet/hld/jpg/R-C.jpg";
        String rpicture2 = "src/main/java/cn/edu/guet/hld/jpg/R-D.jpg";
        JLabel path_p = new JLabel(new ImageIcon(rpicture));
        JLabel path_q = new JLabel(new ImageIcon(rpicture2));
        path_q.setBounds(0, 0, 230, 600);
        path_p.setBounds(0, 0, 420, 600);
        panel1.add(path_q, new byte[1024]);
        contentPane.add(panel1);
        panel2.add(path_p, new byte[1024]);

        contentPane.add(panel2);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel panel2;
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    private JButton[] button = new JButton[20];
    private int isFirst = 0;


    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new SelectInterface();
    }
}
