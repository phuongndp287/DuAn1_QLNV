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

import dao.DantocDAO;

import model.Dantoc;

public class Quanlydantoc extends JPanel {
	
	private Label lblDanhmuc = new Label("DANH MỤC THAM CHIẾU");
	private Label lblQLDT = new Label("Quản lý dân tộc");
	private Label lblDantoc = new Label("Dân tộc");
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnLuu = new JButton("Lưu");
	private JButton btnBoqua = new JButton("Bỏ Qua");
	private JTable tabDanhmuc = new JTable();
	private JTable tabDantoc = new JTable();
	private JScrollPane scDanhmuc = new JScrollPane(tabDanhmuc);
	private JScrollPane scDantoc = new JScrollPane(tabDantoc);

	private JLabel lblTenDantoc = new JLabel("Tên Dân tộc:");
	private JTextField txtTenDantoc = new JTextField();
	private JLabel lblMaDantoc = new JLabel("Mã dân tộc:");
	private JTextField txtMaDantoc = new JTextField();
	private JLabel lblDanhsachDantoc = new JLabel("Danh sách dân tộc");

	
	private JPanel pnelchitiet = new JPanel();
	private GridBagLayout gridbaglayout = new GridBagLayout();
	private BorderLayout bdl = new BorderLayout();
	
	private String header[]  = { "STT", "Mã dân tộc", "Tên dân tộc" };
	private DefaultTableModel tblDantoc= new DefaultTableModel(header, 0);
	private DantocDAO dtdao= new DantocDAO();
	private ArrayList<Dantoc> listDT=null;
	GridBagConstraints gbc = new GridBagConstraints();

	public Quanlydantoc() {
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
		scDantoc = new JScrollPane(tabDantoc);
		tabDantoc.setDefaultEditor(Object.class, null);
		
		pnelchitiet.setLayout(new GridBagLayout());
		pnelchitiet.add(lblDantoc, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
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
		pnelchitiet.add(lblTenDantoc, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtTenDantoc, new GridBagConstraints(1, 1, 8, 1, 8.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblMaDantoc, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtMaDantoc, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

		pnelchitiet.add(lblDanhsachDantoc, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        
        Object[][] data = {};
        tabDantoc.setModel(new DefaultTableModel(data, header));
        tabDantoc.setPreferredScrollableViewportSize(new Dimension(880, 250));
        tabDantoc.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabDantoc.setFillsViewportHeight(true);
        
        TableColumn column = null;
        tabDantoc.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabDantoc.getColumnModel().getColumn(1).setPreferredWidth(400);
        tabDantoc.getColumnModel().getColumn(2).setPreferredWidth(400);
     
        
        tabDantoc.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabDantoc.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabDantoc.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		this.setLayout(new BorderLayout());
		this.add(pnelchitiet, new BorderLayout().NORTH);
		this.add(scDantoc, new BorderLayout().CENTER);
		
	}
	 private void loadBCNVPB() throws DBException {
	        tblDantoc = (DefaultTableModel) tabDantoc.getModel();
	        tblDantoc.setRowCount(0);
	        try {
	        	listDT = dtdao.getAlldantoc();
	            int num = 0;
	            for (Dantoc b : listDT) {
	               
	            	 Object row[] = new Object[]{++num,  b.getMadantoc(), b.getTendantoc()};
	            	 tblDantoc.addRow(row);
	            
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


}
