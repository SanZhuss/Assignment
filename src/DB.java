import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DB {
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/OOPAssignment";
    private static final String user = "postgres";
    private static final String password = "07Postgres06";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(connectionUrl, user, password);
    }


    public static void registerUser(String name, String password, String email, int age, String role) {
        String sql = "INSERT INTO viewers(name, password, email, role, age) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, password); // позже можно hash
            ps.setString(3, email);
            ps.setString(4, role);
            ps.setInt(5, age);

            ps.executeUpdate();
            System.out.println("Registration successful");
        } catch (SQLException e) {
            System.out.println("User already exists");
        }
    }

    public static Viewer login(String email, String password) {
        String sql = " SELECT role, viewer_id, age FROM viewers " +
                "WHERE email = ? AND password = ? ";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("viewer_id");
                int age = rs.getInt("age");
                String role = rs.getString("role");

                Viewer viewer;

                switch (role) {
                    case "CHILD" -> viewer = new ChildViewer(id, age);
                    case "STUDENT" -> viewer = new StudentViewer(id, age);
                    case "PENSIONER" -> viewer = new PensionerViewer(id, age);
                    case "VIP" -> viewer = new VIPViewer(id, age);
                    default -> viewer = new AdultViewer(id, age);
                }

                return viewer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void showCinemasAndMovies() {
        String sql = "SELECT * FROM cinemas";

        String b = "SELECT mo.movie_id, mo.title, mo.genre, mo.rating FROM movies AS mo";

        try (Connection con = DB.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             ResultSet rs2 = stmt.executeQuery(b)) {

            while (rs.next() && rs2.next()) {
                IO.println(rs.getInt("cinema_id") + ". Cinema: " + rs.getString("name") + " " + " Location: " + rs.getString("location"));
                IO.println("     " + rs2.getInt("movie_id") + ". Movie: " + rs2.getString("title") + " Genre: " + rs2.getString("genre") + " Rating: " + rs2.getDouble("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Film getMovieById(int movieId) {

        String sql = """
        SELECT movie_id, cinema_id, title, genre, price, rating
        FROM movies
        WHERE movie_id = ?
    """;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, movieId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Film(
                        rs.getInt("movie_id"),
                        rs.getInt("cinema_id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("price"),
                        rs.getDouble("rating")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void saveTicket(int viewerId, int movieId, int price) {

        String sql = """
        INSERT INTO tickets(viewer_id, movie_id, price)
        VALUES (?, ?, ?)
    """;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, viewerId);
            ps.setInt(2, movieId);
            ps.setInt(3, price);

            ps.executeUpdate();
            System.out.println("Ticket saved successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error saving ticket");
        }
    }


}
