package cn.edu.guet.zt.statistics.bean;

import java.util.Objects;

public class MonthlySales {
    /**
     * 获取月销售表monthly_sales
     */
    private String month;
    private int sales;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonthlySales)) return false;
        MonthlySales that = (MonthlySales) o;
        return sales == that.sales && Objects.equals(getMonth(), that.getMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonth(), sales);
    }

    @Override
    public String toString() {
        return "MonthlySales{" +
                "month='" + month + '\'' +
                ", sales=" + sales +
                '}';
    }
}
