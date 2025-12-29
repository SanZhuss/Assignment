public class VIPViewer extends Viewer{
    private int vipId;

    public VIPViewer(String name, int age, int vipId){
        super(name, age);
        this.vipId = vipId;
    }


    public int getVipId(){ return this.vipId; };
    @Override
    public double getDiscount(){return 0.5;}

    public void setVipId(int vipId){ this.vipId = vipId; };
}
