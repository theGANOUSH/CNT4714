package common;

public class Book {
	private int ID;
    private String price;
    private String Title;

    public Book(int id, String price, String title) {
        this.ID = id;
        this.price = price;
        this.Title = title;
    }
    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }
    public String toString() {
        return ID + " " + Title + " " +"$"+ price + " ";
    }
}
