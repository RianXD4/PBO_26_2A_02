public class Main {
    public static void main(String[] args) {
        Peminjaman pmj1 = new Peminjaman("513411", "Pemrograman Dasar", "Budi Santoso", 5);
        Peminjaman pmj2 = new Peminjaman("513567", "Basis Data", "Aldi Prono", 10);
        Peminjaman pmj3 = new Peminjaman("513987", "Sistem Operasi", "alek", 17);

        RuangKelas rk1 = new RuangKelas("LPY2", "Sipil", 30, 25);

        pmj1.tampilkanDataTransaksi();
        System.out.println();
        pmj2.tampilkanDataTransaksi();
        System.out.println();
        pmj3.tampilkanDataTransaksi();
        System.out.println();

        rk1.tampilData();
        System.out.println();
        rk1.jumlahMahasiswa = 40;
        rk1.tampilData();
        System.out.println();

        MataKuliah mk1 = new MataKuliah("PBO", "Pemrograman Berbasis Objek", 4, 70);
        MataKuliah mk2 = new MataKuliah("BING 2", "Bahasa Inggris 2", 4, 85);
        MataKuliah mk3 = new MataKuliah("ManPro", "Manajemen Projek", 6, 70);

        mk1.tampilData();
        System.out.println();
        mk2.tampilData();
        System.out.println();
        mk3.tampilData();

    }
}
