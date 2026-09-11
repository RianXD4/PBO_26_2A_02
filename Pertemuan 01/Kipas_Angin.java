public class Kipas_Angin {
    int level;
    boolean auto_turn;

    public void input(int lvl){
        level = lvl;
    }

    public void auto_turn_on(){
        boolean auto_turn = true;
        System.out.println("Putar otomatisnya berhasil dinyalakan");
    }

    public void auto_turn_off(){
        boolean auto_turn = false;
        System.out.println("Putar otomatisnya berhasil dimatikan");
    }
    
    public void tampil_Info(){
        System.out.println("Level angin\t: "+level);
        System.out.println("Putar Otomatis\t: "+auto_turn);
    }
}
