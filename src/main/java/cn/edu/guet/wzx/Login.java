package cn.edu.guet.wzx;



import cn.edu.guet.zt.manager.ManagerGUI;
import cn.juntai.wxpaydemo.util.ConnectionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
/*
 * Created by JFormDesigner on Sat Apr 02 15:41:52 CST 2022
 */


/**
 * @author 1
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    public int getid(){
        return this.id;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(75, 86), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(130, 85, 100, textField1.getPreferredSize().height);
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char keyChar=e.getKeyChar();

                if(((keyChar>='0'&&keyChar<='9')||(keyChar>='a'&&keyChar<='z')||(keyChar>='A'&&keyChar<='Z'))
                        &&textField1.getText().length()<20){
                    return;
                }
                //当输入出现在限制之外时会出现提示音并且不允许输入
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "输入格式不规范，只能输入因为字母和数字","格式错误",JOptionPane.ERROR_MESSAGE);
                //System.out.println("输入格式不规范，只能输入因为字母和数字");
                e.consume();
            }
        });

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(80, 121), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(130, 120, 100, textField2.getPreferredSize().height);
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char keyChar=e.getKeyChar();
                if(((keyChar>='0'&&keyChar<='9')||(keyChar>='a'&&keyChar<='z')||(keyChar>='A'&&keyChar<='Z')
                        ||keyChar=='.'||keyChar==',')&&textField2.getText().length()<=12){
                    return;

                }

                //当输入出现在限制之外时会出现提示音并且不允许输入
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "输入格式不规范，只能输入因为字母和数字和“，”“.”","格式错误",JOptionPane.ERROR_MESSAGE);
                //System.out.println("输入格式不规范，只能输入因为字母和数字和“，”“.”");
                e.consume();
            }


        });

        //---- radioButton1 ----

        radioButton1.setText("\u7528\u6237");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(90, 160), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("商家");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(170, 160), radioButton2.getPreferredSize()));

        ButtonGroup bg=new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        //添加图片
        label3.setIcon(new ImageIcon("src\\main\\resources\\tea_picture\\logo.png"));
        label3.setBounds(new Rectangle(new Point(0, 0), label3.getPreferredSize()));
        this.getContentPane().add(label3);


        //---- button1 ----
        button1.addActionListener(
                (e) -> {
                    /*
                    1、拿到登录界面的用户名和密码
                    2、去和数据库中的用户名和密码比对
                    3、创建了数据库和表
                    4、添加一条记录
                    INSERT INTO sys_user (id,name,password) VALUES(1111,'guet','guet1234');
                     */
                    String username = textField1.getText();
                    String password = textField2.getText();
                    Connection conn = null;
                    // sql查询语句
                    //String sql = "SELECT * FROM sys_user WHERE name='" + username + "' AND password='" + password + "'";
                    //System.out.println(sql);
                    ResultSet rs = null;//结果集：内存，存储了查询到的数据；内存区有一个游标，执行完查询的时候，不指向任何记录
                    Statement stmt = null;//语句对象，容易产生注入攻击

                    try {
                        conn = ConnectionHandler.getConnection();

                        stmt = conn.createStatement();

                            /*
                            身份选择功能
                             */
                        if(radioButton1.isSelected()){
                            String sql = "SELECT * FROM customer WHERE name='" + username + "' AND password='" + password + "'";
                            System.out.println(sql);
                            rs = stmt.executeQuery(sql);
                            if(rs.next()){
                                Main main=new Main();
                                main.setVisible(true);
                                System.out.println("登陆成功");
                                this.setVisible(false);
                            }else{
                                JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误","格式错误",JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        else if(radioButton2.isSelected()){
                            //跳转到商家界面
                            String sql1 = "SELECT * FROM sys_user WHERE name='" + username + "' AND password='" + password + "'";
                            System.out.println(sql1);
                            rs = stmt.executeQuery(sql1);
                            if(rs.next()){
                                ManagerGUI managerGUI = new ManagerGUI();
                                managerGUI.setVisible(true);
                                System.out.println("登陆成功");
                                this.setVisible(false);

                            }
                            else{
                                JOptionPane.showMessageDialog(null, "登陆失败，用户名或密码错误","格式错误",JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(80, 200), button1.getPreferredSize()));

        //button2
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Register register=new Register();
                        register.setVisible(true);
                        dispose();

                    }
                }
        );
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(180, 200), button1.getPreferredSize()));



        contentPane.setPreferredSize(new Dimension(900, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);//组件设置为可见
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private int id;


    public static void main(String[] args) {
        new Login();
    }
}
