public class AdultViewer extends Viewer {

    public AdultViewer(int id, int age) {
        super(id, age);
    }

    @Override
    public double getDiscount() {
        return 0.0;
    }
}
