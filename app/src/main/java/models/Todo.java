package models;

public class Todo {
    private String title;
    private String des;

    public Todo(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public Todo() {

    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
