// ======================= Cinema.java =======================
public class Cinema {
    private String name;
    private String location;

    public Cinema(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters
    public String getName() { return name; }
    public String getLocation() { return location; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }

    public void printInfo() {
        IO.println("Cinema: " + name + " | Location: " + location);
    }

    // Compare cinemas by name
    public boolean equals(Cinema other) {
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Cinema: " + name + " | Location: " + location;
    }
}
