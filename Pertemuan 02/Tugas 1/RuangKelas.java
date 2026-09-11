public class RuangKelas {
    String kodeRuang;
    String namaGedung;
    int kapasitas;
    int jumlahMahasiswa;

    public RuangKelas(String kodeRuang, String namaGedung, int kapasitas, int jumlahMahasiswa){
        this.kodeRuang = kodeRuang;
        this.namaGedung = namaGedung;
        this.kapasitas = kapasitas;
        this.jumlahMahasiswa = jumlahMahasiswa;
    }

    public int hitungSisaKursi(){
        int avaib = kapasitas - jumlahMahasiswa;
        if (avaib > 0) {
            return avaib;
        } else {
            return 0;
        }
    }

    public void tampilData(){
        System.out.println("Kode Ruang       : "+kodeRuang);
        System.out.println("Nama Gedung      : "+namaGedung);
        System.out.println("Kapasitas        : "+kapasitas);
        System.out.println("Jumlah Mahasiswa : "+jumlahMahasiswa);
        System.out.println("Sisa Kursi       : "+hitungSisaKursi());
    }
}
