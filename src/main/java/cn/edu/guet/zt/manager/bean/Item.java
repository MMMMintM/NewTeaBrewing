package cn.edu.guet.zt.manager.bean;

import java.util.Objects;

public class Item {
    private int id;
    private String title;
    private int price ;
    private String des;
    private int sales;
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() && getPrice() == item.getPrice() && getSales() == item.getSales() && Objects.equals(getTitle(), item.getTitle()) && Objects.equals(getDes(), item.getDes()) && Objects.equals(getImgUrl(), item.getImgUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPrice(), getDes(), getSales(), getImgUrl());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", des='" + des + '\'' +
                ", sales=" + sales +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
