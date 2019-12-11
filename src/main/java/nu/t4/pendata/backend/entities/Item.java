package nu.t4.pendata.backend.entities;

public class Item {
    int id;
    int userId;
    String link;

    public Item() {
    }

    public Item(int id, int userId, String link) {
        this.id = id;
        this.userId = userId;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
