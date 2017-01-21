/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelLaundry;
import util.Koneksi;

/**
 *
 * @author ChairulHamni
 */
public class ControllerLaundry {
    Koneksi koneksi = new Koneksi();
    
    public void simpanLaundry(ModelLaundry ml){
        koneksi.koneksiDatabase();
        String querySimpan = "insert into tbl_pelanggan(nama,alamat,berat,jenispakaian,harga,total) values ('"+ml.getNama()+"','"+ml.getAlamat()+"',"
                + "'"+ml.getBerat()+"','"+ml.getJenispakaian()+"','"+ml.getHarga()+"','"+ml.getTotal()+"')";
        try {
            koneksi.state.executeUpdate(querySimpan);
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "tidak berhasil disimpan");
            System.err.println(""+e);
        }
    }
    
    public void hapusData(ModelLaundry ml){
        try {
            koneksi.koneksiDatabase();
            String query = "delete from tbl_pelanggan where id=('"+ml.getId()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
        } catch (SQLException e) {
            System.err.println("Eror :"+e);
            JOptionPane.showMessageDialog(null, "data tidak terhapus");
        }        
    }
    
    public void ubahData(ModelLaundry ml){
        koneksi.koneksiDatabase();
        try {
            int id = ml.getId();
            String Nama = ml.getNama();
            String Alamat = ml.getAlamat();
            String Jenispakaian = ml.getJenispakaian();
            int Berat = ml.getBerat();
            int Harga = ml.getHarga();
            int Total = ml.getTotal();
            
            String query = "update tbl_pelanggan "
                    + "set nama='"+Nama+"',"
                    + "alamat='"+Alamat+"',"
                    + "JenisPakaian='"+Jenispakaian+"',"
                    + "Berat='"+Berat+"',"
                    + "Harga='"+Harga+"',"
                    + "Total='"+Total+"'"
                    + "where id= '"+id+"'";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
        } catch (SQLException e) {
            System.err.println(""+e);
            JOptionPane.showMessageDialog(null, "data Tidak berhasil diubah");
        }
    }
}
