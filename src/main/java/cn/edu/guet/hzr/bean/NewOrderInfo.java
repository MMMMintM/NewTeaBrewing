package cn.edu.guet.hzr.bean;

import java.util.Date;
import java.util.Objects;

public class NewOrderInfo {

    private String ID;
    private int customerID;
    private int mchID;
    private String outTradeNo;
    private Date orderTime;
    private String transactionID;
    private int userID;
    private int itemID;
    private float itemPrice;
    private int amount;
    private float orderPrice;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getMchID() {
        return mchID;
    }

    public void setMchID(int mchID) {
        this.mchID = mchID;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewOrderInfo)) return false;
        NewOrderInfo that = (NewOrderInfo) o;
        return getCustomerID() == that.getCustomerID() && getMchID() == that.getMchID() && getUserID() == that.getUserID() && getItemID() == that.getItemID() && Float.compare(that.getItemPrice(), getItemPrice()) == 0 && getAmount() == that.getAmount() && Float.compare(that.getOrderPrice(), getOrderPrice()) == 0 && Objects.equals(getID(), that.getID()) && Objects.equals(getOutTradeNo(), that.getOutTradeNo()) && Objects.equals(getOrderTime(), that.getOrderTime()) && Objects.equals(getTransactionID(), that.getTransactionID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCustomerID(), getMchID(), getOutTradeNo(), getOrderTime(), getTransactionID(), getUserID(), getItemID(), getItemPrice(), getAmount(), getOrderPrice());
    }

    @Override
    public String toString() {
        return "NewOrderInfo{" +
                "ID='" + ID + '\'' +
                ", customerID=" + customerID +
                ", mchID=" + mchID +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", orderTime=" + orderTime +
                ", transactionID='" + transactionID + '\'' +
                ", userID=" + userID +
                ", itemID=" + itemID +
                ", itemPrice=" + itemPrice +
                ", amount=" + amount +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
