import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TUGAS 2 - Relasi antar class.
 * Laboratorium menampung banyak Laptop dan mencatat semua Peminjaman.
 */
public class Laboratorium {
    public static final int MAKS_PINJAM = 2;   // batas pinjaman aktif per mahasiswa

    private final String nama;
    private final List<Laptop> daftarLaptop = new ArrayList<>();
    private final List<Peminjaman> riwayat = new ArrayList<>();

    public Laboratorium(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public boolean tambahLaptop(Laptop lp) {
        // Kembalikan false jika lp null atau kode aset sudah ada
        if (lp == null || cariLaptop(lp.getKodeAset()) != null) {
            return false;
        }
        daftarLaptop.add(lp);
        return true;
    }

    public Laptop cariLaptop(String kodeAset) {
        if (kodeAset == null) {
            return null;
        }
        for (Laptop lp : daftarLaptop) {
            if (lp.getKodeAset().equals(kodeAset)) {
                return lp;
            }
        }
        return null;
    }

    public int jumlahPinjamanAktif(Mahasiswa m) {
        if (m == null) {
            return 0;
        }
        int count = 0;
        for (Peminjaman p : riwayat) {
            if (p.isAktif() && p.getMahasiswa().getNim().equals(m.getNim())) {
                count++;
            }
        }
        return count;
    }

    public Peminjaman pinjamkan(Mahasiswa m, String kodeAset) {
        if (m == null) {
            return null;
        }

        Laptop laptop = cariLaptop(kodeAset);

        if (laptop == null || !laptop.isTersedia() || jumlahPinjamanAktif(m) >= MAKS_PINJAM) {
            return null;
        }

    
        laptop.pinjam();

        Peminjaman p = new Peminjaman(m, laptop);
        riwayat.add(p);
        return p;
    }

    public boolean kembalikan(String kodeAset) {
        if (kodeAset == null) {
            return false;
        }

        // Cari peminjaman yang aktif untuk laptop tersebut
        for (Peminjaman p : riwayat) {
            if (p.isAktif() && p.getLaptop().getKodeAset().equals(kodeAset)) {
                p.selesai();               
                p.getLaptop().kembalikan(); 
                return true;
            }
        }

        return false;
    }

    public List<Laptop> getDaftarLaptop() {
        // Kembalikan daftar yang TIDAK bisa diubah dari luar class
        return Collections.unmodifiableList(daftarLaptop);
    }
}