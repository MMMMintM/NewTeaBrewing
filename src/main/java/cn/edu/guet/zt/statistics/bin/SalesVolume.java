package cn.edu.guet.zt.statistics.bin;

import java.util.Objects;

public class SalesVolume {
    /**
     *sales_volume
     * 销量表
     */
    private int id;
    private String title;
    private int volume;
    private int total_sales;

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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesVolume)) return false;
        SalesVolume that = (SalesVolume) o;
        return getId() == that.getId() && getVolume() == that.getVolume() && getTotal_sales() == that.getTotal_sales() && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getVolume(), getTotal_sales());
    }

    @Override
    public String toString() {
        return "SalesVolume{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", volume=" + volume +
                ", total_sales=" + total_sales +
                '}';
    }
}
