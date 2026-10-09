import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Penguji otomatis Tugas 1. JANGAN mengubah file ini.
 * Kompilasi : javac *.java
 * Jalankan  : java UjiTugas1
 */
public class UjiTugas1 {
    interface Uji { boolean jalankan() throws Exception; }
    interface Aksi { void jalankan() throws Exception; }

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

    static boolean melempar(Class<? extends Throwable> tipe, Aksi a) {
        try {
            a.jalankan();
            return false;
        } catch (Throwable e) {
            return tipe.isInstance(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Uji Tugas 1: Enkapsulasi ===");

        cek("konstruktor menyimpan data dan laptop baru tersedia", () -> {
            Laptop lp = new Laptop("LP-01", "Asus", 8);
            return "LP-01".equals(lp.getKodeAset()) && "Asus".equals(lp.getMerk())
                    && lp.getRamGB() == 8 && lp.isTersedia();
        });

        cek("kode aset yang tidak diawali 'LP-' ditolak", () ->
                melempar(IllegalArgumentException.class, () -> new Laptop("PC-01", "Asus", 8)));

        cek("merk kosong ditolak", () ->
                melempar(IllegalArgumentException.class, () -> new Laptop("LP-02", "  ", 8)));

        cek("RAM selain 4, 8, 16, 32 ditolak", () ->
                melempar(IllegalArgumentException.class, () -> new Laptop("LP-03", "Acer", 12)));

        cek("pinjam() pertama berhasil dan status berubah", () -> {
            Laptop lp = new Laptop("LP-04", "Asus", 8);
            return lp.pinjam() && !lp.isTersedia();
        });

        cek("pinjam() kedua kali gagal (laptop sedang dipinjam)", () -> {
            Laptop lp = new Laptop("LP-05", "Asus", 8);
            lp.pinjam();
            return !lp.pinjam();
        });

        cek("kembalikan() membuat laptop tersedia lagi", () -> {
            Laptop lp = new Laptop("LP-06", "Asus", 8);
            lp.pinjam();
            lp.kembalikan();
            return lp.isTersedia();
        });

        cek("kembalikan() saat laptop tidak dipinjam ditolak", () ->
                melempar(IllegalStateException.class, () -> new Laptop("LP-07", "Asus", 8).kembalikan()));

        cek("upgradeRam() dari 8 ke 16 berhasil", () -> {
            Laptop lp = new Laptop("LP-08", "Lenovo", 8);
            lp.upgradeRam(16);
            return lp.getRamGB() == 16;
        });

        cek("upgradeRam() ke nilai lebih kecil ditolak dan RAM tidak berubah", () -> {
            Laptop lp = new Laptop("LP-09", "Lenovo", 16);
            boolean ditolak = melempar(IllegalArgumentException.class, () -> lp.upgradeRam(8));
            return ditolak && lp.getRamGB() == 16;
        });

        cek("upgradeRam() ke nilai tidak valid ditolak", () -> {
            Laptop lp = new Laptop("LP-10", "Lenovo", 8);
            return melempar(IllegalArgumentException.class, () -> lp.upgradeRam(24));
        });

        cek("info() menampilkan status tersedia/dipinjam", () -> {
            Laptop lp = new Laptop("LP-11", "Acer", 16);
            boolean awal = lp.info().equals("LP-11 | Acer | 16 GB | tersedia");
            lp.pinjam();
            return awal && lp.info().equals("LP-11 | Acer | 16 GB | dipinjam");
        });

        cek("semua atribut private (minimal 4 atribut) dan tidak ada method setXxx", () -> {
            int jumlah = 0;
            for (Field f : Laptop.class.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) continue;
                if (!Modifier.isPrivate(f.getModifiers())) return false;
                jumlah++;
            }
            for (Method m : Laptop.class.getDeclaredMethods()) {
                if (m.getName().startsWith("set")) return false;
            }
            return jumlah >= 4;
        });

        System.out.println("-------------------------------------");
        System.out.println("Lulus " + lulus + " dari " + total + " uji");
    }
}
