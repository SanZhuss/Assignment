public class Ticket {

    private int finalPrice;

    public void calculatePrice(Film film, Viewer viewer) {
        finalPrice = (int)(film.getPrice() * (1 - viewer.getDiscount()));
    }

    public int getFinalPrice() {
        return finalPrice;
    }
}