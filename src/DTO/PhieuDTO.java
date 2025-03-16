package DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author truongsonkmhd
 */
public class PhieuDTO {
    private int maphieu;
    private int manguoitao;
    private Timestamp thoigiantao;
    private ArrayList<ChiTietPhieuDTO> CTPhieu;
    private double tongTien;
    private int trangthai;

    public PhieuDTO() {
    }

    public PhieuDTO(int maphieu, int manguoitao, Timestamp thoigiantao, ArrayList<ChiTietPhieuDTO> CTPhieu, double tongTien) {
        this.maphieu = maphieu;
        this.manguoitao = manguoitao;
        this.thoigiantao = thoigiantao;
        this.CTPhieu = CTPhieu;
        this.tongTien = tongTien;
    }

    public PhieuDTO(int maphieu, int manguoitao, Timestamp thoigiantao, ArrayList<ChiTietPhieuDTO> CTPhieu, double tongTien, int trangthai) {
        this.maphieu = maphieu;
        this.manguoitao = manguoitao;
        this.thoigiantao = thoigiantao;
        this.CTPhieu = CTPhieu;
        this.tongTien = tongTien;
        this.trangthai = trangthai;
    }

    public int getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(int maphieu) {
        this.maphieu = maphieu;
    }

    public int getManguoitao() {
        return manguoitao;
    }

    public void setManguoitao(int manguoitao) {
        this.manguoitao = manguoitao;
    }

    public Timestamp getThoigiantao() {
        return thoigiantao;
    }

    public void setThoigiantao(Timestamp thoigiantao) {
        this.thoigiantao = thoigiantao;
    }

    public ArrayList<ChiTietPhieuDTO> getCTPhieu() {
        return CTPhieu;
    }

    public void setCTPhieu(ArrayList<ChiTietPhieuDTO> CTPhieu) {
        this.CTPhieu = CTPhieu;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.maphieu;
        hash = 89 * hash + this.manguoitao;
        hash = 89 * hash + Objects.hashCode(this.thoigiantao);
        hash = 89 * hash + Objects.hashCode(this.CTPhieu);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.tongTien) ^ (Double.doubleToLongBits(this.tongTien) >>> 32));
        hash = 89 * hash + this.trangthai;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhieuDTO other = (PhieuDTO) obj;
        if (this.maphieu != other.maphieu) {
            return false;
        }
        if (this.manguoitao != other.manguoitao) {
            return false;
        }
        if (Double.doubleToLongBits(this.tongTien) != Double.doubleToLongBits(other.tongTien)) {
            return false;
        }
        if (this.trangthai != other.trangthai) {
            return false;
        }
        if (!Objects.equals(this.thoigiantao, other.thoigiantao)) {
            return false;
        }
        return Objects.equals(this.CTPhieu, other.CTPhieu);
    }

    
}
