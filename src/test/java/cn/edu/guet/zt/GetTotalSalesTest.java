package cn.edu.guet.zt;

import cn.edu.guet.zt.statistics.util.GetTotalSales;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetTotalSalesTest {
    @Before
    public void m1(){
        System.out.println("1");
    }

    @Test
    public void test(){
        String rs;
        rs = GetTotalSales.getSales();
        System.out.println(rs);
    }

    @After
    public void m2(){
        System.out.println("2");
    }
}
