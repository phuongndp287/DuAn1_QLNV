package controller;

import views.Chonquanly;
import views.Dangnhap;
import views.Quanly;
import views.Quanlychucvu;
import views.Quanlydantoc;
import views.Quanlyhocvi;
import views.Quanlyphongban;
import views.Quanlytaikhoan;

public class Controller {
	private Chonquanly cql ;
	private Dangnhap dn ;
	public Controller() {
		cql.setVisible(false);
		dn.setVisible(true);
	}

//	public Controller(Chonquanly cql, Dangnhap dn, Quanlytaikhoan qltk, Quanlychucvu qlcv, Quanly ql, Quanlydantoc qldt,
//		Quanlyphongban qlpb, Quanlyhocvi qlhv) {
//		super();
//		this.cql = cql;
//		this.dn = dn;
//		this.qltk = qltk;
//		this.qlcv = qlcv;
//		this.ql = ql;
//		this.qldt = qldt;
//		this.qlpb = qlpb;
//		this.qlhv = qlhv;
//		setVisibale(false);
//		dn.setVisible(true);
//	}

	public void setVisibale(boolean tt) {
		cql.setVisible(tt);
		dn.setVisible(tt);
		
	}
	public static void main(String args[]) {
		Controller con = new Controller();
		
		
	}

}
