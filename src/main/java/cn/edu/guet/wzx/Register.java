/*
 * Created by JFormDesigner on Thu Apr 28 22:38:18 CST 2022
 */
package cn.edu.guet.wzx;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    public Register() {
        initComponents();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);


        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);

        label1.setBounds(new Rectangle(new Point(80, 70), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(85, 105), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u624b\u673a\u53f7\u7801:");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(75, 140), label3.getPreferredSize()));

        contentPane.add(textField1);
        textField1.setBounds(140, 70, 100, textField1.getPreferredSize().height);
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char keyChar=e.getKeyChar();
                int key=e.getKeyCode();

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

        contentPane.add(textField2);
        textField2.setBounds(140, 105, 100, textField2.getPreferredSize().height);
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

        contentPane.add(textField3);
        textField3.setBounds(140, 140, 100, textField3.getPreferredSize().height);
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char keyChar=e.getKeyChar();
                if(keyChar>='0'&&keyChar<='9'&&textField3.getText().length()<=11){
                    return;
                }
                //当输入出现在限制之外时会出现提示音并且不允许输入
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "输入格式不规范，只能输入数字","格式错误",JOptionPane.ERROR_MESSAGE);
                //System.out.println("输入格式不规范，只能输入数字");
                //System.out.println("输入格式不规范，只能输入数字且只允许输入8至11个数字");
                e.consume();
            }
        });

        radioButton1.setText("\u7528\u6237");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(90, 170), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("商家");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(170, 170), radioButton2.getPreferredSize()));

        ButtonGroup bg=new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

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
                        String dbPassword = "LYHWYZZNSB.wan1/";
                        String url = "jdbc:mysql://123.57.42.220:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                        Connection conn = null;
                        // 拼sql，容易有注入攻击


                        ResultSet rs = null;//结果集：内存，存储了查询到的数据；内存区有一个游标，执行完查询的时候，不指向任何记录
                        ResultSet rs1 = null;
                        //System.out.println(sql);
                        try {
                            conn=DriverManager.getConnection(url,user,dbPassword);
                            Statement stmt = conn.createStatement();

                            if(radioButton1.isSelected()){
                                String check1="SELECT * FROM customer WHERE name='"+username+"'";
                                rs = stmt.executeQuery(check1);
                                if (username!=null&&username!=""&&!rs.next()){
                                    String sql = "INSERT INTO  customer (name,password,mobile) VALUES(?,?,?)";
                                    PreparedStatement pstmt=conn.prepareStatement(sql);

                                    pstmt.setString(1, username);
                                    pstmt.setString(2, Password);
                                    pstmt.setString(3, phonenumber);
                                    pstmt.executeUpdate();//执行sql语句
                                    System.out.println("注册成功");

                                    Login login = new Login();
                                    login.setVisible(true);
                                    dispose();

                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "账号已存在或者账号和密码不符合规则","格式错误",JOptionPane.ERROR_MESSAGE);
                                    //System.out.println("账号已存在或者账号不符合规则");
                                }

                            }
                            else if(radioButton2.isSelected()){
                                String check="SELECT * FROM sys_user WHERE name='"+username+"'";

                                rs = stmt.executeQuery(check);
                                if (username!=null&&username!=""&&!rs.next()) {
                                    String sql = "INSERT INTO  sys_user (name,password,mobile) VALUES(?,?,?)";
                                    PreparedStatement pstmt = conn.prepareStatement(sql);

                                    pstmt.setString(1, username);
                                    pstmt.setString(2, Password);
                                    pstmt.setString(3, phonenumber);
                                    pstmt.executeUpdate();//执行sql语句
                                    System.out.println("注册成功");

                                    Login login = new Login();
                                    login.setVisible(true);
                                    dispose();


                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "账号已存在或者账号和密码不符合规则","格式错误",JOptionPane.ERROR_MESSAGE);
                                }

                            }


                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );
        button1.setText("\u6ce8\u518c");
        contentPane.add(button1);
        //button1.setBounds(new Rectangle(new Point(180, 215), button1.getPreferredSize()));
        button1.setBounds(new Rectangle(new Point(145, 215), button1.getPreferredSize()));

        //logo图片


        //label4.setBounds(new Rectangle(new Point(0, 200), label4.getPreferredSize()));
        label4.setIcon(new ImageIcon("src\\main\\resources\\tea_picture\\logo.png"));
        label4.setBounds(new Rectangle(new Point(0, 0), label4.getPreferredSize()));
        this.getContentPane().add(label4);



        contentPane.setPreferredSize(new Dimension(900, 280));
        pack();
        setLocationRelativeTo(getOwner());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Login login=new Login();
                login.setVisible(true);
                dispose();
            }
        });

        this.setResizable(false);
        this.setVisible(true);//设置组件可见
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new Register();
    }
}