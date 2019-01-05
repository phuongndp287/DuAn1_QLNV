package model;

public class Hocvi {
	private int mahocvi;
	private String tenhocvi;
	public int getMahocvi() {
		return mahocvi;
	}
	public void setMahocvi(int mahocvi) {
		this.mahocvi = mahocvi;
	}
	public String getTenhocvi() {
		return tenhocvi;
	}
	public void setTenhocvi(String tenhocvi) {
		this.tenhocvi = tenhocvi;
	}
	public Hocvi(int mahocvi, String tenhocvi) {
		super();
		this.mahocvi = mahocvi;
		this.tenhocvi = tenhocvi;
	}
	public Hocvi() {
		super();
	}
	
}
