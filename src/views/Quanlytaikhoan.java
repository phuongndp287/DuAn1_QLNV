package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.NhanvienDAO;
import dao.PhongbanDAO;
import dao.TaikhoanDAO;
import model.Nhanvien;
import model.Phongban;
import model.Taikhoan;

public class Quanlytaikhoan extends JPanel {
	

	private Label lblDSTK = new Label("Danh sách tài khoản");
	private Label lblTaikhoanPhongban = new Label("TÀI KHOẢN PHÒNG TỔ CHỨC");
	private JButton btnTaotaikhoan = new JButton("Tạo tài khoản");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnKhoa = new JButton("Khóa");
	private JButton btnXoa = new JButton("Xóa");
	private JTable tabPhongban = new JTable();
	private JTable tabTaikhoan = new JTable();
	private JScrollPane scPhongban = new JScrollPane(tabPhongban);
	private JScrollPane scTaikhoan = new JScrollPane(tabTaikhoan);
	private JLabel lblTimkiem = new JLabel("Tìm kiếm:");
	private JTextField txtTimkiem = new JTextField();
	private JButton btnTimkiem = new JButton("Tìm Kiếm");
	
	private JPanel pnelchitiet = new JPanel();
	private String header[]  = { "STT", "Tên tài khoản", "Họ tên","Phòng ban" };
	
	private DefaultTableModel tblTaikhoan= new DefaultTableModel(header, 0);
	private TaikhoanDAO tkdao= new TaikhoanDAO();
	private ArrayList<Taikhoan> listTK=null;
	GridBagConstraints gbc = new GridBagConstraints();

	public Quanlytaikhoan() {
		demo();
		try {
			loadBCNVPB();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void demo() {
		this.setSize(900,600);
		scTaikhoan = new JScrollPane(tabTaikhoan);
		tabTaikhoan.setDefaultEditor(Object.class, null);
		
		pnelchitiet.setLayout(new GridBagLayout());
		pnelchitiet.add(lblTaikhoanPhongban, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnTaotaikhoan, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnSua, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnKhoa, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnXoa, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblTimkiem, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtTimkiem, new GridBagConstraints(1, 1, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnTimkiem, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(scTaikhoan, new GridBagConstraints(0, 2, 9, 1, 9.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        
        Object[][] data = {};
        tabTaikhoan.setModel(new DefaultTableModel(data, header));
        tabTaikhoan.setPreferredScrollableViewportSize(new Dimension(880, 250));
        tabTaikhoan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabTaikhoan.setFillsViewportHeight(true);
        
        TableColumn column = null;
        tabTaikhoan.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabTaikhoan.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabTaikhoan.getColumnModel().getColumn(2).setPreferredWidth(300);
        tabTaikhoan.getColumnModel().getColumn(3).setPreferredWidth(300);
        
        tabTaikhoan.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabTaikhoan.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabTaikhoan.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabTaikhoan.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		this.setLayout(new BorderLayout());
		this.add(pnelchitiet, new BorderLayout().NORTH);
		this.add(scTaikhoan, new BorderLayout().CENTER);
		
	}
	 private void loadBCNVPB() throws DBException {
	        tblTaikhoan = (DefaultTableModel) tabTaikhoan.getModel();
	        tblTaikhoan.setRowCount(0);
	        Nhanvien nv= new Nhanvien();
	        NhanvienDAO nvdao = new NhanvienDAO();
	        PhongbanDAO pbdao = new PhongbanDAO();
	        try {
	        	listTK = tkdao.getAlltaikhoan();
	            int num = 0;
	            for (Taikhoan b : listTK) {
	               
	            	 Object row[] = new Object[]{++num,  b.getTendangnhap(),nvdao.find(b.getManhanvien()).getTennhanvien(),pbdao.find(nvdao.find(b.getManhanvien()).getMaphongban()).getTenphongban()};
	            	 tblTaikhoan.addRow(row);
	            	
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	public static void main(String args[]) {
		
		Quanlytaikhoan qlpb= new Quanlytaikhoan();
		
	}

}
