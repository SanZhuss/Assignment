// ======================= Main.java =======================
public class Main{
    public static void main(String[] args) {

        // Create Films
        Film f1 = new Film("Inception", "Sci-Fi", 148);
        Film f2 = new Film("Interstellar", "Sci-Fi", 169);
        Film f3 = new Film("Solaris", "Sci-Fi", 121);

        // Create Viewers
        Viewer v1 = new Viewer("Alice", 22);
        Viewer v2 = new Viewer("Bob", 30);

        // Create Cinemas
        Cinema c1 = new Cinema("MegaCinema", "Downtown");
        Cinema c2 = new Cinema("StarCinema", "City Center");

        // Output to console
        f1.printInfo();
        f2.printInfo();
        v1.printInfo();
        v2.printInfo();
        c1.printInfo();
        c2.printInfo();

        System.out.println("\n===== COMPARISON =====");

        // Compare Films
        IO.println("f1 equals f2? " + f1.equals(f2));
        IO.println("f1 equals f3? " + f1.equals(f3));

        // Compare Viewers
        IO.println("v1 equals v2? " + v1.equals(v2));

        // Compare Cinemas
        IO.println("c1 equals c2? " + c1.equals(c2));
    }
}
