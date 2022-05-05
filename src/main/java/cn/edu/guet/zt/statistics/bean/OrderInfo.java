package cn.edu.guet.zt.statistics.bean;

import java.util.Date;
import java.util.Objects;

public class OrderInfo {
    private int id;
    private Date date;
    private int order_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOrder_price() {
        return order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderInfo)) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return getId() == orderInfo.getId() && getOrder_price() == orderInfo.getOrder_price() && Objects.equals(getDate(), orderInfo.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getOrder_price());
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", date=" + date +
                ", order_price=" + order_price +
                '}';
    }
}
