package cn.edu.guet.hld.bean;

import java.util.Objects;

public class MilkeTea {
    private int id;
    private String title;
    private float price;
    private String description;
    private int sales;
    private String img_url;

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
        this.title =title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
    public String toString() {
        return "MilkeTea{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", sales=" + sales +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilkeTea milkeTea = (MilkeTea) o;
        return id == milkeTea.id && Float.compare(milkeTea.price, price) == 0 && sales == milkeTea.sales && Objects.equals(title, milkeTea.title) && Objects.equals(description, milkeTea.description) && Objects.equals(img_url, milkeTea.img_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, sales, img_url);
    }
}
