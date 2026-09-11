public class Kontainer {
    private String nomorResi, namaPemilik;
    private int kapasitasMaksimal, beratMuatanSaatIni;

    Kontainer(String noRes, String nmPm, int muatan) {
        nomorResi = noRes;
        namaPemilik = nmPm;
        kapasitasMaksimal = muatan;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public String getNomorResi() {
        return nomorResi;
    }

    public int getKapasitasMakasimal() {
        return kapasitasMaksimal;
    }

    public int getMuatanSaatIni() {
        return beratMuatanSaatIni;
    }

    public void tambahMuatan(int baruMuatan) {
        if ((beratMuatanSaatIni + baruMuatan) <= kapasitasMaksimal) {
            beratMuatanSaatIni += baruMuatan;
        } else {
            System.out.println("Muatan Melebihi Kapasitas ");
        }

    }
    public void turunkanMuatan(int baruMuatan) {
        if ((beratMuatanSaatIni / 2) >= baruMuatan) {
            if ((beratMuatanSaatIni - baruMuatan) < 0) {
                beratMuatanSaatIni = 0;
            } else {
                beratMuatanSaatIni -= baruMuatan;
            }
        } else {
            System.out.println("Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!");
        }
    }
}
