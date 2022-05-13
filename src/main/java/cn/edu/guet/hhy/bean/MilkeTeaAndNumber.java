package cn.edu.guet.hhy.bean;

public class MilkeTeaAndNumber {
    private int id;
    private String title;
    private float price;
    private int number;

    public MilkeTeaAndNumber(int id, String title, float price, int number) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.number = number;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
