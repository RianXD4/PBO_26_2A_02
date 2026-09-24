public class Main {
    public static void main(String[] args) {
        Restoran resto = new Restoran("Resto Nusantara", 5);

        Menu m1 = new Menu("Nasi Goreng", 25000);
        Menu m2 = new Menu("Es Teh Manis", 5000);

        Pesanan p1 = new Pesanan("ORD-001", 10);
        p1.tambahMenu(m1);
        p1.tambahMenu(m2);

        Kasir kasir = new Kasir("Budi");
        kasir.cetakStruk(p1);
        
        System.out.println(resto.info());
    }
}