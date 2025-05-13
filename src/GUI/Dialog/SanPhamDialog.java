/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Dialog;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import GUI.Component.ButtonCustom;
import GUI.Component.HeaderTitle;
import GUI.Component.InputForm;
import GUI.Panel.SanPham;
import helper.Validation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class SanPhamDialog extends JDialog implements MouseListener {
    
    SanPham jpSP;
    private HeaderTitle titlePage;
    private JPanel pnlMain, pnlButtom;
    private ButtonCustom btnThem, btnCapNhat, btnHuyBo;
    private InputForm tenSP, soLuongTon, thuongHieu, xuatXu, khuVucKho;
    private JTextField maSP;
    SanPhamDTO sp;
    
    public SanPhamDialog(SanPham jpSP, JFrame owner, String title, boolean modal, String type) {
        super(owner, title, modal);
        this.jpSP = jpSP;
        tenSP = new InputForm("Tên sản phẩm");
        soLuongTon = new InputForm("Số lượng tồn");
        thuongHieu = new InputForm("Thương hiệu");
        xuatXu = new InputForm("Xuất xứ");
        khuVucKho = new InputForm("Khu vực kho");
        initComponents(title, type);
    }
    
    public SanPhamDialog(SanPham jpSP, JFrame owner, String title, boolean modal, String type, DTO.SanPhamDTO sp) {
        super(owner, title, modal);
        this.sp = sp;
        maSP = new JTextField("");
        setMaSP(Integer.toString(sp.getMasp()));
        tenSP = new InputForm("Tên sản phẩm");
        setTenSP(sp.getTensp());
        soLuongTon = new InputForm("Số lượng tồn");
        setSoLuongTon(Integer.toString(sp.getSoluongton()));
        thuongHieu = new InputForm("Thương hiệu");
        setThuongHieu(sp.getThuonghieu());
        xuatXu = new InputForm("Xuất xứ");
        setXuatXu(sp.getXuatxu());
        khuVucKho = new InputForm("Khu vực kho");
        setKhuVucKho(Integer.toString(sp.getKhuvuckho()));
        this.jpSP = jpSP;
        initComponents(title, type);
    }
    
    public void initComponents(String title, String type) {
        this.setSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout(0, 0));
        titlePage = new HeaderTitle(title.toUpperCase());
        pnlMain = new JPanel(new GridLayout(3, 1, 20, 0));
        pnlMain.setBackground(Color.white);
        
        pnlMain.add(tenSP);
        pnlMain.add(soLuongTon);
        pnlMain.add(thuongHieu);
        pnlMain.add(xuatXu);
        pnlMain.add(soLuongTon);
        pnlMain.add(khuVucKho);
        
        pnlButtom = new JPanel(new FlowLayout());
        pnlButtom.setBorder(new EmptyBorder(10, 0, 10, 0));
        pnlButtom.setBackground(Color.white);
        btnThem = new ButtonCustom("Thêm sản phẩm", "success", 14);
        btnCapNhat = new ButtonCustom("Lưu thông tin", "success", 14);
        btnHuyBo = new ButtonCustom("Huỷ bỏ", "danger", 14);

        //Add MouseListener btn
        btnThem.addMouseListener(this);
        btnCapNhat.addMouseListener(this);
        btnHuyBo.addMouseListener(this);
        
        switch (type) {
            case "create" ->
                pnlButtom.add(btnThem);
            case "update" ->
                pnlButtom.add(btnCapNhat);
            case "view" -> {
                tenSP.setDisable();
                soLuongTon.setDisable();
                thuongHieu.setDisable();
                xuatXu.setDisable();
                soLuongTon.setDisable();
                khuVucKho.setDisable();
            }
            default ->
                throw new AssertionError();
        }
        pnlButtom.add(btnHuyBo);
        
        this.add(titlePage, BorderLayout.NORTH);
        this.add(pnlMain, BorderLayout.CENTER);
        this.add(pnlButtom, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void setTenSP(String name) {
        tenSP.setText(name);
    }
    
    public String getTenSP() {
        return tenSP.getText();
    }
    
    public void setMaSP(String id) {
        maSP.setText(id);
    }
    
    public String getMaSP() {
        return maSP.getText();
    }
    
    public String getSoLuongTon() {
        return soLuongTon.getText();
    }
    
    public void setSoLuongTon(String id) {
        this.soLuongTon.setText(id);
    }
    
    public String getThuongHieu() {
        return thuongHieu.getText();
    }
    
    public void setThuongHieu(String id) {
        this.thuongHieu.setText(id);
    }
    
    public String getXuatXu() {
        return xuatXu.getText();
    }
    
    public void setXuatXu(String id) {
        this.xuatXu.setText(id);
    }
    
    public String getKhuVucKho() {
        return khuVucKho.getText();
    }
    
    public void setKhuVucKho(String id) {
        this.khuVucKho.setText(id);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    boolean Validation() {
        if (Validation.isEmpty(tenSP.getText())) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được rỗng", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Validation.isEmpty(soLuongTon.getText()) || !Validation.isNumber(soLuongTon.getText())) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn không được rỗng và phải là số", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Validation.isEmpty(thuongHieu.getText())) {
            JOptionPane.showMessageDialog(this, "Thương hiệu không được rỗng", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Validation.isEmpty(xuatXu.getText())) {
            JOptionPane.showMessageDialog(this, "Xuất xứ không được rỗng", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (Validation.isEmpty(khuVucKho.getText()) || !Validation.isNumber(soLuongTon.getText())) {
            JOptionPane.showMessageDialog(this, "Khu vực kho không được rỗng và phải là số", "Cảnh báo !", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btnThem && Validation()) {
            int id = SanPhamDAO.getInstance().getAutoIncrement();
            jpSP.spBUS.add(new DTO.SanPhamDTO(id, tenSP.getText(), Integer.parseInt(soLuongTon.getText()), thuongHieu.getText(), xuatXu.getText(), Integer.parseInt(khuVucKho.getText())));
            jpSP.loadDataTalbe(jpSP.listSP);
            dispose();
            
        } else if (e.getSource() == btnHuyBo) {
            dispose();
        } else if (e.getSource() == btnCapNhat && Validation()) {
            jpSP.spBUS.update(new SanPhamDTO(sp.getMasp(), tenSP.getText(), Integer.parseInt(soLuongTon.getText()), thuongHieu.getText(), xuatXu.getText(), Integer.parseInt(khuVucKho.getText())));
            jpSP.loadDataTalbe(jpSP.listSP);
            dispose();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
