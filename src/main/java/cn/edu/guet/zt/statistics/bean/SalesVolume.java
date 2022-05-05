package cn.edu.guet.zt.statistics.bean;

import java.sql.Time;
import java.util.Date;
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
    private Date update_time;

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

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesVolume)) return false;
        SalesVolume that = (SalesVolume) o;
        return getId() == that.getId() && getVolume() == that.getVolume() && getTotal_sales() == that.getTotal_sales() && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getUpdate_time(), that.getUpdate_time());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getVolume(), getTotal_sales(), getUpdate_time());
    }

    @Override
    public String toString() {
        return "SalesVolume{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", volume=" + volume +
                ", total_sales=" + total_sales +
                ", update_time=" + update_time +
                '}';
    }
}
