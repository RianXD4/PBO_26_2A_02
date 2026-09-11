public class Buku {
    String isbn;
    String judul;
    String penulis;
    String penerbit;
    int tahunTerbit;

    public void tampilInfoBuku(){
        System.out.println("ISBN\t\t: "+isbn);
        System.out.println("Judul\t\t: "+judul);
        System.out.println("Penulis\t\t: "+penulis);
        System.out.println("Penerbit\t: "+penerbit);
        System.out.println("Tahun Terbit\t: "+tahunTerbit);
    }
}
