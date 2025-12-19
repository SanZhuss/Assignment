// ======================= Main.java =======================

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;


public class Main{
    static Random random = new Random();
    static Scanner input = new Scanner(System.in);
    static List<Cinema> cinemas = new ArrayList<>();
    static List<Film> films = new ArrayList<>();
    static List<Film> filmsBooked = new ArrayList<>();
    static List<Cinema> cinemasBooked = new ArrayList<>();
    static List<Viewer> viewers = new ArrayList<>();
    static int count = 0;
    static int people = 0;
    public static void showCinema() {
        if(count == 0){
            String[] names = {
                    "StarCinema", "MegaCinema", "UltraCinema", "LegandCinema", "OuterWorldTheater",
                    "CinemaOfJustice", "GoodCinema"
            };

            String[] locations = {
                    "Downtown", "City Center", "Metro Miami Center", "Gotham", "Wall Street",
                    "Anthem Center", "Proud Street"
            };

            for (int i = 0; i < 7; i++) {
                String name = names[i];
                String location = locations[random.nextInt(locations.length)];
                cinemas.add(new Cinema(name, location));
            }
        }

        IO.println("Список кинотеатров: ");
        int count = 0;
        for (Cinema cinem : cinemas) {
            count++;
            IO.println(count + ". " + cinem);
        }
        count = 0;
    };

    public static void setCinema(){
        IO.println("Выберите удобный кинотеатр (от 1 до 7): ");
        int cinemaNO = input.nextInt();
        input.nextLine();
        cinemasBooked.add(cinemas.get(cinemaNO-1));
    }

    public static void showFilm(){
        if(count == 0){
            String[] titles = {
                    "Silent Night", "Dark Horizon", "Last Hope", "Lost City",
                    "Red Shadow", "Golden Path", "Broken Dreams", "Final Escape",
                    "Hidden Truth", "Iron Will", "Cold Fire", "Blue Moon",
                    "Fallen Star", "Midnight Run", "Echoes", "Storm Riders",
                    "Infinite Loop", "Dead Zone", "Neon Lights", "Forgotten Road"
            };

            String[] genres = {
                    "Action", "Drama", "Comedy", "Thriller", "Sci-Fi",
                    "Fantasy", "Horror", "Romance"
            };

            for (int i = 0; i < 20; i++) {
                String title = titles[i];
                String genre = genres[random.nextInt(genres.length)];
                int duration = 80 + random.nextInt(61); // 80–140 minutes
                double rating = Math.round((5 + random.nextDouble() * 5) * 10.0) / 10.0; // 5.0–10.0
                films.add(new Film(title, genre, duration, rating));
            }
        }
        count = 7;
        IO.println("Список доступных фильмов: ");
        for(Film fl : films){
            IO.println("- " + fl);
        }
    };

    public static void setFilm(){
        IO.println("Выберите фильм: ");
        int cinemaNO = input.nextInt();
        input.nextLine();
        filmsBooked.add(films.get(cinemaNO-1));
    }

    public static void setViewer(){
        Scanner input = new Scanner(System.in);
        IO.println("Имя зрителя: ");
        String name = input.nextLine();

        IO.println("Возраст: ");
        int age = input.nextInt();
        input.nextLine();

        String ticket;
        if(age < 18){
            ticket = "child";
        }else{
            ticket = "adult";
        }
        Viewer person = new Viewer(name, age, ticket);
        viewers.add(person);
        people++;
    };

    public static void main(String[] args) {
        while(true){
            showCinema();
            setCinema();
            showFilm();
            setFilm();
            setViewer();
            for(int i = 0; i < people; i++){
                IO.println((i+1) + ")\n" + "- " + cinemasBooked.get(i) + "\n" + "- " + filmsBooked.get(i) + "\n" + "- " + viewers.get(i));
            }
            IO.println("Хотите еще одного человека добавить?(yes/no):");
            String st = input.nextLine();
            if (st.equalsIgnoreCase("no")){
                break;
            }
        }
    }
}
