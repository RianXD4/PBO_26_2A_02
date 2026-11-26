/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Adrian
 */
public class Peminjaman {
    private int idpeminjaman;
    private Buku buku = new Buku();
    private Anggota anggota = new Anggota();
    private String tanggalpinjam;
    private String tanggalkembali;

    private static final String SELECT =
            "SELECT p.idpeminjaman, p.tanggalpinjam, p.tanggalkembali, "
          + "a.idanggota, a.nama AS namaanggota, a.alamat, a.telepon, "
          + "b.idbuku, b.judul, b.penerbit, b.penulis, "
          + "k.idkategori, k.nama AS namakategori, k.keterangan "
          + "FROM peminjaman p "
          + "INNER JOIN anggota a ON p.idanggota = a.idanggota "
          + "INNER JOIN buku b ON p.idbuku = b.idbuku "
          + "LEFT JOIN kategori k ON b.idkategori = k.idkategori ";

    public Peminjaman() {}

    public Peminjaman(Anggota anggota, Buku buku) {
        this.anggota = anggota;
        this.buku = buku;
    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalpinjam) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalpinjam = tanggalpinjam;
    }

    public int getIdpeminjaman() { return idpeminjaman; }

    public int getIdPeminjaman() { return idpeminjaman; }

    public Buku getBuku() { return buku; }
    public Anggota getAnggota() { return anggota; }
    public String getTanggalpinjam() { return tanggalpinjam; }
    public String getTanggalkembali() { return tanggalkembali; }

    public void setIdpeminjaman(int idpeminjaman) { this.idpeminjaman = idpeminjaman; }
    public void setBuku(Buku buku) { this.buku = buku; }
    public void setAnggota(Anggota anggota) { this.anggota = anggota; }
    public void setTanggalpinjam(String tanggalpinjam) { this.tanggalpinjam = tanggalpinjam; }
    public void setTanggalkembali(String tanggalkembali) { this.tanggalkembali = tanggalkembali; }

    private Peminjaman mapping(ResultSet rs) throws Exception {
        Peminjaman p = new Peminjaman();
        p.setIdpeminjaman(rs.getInt("idpeminjaman"));
        p.setTanggalpinjam(rs.getString("tanggalpinjam"));
        p.setTanggalkembali(rs.getString("tanggalkembali"));

        Anggota a = new Anggota();
        a.setIdanggota(rs.getInt("idanggota"));
        a.setNama(rs.getString("namaanggota"));
        a.setAlamat(rs.getString("alamat"));
        a.setTelepon(rs.getString("telepon"));
        p.setAnggota(a);

        Kategori k = new Kategori();
        k.setIdKategori(rs.getInt("idkategori"));
        k.setNama(rs.getString("namakategori"));
        k.setKeterangan(rs.getString("keterangan"));

        Buku b = new Buku();
        b.setIdbuku(rs.getInt("idbuku"));
        b.setKategori(k);
        b.setJudul(rs.getString("judul"));
        b.setPenerbit(rs.getString("penerbit"));
        b.setPenulis(rs.getString("penulis"));
        p.setBuku(b);

        return p;
    }

    public Peminjaman getById(int id) {
        Peminjaman p = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery(SELECT + "WHERE p.idpeminjaman = " + id);
        try {
            while (rs.next()) {
                p = mapping(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> list = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery(SELECT);
        try {
            while (rs.next()) {
                list.add(mapping(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> list = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery(SELECT
                + "WHERE a.nama LIKE '%" + keyword + "%' "
                + "OR b.judul LIKE '%" + keyword + "%' "
                + "OR b.penulis LIKE '%" + keyword + "%' "
                + "OR p.idanggota LIKE '%" + keyword + "%' "
                + "OR p.idbuku LIKE '%" + keyword + "%'");
        try {
            while (rs.next()) {
                list.add(mapping(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save() {
        if (getById(idpeminjaman).getIdpeminjaman() == 0) {
            String sql = "INSERT INTO peminjaman "
                    + "(idanggota, idbuku, tanggalpinjam, tanggalkembali) VALUES ("
                    + anggota.getIdanggota() + ", "
                    + buku.getIdbuku() + ", "
                    + sqlDate(tanggalpinjam) + ", "
                    + sqlDate(tanggalkembali) + ")";
            idpeminjaman = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE peminjaman SET "
                    + "idanggota=" + anggota.getIdanggota()
                    + ", idbuku=" + buku.getIdbuku()
                    + ", tanggalpinjam=" + sqlDate(tanggalpinjam)
                    + ", tanggalkembali=" + sqlDate(tanggalkembali)
                    + " WHERE idpeminjaman=" + idpeminjaman;
            DBHelper.executeQuery(sql);
        }
    }

    public void delete() {
        DBHelper.executeQuery(
                "DELETE FROM peminjaman WHERE idpeminjaman=" + idpeminjaman);
    }

    public void pinjam() {
        this.tanggalpinjam = now();
        this.tanggalkembali = null;
        save();
    }

    public void kembalikan() {
        this.tanggalkembali = now();
        save();
    }

    private static String now() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private static String sqlDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "NULL";
        }
        return "'" + value.replace("'", "''") + "'";
    }

    @Override
    public String toString() {
        return buku.getJudul() + " - " + anggota.getNama();
    }
}
