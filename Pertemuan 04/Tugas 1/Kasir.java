public class Kasir {
    private String nama;

    public Kasir(String nama) {
        this.nama = nama;
    }

    public void cetakStruk(Pesanan pesanan) { //Bagian Dependency
        System.out.println("=== STRUK PEMBAYARAN ===");
        System.out.println("Kasir   : " + this.nama);
        System.out.println("ID Pesan: " + pesanan.getIdPesanan());
        System.out.println("Items   :");
        
        Menu[] items = pesanan.getArrayMenu();
        for (int i = 0; i < pesanan.getJumlahMenu(); i++) {
            System.out.println(" - " + items[i].getNama() + " : Rp" + items[i].getHarga());
        }
        
        System.out.println("Total   : Rp" + pesanan.hitungTotal());
        System.out.println("=======================");
    }
}