package model;

public class Phongban {
	private int maphongban;
	private String tenphongban;
	public Phongban(int maphongban, String tenphongban) {
		super();
		this.maphongban = maphongban;
		this.tenphongban = tenphongban;
	}
	public Phongban() {
		super();
	}
	public int getMaphongban() {
		return maphongban;
	}
	public void setMaphongban(int maphongban) {
		this.maphongban = maphongban;
	}
	public String getTenphongban() {
		return tenphongban;
	}
	public void setTenphongban(String tenphongban) {
		this.tenphongban = tenphongban;
	}
	
	
	
}
