public class Main {
    public static void main(String[] args) {
        Dosen dosen1 = new Dosen("19850101", "Dr. Budi Santoso", "Jl. Mawar No. 12");
        dosen1.setSKS(12);

        Dosen dosen2 = new Dosen("19900202", "Siti Aminah, M.T.", "Jl. Melati No. 45");
        dosen2.setSKS(15);

        DaftarGaji daftarGaji = new DaftarGaji(2);

        daftarGaji.addPegawai(dosen1);
        daftarGaji.addPegawai(dosen2);

        daftarGaji.printSemuaGaji();
    }
}