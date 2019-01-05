package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import dao.NhanvienDAO;
import dao.PhongbanDAO;
import model.NhanvienPhongban;
import model.Phongban;

public class Baocao extends JPanel {
	private JPanel pnelNamtuyendung = new JPanel();
	private JPanel pnelNhanvientheoPB = new JPanel();
	private JPanel pnelNhanviencophucap = new JPanel();
	private JPanel pnelNamtuyendungtop= new JPanel();
	private JPanel pnelNhanvientheoPBtop= new JPanel();
	private JPanel pnelNhanviencophucaptop= new JPanel();
	private JLabel lblBaocaotheonam = new JLabel("Báo cáo theo năm tuyển dụng");
	private JLabel lblBaocaonhanvientheophongban = new JLabel("Báo cáo số lượng nhân viên theo phòng ban");
	private JLabel lblLietkedanhsachnhanviencophucapchucvu = new JLabel("Báo cáo nhân viên có phụ cấp chức vụ");
	private JComboBox cbxBaocaotheonam = new JComboBox<>();
	private JComboBox cbxBaocaotheophongban = new JComboBox<>();
	private JComboBox cbxLietkedanhsach = new JComboBox<>();
	private String header1[] = {"STT", "Năm tuyển dụng","Số lượng nhân viên"};
	private String header2[] = {"STT", "Phòng ban","Số lượng nhân viên"};
	private String header3[] = {"STT", "Phòng ban","Mã nhân viên","Họ tên","Giới tính","Ngày sinh","Dân tộc","Điện thoại","Ngày tuyển dụng","Loại hợp đồng"};
	private DefaultTableModel tbltheonam= new  DefaultTableModel(header1,0);
	private DefaultTableModel tbltheophongban= new  DefaultTableModel(header2,0);
	private DefaultTableModel tblcophucapchucvu= new  DefaultTableModel(header3,0);
	private JTable tbtheonam=new JTable();
	private JTable tbtheophongban=new JTable();
	private JTable tbcophucapchucvu=new JTable();
	private JScrollPane sctheonam= new JScrollPane();
	private JScrollPane sctheophongban= new JScrollPane();
	private JScrollPane sccophucapchucvu= new JScrollPane();
	private ArrayList<NhanvienPhongban> listNVPB=new ArrayList<>();
	private PhongbanDAO pbdao= new PhongbanDAO();
    private Phongban pb= new Phongban();
    
	public Baocao() {
		try {
			init();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(true);
	}

	public void init() throws DBException {
		this.setSize(1200, 600);
		this.setVisible(true);
		

		sctheonam.add(tbtheonam);
		sctheophongban.add(tbtheophongban);
		sccophucapchucvu.add(tbcophucapchucvu);
		
		cbxBaocaotheonam.setSize(200, 20);
		pnelNamtuyendung.setLayout(new BorderLayout());
		pnelNamtuyendungtop.setLayout(new BorderLayout());
		pnelNamtuyendungtop.add(lblBaocaotheonam,BorderLayout.WEST);
		pnelNamtuyendungtop.add(cbxBaocaotheonam,BorderLayout.EAST);
		pnelNamtuyendung.add(pnelNamtuyendungtop,new BorderLayout().NORTH);
		pnelNamtuyendung.add(sctheonam,new BorderLayout().CENTER);
		
		
		pnelNhanvientheoPB.setLayout(new BorderLayout());
		pnelNhanvientheoPBtop.setLayout(new BorderLayout());
		pnelNhanvientheoPBtop.add(lblBaocaonhanvientheophongban,BorderLayout.WEST);
		pnelNhanvientheoPBtop.add(cbxBaocaotheophongban,BorderLayout.EAST);
		pnelNhanvientheoPB.add(pnelNhanvientheoPBtop,new BorderLayout().NORTH);
		pnelNhanvientheoPB.add(sctheophongban,new BorderLayout().CENTER);
		

		 Object[][] data = {};
	        tbtheophongban.setModel(new DefaultTableModel(data, header2));
	        tbtheophongban.setPreferredScrollableViewportSize(new Dimension(1300, 136));
	        tbtheophongban.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 
		
		this.setLayout(new BorderLayout());
		this.add(pnelNamtuyendung, BorderLayout.NORTH);
		this.add(pnelNhanvientheoPB, BorderLayout.CENTER);
		
	        
	        loadNVPB();
	}
	 private void loadNVPB() throws DBException {
	        tbltheophongban = (DefaultTableModel) tbtheophongban.getModel();
	        tbltheophongban.setRowCount(0);
	      
	        
	        try {
	        	
	        	listNVPB = new NhanvienDAO().getAllNhanvienPhongban();
	            int num = 0;
	            for (NhanvienPhongban b : listNVPB) {
	                
	                Object row[] = new Object[]{++num,  pbdao.find(b.getMaphongban()).getTenphongban(), b.getSonhanvien()};
	                tbltheophongban.addRow(row);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	 
	 public static void main (String args[]) {
		 
		 JFrame frame= new JFrame();
		 frame.setSize(1200,600);
		 frame.setVisible(true);
		 frame.getContentPane().add(new Baocao());
		 
	 }
}

