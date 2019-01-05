package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import controller.QuanlyTablePhongban;
import controller.TableNhanvien;
import dao.NhanvienDAO;
import dao.PhongbanDAO;
import dataaccsesshelper.Validate;
import model.Nhanvien;
import model.Phongban;

public class Quanly extends JPanel {
	private JCheckBox cbHienthiphongban = new JCheckBox("Chỉ hiển thị phòng ban có nhân viên");
	private JTable tabPhongban = new JTable();
	private JTable tabNhanvien = new JTable();
	private JPanel pntabNhanvien = new JPanel();
	private JScrollPane scPhongban = new JScrollPane(tabPhongban);
	private JScrollPane scNhanvien = new JScrollPane(tabNhanvien);
	private JLabel lblPhongban = new JLabel("Phòng ban");
	private JComboBox cbxPhongban = new JComboBox();
	private JLabel lblManhanvien = new JLabel("Mã nhân viên");
	private JTextField txtManhanvien = new JTextField();
	private JLabel lblHoten = new JLabel("Họ tên");
	private JTextField txtHoten = new JTextField();
	private JLabel lblGioitinh = new JLabel("Giới tính");
	private JRadioButton rdNam = new JRadioButton("Nam");
	private JRadioButton rdNu = new JRadioButton("Nữ");
	private ButtonGroup groupGioitinh = new ButtonGroup();
	private JLabel lblNgaysinh = new JLabel("Ngày sinh");
	private JTextField txtNgaysinh = new JTextField();
	private JLabel lblDantoc = new JLabel("Dân tộc");
	private JComboBox cbxDantoc = new JComboBox<>();
	private JLabel lblDienthoai = new JLabel("Điện thoại");
	private JTextField txtDienthoai = new JTextField();
	private JLabel lblEmail = new JLabel("Email");
	private JTextField txtEmail = new JTextField();
	private JLabel lblChuyenmon = new JLabel("Chuyên môn");
	private JTextField txtChuyenmon = new JTextField();
	private JLabel lblHocvi = new JLabel("Học vị");
	private JComboBox cbxHocvi = new JComboBox<>();
	private JLabel lblNgaytuyendung = new JLabel("Ngày tuyển dụng");
	private JTextField txtNgaytuyendung = new JTextField();
	private JCheckBox cbhddaihan = new JCheckBox("Hợp đồng dài hạn");
	private JLabel lblHesoluong = new JLabel("Hệ số lương");
	private JTextField txtHesoluong = new JTextField();
	private JLabel lblChucvu = new JLabel("Chức vụ");
	private JRadioButton rdNhanvien = new JRadioButton("Nhân viên");
	private JRadioButton rdPhotruongphong = new JRadioButton("Phó trưởng phòng");
	private JRadioButton rdTruongphong = new JRadioButton("Trưởng phòng");
	private ButtonGroup groupChucvu = new ButtonGroup();
	private JLabel lblPhucapchucvu = new JLabel("Phụ cấp chức vụ");
	private JTextField txtPhucapchucvu = new JTextField();
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton(" Sửa ");
	private JButton btnXoa = new JButton(" Xóa ");
	private JButton btnLuu1 = new JButton(" Lưu ");
	private JButton btnLuu2 = new JButton(" Lưu ");
	private JButton btnBoqua = new JButton("Bỏ qua");
	private JLabel lblTimkiem = new JLabel("Tìm kiếm:");
	private JTextField txtTimkiem = new JTextField();
	private JButton btnTimkiem = new JButton("Tìm Kiếm");
	private JButton btnKetxuat = new JButton("Kết xuất");
	private JPanel pnelQuanly = new JPanel();
	private JPanel pnelLetrai;
	private JPanel pnelChitiet = new JPanel();
	private GridBagLayout gridbaglayout = new GridBagLayout();
	private BorderLayout bdl = new BorderLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private String[] columnNamePhongban;
	private String[][] dataPhongban;
	private String[] columnNameNhanvien;
	private String[][] dataNhanvien;
	private QuanlyTablePhongban tablePhongbanModel = new QuanlyTablePhongban();
	private TableNhanvien tableNhanvienModel = new TableNhanvien();
	private static int checkmanhanvien = 0;
	private static int checkthemsua = 0;
	private JLabel lblTenPhongban = new JLabel("NHÂN VIÊN PHÒNG BAN");

