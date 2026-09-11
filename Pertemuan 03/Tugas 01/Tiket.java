public class Tiket {
    private String judulFilm;
    private double hargaDasar;
    private boolean statusPembayaran;

    Tiket(String jdlFil, double harga){
        if (harga < 0) {
            harga = 35000;
        }
        judulFilm = jdlFil;
        hargaDasar = harga;
        statusPembayaran = false;
    }
    
    public String getJudulFilm(){
        return judulFilm;
    }

    public double getHargaDasar(){
        return hargaDasar;
    }

    public void lakukanPembayaran(){
        statusPembayaran = true;
    }
    
    public String isStatusPembayaran(){
        String msg = "";
        if (statusPembayaran) {
            msg = "Sudah Dibayar";
        } else {
            msg = "Belum Dibayar";
        }
        return msg;
    } 


}
