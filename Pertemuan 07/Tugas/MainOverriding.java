public class MainOverriding {

    public static void main(String[] args) {
        Manusia[] orang = new Manusia[2];
        orang[0] = new Dosen();
        orang[1] = new Mahasiswa();

        for (Manusia m : orang) {
            m.bernafas();
            m.makan(); 
        }

        ((Dosen) orang[0]).lembur();
        ((Mahasiswa) orang[1]).tidur();
    }
}
