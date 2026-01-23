// ======================= Viewer.java =======================
public abstract class Viewer {

    protected int id;
    protected int age;

    public Viewer(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() { return id; }
    public int getAge() { return age; }

    public void setId(int id) { this.id = id; }
    public void setAge(int age) { this.age = age; }

    public boolean isChild() {
        return age < 18;
    }

    public abstract double getDiscount();
}

