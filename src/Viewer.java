// ======================= Viewer.java =======================
public class Viewer {
    private String name;
    private int age;

    public Viewer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    public void printInfo() {
        IO.println("Viewer: " + name + ", Age: " + age);
    }

    // Compare viewers by name
    public boolean equals(Viewer other) {
        return this.name.equals(other.name);
    }
}