	public Quanly() {

		Quanly();
		this.setVisible(true);
	}

	public void Quanly() {

		rdNhanvien.setSelected(true);
		tabNhanvien = new JTable();
		tabNhanvien.setModel(tableNhanvienModel);
		scNhanvien = new JScrollPane(tabNhanvien);
		tabPhongban = new JTable();
		tabPhongban.setModel(tablePhongbanModel);
		scPhongban = new JScrollPane(tabPhongban);
		for (int i = 0; i < tablePhongbanModel.getListPhongban().size(); i++) {
			cbxPhongban.addItem(tablePhongbanModel.getListPhongban().get(i).getTenphongban());

		}
		for (int i = 0; i < tablePhongbanModel.getListDantoc().size(); i++) {
			cbxDantoc.addItem(tablePhongbanModel.getListDantoc().get(i).getTendantoc());

		}
		for (int i = 0; i < tablePhongbanModel.getListHocvi().size(); i++) {
			cbxHocvi.addItem(tablePhongbanModel.getListHocvi().get(i).getTenhocvi());

		}
		rdNhanvien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rdNhanvien.isSelected()) {

					txtPhucapchucvu.setText("0.0");
				}
			}
		});
		rdPhotruongphong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rdPhotruongphong.isSelected()) {

					txtPhucapchucvu.setText("0.7");
				}
			}
		});
		rdTruongphong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rdTruongphong.isSelected()) {
					rdTruongphong.setSelected(true);

					txtPhucapchucvu.setText("1.0");
				}
			}
		});
		
		
		this.setSize(1200, 600);
		pnelQuanly.setLayout(bdl);
		pnelLetrai = new JPanel();
		pnelLetrai.setSize(300, 600);
		pnelLetrai.setLayout(new BorderLayout());
		pnelLetrai.add(cbHienthiphongban, new BorderLayout().NORTH);
		pnelLetrai.add(scPhongban, new BorderLayout().CENTER);
		pnelChitiet.setLayout(new GridBagLayout());

		pnelChitiet.add(lblTenPhongban, new GridBagConstraints(0, 0, 1, 1, 2.0, 2.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnThem, new GridBagConstraints(4, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnSua, new GridBagConstraints(5, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnXoa, new GridBagConstraints(6, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnLuu1, new GridBagConstraints(7, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnLuu2, new GridBagConstraints(7, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnBoqua, new GridBagConstraints(8, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

		pnelChitiet.add(lblPhongban, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(cbxPhongban, new GridBagConstraints(1, 1, 8, 1, 8.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblManhanvien, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtManhanvien, new GridBagConstraints(1, 2, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblHoten, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtHoten, new GridBagConstraints(4, 2, 5, 1, 5.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		groupGioitinh.add(rdNam);
		groupGioitinh.add(rdNu);

		pnelChitiet.add(lblGioitinh, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(rdNam, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(rdNu, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblNgaysinh, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtNgaysinh, new GridBagConstraints(4, 3, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblDantoc, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(cbxDantoc, new GridBagConstraints(7, 3, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblDienthoai, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtDienthoai, new GridBagConstraints(1, 4, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtDienthoai, new GridBagConstraints(1, 4, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblEmail, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtEmail, new GridBagConstraints(4, 4, 5, 1, 5.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblChuyenmon, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtChuyenmon, new GridBagConstraints(1, 5, 5, 1, 5.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblHocvi, new GridBagConstraints(6, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(cbxHocvi, new GridBagConstraints(7, 5, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblNgaytuyendung, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtNgaytuyendung, new GridBagConstraints(1, 6, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(cbhddaihan, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblHesoluong, new GridBagConstraints(7, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtHesoluong, new GridBagConstraints(8, 6, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblChucvu, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		groupChucvu.add(rdNhanvien);
		groupChucvu.add(rdTruongphong);
		groupChucvu.add(rdPhotruongphong);
		pnelChitiet.add(rdNhanvien, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(rdPhotruongphong, new GridBagConstraints(2, 7, 2, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(rdTruongphong, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblPhucapchucvu, new GridBagConstraints(7, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtPhucapchucvu, new GridBagConstraints(8, 7, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(lblTimkiem, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(txtTimkiem, new GridBagConstraints(1, 8, 2, 1, 2.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnTimkiem, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelChitiet.add(btnKetxuat, new GridBagConstraints(8, 8, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

		tabNhanvien.setPreferredScrollableViewportSize(new Dimension(900, 300));

		pnelQuanly.add(pnelLetrai, bdl.WEST);
		JPanel pnnelTop = new JPanel();
		JPanel pnBody = new JPanel();
		pnBody.setLayout(new BorderLayout());
		pnelQuanly.add(pnnelTop, bdl.NORTH);
		pnnelTop.setPreferredSize(new Dimension(1200, 0));
		pnelLetrai.setPreferredSize(new Dimension(300, 600));
		pnBody.add(pnelChitiet, new BorderLayout().NORTH);
		pnBody.add(scNhanvien, new BorderLayout().CENTER);

		JPanel pnLephai = new JPanel();
		pnLephai.setPreferredSize(new Dimension(20, 600));

		pnelQuanly.add(pnBody, bdl.CENTER);
		this.add(pnelQuanly);

		// event khoa table
		tabPhongban.setDefaultEditor(Object.class, null);
		tabNhanvien.setDefaultEditor(Object.class, null);
		trangthaibandau(false);
		trangthaiThemsuaxoa(true);
		tabPhongban.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				Phongban pb = new Phongban();
				int rows = tabPhongban.getSelectedRow();
				int colums = tabPhongban.getSelectedColumn();
				Phongban phongban = (Phongban) tablePhongbanModel.getObjectAt(rows, colums);
				tabNhanvien.setModel(new TableNhanvien(phongban.getMaphongban()));
				NhanvienDAO nhanviendao = new NhanvienDAO();

				tableNhanvienModel.setListnhanvien(nhanviendao.getAllNhanvienTheophongban(phongban.getMaphongban()));
				cbxPhongban.setSelectedIndex(phongban.getMaphongban() - 1);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		cbHienthiphongban.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cbHienthiphongban.isSelected()) {

					PhongbanDAO pbdao = new PhongbanDAO();
					tabPhongban.setModel(new QuanlyTablePhongban(pbdao.getAllphongbancoNhanvien()));

				} else {
					PhongbanDAO pbdao = new PhongbanDAO();
					tabPhongban.setModel(tablePhongbanModel);
				}
			}
		});

		tabNhanvien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				Nhanvien nv = new Nhanvien();
				int rows = tabNhanvien.getSelectedRow();
				int colums = tabNhanvien.getSelectedColumn();
				tabNhanvien.getSelectedRow();
				int manv = (Integer) tabNhanvien.getValueAt(rows, 1);
				NhanvienDAO nvdao = new NhanvienDAO();
				nv = nvdao.find(manv);
				cbxPhongban.setSelectedIndex(nv.getMaphongban() - 1);
				txtManhanvien.setText(nv.getManhanvien() + "");
				txtHoten.setText(nv.getTennhanvien() + "");
				if (nv.isGioitinh()) {
					rdNam.setSelected(true);

				}
				if (nv.isGioitinh() == false) {
					rdNu.setSelected(true);
				}

				txtNgaysinh.setText(Validate.ConvertDate(nv.getNgaytuyendung()));

				cbxDantoc.setSelectedIndex(nv.getMadantoc() - 1);
				txtDienthoai.setText(nv.getDienthoai());
				txtEmail.setText(nv.getEmail());
				txtChuyenmon.setText(nv.getChuyenmon());
				cbxHocvi.setSelectedIndex(nv.getMahocvi() - 1);
				txtNgaytuyendung.setText(Validate.ConvertDate(nv.getNgaytuyendung()));

				if (nv.isHopdongdaihan()) {
					cbhddaihan.setSelected(true);
				}

				txtHesoluong.setText(nv.getHesoluong() + "");
				if (nv.getMachucvu() == 1) {
					rdNhanvien.setSelected(true);
					txtPhucapchucvu.setText("0.0");
				} else if (nv.getMachucvu() == 2) {
					rdPhotruongphong.setSelected(true);

					txtPhucapchucvu.setText("0.7");
				} else if (nv.getMachucvu() == 3) {
					rdTruongphong.setSelected(true);

					txtPhucapchucvu.setText("1.0");
				}

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		txtDienthoai.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (txtDienthoai.getText().isEmpty()) {
				} else {
					if (Validate.checkNumberPhone(txtDienthoai.getText()) == -1) {
						JOptionPane.showMessageDialog(null, "Chuỗi nhập vào không phải là số");
						txtDienthoai.requestFocus();
					} else if (Validate.checkNumberPhone(txtDienthoai.getText()) == 2) {

						JOptionPane.showMessageDialog(null, "Độ dài số điện thoại không đúng");
						txtDienthoai.requestFocus();
					} else if (Validate.checkNumberPhone(txtDienthoai.getText()) == 1) {

						String sodienthoai = txtDienthoai.getText();

					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtNgaysinh.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (txtNgaysinh.getText().isEmpty()) {
				} else {
					if (Validate.isDateValid(txtNgaysinh.getText())) {
					} else {
						JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng ngày/tháng/năm");
						txtNgaysinh.requestFocus();

					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (txtEmail.getText().isEmpty()) {
				} else {
					if (Validate.isValidEmail(txtEmail.getText())) {
					} else {
						JOptionPane.showMessageDialog(null, "Email không hợp lệ");
						txtEmail.requestFocus();
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtNgaytuyendung.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (txtNgaytuyendung.getText().isEmpty()) {
				} else {
					if (Validate.isDateValid(txtNgaytuyendung.getText())) {

					} else {
						JOptionPane.showMessageDialog(null, "Ngày tuyển dụng không đúng định dạng ngày/tháng/năm");
						txtNgaytuyendung.requestFocus();
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtManhanvien.requestFocus();
				trangthaibandau(true);
				trangthaiThemsuaxoa(false);
				btnLuu1.setEnabled(true);
				btnLuu1.setVisible(true);
				btnLuu2.setVisible(false);
				btnBoqua.setEnabled(true);
				xoatrang();
				txtManhanvien.addFocusListener(new FocusListener() {

					@Override
					public void focusLost(FocusEvent arg0) {
						// TODO Auto-generated method stub
						NhanvienDAO nvdao = new NhanvienDAO();
						ArrayList<Nhanvien> listnv = new ArrayList<>();
						listnv = nvdao.getAllNhanvien();
						if (txtManhanvien.getText().isEmpty()) {
						} else {
							for (Nhanvien nhanvien : listnv) {
								if (nhanvien.getManhanvien() == Integer.parseInt(txtManhanvien.getText())) {
									JOptionPane.showMessageDialog(null, "Mã nhân viên bị trùng lặp");

									txtManhanvien.requestFocus();
								} else {
									int manhanvien = Integer.parseInt(txtManhanvien.getText());

								}
							}
						}
					}

					@Override
					public void focusGained(FocusEvent arg0) {
						// TODO Auto-generated method stub

					}
				});

			}
		});
		btnLuu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (txtManhanvien.getText().isEmpty() || txtHoten.getText().isEmpty()
						|| txtDienthoai.getText().isEmpty() || txtNgaysinh.getText().isEmpty()
						|| txtEmail.getText().isEmpty() || txtChuyenmon.getText().isEmpty()
						|| txtNgaytuyendung.getText().isEmpty() || lblHesoluong.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin nhân viên");

				} else {
					NhanvienDAO nvdao = new NhanvienDAO();
					int maphongban = cbxPhongban.getSelectedIndex() + 1;
					int manhanvien = Integer.parseInt(txtManhanvien.getText());
					String tennhanvien = txtHoten.getText();
					boolean gioitinh = rdNam.isSelected();
					String convertngaysinh = Validate.ConvertDatetoDate(txtNgaysinh.getText());
					String ngaysinh = Validate.ConverDatetoSQL(convertngaysinh);
					int madantoc = cbxDantoc.getSelectedIndex() + 1;
					String sodienthoai = txtDienthoai.getText();
					String email = email = txtEmail.getText();
					String chuyenmon = txtChuyenmon.getText();
					int mahocvi = cbxHocvi.getSelectedIndex() + 1;
					String convertngaytuyendung = Validate.ConvertDatetoDate(txtNgaytuyendung.getText());
					String ngaytuyendung = Validate.ConverDatetoSQL(convertngaytuyendung);
					boolean hopdongdaihan = cbhddaihan.isSelected();
					Double hesoluong = Double.parseDouble(txtHesoluong.getText());
					int machucvu = 1;
					if (rdNhanvien.isSelected()) {
						machucvu = 1;
					} else if (rdPhotruongphong.isSelected()) {
						machucvu = 2;
					} else if (rdTruongphong.isSelected()) {
						machucvu = 3;
					}
					Nhanvien nv = new Nhanvien(maphongban, manhanvien, tennhanvien, gioitinh, ngaysinh, madantoc,
							sodienthoai, email, chuyenmon, ngaytuyendung, machucvu, hopdongdaihan, hesoluong, mahocvi);

					TableNhanvien tb = new TableNhanvien();
					boolean themnv = tb.themnv(nv);
					if (themnv) {
						tabNhanvien.setModel(new TableNhanvien(nv.getMaphongban()));
						trangthaibandau(false);
						trangthaiThemsuaxoa(true);

					} else {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại kiểm tra lại mã nhân viên!");
					}
				}

			}
		});
		btnBoqua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				trangthaibandau(false);
				xoatrang();
				btnLuu1.setVisible(true);
				btnLuu2.setVisible(true);
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);

			}
		});

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtHoten.requestFocus();
				trangthaibandauSua(true);
				trangthaiThemsuaxoa(false);
				btnLuu1.setVisible(false);
				btnLuu2.setVisible(true);
				btnLuu2.setEnabled(true);
				btnBoqua.setEnabled(true);
				txtManhanvien.setEnabled(false);
			}
		});

		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int xoa = -1;
				xoa = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên?");
				if (xoa == 0) {

					if (txtManhanvien.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Hãy chọn nhân viên cần xóa");

					} else {

						NhanvienDAO nvdao = new NhanvienDAO();
						Nhanvien nv = nvdao.find(Integer.parseInt(txtManhanvien.getText()));
						boolean check = nvdao.getDelete(Integer.parseInt(txtManhanvien.getText()));
						if (check) {
							tabNhanvien.setModel(new TableNhanvien(nv.getMaphongban()));
							trangthaibandau(false);
							xoatrang();
							trangthaiThemsuaxoa(true);
						}

					}
				}
			}
		});

		btnLuu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (txtManhanvien.getText().isEmpty() || txtHoten.getText().isEmpty()
						|| txtDienthoai.getText().isEmpty() || txtNgaysinh.getText().isEmpty()
						|| txtEmail.getText().isEmpty() || txtChuyenmon.getText().isEmpty()
						|| txtNgaytuyendung.getText().isEmpty() || lblHesoluong.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin nhân viên");

				} else {
					NhanvienDAO nvdao = new NhanvienDAO();
					int maphongban = cbxPhongban.getSelectedIndex() + 1;
					int manhanvien = Integer.parseInt(txtManhanvien.getText());
					String tennhanvien = txtHoten.getText();
					boolean gioitinh = rdNam.isSelected();
					String convertngaysinh = Validate.ConvertDatetoDate(txtNgaysinh.getText());
					String ngaysinh = Validate.ConverDatetoSQL(convertngaysinh);
					int madantoc = cbxDantoc.getSelectedIndex() + 1;
					String sodienthoai = txtDienthoai.getText();
					String email = email = txtEmail.getText();
					String chuyenmon = txtChuyenmon.getText();
					int mahocvi = cbxHocvi.getSelectedIndex() + 1;
					String convertngaytuyendung = Validate.ConvertDatetoDate(txtNgaytuyendung.getText());
					String ngaytuyendung = Validate.ConverDatetoSQL(convertngaytuyendung);
					boolean hopdongdaihan = cbhddaihan.isSelected();
					Double hesoluong = Double.parseDouble(txtHesoluong.getText());
					int machucvu = 1;
					if (rdNhanvien.isSelected()) {
						machucvu = 1;
					} else if (rdPhotruongphong.isSelected()) {
						machucvu = 2;
					} else if (rdTruongphong.isSelected()) {
						machucvu = 3;
					}
					Nhanvien nv = new Nhanvien(maphongban, manhanvien, tennhanvien, gioitinh, ngaysinh, madantoc,
							sodienthoai, email, chuyenmon, ngaytuyendung, machucvu, hopdongdaihan, hesoluong, mahocvi);
					if (nvdao.getUpDate(nv)) {

						tabNhanvien.setModel(new TableNhanvien(nv.getMaphongban()));
						trangthaibandau(false);
						trangthaiThemsuaxoa(true);

					} else {
						JOptionPane.showMessageDialog(null, "Cập nhất thông tin nhân viên thất bại!");
					}
				}

			}
		});

	}


	public void trangthaibandau(boolean tt) {
		btnLuu1.setEnabled(tt);
		btnLuu2.setEnabled(tt);
		btnBoqua.setEnabled(tt);
		trangthaiThemsuaxoa(tt);
		cbxPhongban.setEnabled(tt);
		txtManhanvien.setEnabled(tt);
		txtHoten.setEnabled(tt);
		rdNam.setEnabled(tt);
		rdNu.setEnabled(tt);
		txtNgaysinh.setEnabled(tt);
		cbxDantoc.setEnabled(tt);
		txtDienthoai.setEnabled(tt);
		txtEmail.setEnabled(tt);
		txtChuyenmon.setEnabled(tt);
		cbxHocvi.setEnabled(tt);
		txtNgaytuyendung.setEnabled(tt);
		cbhddaihan.setEnabled(tt);
		txtHesoluong.setEnabled(tt);
		rdNhanvien.setEnabled(tt);
		rdPhotruongphong.setEnabled(tt);
		rdTruongphong.setEnabled(tt);
		txtPhucapchucvu.setEnabled(tt);
	}

	public void trangthaibandauSua(boolean tt) {
		btnLuu1.setVisible(false);
		btnLuu2.setEnabled(tt);
		btnBoqua.setEnabled(tt);
		trangthaiThemsuaxoa(tt);
		cbxPhongban.setEnabled(tt);
		txtManhanvien.setEnabled(tt);
		txtHoten.setEnabled(tt);
		rdNam.setEnabled(tt);
		rdNu.setEnabled(tt);
		txtNgaysinh.setEnabled(tt);
		cbxDantoc.setEnabled(tt);
		txtDienthoai.setEnabled(tt);
		txtEmail.setEnabled(tt);
		txtChuyenmon.setEnabled(tt);
		cbxHocvi.setEnabled(tt);
		txtNgaytuyendung.setEnabled(tt);
		cbhddaihan.setEnabled(tt);
		txtHesoluong.setEnabled(tt);
		rdNhanvien.setEnabled(tt);
		rdPhotruongphong.setEnabled(tt);
		rdTruongphong.setEnabled(tt);
		txtPhucapchucvu.setEnabled(tt);
	}

	public void xoatrang() {
		txtManhanvien.setText("");
		txtHoten.setText("");
		txtNgaysinh.setText("");
		txtDienthoai.setText("");
		txtEmail.setText("");
		txtChuyenmon.setText("");
		txtNgaytuyendung.setText("");
		txtHesoluong.setText("");
		txtPhucapchucvu.setText("");
	}

	public void trangthaiThem() {
		btnThem.setEnabled(false);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnLuu1.setEnabled(true);
		btnLuu2.setEnabled(false);
		btnBoqua.setEnabled(true);
		trangthaibandau(true);

	}

	public void trangthaiThemsuaxoa(boolean tt) {
		btnThem.setEnabled(tt);
		btnSua.setEnabled(tt);
		btnXoa.setEnabled(tt);
	}
public static void main(String args[]) {
	JFrame frame= new JFrame();
	frame.setVisible(true);
	Quanly ql= new Quanly();
	ql.setVisible(true);
	frame.getContentPane().add(ql);
	
	
}
}
