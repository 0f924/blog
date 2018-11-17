package cn.itcast.blog.pojo;

public class Critique {
    private int id;
    private int AId;
    private String content;
    private String username;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Critique{" +
                "id=" + id +
                ", AId=" + AId +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
