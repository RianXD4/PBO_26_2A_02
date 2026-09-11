public class Bioskop {
    public static void main(String[] args) {
        Tiket tiket1 = new Tiket("Avenger", -5000);
        System.out.println("Film: "+tiket1.getHargaDasar());
        System.out.println("Harga Tiket: "+tiket1.getJudulFilm());
        System.out.println("Status Lunas? "+tiket1.isStatusPembayaran());

        System.out.println("\nMemproses pembayaran....");
        tiket1.lakukanPembayaran();
        System.out.println("Status Lunas Terbaru? "+tiket1.isStatusPembayaran());
    }
}
