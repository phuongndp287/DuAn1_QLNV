package views;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.TaikhoanDAO;
import dataaccsesshelper.Validate;
import model.Taikhoan;

public class Dangnhap extends JFrame {
	private JLabel lblTendangnhap = new JLabel("Tên đăng nhập");
	private JLabel lblMatkhau = new JLabel("Mật khẩu");
	private JTextField txtTendangnhap = new JTextField();
	private JPasswordField txtMatkhau = new JPasswordField();
	private JButton btnDangnhap = new JButton("Đăng nhập");
	private JButton btnboqua = new JButton("Bỏ qua");
	private JPanel pn1 = new JPanel();
	private JPanel pn2 = new JPanel();
	private GridBagLayout gridbaglayout = new GridBagLayout();
	private JCheckBox cbnhomatkhau = new JCheckBox("Nhớ mật khẩu");
	private JFrame frame = new JFrame("Quản lý nhân viên");
	GridBagConstraints gbc = new GridBagConstraints();

	public Dangnhap() {

		demo();

	}

	public void demo() {

		pn1.setLayout(gridbaglayout);

		pn1.add(lblTendangnhap, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 10), 0, 0));
		pn1.add(txtTendangnhap, new GridBagConstraints(1, 0, 3, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 20), 0, 0));

		pn1.add(lblMatkhau, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 10), 0, 0));
		pn1.add(txtMatkhau, new GridBagConstraints(1, 1, 3, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 20), 0, 0));
		pn1.add(cbnhomatkhau, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 10), 0, 0));

		frame.getContentPane().add(pn1);
		pn2.setLayout(new FlowLayout());
		pn2.add(btnDangnhap);
		pn2.add(btnboqua);
		pn1.add(pn2, new GridBagConstraints(2, 2, 2, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 20), 0, 0));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		btnDangnhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtTendangnhap.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy nhập tài khoản!");
					txtTendangnhap.requestFocus();
				} else if (txtMatkhau.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hãy nhập mật khẩu!");
					txtMatkhau.requestFocus();
				} else {
					String user = txtTendangnhap.getText();
					String pass = txtMatkhau.getText();

					boolean check = checkLogin(user, pass);
					if (check) {
						Chonquanly cql = new Chonquanly();
						frame.setVisible(false);
						cql.getItemquaylai().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								frame.setVisible(true);
							}
						});
						if (cbnhomatkhau.isSelected() == false) {
							txtMatkhau.setText("");
							txtTendangnhap.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Đăng nhập không thành công kiểm tra lại thông tin đăng nhập!");

					}

				}
			}
		});
	}

	public boolean checkLogin(String user, String pass) {
		TaikhoanDAO tkdao = new TaikhoanDAO();
		Taikhoan tk = new Taikhoan();
		tk = tkdao.find(user);
		System.out.println(tk.getMatkhau());
		if (tk.getMatkhau().equals(Validate.md5(pass))) {
			return true;
		} else
			return false;
	}

	public static void main(String args[]) {
		Dangnhap lout = new Dangnhap();
	}
}
