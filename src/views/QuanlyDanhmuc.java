package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class QuanlyDanhmuc extends JPanel {
	private Label lblDanhmuc = new Label("DANH MỤC THAM CHIẾU");

	private Label lblPHONGBAN = new Label("PHÒNG BAN");
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnLuu = new JButton("Lưu");
	private JButton btnBoqua = new JButton("Bỏ Qua");
	private JTable tabDanhmuc = new JTable();
	private JTable tabPhongban = new JTable();
	private JScrollPane scDanhmuc = new JScrollPane(tabDanhmuc);
	private JScrollPane scPhongban = new JScrollPane(tabPhongban);

	private JLabel lblTenphongban = new JLabel("Tên phòng ban:");
	private JTextField txtTenphongban = new JTextField();
	private JLabel lblMaphongban = new JLabel("Mã phòng ban:");
	private JTextField txtMaphongban = new JTextField();
	private JLabel lblDanhsachphongban = new JLabel("Danh sách phòng ban");
	private JPanel pnTop = new JPanel();
	private JPanel pn1 = new JPanel();
	private JPanel pneldanhmuc;
	private JPanel pnBody = new JPanel();
	private GridBagLayout gridbaglayout = new GridBagLayout();
	private BorderLayout bdl = new BorderLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private Quanlyphongban qlpb = new Quanlyphongban();
	private Quanlytaikhoan qltk = new Quanlytaikhoan();
	private Quanlyhocvi qlhv = new Quanlyhocvi();
	private Quanlychucvu qlcv = new Quanlychucvu();
	private Quanlydantoc qldt = new Quanlydantoc();

	public QuanlyDanhmuc() {

		demo();
	}

	public void demo() {
		String[] columnNameDanhmuc = { "STT", "Danh mục" };
		String[][] data = { { "1", "Phòng ban" },

				{ "2", "Dân tộc" }, { "3", "Học vị" }, { "4", "Chức vụ" }, { "5", "Tài khoản" } };
		
		
		scPhongban = new JScrollPane(tabPhongban);
		tabDanhmuc = new JTable(data, columnNameDanhmuc);
		tabDanhmuc.setBounds(10, 40, 200, 200);
		scDanhmuc = new JScrollPane(tabDanhmuc);

		this.setSize(1200, 600);
		this.setLayout(bdl);
		pneldanhmuc = new JPanel();

		tabDanhmuc.setDefaultEditor(Object.class, null);
		tabPhongban.setDefaultEditor(Object.class, null);
		pneldanhmuc.setLayout(new BorderLayout());
		pneldanhmuc.add(lblDanhmuc, new BorderLayout().NORTH);
		pneldanhmuc.add(scDanhmuc, new BorderLayout().CENTER);

		pnBody.setLayout(new BorderLayout());
		this.add(pnTop, bdl.NORTH);
		this.add(pneldanhmuc, bdl.WEST);
		pneldanhmuc.setPreferredSize(new Dimension(300, 600));

		pnBody.setPreferredSize(new Dimension(900, 600));
		
		
		this.add(pnBody, bdl.CENTER);

		
	}

	public static void main(String args[]) {

		QuanlyDanhmuc qlpb = new QuanlyDanhmuc();

	}

	public JTable getTabDanhmuc() {
		return tabDanhmuc;
	}

	public void setTabDanhmuc(JTable tabDanhmuc) {
		this.tabDanhmuc = tabDanhmuc;
	}

	public JPanel getPnBody() {
		return pnBody;
	}

	public void setPnBody(JPanel pnBody) {
		this.pnBody = pnBody;
	}
	
	
	

}
