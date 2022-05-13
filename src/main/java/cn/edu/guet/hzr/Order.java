package cn.edu.guet.zt.statistics.dao;

import cn.edu.guet.hzr.UpdateOrder;
import cn.edu.guet.zt.statistics.bean.OrderInfo;
import cn.edu.guet.zt.statistics.util.GetTable;
import cn.edu.guet.zt.statistics.util.ResetTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.Date;

public class Order extends JFrame{
    public Order() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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

        GetTable getTable = new GetTable();

        DefaultTableModel tableModel = new DefaultTableModel(GetTable.queryDate(sql[0],data,head[0]),head[0]){
            public boolean isCellEditable(int row,int colume){
                return false;
            }
        };

        table1.setModel(tableModel);
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("商品订单管理");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(250, 10), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("索引");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(10, 220), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("商品ID：");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 255), label3.getPreferredSize()));

        //---- label4 ----
       /* label4.setText("商品名称");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(20, 295), label4.getPreferredSize()));

        */

        contentPane.add(textField1);
        textField1.setBounds(85, 255, 105, textField1.getPreferredSize().height);
        /*
        contentPane.add(textField2);
        textField2.setBounds(85, 295, 105, textField2.getPreferredSize().height);

         */

        //---- button1 ----
        button1.setText("修改订单");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(280, 465), button1.getPreferredSize()));
        button1.addActionListener(
                e->{
                    // table1.setModel(ResetTable.reset(GetTable.queryDate(sql[1],data,head[0]),head[0]));
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    int id=(int)table1.getValueAt(rowNo, 0);
                    Date data=(Date)table1.getValueAt(rowNo, 4);
                    int order_price=(int)table1.getValueAt(rowNo, 3);
                    System.out.println(id);
                    System.out.println(data);
                    System.out.println(order_price);

                    OrderInfo orderInfo=new OrderInfo();
                    UpdateOrder updateOrder=new UpdateOrder(orderInfo);
                    updateOrder.setVisible(true);


                }
        );

        //---- button2 ----
        /*
        button2.setText("删除订单");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(430, 465), button2.getPreferredSize()));
        button2.addActionListener(
                e->{
                    //table1.setModel(ResetTable.reset(GetTable.queryDate(sql[1],data,head[0]),head[0]));


                }
        );

         */

        //---- button3 ----
        button3.setText("查询");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(75, 305), button3.getPreferredSize()));
        button3.addActionListener(
                e -> {
                    String ID = textField1.getText();
                    String sql = "SELECT id,amount,item_price,order_price,order_time FROM order_info WHERE INSTR(id,'" +
                            ID + "')<>0 ;";

                    //String sql = "SELECT * FROM order_info WHERE ID="+ID+"";
                    table1.setModel(ResetTable.reset(GetTable.queryDate(sql,data,head[0]),head[0]));
                }
        );

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(210, 50), scrollPane1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(700, 520));
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
    private JLabel label7;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private Object[][] data = null;
    private String head[][] = {
            {"商品ID","订单数量","单价","总价","下单时间"},
            {"日期","销售额"},
            {"月份","销售额"}
    };
    private String sql[] = {
            "SELECT id,amount,item_price,order_price,order_time FROM order_info;",
            "SELECT * FROM sales_volume ORDER BY volume DESC;",
            "SELECT * FROM sales_volume ORDER BY total_sales DESC;",
            "SELECT * FROM daily_sales;",
            "SELECT * FROM monthly_sales"
    };
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Order();
    }
}
