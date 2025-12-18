// ======================= Viewer.java =======================
public class Viewer {
    private String name;
    private int age;
    private String ticket;

    public Viewer(String name, int age, String ticket) {
        this.name = name;
        this.age = age;
        this.ticket = ticket;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getTicket() { return ticket;}

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setTicket(String ticket) { this.ticket = ticket; }

    public void printInfo() {
        IO.println("Viewer: " + name + ", Age: " + age + ", Ticket: " + ticket);
    }

    @Override
    public String toString() {
        return "Viewer: " + name + ", Age: " + age + ", Ticket: " + ticket;
    }
}

