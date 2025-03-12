package DTO;

import java.util.Objects;

/**
 *
 * @author User
 */

public class LoaiMonAnDTO {
    private int maloaimonan;
    private String tenloaimonan;

    public LoaiMonAnDTO(int maloaimonan, String tenloaimonan) {
        this.maloaimonan = maloaimonan;
        this.tenloaimonan = tenloaimonan;
    }

    public LoaiMonAnDTO() {
    }

    public int getMaloaimonan() {
        return maloaimonan;
    }

    public void setMaloaimonan(int maloaimonan) {
        this.maloaimonan = maloaimonan;
    }

    public String getTenloaimonan() {
        return tenloaimonan;
    }

    public void setTenloaimonan(String tenloaimonan) {
        this.tenloaimonan = tenloaimonan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.maloaimonan;
        hash = 97 * hash + Objects.hashCode(this.tenloaimonan);
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
        final LoaiMonAnDTO other = (LoaiMonAnDTO) obj;
        if (this.maloaimonan != other.maloaimonan) {
            return false;
        }
        return Objects.equals(this.tenloaimonan, other.tenloaimonan);
    }
   
    
 
}
