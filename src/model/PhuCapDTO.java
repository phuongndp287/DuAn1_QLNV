/**
 * 
 */
package model;

/**
 * @author Admin
 *
 */
public class PhuCapDTO {
	private String maNv;
	private String tenNv;
	/**
	 * @return the tenNv
	 */
	public String getTenNv() {
		return tenNv;
	}
	/**
	 * @param tenNv the tenNv to set
	 */
	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}
	private String chuyenMon;
	private String chucVu;
	private String hocVi;
	private String heSoPC;
	/**
	 * @return the maNv
	 */
	public String getMaNv() {
		return maNv;
	}
	/**
	 * @param maNv the maNv to set
	 */
	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}
	/**
	 * @return the chuyenMon
	 */
	public String getChuyenMon() {
		return chuyenMon;
	}
	/**
	 * @param chuyenMon the chuyenMon to set
	 */
	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}
	/**
	 * @return the chucVu
	 */
	public String getChucVu() {
		return chucVu;
	}
	/**
	 * @param chucVu the chucVu to set
	 */
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	/**
	 * @return the hocVi
	 */
	public String getHocVi() {
		return hocVi;
	}
	/**
	 * @param hocVi the hocVi to set
	 */
	public void setHocVi(String hocVi) {
		this.hocVi = hocVi;
	}
	/**
	 * @return the heSoPC
	 */
	public String getHeSoPC() {
		return heSoPC;
	}
	/**
	 * @param heSoPC the heSoPC to set
	 */
	public void setHeSoPC(String heSoPC) {
		this.heSoPC = heSoPC;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhuCapDTO [maNv=" + maNv + ", chuyenMon=" + chuyenMon + ", chucVu=" + chucVu + ", hocVi=" + hocVi
				+ ", heSoPC=" + heSoPC + "]";
	}
	public PhuCapDTO(String maNv, String tenNv, String chuyenMon, String chucVu, String hocVi, String heSoPC) {
		super();
		this.maNv = maNv;
		this.tenNv=tenNv;
		this.chuyenMon = chuyenMon;
		this.chucVu = chucVu;
		this.hocVi = hocVi;
		this.heSoPC = heSoPC;
	}
	public PhuCapDTO() {
		super();
	}
	
}
