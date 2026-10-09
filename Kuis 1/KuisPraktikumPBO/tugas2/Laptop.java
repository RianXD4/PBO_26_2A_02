public class Laptop {
    private final String kodeAset;
    private final String merk;
    private int ramGB;
    private boolean tersedia;

    public Laptop(String kodeAset, String merk, int ramGB) {
        if (kodeAset == null || !kodeAset.startsWith("LP-")) {
            throw new IllegalArgumentException("Kode aset harus diawali 'LP-'");
        }
        if (merk == null || merk.isBlank()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong");
        }
        if (!ramValid(ramGB)) {
            throw new IllegalArgumentException("RAM harus 4, 8, 16, atau 32 GB");
        }
        this.kodeAset = kodeAset;
        this.merk = merk;
        this.ramGB = ramGB;
        this.tersedia = true;
    }

    private static boolean ramValid(int ram) {
        return ram == 4 || ram == 8 || ram == 16 || ram == 32;
    }

    public String getKodeAset() { return kodeAset; }

    public String getMerk() { return merk; }

    public int getRamGB() { return ramGB; }

    public boolean isTersedia() { return tersedia; }

    public void upgradeRam(int ramBaru) {
        if (!ramValid(ramBaru) || ramBaru <= ramGB) {
            throw new IllegalArgumentException("Upgrade RAM tidak valid: " + ramBaru);
        }
        ramGB = ramBaru;
    }

    public boolean pinjam() {
        if (!tersedia) {
            return false;
        }
        tersedia = false;
        return true;
    }

    public void kembalikan() {
        if (tersedia) {
            throw new IllegalStateException("Laptop " + kodeAset + " tidak sedang dipinjam");
        }
        tersedia = true;
    }

    public String info() {
        return kodeAset + " | " + merk + " | " + ramGB + " GB | "
                + (tersedia ? "tersedia" : "dipinjam");
    }
}
