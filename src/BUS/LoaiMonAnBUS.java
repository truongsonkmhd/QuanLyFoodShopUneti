/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiMonAnDAO;
import DTO.LoaiMonAnDTO;
import java.util.ArrayList;

/**
 *
 * @author truongsonkmhd
 */
public class LoaiMonAnBUS {
    
    private final LoaiMonAnDAO loaiMonAnDao = new LoaiMonAnDAO();
    public ArrayList<LoaiMonAnDTO> listLoaiMonAn = new ArrayList<>();

    public LoaiMonAnBUS() {
        listLoaiMonAn = loaiMonAnDao.selectAll();
    }
    
    public ArrayList<LoaiMonAnDTO> getAll() {
        return this.listLoaiMonAn;
    }
    
    public LoaiMonAnDTO getByIndex(int index) {
        return this.listLoaiMonAn.get(index);
    }
    
    public Boolean add(LoaiMonAnDTO kh) {
        boolean check = loaiMonAnDao.insert(kh) != 0;
        if (check) {
            this.listLoaiMonAn.add(kh);
        }
        return check;
    }

    public Boolean delete(LoaiMonAnDTO kh) {
        boolean check = loaiMonAnDao.delete(Integer.toString(kh.getMaloaimonan())) != 0;
        if (check) {
            this.listLoaiMonAn.remove(getIndexByMaDV(kh.getMaloaimonan()));
        }
        return check;
    }

    public Boolean update(LoaiMonAnDTO kh) {
        boolean check = loaiMonAnDao.update(kh) != 0;
        if (check) {
            this.listLoaiMonAn.set(getIndexByMaDV(kh.getMaloaimonan()), kh);
        }
        return check;
    }
    
    public int getIndexByMaDV(int maLoaiMonAn) {
        int i = 0;
        int vitri = -1;
        while (i < this.listLoaiMonAn.size() && vitri == -1) {
            if (listLoaiMonAn.get(i).getMaloaimonan()== maLoaiMonAn) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }


 
}
