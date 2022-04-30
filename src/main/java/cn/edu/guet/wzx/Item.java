package cn.edu.guet.wzx;

import java.util.Objects;

public class Item {
    private int id;
    private String title;
    private Float price;
    private String description;
    private int sales;
    private String img_url;

    public Item() {
    }

    public Item(int id, String title, Float price, String description, int sales, String img_url) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.sales = sales;
        this.img_url = img_url;
    }

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && sales == item.sales && Objects.equals(title, item.title) && Objects.equals(price, item.price) && Objects.equals(description, item.description) && Objects.equals(img_url, item.img_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, sales, img_url);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", sales=" + sales +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
