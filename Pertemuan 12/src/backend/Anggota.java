/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class Anggota {
    private int idanggota;
    private String nama;
    private String alamat;
    private String telepon;

    public Anggota() {}

    public Anggota(String nama, String alamat, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public int getIdanggota() { return idanggota; }

    public int getIdAnggota() { return idanggota; }

    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }
    public String getTelepon() { return telepon; }

    public void setIdanggota(int idanggota) { this.idanggota = idanggota; }
    public void setNama(String nama) { this.nama = nama; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public void setTelepon(String telepon) { this.telepon = telepon; }

    public Anggota getById(int id) {
        Anggota anggota = new Anggota();
        ResultSet rs = DBHelper.selectQuery(
                "SELECT * FROM anggota WHERE idanggota = '" + id + "'");
        try {
            while (rs.next()) {
                anggota.setIdanggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return anggota;
    }

    public ArrayList<Anggota> getAll() {
        ArrayList<Anggota> list = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota");
        try {
            while (rs.next()) {
                Anggota anggota = new Anggota();
                anggota.setIdanggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
                list.add(anggota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Anggota> search(String keyword) {
        ArrayList<Anggota> list = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery(
                "SELECT * FROM anggota WHERE nama LIKE '%" + keyword + "%' "
              + "OR alamat LIKE '%" + keyword + "%' "
              + "OR telepon LIKE '%" + keyword + "%'");
        try {
            while (rs.next()) {
                Anggota anggota = new Anggota();
                anggota.setIdanggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
                list.add(anggota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save() {
        if (getById(idanggota).getIdanggota() == 0) {
            String sql = "INSERT INTO anggota (nama, alamat, telepon) VALUES ('"
                    + nama + "','" + alamat + "','" + telepon + "')";
            idanggota = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE anggota SET nama='" + nama
                    + "', alamat='" + alamat
                    + "', telepon='" + telepon
                    + "' WHERE idanggota=" + idanggota;
            DBHelper.executeQuery(sql);
        }
    }

    public void delete() {
        DBHelper.executeQuery(
                "DELETE FROM anggota WHERE idanggota=" + idanggota);
    }

    @Override
    public String toString() {
        return nama;
    }
}
