package cn.edu.guet.sjl.main;

import cn.edu.guet.sjl.util.GETDATA;
import cn.edu.guet.sjl.util.ResetTable;
import cn.edu.guet.wzx.Login;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class iface extends JFrame {
    public iface() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Login log=new Login();
        Id=log.getid();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button3 = new JButton();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        JComboBox1 = new JComboBox();

        GETDATA getTable = new GETDATA();

        DefaultTableModel tableModel = new DefaultTableModel(GETDATA.queryDate(sql[0],data,head),head){
            public boolean isCellEditable(int row,int colume){
                return false;
            }
        };

        table1.setModel(tableModel);

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(210, 30, 480, 375);

        //---- label1 ----
        label1.setText("订单记录");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(10, 10), label1.getPreferredSize()));

        //---- button1 ----
        button1.setText("历史订单");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 35), button1.getPreferredSize()));
        button1.addActionListener(
                e->{
                    sql[0]="SELECT * FROM order_info AND order_info.user_id =" + Id + "ORDER BY order_time DESC;";
                    table1.setModel(ResetTable.reset(GETDATA.queryDate(sql[0],data,head),head));
                }
        );

        //---- button2 ----
        button2.setText("当前订单");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(40, 75), button2.getPreferredSize()));
        button2.addActionListener(
                e->{
                    sql[0]="SELECT * FROM order_info where order_info.transaction_id=0 AND order_info.user_id =" + Id + ";";
                    table1.setModel(ResetTable.reset(GETDATA.queryDate(sql[0],data,head),head));
                }
        );


        //---- label2 ----
        label2.setText("年：");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(20, 220), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("商品ID：");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 255), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("商品名称");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(20, 295), label4.getPreferredSize()));

        label5.setText("索引");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(10, 180), label5.getPreferredSize()));

        label6.setText("亲爱的"+Id+"用户");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(10, 150), label6.getPreferredSize()));

        contentPane.add(textField1);
        textField1.setBounds(85, 255, 105, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(85, 295, 105, textField2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("查询");//查询
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(65, 355), button3.getPreferredSize()));
        button3.addActionListener(
                e -> {
                    String ID = textField1.getText();
                    String time = (String)JComboBox1.getSelectedItem();
                    if(ID=="") {//这里可能有问题
                        String Sql = "SELECT * FROM order_info WHERE order_info.user_id =" +
                                Id + "AND order_info.id=" + ID + "AND YEAR(order_info.order_time)=" + time + ";";
                        sql[0] = Sql;
                    }
                    else
                    {
                        String Sql = "SELECT * FROM order_info WHERE order_info.user_id =" +
                                Id  + "AND YEAR(order_info.order_time)=" + time + ";";
                        sql[0] = Sql;
                    }
                    table1.setModel(ResetTable.reset(GETDATA.queryDate(sql[0],data,head),head));
                }
        );


        button4.setText("刷新");//刷新
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(5, 450), button4.getPreferredSize()));
        button4.addActionListener(
                e -> {
                    String Sql="SELECT * FROM order_info where order_info.transaction_id=1;";
                    sql[0]=Sql;
                    table1.setModel(ResetTable.reset(GETDATA.queryDate(sql[0],data,head),head));
                }
        );

        //-----JComboBox1------

        JComboBox1.addItem("2022");
        JComboBox1.addItem("2021");   //向下拉列表中添加一项
        JComboBox1.addItem("2020");
        contentPane.add(JComboBox1);
        JComboBox1.setBounds(85,220,100,20);
        JComboBox1.setVisible(true);


        contentPane.setPreferredSize(new Dimension(695, 520));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button3;
    private JLabel label5;
    private JLabel label6;
    private JComboBox JComboBox1;
    private JLabel label7;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private Object[][] data = null;
    private String head[] =
            {"商品ID","商品名称","商品数量","更新时间","金额"};
    private String sql[] = {
            "SELECT * FROM order_info where order_info.transaction_id=1;",
    };
    private int Id;






    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new iface();
    }
}
