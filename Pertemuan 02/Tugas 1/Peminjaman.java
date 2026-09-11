public class Peminjaman {
    String idPeminjaman;
    String judul;
    String namaPeminjam;
    int lamaPeminjam;

    public Peminjaman(String idpeminjam, String jdl, String nmPeminjam, int lamapeminjam){
        idPeminjaman = idpeminjam;
        judul = jdl;
        namaPeminjam = nmPeminjam;
        lamaPeminjam = lamapeminjam;
    }

    public int hitungTelat(){
        int telat = lamaPeminjam - 7;
        if (telat > 0) {
            return telat;
        } else {
            return  0;
        }
    }

    public int hitungDenda(){
        int telat = hitungTelat();
        if (telat > 0) {
            return telat * 1000;
        } else {
            return 0;
        }
    }

    public void tampilkanDataTransaksi(){
        System.out.println("ID Peminjaman    : "+idPeminjaman);
        System.out.println("Judul Buku       : "+judul);
        System.out.println("Nama Peminjam    : "+namaPeminjam);
        System.out.println("Lama Peminjaman  : "+lamaPeminjam+" Hari");
        System.out.println("Telat            : "+hitungTelat()+" Hari");
        System.out.println("Denda            : RP."+hitungDenda());
    }
}
