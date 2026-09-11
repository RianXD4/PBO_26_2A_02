public class TestBuku {
    public static void main(String[] args) {
        Buku buku1 = new Buku();
        buku1.isbn = "978-979-29-6104-2";
        buku1.judul = "Dasar Pemrograman Berbasis";
        buku1.penulis = "Abdul Kadir";
        buku1.tahunTerbit = 2021;
        buku1.tampilInfoBuku();

        Buku buku2 = new Buku();
        buku2.isbn = "978-602-291-662-8";
        buku2.judul = "Laskar Pelangi";
        buku2.penulis = "Andrea Hirata";
        buku2.penerbit = "Bentang Pustaka";
        buku2.tahunTerbit = 2005;
        buku2.tampilInfoBuku();

        Buku buku3 = new Buku();
        buku3.isbn = "978-602-6208-88-0";
        buku3.judul = "The Old Man and the Sea";
        buku3.penulis = "Ernest Hemingway";
        buku3.penerbit = "Pustaka Jaya";
        buku3.tahunTerbit = 1973;
        buku3.tampilInfoBuku();

        
    }    
}
