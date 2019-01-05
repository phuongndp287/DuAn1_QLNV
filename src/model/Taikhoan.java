package model;

public class Taikhoan {
	private int manhanvien;
	private String tendangnhap;
	private String matkhau;
	private boolean isAdmin;
	public int getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(int manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Taikhoan() {
		super();
		
	}
	public Taikhoan(int manhanvien, String tendangnhap, String matkhau, boolean isAdmin) {
		super();
		this.manhanvien = manhanvien;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.isAdmin = isAdmin;
	}

}
