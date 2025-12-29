// ======================= Main.java =======================

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;


public class Main{
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    List<Cinema> cinemas = new ArrayList<>();
    List<Film> films = new ArrayList<>();
    List<Film> filmsBooked = new ArrayList<>(); Film resFilm;
    List<Cinema> cinemasBooked = new ArrayList<>();
    List<Viewer> viewers = new ArrayList<>();
    int count = 0;
    int people = 0;
    boolean key = true; double price;
    public void showCinema() {
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

    public void setCinema(){
        IO.println("Выберите удобный кинотеатр (от 1 до 7): ");
        int cinemaNO = input.nextInt();
        input.nextLine();
        cinemasBooked.add(cinemas.get(cinemaNO-1));
    }

    public void showFilm(){
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
                double price = 1000 + random.nextInt(1001); // 80–140 minutes
                double rating = Math.round((5 + random.nextDouble() * 5) * 10.0) / 10.0; // 5.0–10.0
                films.add(new Film(title, genre, price, rating));
            }
        }
        count = 7;
        IO.println("Список доступных фильмов: ");
        int cnt = 0;
        for(Film fl : films){
            cnt++;
            IO.println(cnt + ". " + fl);
        }
    };

    public void setFilm(){
        IO.println("Выберите фильм: ");
        int filmNO = input.nextInt();
        input.nextLine();
        resFilm = films.get(filmNO-1);
        filmsBooked.add(films.get(filmNO-1));
    }

    public void setViewer(){
        Scanner input = new Scanner(System.in);
        int id; people++;
        Viewer person;
        IO.println("Имя зрителя: ");
        String name = input.nextLine();

        IO.println("Возраст: ");
        int age = input.nextInt();
        input.nextLine();

        IO.println("Кто вы?(Введите число): \n1)Студент  \n2)Взрослый  \n3)ВИП Персона");
        int vwr = input.nextInt();
        input.nextLine();

        if(vwr==1) {
            IO.println("Введите название вашего Университета:");
            String univ = input.nextLine();
            person = new StudentViewer(name, age, univ);
            this.price = resFilm.getPrice()*(1-person.getDiscount());
            viewers.add(person);
        } else if (vwr==2) {
            IO.println("Введите Старховой номер:");
            id = input.nextInt();
            input.nextLine();
            person = new PensionerViewer(name, age, id);
            this.price = resFilm.getPrice()*(1-person.getDiscount());
            viewers.add(person);
        } else if (vwr == 3) {
            IO.println("Введите VIP номер:");
            id = input.nextInt();
            input.nextLine();
            person = new VIPViewer(name, age, id);
            this.price = resFilm.getPrice()*(1-person.getDiscount());
            viewers.add(person);
        }
        IO.println("Стоимость билета: " + this.price);
        IO.println("Введите сумму денег: ");
        double balance = input.nextInt();
        input.nextLine();

        while(true){
            if(balance < resFilm.getPrice()){
                IO.println("Недостаточно средств! Пожалуйста, введите новую сумму денег: ");
                balance = input.nextInt();
                input.nextLine();
            }
            else{
                break;
            }
        }
        IO.println("Билет куплен. Cдача: " + (balance-price));
    };

    public void showTicket(){
        for(int i = 0; i < people; i++){
            IO.println((i+1) + ")\n" + "- " + cinemasBooked.get(i) + "\n" + "- " + filmsBooked.get(i) + "\n" + "- " + viewers.get(i));
        }
    }

    public void menuBooking(){
        while(this.key){
            IO.println("Букинг: \n1)Кинотеатры \n2)Фильмы \n3)Купить билеты");
            count = 0;
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    showCinema();
                    break;
                case 2:
                    showFilm();
                    break;
                case 3:
                    setCinema();
                    setFilm();
                    setViewer();
                    this.key = false;
                    break;
                default:
                    this.key = false;
                    break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main app = new Main();
        while(true){
            app.menuBooking();
            app.key = true;
            IO.println("Хотите еще одного человека добавить?(yes/no):");
            String st = input.nextLine();
            if (st.equalsIgnoreCase("no")){
                break;
            }
        }
    }
}
