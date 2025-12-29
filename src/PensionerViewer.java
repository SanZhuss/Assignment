public class PensionerViewer extends Viewer{
    private int insuranceNumber;

    public PensionerViewer(String name, int age, int insuranceNumber){
        super(name, age);
        this.insuranceNumber = insuranceNumber;
    }


    public int getInsuranceNumber(){ return this.insuranceNumber; };
    @Override
    public double getDiscount(){return 0.3;}

    public void setInsuranceNumber(int insuranceNumber){ this.insuranceNumber = insuranceNumber; };
}
