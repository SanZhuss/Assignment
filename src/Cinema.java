// ======================= Cinema.java =======================
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Cinema {

    static Scanner input = new Scanner(System.in);

    public static void showMovies() {
        System.out.println("Movies list...");
        DB.showCinemasAndMovies();
    }

    public static void buyTicket(Viewer viewer) {

        System.out.print("Movie ID: ");
        int movieId = input.nextInt();

        Film film = DB.getMovieById(movieId);

        Ticket ticket = new Ticket();
        ticket.calculatePrice(film, viewer);

        DB.saveTicket(viewer.getId(), movieId, ticket.getFinalPrice());

        System.out.println("Ticket price: " + ticket.getFinalPrice());
    }
}

