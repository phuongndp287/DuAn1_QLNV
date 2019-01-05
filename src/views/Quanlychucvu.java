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

import dao.ChucvuDAO;

import model.Chucvu;

public class Quanlychucvu extends JPanel {
	
	private Label lblDanhmuc = new Label("DANH MỤC THAM CHIẾU");
	private Label lblQLCV = new Label("Quản lý chức vụ");
	private Label lblChucvu = new Label("Chức vụ");
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnLuu1 = new JButton("Lưu");
	private JButton btnLuu2 = new JButton("Lưu");
	private JButton btnBoqua = new JButton("Bỏ Qua");
	private JTable tabDanhmuc = new JTable();
	private JTable tabChucvu = new JTable();
	private JScrollPane scDanhmuc = new JScrollPane(tabDanhmuc);
	private JScrollPane scChucvu = new JScrollPane(tabChucvu);
	private JLabel lblTenChucvu = new JLabel("Tên chức vụ");
	private JTextField txtTenChucvu = new JTextField();
	private JLabel lblMaChucvu = new JLabel("Mã chức vụ");
	private JTextField txtMaChucvu = new JTextField();
	private JLabel lblHesophucap = new JLabel("Hệ số phụ cấp");
	private JTextField txtHesophucap = new JTextField();
	private JLabel lblDanhsachChucvu = new JLabel("Danh sách chức vụ");
	
	private JPanel pnelchitiet = new JPanel();
	private GridBagLayout gridbaglayout = new GridBagLayout();
	private BorderLayout bdl = new BorderLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private String header[]  = { "STT", "Mã chức vụ ","Tên chức vụ","Hệ số phụ cấp" };
	private DefaultTableModel tblChucvu= new DefaultTableModel(header, 0);
	private ChucvuDAO cvdao= new ChucvuDAO();
	private ArrayList<Chucvu> listCV=null;
	

	public Quanlychucvu() {
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
		scChucvu = new JScrollPane(tabChucvu);
		tabChucvu.setDefaultEditor(Object.class, null);
		
		pnelchitiet.setLayout(new GridBagLayout());
		pnelchitiet.add(lblChucvu, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnThem, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnSua, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnXoa, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnLuu1, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnLuu2, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnBoqua, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblTenChucvu, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtTenChucvu, new GridBagConstraints(1, 1, 8, 1, 8.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblMaChucvu, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtMaChucvu, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblHesophucap, new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtHesophucap, new GridBagConstraints(8, 2, 1, 1, 0.1, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblDanhsachChucvu, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        
        Object[][] data = {};
        tabChucvu.setModel(new DefaultTableModel(data, header));
        tabChucvu.setPreferredScrollableViewportSize(new Dimension(880, 250));
        tabChucvu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabChucvu.setFillsViewportHeight(true);
        
        TableColumn column = null;
        tabChucvu.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabChucvu.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabChucvu.getColumnModel().getColumn(2).setPreferredWidth(400);
        tabChucvu.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        tabChucvu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabChucvu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabChucvu.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabChucvu.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		this.setLayout(new BorderLayout());
		this.add(pnelchitiet, new BorderLayout().NORTH);
		this.add(scChucvu, new BorderLayout().CENTER);
		
	}
	 private void loadBCNVPB() throws DBException {
	        tblChucvu = (DefaultTableModel) tabChucvu.getModel();
	        tblChucvu.setRowCount(0);
	        try {
	        	listCV = cvdao.getAllchucvu();
	            int num = 0;
	            for (Chucvu b : listCV) {
	               
	            	 Object row[] = new Object[]{++num,  b.getMachucvu(), b.getTenchucvu(),b.getHesophucap()};
	            	 tblChucvu.addRow(row);
	            	
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


}
