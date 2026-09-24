public class Restoran {
    private String nama;
    private Meja[] arrayMeja;

    public Restoran(String nama, int jumlahMeja) {
        this.nama = nama;
        this.arrayMeja = new Meja[jumlahMeja]; //bagian Composition nya
        this.initMeja();
    }

    private void initMeja() {
        for (int i = 0; i < arrayMeja.length; i++) {
            this.arrayMeja[i] = new Meja(i + 1);
        }
    }

    public String getNama() {
        return nama;
    }

    public String info(){
        String info = "";
        info += "List Meja\n";
        for (int i = 0; i < arrayMeja.length; i++) {
            info += "No Meja Ke-"+(i+1)+" : "+arrayMeja[i].getNomorMeja()+"\n";
        }
        return info;
    }
}