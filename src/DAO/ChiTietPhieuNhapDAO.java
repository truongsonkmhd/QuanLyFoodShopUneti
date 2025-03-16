package DAO;

import DTO.ChiTietPhieuDTO;
import config.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author truongsonkmhd
 */
public class ChiTietPhieuNhapDAO implements DAOinterface<ChiTietPhieuDTO> {

     public static ChiTietPhieuNhapDAO getInstance() {
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public int insert(ChiTietPhieuDTO t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO chitietphieunhap (maphieu, masp, soluong, dongia) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieu());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getDongia());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChiTietPhieuDTO t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE chitietphieunhap SET maphieu=?, masp=?, soluong=?, dongia = ?  WHERE maphieu=? AND masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieu());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getSoluong());
            pst.setInt(5, t.getMaphieu());
            pst.setInt(6, t.getMasp());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public int delete(ChiTietPhieuDTO t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM chitietphieunhap WHERE maPhieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieu());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<ChiTietPhieuDTO> selectAll(int t) {
        ArrayList<ChiTietPhieuDTO> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieunhap WHERE maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maPhieu = rs.getInt("maphieu");
                int maMay = rs.getInt("masp");
                int soLuong = rs.getInt("soluong");
                double donGia = rs.getDouble("dongia");
                ChiTietPhieuDTO ctp = new ChiTietPhieuDTO(maPhieu, maMay, soLuong, donGia);
                ketQua.add(ctp);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<ChiTietPhieuDTO> selectAll() {
        ArrayList<ChiTietPhieuDTO> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieunhap";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maPhieu = rs.getInt("maphieu");
                int maMay = rs.getInt("masp");
                int soLuong = rs.getInt("soluong");
                double donGia = rs.getDouble("dongia");
                ChiTietPhieuDTO ctp = new ChiTietPhieuDTO(maPhieu, maMay, soLuong, donGia);
                ketQua.add(ctp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ChiTietPhieuDTO selectById(String t) {
        ChiTietPhieuDTO ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietphieunhap WHERE maphieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 int maPhieu = rs.getInt("maphieu");
                int maMay = rs.getInt("masp");
                int soLuong = rs.getInt("soluong");
                double donGia = rs.getDouble("dongia");
                ketQua = new ChiTietPhieuDTO(maPhieu, maMay, soLuong, donGia);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
