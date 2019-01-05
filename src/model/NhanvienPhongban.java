package model;

public class NhanvienPhongban {
private int maphongban;
private int sonhanvien;
public int getMaphongban() {
	return maphongban;
}


public NhanvienPhongban() {
	super();
	
}
public NhanvienPhongban(int maphongban, int sonhanvien) {
	super();
	this.maphongban = maphongban;
	this.sonhanvien = sonhanvien;
}



public void setMaphongban(int maphongban) {
	this.maphongban = maphongban;
}
public int getSonhanvien() {
	return sonhanvien;
}
public void setSonhanvien(int sonhanvien) {
	this.sonhanvien = sonhanvien;
}

}
