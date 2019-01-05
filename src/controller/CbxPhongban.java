package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import dao.PhongbanDAO;
import model.Phongban;

public class CbxPhongban extends AbstractListModel implements ComboBoxModel {
	private Phongban phongban;
	private PhongbanDAO phongbandao;
	private Object selectedItem;
	private ArrayList<Phongban> listphongban;
	
	public CbxPhongban() {
		listphongban = phongbandao.getAllphongban();
	  }
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getElementAt(int i) {
		// TODO Auto-generated method stub
		return listphongban.get(i);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return listphongban.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}
	  
		  
	@Override
	public void setSelectedItem(Object anItem) {
		  selectedItem = anItem;
		
	}

}
