
package DTO;

import java.util.Objects;

/**
 *
 * @author TRUONGSONKMHD
 */
public class ChiTietPhieuDTO {
    private int maphieu;
    private int masp;
    private int soluong;
    private double dongia;

    public ChiTietPhieuDTO() {
    }

    public ChiTietPhieuDTO(int maphieu, int masp, int soluong, double dongia) {
        this.maphieu = maphieu;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public int getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(int maphieu) {
        this.maphieu = maphieu;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.maphieu);
        hash = 79 * hash + this.masp;
        hash = 79 * hash + this.soluong;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.dongia) ^ (Double.doubleToLongBits(this.dongia) >>> 32));
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
        final ChiTietPhieuDTO other = (ChiTietPhieuDTO) obj;
        if (this.masp != other.masp) {
            return false;
        }
        if (this.soluong != other.soluong) {
            return false;
        }
        if (Double.doubleToLongBits(this.dongia) != Double.doubleToLongBits(other.dongia)) {
            return false;
        }
        return Objects.equals(this.maphieu, other.maphieu);
    }
    
    
    
}
