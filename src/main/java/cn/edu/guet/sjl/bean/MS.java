package cn.edu.guet.sjl.bean;

import java.util.Objects;

public class MS {
    private int id;
    private int user_id;
    private float order_price;
    private String order_time;
    private int amount;
    private int transaction_id;


    public int getId() {
        return id;
    }

    public int getuser_id() {
        return user_id;
    }

    public float getorder_price() {
        return order_price;
    }


    public String getorder_time() {
        return order_time;
    }


    public int getamount() {
        return amount;
    }

    public int gettransaction_id() {
        return transaction_id;
    }



    //////
    public void setId(int id) {
        this.id=id;
    }

    public void setuser_id(int user_id) {
        this.user_id=user_id;
    }

    public void setorder_price(float order_price) {
        this.order_price=order_price;
    }


    public void setorder_time(String order_time) {
        this.order_time=order_time;
    }


    public void setamount(int amount) {
        this.amount=amount;
    }

    public void settransaction_id(int transaction_id) {
        this.transaction_id=transaction_id;
    }





    @Override
    public String toString() {
        return "MS{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", order_price=" + order_price +
                ", order_time='" + order_time + '\'' +
                ", amount=" + amount +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MS milkeTea = (MS) o;
        return id == milkeTea.id && Float.compare(milkeTea.order_price, order_price) == 0 && amount == milkeTea.amount && transaction_id==milkeTea.transaction_id && user_id==milkeTea.user_id && Objects.equals(order_time, milkeTea.order_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, order_price, order_time, amount, transaction_id);
    }
}
