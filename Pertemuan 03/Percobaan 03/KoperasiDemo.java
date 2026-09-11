public class KoperasiDemo {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota("Iwan","Jalan Mawar");
        System.out.println("Simpanan "+anggota1.getNama()+" : RP "+anggota1.getSimpnan());
        anggota1.setNama("Iwan Setiawan");
        anggota1.setAlamat("Jalan Sukarno Hatta No 10");
        anggota1.setor(100000);
        System.out.println("Simpanan "+anggota1.getNama()+" : RP "+anggota1.getSimpnan());
        anggota1.pinjam(5000);
        System.out.println("Simpanan "+anggota1.getNama()+" : RP "+anggota1.getSimpnan());

    }
}
