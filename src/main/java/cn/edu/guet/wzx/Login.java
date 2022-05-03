package cn.edu.guet.wzx;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("guet");
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField("guet1234");
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
        label1.setBounds(new Rectangle(new Point(115, 90), label1.getPreferredSize()));
        label1.setBounds(new Rectangle(new Point(75, 86), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(185, 85, 100, textField1.getPreferredSize().height);
        textField1.setBounds(130, 85, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(120, 125), label2.getPreferredSize()));
        label2.setBounds(new Rectangle(new Point(80, 121), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(185, 120, 100, textField2.getPreferredSize().height);
        textField2.setBounds(130, 120, 100, textField2.getPreferredSize().height);

        //---- radioButton1 ----

        radioButton1.setText("\u7528\u6237");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(140, 160), radioButton1.getPreferredSize()));
        radioButton1.setBounds(new Rectangle(new Point(90, 160), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("商家");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(210, 160), radioButton2.getPreferredSize()));
        radioButton2.setBounds(new Rectangle(new Point(170, 160), radioButton2.getPreferredSize()));

        //添加图片
        label3.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\5b0988e595225.cdn.sohucs.png"));
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
                    String user = "root";
                    String dbPassword = "123456";
                    String url = "jdbc:mysql://localhost:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

                    Connection conn = null;
                    // ?sql?????????????
                    // sql查询语句
                    String sql = "SELECT * FROM sys_user WHERE name='" + username + "' AND password='" + password + "'";
                    System.out.println(sql);
                    ResultSet rs = null;//结果集：内存，存储了查询到的数据；内存区有一个游标，执行完查询的时候，不指向任何记录
                    Statement stmt = null;//语句对象，容易产生注入攻击
                    try {
                        conn = DriverManager.getConnection(url, user, dbPassword);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);
                        if (rs.next()) {//让游标向下移动一次
                            /*
                            身份选择功能
                             */
                            if(radioButton1.isSelected()){
                                Main main=new Main();
                                main.setVisible(true);
                                System.out.println("登陆成功");
                                this.setVisible(false);
                            }
                            else if(radioButton2.isSelected()){
                                Password pwd=new Password();
                                pwd.setVisible(true);
                            }
                        } else {
                            System.out.println("用户名或密码错误");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(125, 200), button1.getPreferredSize()));
        button1.setBounds(new Rectangle(new Point(80, 200), button1.getPreferredSize()));

        //button2
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Register register=new Register();
                        register.setVisible(true);
                    }
                }
        );
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 200), button1.getPreferredSize()));
        button2.setBounds(new Rectangle(new Point(180, 200), button1.getPreferredSize()));



        contentPane.setPreferredSize(new Dimension(400, 300));
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
    public static void main(String[] args) {
        new Login();
    }
}