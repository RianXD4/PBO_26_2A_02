public class Earphone {
    int sound;
    boolean plugged;

    public void input(int sound, boolean plugged){
        this.sound = sound;
        this.plugged = plugged;
    }

    public void turn_On(){
        if (plugged==true) {
            System.out.println("Earphone berhasil tersambung");
        } else {
            System.out.println("earphone belum disambung");
        }
    }

    public void turn_off(){
        plugged = false;
        System.out.println("Earphone sudah berhasil dicabut");
    }

    public void tampil_Info(){
        System.out.println("Sound\t: "+sound);
        System.out.println("Plugged\t: "+plugged);
    }
}
