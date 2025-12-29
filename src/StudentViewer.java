public class StudentViewer extends Viewer{
    private String university;

    public StudentViewer(String name, int age, String university){
        super(name, age);
        this.university = university;
    }


    public String getUniversity(){ return this.university; };
    @Override
    public double getDiscount(){return 0.2;}

    public void setUniversity(String university){ this.university = university; };
}
