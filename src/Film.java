// ======================= Film.java =======================
public class Film {
    private String title;
    private String genre;
    private int duration; // minutes

    public Film(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    // Getters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setDuration(int duration) { this.duration = duration; }

    public void printInfo() {
        IO.println("Film: " + title + " (" + genre + ", " + duration + " min)");
    }

    // Compare films by title
    public boolean equals(Film other) {
        return this.title.equals(other.title);
    }
}
