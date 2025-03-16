
package DTO;

import java.util.Objects;

/**
 *
 * @author User
 */
public class ThongKeProductDTO {
    private String maSP;
    private String tenSP;
    private int slNhap;
    private int slXuat;

    public ThongKeProductDTO() {
    }

    public ThongKeProductDTO(String maMay, String tenMay, int slNhap, int slXuat) {
        this.maSP = maMay;
        this.tenSP = tenMay;
        this.slNhap = slNhap;
        this.slXuat = slXuat;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSlNhap() {
        return slNhap;
    }

    public void setSlNhap(int slNhap) {
        this.slNhap = slNhap;
    }

    public int getSlXuat() {
        return slXuat;
    }

    public void setSlXuat(int slXuat) {
        this.slXuat = slXuat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.maSP);
        hash = 29 * hash + Objects.hashCode(this.tenSP);
        hash = 29 * hash + this.slNhap;
        hash = 29 * hash + this.slXuat;
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
        final ThongKeProductDTO other = (ThongKeProductDTO) obj;
        if (this.slNhap != other.slNhap) {
            return false;
        }
        if (this.slXuat != other.slXuat) {
            return false;
        }
        if (!Objects.equals(this.maSP, other.maSP)) {
            return false;
        }
        return Objects.equals(this.tenSP, other.tenSP);
    }

    
}
