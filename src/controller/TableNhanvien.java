package controller;

import java.awt.image.IndexColorModel;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.NhanvienDAO;
import dataaccsesshelper.Validate;
import model.Nhanvien;

public class TableNhanvien extends AbstractTableModel {
	private ArrayList<Nhanvien> listnhanvien = new ArrayList<>();
	private Nhanvien nhanvien;
	private String[] columnsnhanvien = { "STT","Mã nhân viên", "Họ tên", "Giới tính", "Ngày Sinh", "Nhân Lương" };
	private NhanvienDAO nhanviendao = new NhanvienDAO();
	
	public NhanvienDAO getnhanvienDAO() {
		return nhanviendao;
	}
	public TableNhanvien(int mapb) {

		listnhanvien = nhanviendao.getAllNhanvienTheophongban(mapb);
		
	}

	public TableNhanvien() {

		
	}

	
	public ArrayList<Nhanvien> getListnhanvien() {
		return listnhanvien;
	}

	public void setListnhanvien(ArrayList<Nhanvien> listnhanvien) {
		this.listnhanvien = listnhanvien;
	}

	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public String[] getColumnsnhanvien() {
		return columnsnhanvien;
	}

	public void setColumnsnhanvien(String[] columnsnhanvien) {
		this.columnsnhanvien = columnsnhanvien;
	}

	public NhanvienDAO getNhanviendao() {
		return nhanviendao;
	}

	public void setNhanviendao(NhanvienDAO nhanviendao) {
		this.nhanviendao = nhanviendao;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnsnhanvien.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listnhanvien.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnsnhanvien[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		if (col == 0)
			return false;
		return true;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		switch (col) {
		case 1:
			listnhanvien.get(row).setManhanvien((Integer) value);
			break;
		case 2:
			listnhanvien.get(row).setTennhanvien((String) value);
			break;

		}
		// fireTableCellUpdated(row, col);
		listnhanvien = nhanviendao.getAllNhanvien();
		// cusListModel.fireChange();
	}
	public boolean themnv(Nhanvien nv) {
		if(nhanviendao.getInsert(nv)) {
			listnhanvien=nhanviendao.getAllNhanvien();
			return true;
		}else {return false;}
		
		
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Nhanvien nhanvien = listnhanvien.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return listnhanvien.indexOf(nhanvien)+1;
		case 1:
			return nhanvien.getManhanvien();
		case 2:
			return nhanvien.getTennhanvien();
		case 3:
			if (nhanvien.isGioitinh() == true) {
				return "Nam";
			} else {
				return "Nữ";
			}
		case 4:
			return Validate.ConvertDate(nhanvien.getNgaysinh().toString());
		case 5:
			return nhanvien.getHesoluong();

		default:
			break;
		}
		return null;
	}
	public Object getObjectAt(int rowIndex, int columnIndex) {
		Nhanvien nhanvien = listnhanvien.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return nhanvien;
		case 1:
			return nhanvien;
		case 2:
			return nhanvien;
		case 3:
			return nhanvien;
		case 4:
			return nhanvien;

		default:
			break;
		}
		return null;
	}

}
