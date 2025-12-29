// ======================= Viewer.java =======================
public class Viewer {
    protected String name;
    protected int age;
    protected int id;

    public Viewer(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //Method
    public double getDiscount() {
        return 0.0;
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

    @Override
    public String toString() {
        return "Viewer: " + name + ", Age: " + age ;
    }
}

