/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhuVucKhoDTO;
import DTO.LoaiMonAnDTO;
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
 * @author User
 */
public class LoaiMonAnDAO implements DAOinterface<LoaiMonAnDTO> {

    public static LoaiMonAnDAO getInstance() {
        return new LoaiMonAnDAO();
    }

    @Override
    public int insert(LoaiMonAnDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "INSERT INTO `loaimonan`(`maloaimonan`, `tenloaimonan`) VALUES (?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaloaimonan());
            pst.setString(2, t.getTenloaimonan());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(LoaiMonAnDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "UPDATE `loaimonan` SET `tenloaimonan`=? WHERE `maloaimonan`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaloaimonan());
            pst.setString(2, t.getTenloaimonan());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(String t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "UPDATE khuvuckho SET trangthai = 0 WHERE  maloaimonan = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<LoaiMonAnDTO> selectAll() {
        ArrayList<LoaiMonAnDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "SELECT * FROM khuvuckho";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maloaimonan = rs.getInt("maloaimonan");
                String tenloaimonan = rs.getString("tenloaimonan");
                LoaiMonAnDTO kvk = new LoaiMonAnDTO(maloaimonan, tenloaimonan);
                result.add(kvk);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public LoaiMonAnDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
