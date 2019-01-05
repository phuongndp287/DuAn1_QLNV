package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

public class Chonquanly extends JFrame {

	private JPanel pnelQuanly = new JPanel();

	BorderLayout bdl = new BorderLayout();
	private JMenuBar mnuquanly = new JMenuBar();
	private JMenu menuql = new JMenu("Quản lý");
	private JMenu menubc = new JMenu("Báo cáo");
	private JMenuItem itembaocao = new JMenuItem("Báo cáo");
	private JMenu menuthoat = new JMenu("Thoát");
	private JMenuItem itemquaylai = new JMenuItem("Quay lại");
	private JMenuItem itemthoat = new JMenuItem("Thoát chương trình");
	private JMenuItem itemquanly = new JMenuItem("Quản lý nhân viên");
	private JMenuItem itemdanhmuc = new JMenuItem("Quản lý danh mục");

	private JFrame quanly = new JFrame("Quản lý nhân viên");
	private Quanly ql = new Quanly();
	private BaocaoView bc = new BaocaoView();
	private QuanlyDanhmuc dm = new QuanlyDanhmuc();
	private JPanel pnbody = new JPanel();

	public Chonquanly() {
		Quanly();

	}

	public void Quanly() {
		menuql.add(itemquanly);
		menuql.add(itemdanhmuc);

		menuthoat.add(itemquaylai);
		menuthoat.add(itemthoat);
		mnuquanly.add(menuql);

		mnuquanly.add(menubc);
		mnuquanly.add(menuthoat);
		menubc.add(itembaocao);
		ql.setVisible(true);
		bc.setVisible(true);
		quanly.setDefaultCloseOperation(quanly.EXIT_ON_CLOSE);
		quanly.setSize(1220, 600);
		quanly.setLocationRelativeTo(null);
		quanly.setVisible(true);
		quanly.setResizable(false);
		pnelQuanly.setLayout(bdl);
		JPanel pnnelTop = new JPanel();
		pnnelTop.setLayout(new BorderLayout());
		pnnelTop.add(mnuquanly, BorderLayout.WEST);

		ImagePanel panel = new ImagePanel(new ImageIcon("images/nhanvien.png").getImage());
		pnelQuanly.add(pnnelTop, bdl.NORTH);
		pnnelTop.setPreferredSize(new Dimension(1200, 20));

		pnelQuanly.add(pnbody, bdl.CENTER);
		quanly.getContentPane().add(pnelQuanly);
		quanly.revalidate();
		quanly.repaint();
		itemquanly.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnbody.remove(bc);
				pnbody.remove(dm);
				pnbody.add(ql, BorderLayout.CENTER);

				quanly.revalidate();
				quanly.repaint();

			}
		});
		itemdanhmuc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnbody.remove(ql);
				pnbody.remove(bc);
				pnbody.add(dm, BorderLayout.CENTER);

				quanly.revalidate();
				quanly.repaint();
			}
		});
		itemquaylai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quanly.setVisible(false);

			}
		});
		itemthoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?");
				if (hoi == 0) {
					System.exit(0);
				}
			}
		});
		itembaocao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnbody.remove(ql);
				pnbody.remove(dm);
				pnbody.add(bc, BorderLayout.CENTER);

				quanly.revalidate();
				quanly.repaint();
			}
		});
		dm.getTabDanhmuc().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (dm.getTabDanhmuc().getSelectedRow() == 0) {
					dm.getPnBody().removeAll();
					dm.getPnBody().add(new Quanlyphongban());
					quanly.revalidate();
					quanly.repaint();
				} else if (dm.getTabDanhmuc().getSelectedRow() == 1) {
					dm.getPnBody().removeAll();
					dm.getPnBody().add(new Quanlydantoc());
					quanly.revalidate();
					quanly.repaint();
				} else if (dm.getTabDanhmuc().getSelectedRow() == 2) {
					dm.getPnBody().removeAll();
					dm.getPnBody().add(new Quanlyhocvi());
					quanly.revalidate();
					quanly.repaint();
				} else if (dm.getTabDanhmuc().getSelectedRow() == 3) {
					dm.getPnBody().removeAll();
					dm.getPnBody().add(new Quanlychucvu());
					quanly.revalidate();
					quanly.repaint();
				} else if (dm.getTabDanhmuc().getSelectedRow() == 4) {
					dm.getPnBody().removeAll();
					dm.getPnBody().add(new Quanlytaikhoan());
					quanly.revalidate();
					quanly.repaint();
				}
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
	}

	public JMenuItem getItemquaylai() {
		return itemquaylai;
	}

	public void setItemquaylai(JMenuItem itemquaylai) {
		this.itemquaylai = itemquaylai;
	}

	
}
