public class Laptop {
    String kodeInventaris;
    String merk;
    int ramGB;

    public void tampilSpesifikasi(){
        System.out.println("Kode Inventaris : "+kodeInventaris);
        System.out.println("Merk            : "+merk);
        System.out.println("RAM             : "+ramGB);
    }

    public int upgradeRam(int tambahanGB){
        ramGB = ramGB + tambahanGB;
        return  ramGB;
    }

    public  int hitungHargaSewa(int jumlahHari){
        int harga = jumlahHari * 25000;
        return  harga;
    }
}

