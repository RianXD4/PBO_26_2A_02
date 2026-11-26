package backend;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Kategori {
    private int idkategori;
    private String nama;
    private String keterangan;

    public Kategori() {}

    public Kategori(String nama, String keterangan) {
        this.nama = nama;
        this.keterangan = keterangan;
    }

    public int getIdKategori() { return idkategori; }
    public void setIdKategori(int idkategori) { this.idkategori = idkategori; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
    
    
    public Kategori getById(int id) {
        Kategori kat = new Kategori();
        ResultSet rs = DBHelper.selectQuery(
            "SELECT * FROM kategori WHERE idkategori = " + id);
        try {
            while (rs.next()) {
                kat.setIdKategori(rs.getInt("idkategori"));
                kat.setNama(rs.getString("nama"));
                kat.setKeterangan(rs.getString("keterangan"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return kat;
    }

    public ArrayList<Kategori> getAll() {
        ArrayList<Kategori> list = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kategori");
        try {
            while (rs.next()) {
                Kategori kat = new Kategori();
                kat.setIdKategori(rs.getInt("idkategori"));
                kat.setNama(rs.getString("nama"));
                kat.setKeterangan(rs.getString("keterangan"));
                list.add(kat);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public ArrayList<Kategori> search(String keyword) {
        ArrayList<Kategori> list = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery(
            "SELECT * FROM kategori WHERE nama LIKE '%" + keyword + "%' " +
            "OR keterangan LIKE '%" + keyword + "%'");
        try {
            while (rs.next()) {
                Kategori kat = new Kategori();
                kat.setIdKategori(rs.getInt("idkategori"));
                kat.setNama(rs.getString("nama"));
                kat.setKeterangan(rs.getString("keterangan"));
                list.add(kat);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public void save() {
        if (getById(idkategori).getIdKategori() == 0) {
            String sql = "INSERT INTO kategori (nama, keterangan) VALUES ('"
                       + nama + "','" + keterangan + "')";
            idkategori = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE kategori SET nama='" + nama
                       + "', keterangan='" + keterangan
                       + "' WHERE idkategori=" + idkategori;
            DBHelper.executeQuery(sql);
        }
    }

    public void delete() {
        DBHelper.executeQuery(
            "DELETE FROM kategori WHERE idkategori=" + idkategori);
    }

    // REQUIRED so JComboBox displays the category name instead of "backend.Kategori@..."
    @Override
    public String toString() {
        return nama;
    }
}