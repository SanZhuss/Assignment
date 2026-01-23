public class ChildViewer extends Viewer {

    public ChildViewer(int id, int age) {
        super(id, age);
    }

    @Override
    public double getDiscount() {
        return 0.2;
    }
}
