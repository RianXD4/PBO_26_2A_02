
public class Singa extends Binatang implements IKarnivora {
    private String suara;
    private String warnaBulu;
    
    public Singa(String nama, int jmlKaki, String suara, String warnaBulu) {
        super(nama, jmlKaki);
        this.suara = suara;
        this.warnaBulu = warnaBulu;
    }
    
    @Override
    public void displayMakan() {
        System.out.println("Jenis: Karnivora");
        System.out.println("Makanan: Daging");
    }
    
    @Override
    public void displayBinatang() {
        super.displayBinatang();
        System.out.println("Suara: " + this.suara);
        System.out.println("Warna Bulu: " + this.warnaBulu);
    }
    
    @Override
    public void displayData() {
        displayMakan();
        displayBinatang();
    }
}
