package cn.edu.guet.hhy;

import cn.juntai.wxpaydemo.pay.WXPay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayGUI extends JFrame {
    JPanel contentPane;
    JLabel totlePrice;
    JLabel totolePrice_text;
    JButton updata;
    JButton pay;
    JButton noPay;
    String[][] data;
    public Double sum;

    public void initPayGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        String[] header = {"商品id", "名称", "单价", "数量" };
        TestGUI testGUI = new TestGUI();
        data = testGUI.InittestGui();

        // create a table model
        DefaultTableModel model = new DefaultTableModel(data, header);
        // create a JTable object
        JTable table = new JTable(model);
        // set the style of the table
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);

        // must do: bind a JTable object to a JScrollPane object, otherwise the header of the table will not be displayed in the JPanel.
        JScrollPane jScrollPane = new JScrollPane();
        // key, crucial!
        jScrollPane.setViewportView(table);
        // set the position of the JScrollPane object
        jScrollPane.setBounds(20, 20, 700, 600);
        // add the JScrollPane object to JPanel
        add(jScrollPane);
        //按钮
        totlePrice = new JLabel("总价:");
        totlePrice.setBounds(50,650,100,100);
        totolePrice_text = new JLabel("0元");
        totolePrice_text.setBounds(100,650, 100, 100);
        updata = new JButton("刷新");
        updata.setBounds(200, 650, 70, 50);
        pay = new JButton("支付");
        pay.setBounds(400, 650, 70, 50);
        noPay = new JButton("取消");
        noPay.setBounds(600,650, 70,50);
        contentPane.add(totlePrice);
        contentPane.add(totolePrice_text);
        contentPane.add(pay);
        contentPane.add(noPay);
        contentPane.add(updata);
        //监视器
        updata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalNumber();
            }
        });
        noPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wxpay();
            }
        });


        this.setTitle("购物清单");
        this.setSize(800,800);
        this.setLocation(200,200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void totalNumber() {
         sum = 0.00;
        for (int i = 0; (i < data.length && data[i][0]!=null); i++) {
            sum += Double.parseDouble(data[i][2]) * Double.parseDouble(data[i][3]);
        }
        totolePrice_text.setText(Double.toString(sum));
    }
    public static void main(String[] args) {
        PayGUI payGUI = new PayGUI();
        payGUI.initPayGUI();
    }
    public void wxpay() {
        WXPay.unifiedOrder(sum);
    }
}
