public class MainPercobaan01 {
    public static void main(String[] args) {
        Processor p = new Processor("Intel i5", 3);
        laptop l = new laptop("Thinkpad", p);
        l.info();

        Processor p1 = new Processor();
        p1.setMerk("Intel i5");
        p1.setCache(4);
        laptop l1 = new laptop();
        l1.setMerk("Thinkpad");
        l1.setProc(p1);
        l1.info();

        laptop l2 = new laptop("Thinkpad", new Processor("Intel i5", 3));
        l2.info();
    }
}
