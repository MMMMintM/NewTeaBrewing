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
        contentPane.add(textField1);
        textField1.setBounds(185, 85, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(120, 125), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(185, 120, 100, textField2.getPreferredSize().height);

        //---- radioButton1 ----

        radioButton1.setText("\u7528\u6237");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(140, 160), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("�̼�");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(210, 160), radioButton2.getPreferredSize()));



        //---- button1 ----
        button1.addActionListener(
                (e) -> {
                    /*
                    1���õ���¼������û���������
                    2��ȥ�����ݿ��е��û���������ȶ�
                    3�����������ݿ�ͱ�
                    4�����һ����¼
                    INSERT INTO sys_user (id,name,password) VALUES(1111,'guet','guet1234');
                     */
                    String username = textField1.getText();
                    String password = textField2.getText();

                    String user = "root";
                    String dbPassword = "123456";
                    String url = "jdbc:mysql://localhost:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

                    Connection conn = null;
                    // ?sql?????????????
                    String sql = "SELECT * FROM sys_user WHERE name='" + username + "' AND password='" + password + "'";
                    System.out.println(sql);
                    ResultSet rs = null;//��������ڴ棬�洢�˲�ѯ�������ݣ��ڴ�����һ���αִ꣬�����ѯ��ʱ�򣬲�ָ���κμ�¼
                    Statement stmt = null;//���������ײ���ע�빥��

                    try {
                        conn = DriverManager.getConnection(url, user, dbPassword);

                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);
                        if (rs.next()) {//���α������ƶ�һ��

                            /*
                            ���ѡ����
                             */
                        if(radioButton1.isSelected()){

                            Main main=new Main();
                            main.setVisible(true);
                            System.out.println("��½�ɹ�");
                            this.setVisible(false);
                        }
                        else if(radioButton2.isSelected()){
                            Password pwd=new Password();
                            pwd.setVisible(true);
                        }


                        } else {
                            System.out.println("�û������������");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(125, 200), button1.getPreferredSize()));

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
        button2.setText("ע��");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(230, 200), button1.getPreferredSize()));



        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);//�������Ϊ�ɼ�
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;


    public static void main(String[] args) {
        new Login();
    }
}
