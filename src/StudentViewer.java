public class StudentViewer extends AdultViewer {

    public StudentViewer(int id, int age) {
        super(id, age);
    }

    @Override
    public double getDiscount() {
        return 0.15; // 15%
    }
}
