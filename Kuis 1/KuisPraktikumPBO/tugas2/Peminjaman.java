/**
 * TUGAS 2 - Relasi antar class.
 * Satu objek Peminjaman mencatat SATU mahasiswa yang meminjam SATU laptop.
 * Lengkapi setiap bagian bertanda TODO.
 */
public class Peminjaman {
    private Mahasiswa mahasiswa;
    private Laptop laptop;
    private boolean aktif;
    // Done: deklarasikan atribut private (mahasiswa, laptop, aktif)

    public Peminjaman(Mahasiswa mahasiswa, Laptop laptop) {
        // DONE: simpan mahasiswa dan laptop. Peminjaman baru selalu aktif.
        this.mahasiswa = mahasiswa;
        this.laptop = laptop;
        this.aktif = true;
    }

    public Mahasiswa getMahasiswa() {
        // done
        return mahasiswa;
    }

    public Laptop getLaptop() {
        // DONE
        return laptop;
    }

    public boolean isAktif() {
        // DONE
        return aktif;
    }

    public void selesai() {
        // DONE: tandai peminjaman sudah tidak aktif
        this.aktif = false;
    }
}
