package cn.itcast.blog.pojo;

public class BlogInfo {
    private String username;
    private String blogtitle;
    private String idiograph;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public String getIdiograph() {
        return idiograph;
    }

    public void setIdiograph(String idiograph) {
        this.idiograph = idiograph;
    }

    @Override
    public String toString() {
        return "BlogInfo{" +
                "username='" + username + '\'' +
                ", blogtitle='" + blogtitle + '\'' +
                ", idiograph='" + idiograph + '\'' +
                '}';
    }
}