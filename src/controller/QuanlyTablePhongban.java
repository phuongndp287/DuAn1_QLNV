package controller;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.DantocDAO;
import dao.HocviDAO;
import dao.PhongbanDAO;
import model.Dantoc;
import model.Hocvi;
import model.Phongban;

public class QuanlyTablePhongban extends AbstractTableModel {
private ArrayList<Phongban> listphongban=new ArrayList<>();
private ArrayList<Dantoc> listdantoc=new ArrayList<>();
private ArrayList<Hocvi> listhocvi=new ArrayList<>();
private Phongban phongban;
private Dantoc dantoc;
private Hocvi hocvi;
private String[] columnsPhongban={"STT","Tên phòng ban"};	
private PhongbanDAO phongbandao=new PhongbanDAO();
private DantocDAO dantocdao=new DantocDAO();
private HocviDAO hocvidao=new HocviDAO();

public PhongbanDAO getPhongbanDAO(){
	return phongbandao;
	
}
public QuanlyTablePhongban(){
	
	listphongban=phongbandao.getAllphongban();
	listdantoc=dantocdao.getAlldantoc();
	listhocvi=hocvidao.getAllhocvi();
}
public QuanlyTablePhongban(ArrayList phongban){
	
	listphongban=phongban;
	listdantoc=dantocdao.getAlldantoc();
	listhocvi=hocvidao.getAllhocvi();
}
public ArrayList<Phongban> getListPhongban(){
	return listphongban;
}
public ArrayList<Dantoc> getListDantoc(){
	return listdantoc;
}
public ArrayList<Hocvi> getListHocvi(){
	return listhocvi;
}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnsPhongban.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listphongban.size();
	}
	@Override
	public String getColumnName(int columnIndex) {
		return columnsPhongban[columnIndex];
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		if(col == 0) return false;
		return true;
	}
	@Override
	public void setValueAt(Object value, int row, int col) {
		switch (col) {
		case 1:
			listphongban.get(row).setMaphongban((Integer)value);
			break;
		case 2:
			listphongban.get(row).setTenphongban((String)value);
			break;
	
		}
//	    fireTableCellUpdated(row, col);
	   listphongban=phongbandao.getAllphongban();
//	    cusListModel.fireChange();
	   
	  }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Phongban phongban = listphongban.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return phongban.getMaphongban();
		case 1:
			return phongban.getTenphongban();
		
		default:
			break;
		}
		return null;
	}
	
	public Object getObjectAt(int rowIndex, int columnIndex) {
		Phongban phongban = listphongban.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return phongban;
		case 1:
			return phongban;
		
		default:
			break;
		}
		return null;
	}
	

}
