/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiMonAnDAO;
import DAO.SizeSanPhamDAO;
import DTO.LoaiMonAnDTO;
import DTO.ThuocTinhSanPham.SizeSanPhamDTO;
import DTO.ThuocTinhSanPham.XuatXuDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SizeSpBUS {

    private final SizeSanPhamDAO sizeSanPham = new SizeSanPhamDAO();
    public ArrayList<SizeSanPhamDTO> listSizeSanPham = new ArrayList<>();

    public SizeSpBUS() {
        listSizeSanPham = sizeSanPham.selectAll();
    }

    public ArrayList<SizeSanPhamDTO> getAll() {
        return this.listSizeSanPham;
    }

    public SizeSanPhamDTO getByIndex(int index) {
        return this.listSizeSanPham.get(index);
    }

    public Boolean add(SizeSanPhamDTO kh) {
        boolean check = sizeSanPham.insert(kh) != 0;
        if (check) {
            this.listSizeSanPham.add(kh);
        }
        return check;
    }

    public Boolean delete(SizeSanPhamDTO kh) {
        boolean check = sizeSanPham.delete(Integer.toString(kh.getIdsize())) != 0;
        if (check) {
            this.listSizeSanPham.remove(getIndexByMaDV(kh.getIdsize()));
        }
        return check;
    }

    public Boolean update(SizeSanPhamDTO kh) {
        boolean check = sizeSanPham.update(kh) != 0;
        if (check) {
            this.listSizeSanPham.set(getIndexByMaDV(kh.getIdsize()), kh);
        }
        return check;
    }

    public int getIndexByMaDV(int maIsSizeSanPham) {
        int i = 0;
        int vitri = -1;
        while (i < this.listSizeSanPham.size() && vitri == -1) {
            if (listSizeSanPham.get(i).getIdsize() == maIsSizeSanPham) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public boolean checkDup(String name) {
        boolean check = true;
        int i = 0;
        while (i <= this.listSizeSanPham.size() && check == true) {
            if (this.listSizeSanPham.get(i).getNamesize().toLowerCase().contains(name.toLowerCase())) {
                check = false;
            } else {
                i++;
            }
        }
        return check;
    }

}
