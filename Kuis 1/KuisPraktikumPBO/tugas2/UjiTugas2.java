import java.util.List;

/**
 * Penguji otomatis Tugas 2. JANGAN mengubah file ini.
 * Kompilasi : javac *.java
 * Jalankan  : java UjiTugas2
 */
public class UjiTugas2 {
    interface Uji { boolean jalankan() throws Exception; }

    static int lulus = 0, total = 0;

    static void cek(String nama, Uji u) {
        total++;
        try {
            if (u.jalankan()) {
                lulus++;
                System.out.println("[PASS] " + nama);
            } else {
                System.out.println("[FAIL] " + nama);
            }
        } catch (Throwable e) {
            System.out.println("[FAIL] " + nama + "  (" + e.getClass().getSimpleName() + ")");
        }
    }

    /** Laboratorium berisi tiga laptop: LP-01, LP-02, LP-03. */
    static Laboratorium labBaru() {
        Laboratorium lab = new Laboratorium("Lab Pemrograman 1");
        lab.tambahLaptop(new Laptop("LP-01", "Asus", 8));
        lab.tambahLaptop(new Laptop("LP-02", "Lenovo", 16));
        lab.tambahLaptop(new Laptop("LP-03", "Acer", 8));
        return lab;
    }

    public static void main(String[] args) {
        System.out.println("=== Uji Tugas 2: Relasi antar Class ===");
        Mahasiswa andi = new Mahasiswa("2341720001", "Andi");
        Mahasiswa rina = new Mahasiswa("2341720002", "Rina");

        // --- Peminjaman ---
        cek("Peminjaman baru menyimpan mahasiswa dan laptop, dan aktif", () -> {
            Laptop lp = new Laptop("LP-50", "Asus", 8);
            Peminjaman p = new Peminjaman(andi, lp);
            return p.getMahasiswa() == andi && p.getLaptop() == lp && p.isAktif();
        });

        cek("selesai() membuat peminjaman tidak aktif", () -> {
            Peminjaman p = new Peminjaman(andi, new Laptop("LP-51", "Asus", 8));
            p.selesai();
            return !p.isAktif();
        });

        // --- tambahLaptop dan cariLaptop ---
        cek("tambahLaptop() menyimpan objek laptop yang sama (bukan salinan)", () -> {
            Laboratorium lab = new Laboratorium("Lab A");
            Laptop lp = new Laptop("LP-60", "Asus", 8);
            return lab.tambahLaptop(lp) && lab.cariLaptop("LP-60") == lp;
        });

        cek("tambahLaptop() menolak kode aset yang sudah ada", () -> {
            Laboratorium lab = labBaru();
            return !lab.tambahLaptop(new Laptop("LP-02", "HP", 8))
                    && lab.getDaftarLaptop().size() == 3;
        });

        cek("tambahLaptop(null) ditolak", () -> {
            Laboratorium lab = labBaru();
            return !lab.tambahLaptop(null) && lab.getDaftarLaptop().size() == 3;
        });

        cek("cariLaptop() mengembalikan null untuk kode yang tidak ada", () ->
                labBaru().cariLaptop("LP-99") == null);

        // --- pinjamkan ---
        cek("pinjamkan() berhasil dan laptop menjadi tidak tersedia", () -> {
            Laboratorium lab = labBaru();
            Peminjaman p = lab.pinjamkan(andi, "LP-01");
            return p != null && p.getMahasiswa() == andi
                    && p.getLaptop() == lab.cariLaptop("LP-01")
                    && !lab.cariLaptop("LP-01").isTersedia();
        });

        cek("pinjamkan() laptop yang tidak ada menghasilkan null", () -> {
            Laboratorium lab = labBaru();
            lab.pinjamkan(andi, "LP-01");
            return lab.pinjamkan(andi, "LP-99") == null;
        });

        cek("pinjamkan() laptop yang sedang dipinjam menghasilkan null", () -> {
            Laboratorium lab = labBaru();
            lab.pinjamkan(andi, "LP-01");
            return lab.pinjamkan(rina, "LP-01") == null;
        });

        cek("mahasiswa tidak boleh punya lebih dari 2 pinjaman aktif", () -> {
            Laboratorium lab = labBaru();
            boolean duaPertama = lab.pinjamkan(andi, "LP-01") != null
                    && lab.pinjamkan(andi, "LP-02") != null;
            Peminjaman ketiga = lab.pinjamkan(andi, "LP-03");
            return duaPertama && ketiga == null && lab.cariLaptop("LP-03").isTersedia();
        });

        cek("jumlahPinjamanAktif() dihitung per mahasiswa", () -> {
            Laboratorium lab = labBaru();
            lab.pinjamkan(andi, "LP-01");
            lab.pinjamkan(andi, "LP-02");
            lab.pinjamkan(rina, "LP-03");
            return lab.jumlahPinjamanAktif(andi) == 2 && lab.jumlahPinjamanAktif(rina) == 1;
        });

        // --- kembalikan ---
        cek("kembalikan() menyelesaikan peminjaman dan laptop tersedia lagi", () -> {
            Laboratorium lab = labBaru();
            Peminjaman p = lab.pinjamkan(andi, "LP-01");
            boolean ok = lab.kembalikan("LP-01");
            return ok && !p.isAktif() && lab.cariLaptop("LP-01").isTersedia()
                    && lab.jumlahPinjamanAktif(andi) == 0;
        });

        cek("kembalikan() laptop yang tidak sedang dipinjam menghasilkan false", () ->
                !labBaru().kembalikan("LP-02"));

        cek("setelah mengembalikan, mahasiswa bisa meminjam lagi", () -> {
            Laboratorium lab = labBaru();
            lab.pinjamkan(andi, "LP-01");
            lab.pinjamkan(andi, "LP-02");
            lab.kembalikan("LP-01");
            return lab.pinjamkan(andi, "LP-03") != null && lab.jumlahPinjamanAktif(andi) == 2;
        });

        // --- enkapsulasi daftar ---
        cek("getDaftarLaptop() tidak bisa dipakai untuk menambah laptop dari luar", () -> {
            Laboratorium lab = labBaru();
            List<Laptop> daftar = lab.getDaftarLaptop();
            try {
                daftar.add(new Laptop("LP-77", "Asus", 8));
            } catch (UnsupportedOperationException e) {
                // ditolak: ini perilaku yang benar
            }
            return lab.getDaftarLaptop().size() == 3 && lab.cariLaptop("LP-77") == null;
        });

        System.out.println("-------------------------------------");
        System.out.println("Lulus " + lulus + " dari " + total + " uji");
    }
}
