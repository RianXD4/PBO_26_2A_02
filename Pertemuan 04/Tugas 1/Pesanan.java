public class Pesanan {
    private String idPesanan;
    private Menu[] arrayMenu;
    private int jumlahMenu;

    public Pesanan(String idPesanan, int kapasitasMaksimal) {
        this.idPesanan = idPesanan;
        this.arrayMenu = new Menu[kapasitasMaksimal];
        this.jumlahMenu = 0;
    }

    public void tambahMenu(Menu menu) {
        if (jumlahMenu < arrayMenu.length) {
            this.arrayMenu[jumlahMenu] = menu; //Bagian Aggregation
            jumlahMenu++;
        } else {
            System.out.println("Kapasitas pesanan sudah penuh!");
        }
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < jumlahMenu; i++) {
            total += arrayMenu[i].getHarga();
        }
        return total;
    }

    public Menu[] getArrayMenu() {
        return arrayMenu;
    }

    public int getJumlahMenu() {
        return jumlahMenu;
    }

    public String getIdPesanan() {
        return idPesanan;
    }
}