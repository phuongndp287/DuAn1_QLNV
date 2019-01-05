package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.PhongbanDAO;

import model.Phongban;

public class Quanlyphongban extends JPanel {

	private Label lblQLPB = new Label("Quản lý phòng ban");
	private Label lblPHONGBAN = new Label("PHÒNG BAN");
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnLuu1 = new JButton("Lưu");
	private JButton btnLuu2 = new JButton("Lưu");
	private JButton btnBoqua = new JButton("Bỏ Qua");
	private JTable tabPhongban = new JTable();
	private JScrollPane scPhongban = new JScrollPane(tabPhongban);
	private JLabel lblTenphongban = new JLabel("Tên phòng ban:");
	private JTextField txtTenphongban = new JTextField();
	private JLabel lblMaphongban = new JLabel("Mã phòng ban:");
	private JTextField txtMaphongban = new JTextField();
	private JLabel lblDanhsachphongban = new JLabel("Danh sách phòng ban");
	private JPanel pnelchitiet = new JPanel();
	private GridBagLayout gridbaglayout = new GridBagLayout();
	private BorderLayout bdl = new BorderLayout();
	private String header[] = { "STT", "Mã phòng ban", "Tên phòng ban" };
	private DefaultTableModel tblPhongban = new DefaultTableModel(header, 0);
	private PhongbanDAO pbdao = new PhongbanDAO();
	private ArrayList<Phongban> listPB = null;
	GridBagConstraints gbc = new GridBagConstraints();

	public Quanlyphongban() {
		demo();
		try {
			loadBCNVPB();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void demo() {
		this.setSize(900, 600);
		scPhongban = new JScrollPane(tabPhongban);
		tabPhongban.setDefaultEditor(Object.class, null);

		pnelchitiet.setLayout(new GridBagLayout());
		pnelchitiet.add(lblPHONGBAN, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
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
		pnelchitiet.add(lblTenphongban, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtTenphongban, new GridBagConstraints(1, 1, 8, 1, 8.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(lblMaphongban, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));
		pnelchitiet.add(txtMaphongban, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

		pnelchitiet.add(lblDanhsachphongban, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 0), 0, 0));

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);

		Object[][] data = {};
		tabPhongban.setModel(new DefaultTableModel(data, header));
		tabPhongban.setPreferredScrollableViewportSize(new Dimension(880, 250));
		tabPhongban.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabPhongban.setFillsViewportHeight(true);

		TableColumn column = null;
		tabPhongban.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabPhongban.getColumnModel().getColumn(1).setPreferredWidth(400);
		tabPhongban.getColumnModel().getColumn(2).setPreferredWidth(400);

		tabPhongban.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tabPhongban.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tabPhongban.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		this.setLayout(new BorderLayout());
		this.add(pnelchitiet, new BorderLayout().NORTH);
		this.add(scPhongban, new BorderLayout().CENTER);
		trangthaibandau(false);

		tabPhongban.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tabPhongban.getSelectedRow();
				int colum = 1;
				int maphongban = (int) tblPhongban.getValueAt(row, colum);
				PhongbanDAO pbdao = new PhongbanDAO();
				Phongban pb = new Phongban();
				pb = pbdao.find(maphongban);
				txtMaphongban.setText(pb.getMaphongban() + "");
				txtTenphongban.setText(pb.getTenphongban());
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
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoatrang();
				trangthaithemsuaxoa(false);
				trangthaibandau(true);
				btnLuu1.setVisible(true);
				btnLuu1.setEnabled(true);
				btnLuu2.setVisible(false);
				btnLuu2.setEnabled(false);
				txtTenphongban.requestFocus();
			}
		});
		btnLuu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhongbanDAO pbdao = new PhongbanDAO();
				Phongban pb = new Phongban();
				int maphongban = Integer.valueOf(txtMaphongban.getText());
				String tenphongban = txtTenphongban.getText();
				pb.setMaphongban(maphongban);
				pb.setTenphongban(tenphongban);
				boolean check = pbdao.getInsert(pb);
				if (check) {

					try {
						trangthaibandau(false);
						trangthaithemsuaxoa(true);
						loadBCNVPB();
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Kiểm tra mã phòng ban thêm phòng ban thất bại!");
				}

			}
		});
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				trangthaithemsuaxoa(false);
				trangthaibandau(true);
				btnLuu1.setVisible(false);
				btnLuu1.setEnabled(false);
				btnLuu2.setVisible(true);
				btnLuu2.setEnabled(true);
				txtMaphongban.setEnabled(false);
			}
		});
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				trangthaibandau(false);
				trangthaithemsuaxoa(true);
				if (txtMaphongban.getText().isEmpty() == false) {
					int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa phòng ban?");
					if (hoi == 0) {
						PhongbanDAO pbdao = new PhongbanDAO();

						if (pbdao.getDelete(Integer.parseInt(txtMaphongban.getText()))) {

							try {
								loadBCNVPB();
								xoatrang();
							} catch (DBException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Phòng ban có nhân viên không thể xóa!");
							}

						} else {

							JOptionPane.showMessageDialog(null, "Phòng ban có nhân viên không thể xóa!");
						}

					}
				}
			}
		});
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				trangthaibandau(true);
				trangthaithemsuaxoa(false);
				btnLuu1.setVisible(false);
				btnLuu2.setVisible(true);
				btnLuu2.setEnabled(true);
				txtMaphongban.setEnabled(false);

			}
		});
		btnLuu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tenphongban = txtTenphongban.getText();
				int maphongban = Integer.parseInt(txtMaphongban.getText());
				PhongbanDAO pbdao = new PhongbanDAO();

				if (pbdao.getUpdate(maphongban, tenphongban)) {
					try {
						loadBCNVPB();
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Cập nhật phòng ban thất bại!");
				}
			}
		});
		btnBoqua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				trangthaibandau(false);
				trangthaithemsuaxoa(true);

			}
		});
	}

	public void trangthaithemsuaxoa(boolean tt) {
		btnThem.setEnabled(tt);
		btnSua.setEnabled(tt);
		btnXoa.setEnabled(tt);
	}

	public void xoatrang() {
		txtTenphongban.setText("");
		txtMaphongban.setText("");
	}

	public void trangthaibandau(boolean tt) {
		btnLuu1.setEnabled(tt);
		btnLuu2.setEnabled(tt);
		btnBoqua.setEnabled(tt);
		txtTenphongban.setEnabled(tt);
		txtMaphongban.setEnabled(tt);

	};

	private void loadBCNVPB() throws DBException {
		tblPhongban = (DefaultTableModel) tabPhongban.getModel();
		tblPhongban.setRowCount(0);
		try {
			listPB = pbdao.getAllphongban();
			int num = 0;
			for (Phongban b : listPB) {

				Object row[] = new Object[] { ++num, b.getMaphongban(), b.getTenphongban() };
				tblPhongban.addRow(row);
				System.out.println(b.getTenphongban());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		Quanlyphongban qlpb = new Quanlyphongban();

	}

}
