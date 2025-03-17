package GUI.Panel;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import GUI.Component.itemTaskbar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truongsonkmhd
 */
public class ThongKe extends JPanel {

    JPanel jp_top, jp_center;
    itemTaskbar[] listitem;
    private DefaultTableModel tblModel;
    String[][] getSt = {
        {"Sản phẩm hiện có trong kho", "productt.svg", Integer.toString(SanPhamDAO.getInstance().selectAll().size())},
        {"Khách từ trước đến nay", "stafff.svg", Integer.toString(KhachHangDAO.getInstance().selectAll().size())},
        {"Nhân viên đang hoạt động", "customerr.svg", Integer.toString(NhanVienDAO.getInstance().selectAll().size())}};

    public ThongKe() {
        initComponent();
    }


    private void initComponent() {
        this.setLayout(new BorderLayout(10, 10));
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        jp_top = new JPanel();
        jp_top.setLayout(new GridLayout(1, 3, 20, 0));
        jp_top.setOpaque(false);
        jp_top.setBorder(new EmptyBorder(10, 10, 10, 10));
        jp_top.setPreferredSize(new Dimension(0, 120));

        listitem = new itemTaskbar[getSt.length];
        for (int i = 0; i < getSt.length; i++) {
            listitem[i] = new itemTaskbar(getSt[i][1], getSt[i][2], getSt[i][0], 0);
            jp_top.add(listitem[i]);
        }

        jp_center = new JPanel(new BorderLayout());
        jp_center.setBackground(Color.WHITE);
        JPanel jp_center_top = new JPanel(new FlowLayout());
        jp_center_top.setBorder(new EmptyBorder(10, 0, 0, 10));
        jp_center_top.setOpaque(false);

        jp_center.add(jp_center_top, BorderLayout.NORTH);

      
        tblModel = new DefaultTableModel();
        String[] header = new String[]{"Ngày", "Vốn", "Doanh thu", "Lợi nhuận"};
        tblModel.setColumnIdentifiers(header);
      
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.add(jp_top, BorderLayout.NORTH);
        this.add(jp_center, BorderLayout.CENTER);
    }
}
