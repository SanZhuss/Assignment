public class VIPViewer extends AdultViewer {

    public VIPViewer(int id, int age) {
        super(id, age);
    }

    @Override
    public double getDiscount() {
        return 0.50;
    }
}
