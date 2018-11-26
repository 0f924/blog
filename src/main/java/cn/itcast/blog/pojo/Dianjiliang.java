package cn.itcast.blog.pojo;

import java.util.Date;

public class Dianjiliang {
    private int id;
    private int AId;
    private String ip;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAId() {
        return AId;
    }

    public void setAId(int AId) {
        this.AId = AId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Dianjiliang{" +
                "id=" + id +
                ", AId=" + AId +
                ", ip='" + ip + '\'' +
                ", time=" + time +
                '}';
    }
}
