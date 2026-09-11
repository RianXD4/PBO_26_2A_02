public class MataKuliah {
    String kodeMK;
    String namaMK;
    int sks;
    double nilaiAngka;

    public MataKuliah(String kodeMK, String namaMK, int sks, double nilaiAngka){
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.nilaiAngka = nilaiAngka;
    }

    public double hitungBobotNilai(){
        return  sks*nilaiAngka;
    }

    public void tampilData(){
        System.out.println("Kode Mata Kuliah : "+kodeMK);
        System.out.println("Nama Mata Kuliah : "+namaMK);
        System.out.println("SKS              : "+sks);
        System.out.println("Nilai Angka      : "+nilaiAngka);
        System.out.println("Bobot Nilai      : "+hitungBobotNilai());
    }
}
