public class Kipas_Gantung extends Kipas_Angin{
    boolean clockwise_rotate;

    public void winter_Mode(){
        clockwise_rotate = true;
        System.out.println("Mode hangat sudah berhasil diaktifkan");
    }

    public void summer_Mode(){
        clockwise_rotate = false;
        System.out.println("Mode dingin sudah berhasil diaktifkan");
    }

    @Override
    public void tampil_Info(){
        System.out.println("Level angin\t: "+level);
        System.out.println("Mode\t:"+((clockwise_rotate) ? "Mode Hangat" : "Mode Dingin"));
    }
}