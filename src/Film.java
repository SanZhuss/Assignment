// ======================= Film.java =======================
public class Film {
    private String title;
    private String genre;
    private double rating;
    private double price;

    public Film(String title, String genre, double price, double rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    // Getters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPrice(double price) { this.price = price; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Film: " + title + " (" + genre + ") Ticket price: " + price + " Rating: " + rating;
    }
}
