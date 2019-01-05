/**
 * 
 */
package model;

/**
 * @author Peanut
 *
 */
public class CoutNamTuyenDung {
	int nam;
	String soLuong;
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "CoutNamTuyenDung [nam=" + nam + ", soLuong=" + soLuong + "]";
	}
	public CoutNamTuyenDung(int nam, String kq) {
		super();
		this.nam = nam;
		this.soLuong = kq;
	}
	
}
