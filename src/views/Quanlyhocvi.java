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

import dao.HocviDAO;

import model.Hocvi;

public class Quanlyhocvi extends JPanel {
	
	private Label lblDanhmuc = new Label("DANH MỤC THAM CHIẾU");
	private Label lblQLHV = new Label("Quản lý học vị");
	private Label lblHocvi = new Label("Học vị");
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnLuu = new JButton("Lưu");
	private JButton btnBoqua = new JButton("Bỏ Qua");
	private JTable tabDanhmuc = new JTable();
	private JTable tabHocvi = new JTable();
	private JScrollPane scDanhmuc = new JScrollPane(tabDanhmuc);
	private JScrollPane scHocvi = new JScrollPane(tabHocvi);
	
	private JLabel lblTenhocvi = new JLabel("Tên học vị:");
	private JTextField txtTenhocvi = new JTextField();
	private JLabel lblMahocvi = new JLabel("Mã học vị:");
	private JTextField txtMahocvi = new JTextField();
	private JLabel lblDanhsachhocvi = new JLabel("Danh sách học vị");
	private JPanel pnelchitiet = new JPanel();
	private GridBagLayout gridbaglayout = new GridBagLayout();
	private BorderLayout bdl = new BorderLayout();
	
	private String header[]  = { "STT", "Mã học vị", "Tên học vị" };
	private DefaultTableModel tblHocvi= new DefaultTableModel(header, 0);
	private HocviDAO hvdao= new HocviDAO();
	private ArrayList<Hocvi> listHV=null;
	GridBagConstraints gbc = new GridBagConstraints();

	public Quanlyhocvi() {
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
		scHocvi = new JScrollPane(tabHocvi);
		tabHocvi.setDefaultEditor(Object.class, null);
		
		pnelchitiet.setLayout(new GridBagLayout());
		pnelchitiet.add(lblHocvi, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnThem, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnSua, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnXoa, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnLuu, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(btnBoqua, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblTenhocvi, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtTenhocvi, new GridBagConstraints(1, 1, 8, 1, 8.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblMahocvi, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtMahocvi, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

		pnelchitiet.add(lblDanhsachhocvi, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        
        Object[][] data = {};
        tabHocvi.setModel(new DefaultTableModel(data, header));
        tabHocvi.setPreferredScrollableViewportSize(new Dimension(880, 250));
        tabHocvi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabHocvi.setFillsViewportHeight(true);
        
        TableColumn column = null;
        tabHocvi.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabHocvi.getColumnModel().getColumn(1).setPreferredWidth(400);
        tabHocvi.getColumnModel().getColumn(2).setPreferredWidth(400);
     
        
        tabHocvi.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabHocvi.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabHocvi.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		this.setLayout(new BorderLayout());
		this.add(pnelchitiet, new BorderLayout().NORTH);
		this.add(scHocvi, new BorderLayout().CENTER);
		
	}
	 private void loadBCNVPB() throws DBException {
	        tblHocvi = (DefaultTableModel) tabHocvi.getModel();
	        tblHocvi.setRowCount(0);
	        try {
	        	listHV = hvdao.getAllhocvi();
	            int num = 0;
	            for (Hocvi b : listHV) {
	               
	            	 Object row[] = new Object[]{++num, b.getMahocvi(), b.getTenhocvi()};
	            	 tblHocvi.addRow(row);
	            
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	public static void main(String args[]) {
		
		
		
	}

}
