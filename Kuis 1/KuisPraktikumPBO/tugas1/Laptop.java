/**
 * TUGAS 1 - Enkapsulasi.
 * Lengkapi setiap bagian bertanda TODO sesuai spesifikasi di lembar soal.
 * Jangan mengubah nama class, nama method, maupun tipe parameternya.
 */
public class Laptop {
    private String kodeAset;
    private String merk;
    private int ramGB;
    private boolean tersedia;
    // DONE: deklarasikan atribut yang diperlukan (kodeAset, merk, ramGB, tersedia)

    public Laptop(String kodeAset, String merk, int ramGB) {
        // DONE: validasi parameter, lalu isi atribut. Laptop baru selalu tersedia.
        if (kodeAset == null || !kodeAset.startsWith("LP-")) {
            throw new IllegalArgumentException("Kode aset harus diawali 'LP-'");
        }
        if (merk == null || merk.isBlank()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong");
        }
        if (!(ramGB == 4 || ramGB == 8 || ramGB == 16 || ramGB == 32)) {
            throw new IllegalArgumentException("RAM harus 4, 8, 16, atau 32 GB");
        }
        this.kodeAset = kodeAset;
        this.merk = merk;
        this.ramGB = ramGB;
        this.tersedia = true;
    }

    public String getKodeAset() {
        // DONE
        return kodeAset;
    }

    public String getMerk() {
        // DONE
        return getMerk();
    }

    public int getRamGB() {
        // DONE
        return ramGB;
    }

    public boolean isTersedia() {
        // DONE
        return tersedia;
    }

    public void upgradeRam(int ramBaru) {
        // DONE
        if ((ramBaru == 4 || ramBaru == 8 || ramBaru == 16 || ramBaru == 32) && this.ramGB<ramBaru) {
            this.ramGB = ramBaru;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean pinjam() {
        // DONE
        if (tersedia) {
            tersedia = false;
            return true;
        }else {
            return false;
        }
    }

    public void kembalikan() {
        // DONE
        if (tersedia) {
            throw new IllegalArgumentException();
        } 
        tersedia = true;
    }

    public String info() {
        // DONE
        String info = " ";
        info += (kodeAset + " | "+ merk + " | "+ ramGB + " | "+ (tersedia?"Tersedia":"Dipinjam"));
        return info;
    }
}
