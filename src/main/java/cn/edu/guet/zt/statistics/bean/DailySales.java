package cn.edu.guet.zt.statistics.bean;

import java.util.Objects;

public class DailySales {
    /**
     * 获取日销售表daily_sales
     */
    private String day;
    private int sales;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
        if (!(o instanceof DailySales)) return false;
        DailySales that = (DailySales) o;
        return sales == that.sales && Objects.equals(getDay(), that.getDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), sales);
    }

    @Override
    public String toString() {
        return "DailySales{" +
                "day='" + day + '\'' +
                ", sales=" + sales +
                '}';
    }
}
