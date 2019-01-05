package model;



public class Nhanvien {
	private int maphongban;
	private int manhanvien;
	private String tennhanvien;
	private boolean gioitinh;
	private String ngaysinh;
	private int madantoc;
	private String dienthoai;
	private String email;
	private String chuyenmon;
	private String ngaytuyendung;
	private int machucvu;
	private boolean hopdongdaihan;
	private double hesoluong;
	private int mahocvi;
	
	
	
	public Nhanvien(int maphongban, int manhanvien, String tennhanvien, boolean gioitinh, String ngaysinh, int madantoc,
			String dienthoai, String email, String chuyenmon, String ngaytuyendung, int machucvu, boolean hopdongdaihan,
			double hesoluong, int mahocvi) {
		super();
		this.maphongban = maphongban;
		this.manhanvien = manhanvien;
		this.tennhanvien = tennhanvien;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.madantoc = madantoc;
		this.dienthoai = dienthoai;
		this.email = email;
		this.chuyenmon = chuyenmon;
		this.ngaytuyendung = ngaytuyendung;
		this.machucvu = machucvu;
		this.hopdongdaihan = hopdongdaihan;
		this.hesoluong = hesoluong;
		this.mahocvi = mahocvi;
	}
	public int getMaphongban() {
		return maphongban;
	}
	public void setMaphongban(int maphongban) {
		this.maphongban = maphongban;
	}
	public int getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(int manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getTennhanvien() {
		return tennhanvien;
	}
	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getMadantoc() {
		return madantoc;
	}
	public void setMadantoc(int madantoc) {
		this.madantoc = madantoc;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChuyenmon() {
		return chuyenmon;
	}
	public void setChuyenmon(String chuyenmon) {
		this.chuyenmon = chuyenmon;
	}
	public String getNgaytuyendung() {
		return ngaytuyendung;
	}
	public void setNgaytuyendung(String ngaytuyendung) {
		this.ngaytuyendung = ngaytuyendung;
	}
	public int getMachucvu() {
		return machucvu;
	}
	public void setMachucvu(int machucvu) {
		this.machucvu = machucvu;
	}
	public boolean isHopdongdaihan() {
		return hopdongdaihan;
	}
	public void setHopdongdaihan(boolean hopdongdaihan) {
		this.hopdongdaihan = hopdongdaihan;
	}
	public double getHesoluong() {
		return hesoluong;
	}
	public void setHesoluong(double hesoluong) {
		this.hesoluong = hesoluong;
	}
	public int getMahocvi() {
		return mahocvi;
	}
	public void setMahocvi(int mahocvi) {
		this.mahocvi = mahocvi;
	}
	
	public Nhanvien() {
		super();
	}

	
}
