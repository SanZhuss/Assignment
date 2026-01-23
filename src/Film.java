// ======================= Film.java =======================
public class Film {
    private int id;
    private int cinemaId;
    private String title;
    private String genre;
    private int price;
    private double rating;

    public Film(int id, int cinemaId, String title, String genre, int price, double rating) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    public int getCinemaId() { return cinemaId; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getId() { return id; }
    public int getPrice() { return price; }
    public String getTitle() { return title; }

}

