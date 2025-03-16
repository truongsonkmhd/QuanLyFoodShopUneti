
package DAO;


import DTO.ThongKeProductDTO;
import config.JDBCUtil;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author truongsonkmhd
 */
public class ThongKeDAO {

    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }

    public ArrayList<ThongKeProductDTO> getThongKe(Date timeStart, Date timeEnd) {
        System.out.println(timeStart);
        System.out.println(timeEnd);

        ArrayList<ThongKeProductDTO> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT t1.maMay,tenMay,slNhap,slXuat FROM(\n"
                    + "	SELECT maMay, SUM(soLuong) AS slNhap FROM ChiTietPhieuNhap \n"
                    + "	JOIN PhieuNhap ON PhieuNhap.maPhieu = ChiTietPhieuNhap.maPhieu\n"
                    + "	WHERE thoiGianTao BETWEEN ? AND ?"
                    + "	GROUP BY maMay\n"
                    + ") t1 \n"
                    + "JOIN(\n"
                    + "	SELECT maMay, SUM(soLuong) AS slXuat FROM ChiTietPhieuXuat \n"
                    + "	JOIN PhieuXuat ON PhieuXuat.maPhieu = ChiTietPhieuXuat.maPhieu \n"
                    + "	WHERE thoiGianTao BETWEEN ? AND ?"
                    + "	GROUP BY maMay\n"
                    + ") t2\n"
                    + "ON t1.maMay = t2.maMay\n"
                    + "JOIN MayTinh ON t1.maMay = MayTinh.maMay";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(2, new Timestamp(timeEnd.getTime()));
            pst.setTimestamp(3, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(4, new Timestamp(timeEnd.getTime()));

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maMay");
                String tenSP = rs.getString("tenMay");
                int slNhap = rs.getInt("slNhap");
                int slXuat = rs.getInt("slXuat");
                ThongKeProductDTO p = new ThongKeProductDTO(maSP, tenSP, slNhap, slXuat);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<ThongKeProductDTO> getThongKe() {
        ArrayList<ThongKeProductDTO> ketQua = new ArrayList<ThongKeProductDTO>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT t1.maMay,tenMay,slNhap,slXuat FROM(\n"
                    + "	SELECT maMay, SUM(soLuong) AS slNhap FROM ChiTietPhieuNhap \n"
                    + "	JOIN PhieuNhap ON PhieuNhap.maPhieu = ChiTietPhieuNhap.maPhieu\n"
                    + "	GROUP BY maMay\n"
                    + ") t1 \n"
                    + "JOIN(\n"
                    + "	SELECT maMay, SUM(soLuong) AS slXuat FROM ChiTietPhieuXuat \n"
                    + "	JOIN PhieuXuat ON PhieuXuat.maPhieu = ChiTietPhieuXuat.maPhieu \n"
                    + "	GROUP BY maMay\n"
                    + ") t2\n"
                    + "ON t1.maMay = t2.maMay\n"
                    + "JOIN MayTinh ON t1.maMay = MayTinh.maMay";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maMay = rs.getString("maMay");
                String tenMay = rs.getString("tenMay");
                int slNhap = rs.getInt("slNhap");
                int slXuat = rs.getInt("slXuat");
                ThongKeProductDTO p = new ThongKeProductDTO(maMay, tenMay, slNhap, slXuat);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
