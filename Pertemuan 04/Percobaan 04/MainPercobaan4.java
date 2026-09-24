public class MainPercobaan4 {
    public static void main(String[] args) {
        Penumpang p = new Penumpang("12345", "Mr. Krab");
        Gerbong gerbong = new Gerbong("A", 10);
        gerbong.setPenumpang(p, 1);
        System.out.println(gerbong.info());

        Penumpang p1 = new Penumpang("24356", "Budi");
        gerbong.setPenumpang(p1, 1);
        System.out.println(gerbong.info());
    }
}