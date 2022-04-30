/*
 * Created by JFormDesigner on Thu Apr 28 22:38:18 CST 2022
 */

package cn.wzx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * @author 1
 */
public class Register extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    public Register() {
        initComponents();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(125, 75), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(130, 125), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u624b\u673a\u53f7\u7801:");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(120, 170), label3.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(185, 75, 100, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(185, 125, 100, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(185, 170, 100, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       // System.out.println("测试");
                        String username = textField1.getText();
                        String Password = textField2.getText();
                        String phonenumber = textField2.getText();

                        String user = "root";
                        String dbPassword = "123456";
                        String url = "jdbc:mysql://localhost:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

                        Connection conn = null;
                        // 拼sql，容易有注入攻击

                        String check="SELECT * FROM sys_user WHERE name='"+username+"'";

                        //System.out.println(sql);
                        try {
                            conn=DriverManager.getConnection(url,user,dbPassword);
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery(check);
                            System.out.println(rs);
                            if(username!=null&&username!=""&&!rs.next()){
                                String sql = "INSERT INTO  sys_user (name,password,mobile) VALUES(?,?,?)";
                                PreparedStatement pstmt=conn.prepareStatement(sql);
                                pstmt.setString(1,username);
                                pstmt.setString(2,Password);
                                pstmt.setString(3,phonenumber);
                                pstmt.executeUpdate();//执行sql语句

                                System.out.println("注册成功");
                                Login login=new Login();
                                login.setVisible(true);
                            }else {
                                System.out.println("账号已存在或者账号不符合规则");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();

                        }

                    }


                }
        );
        button1.setText("\u6ce8\u518c");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(180, 215), button1.getPreferredSize()));

        //logo图片
        ImageIcon image=new ImageIcon("E:\\Java\\images\\logo.jpg");
        label4 = new JLabel(image);
        label4.setBounds(new Rectangle(new Point(0, 200), label4.getPreferredSize()));
        this.getContentPane().add(label4);


        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);//设置组件可见
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }




    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
