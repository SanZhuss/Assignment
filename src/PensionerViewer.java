public class PensionerViewer extends AdultViewer {

    public PensionerViewer(int id, int age) {
        super(id, age);
    }

    @Override
    public double getDiscount() {
        return 0.30; // 30%
    }
}
