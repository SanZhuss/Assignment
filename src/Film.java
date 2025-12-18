// ======================= Film.java =======================
public class Film {
    private String title;
    private String genre;
    private int duration; // minutes
    private double rating;

    public Film(String title, String genre, int duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    // Getters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
    public double getRating() { return rating; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Film: " + title + " (" + genre + ", " + duration + " min)" + " Rating: " + rating;
    }

}
