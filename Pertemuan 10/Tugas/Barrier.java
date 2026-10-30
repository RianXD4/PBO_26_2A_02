public class Barrier implements Destroyable{
    private int strength;
    public Barrier(int str){
        strength = str;
    }
    public void setStrength(int str){
        strength = str;
    }
    public int getStrength(){
        return strength;
    }
    public void destroyed(){
        strength -=9;
    }
    public String getBarrierInfo(){
        return "Strength "+strength;
    }
}
