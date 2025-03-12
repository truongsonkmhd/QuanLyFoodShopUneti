/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoaiMonAnDTO;
import DTO.ThuocTinhSanPham.SizeSanPhamDTO;
import config.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Truong son kmhd
 */
public class SizeSanPhamDAO implements DAOinterface<SizeSanPhamDTO> {

    public static SizeSanPhamDAO getInstance() {
        return new SizeSanPhamDAO();
    }

    @Override
    public int insert(SizeSanPhamDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "INSERT INTO `size_sanpham`(`idsize`, `namesize`, 'trangthai') VALUES (?,?,1)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getIdsize());
            pst.setString(2, t.getNamesize());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(SizeSanPhamDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "UPDATE `size_sanpham` SET `namesize`=? WHERE `masp`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getNamesize());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(String t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "UPDATE `size_sanpham` SET `trangthai`=0 WHERE idsize = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<SizeSanPhamDTO> selectAll() {
        ArrayList<SizeSanPhamDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "SELECT * FROM sizesanpham";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int masize = rs.getInt("idsize");
                String namesize = rs.getString("namesize");
                SizeSanPhamDTO kvk = new SizeSanPhamDTO(masize, namesize);
                result.add(kvk);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public SizeSanPhamDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlikhohang' AND   TABLE_NAME   = 'sizesanpham'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");

                }
            }
        } catch (SQLException ex) {
        }
        return result;
    }

}
