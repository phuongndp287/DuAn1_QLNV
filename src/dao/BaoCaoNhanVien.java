package dao;
/*
 * Cái method CountNvByNam trả về list rồi đó anh, xong anh display qua view giúp em, chả hiểu sao em không chạy được views anh gửi
 */
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import dao.DantocDAO;
import model.Nhanvien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.CoutNamTuyenDung;
import model.Hocvi;
import model.Nhanvien;

public class BaoCaoNhanVien extends DantocDAO {
	private final String sql = "select count (*) from dbo.nhanvien";
	private final String QUERY_NHANVIEN_BY_DANTOC = "select count(*) from dbo.nhanvien where MaDanToc=?";
	private final String QUERY_NHANVIEN_BY_GIOITINH = "select count(*) from dbo.nhanvien where Gioitinh=?	";
	private final String QUERY_NHANVIEN_BY_MACHUCVU = "select count(*) from dbo.nhanvien where MaChucvu=?";
	private final String QUERY_NHANVIEN_BY_HOCVI = "	select count(*) from dbo.nhanvien where Mahocvi=?";
	private final String QUERY_NHANVIEN_BY_PHONGBAN = "	select count(*) from dbo.nhanvien where maphongban=?";

	public void getAllNhanvien() {
		String kq = null;

		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq = rs.getString(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("so nhan vien trong cong ty" + kq);
	}

	/*
	 * ==========================CountNvByDanToc=====================
	 */
	public void CountNvByDanToc(int maDanToc) {

		String kq = null;

		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_DANTOC);
			ps.setLong(1, maDanToc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq = rs.getString(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("so nhan vien co dan toc " + maDanToc + " la:" + kq);
	}

	/*
	 * ===========================CountNvByGioiTinh=========================
	 */
	public void CountNvByGioiTinh(int maGioiTinh) {
		String kq = null;

		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_GIOITINH);
			ps.setLong(1, maGioiTinh);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq = rs.getString(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("so nhan vien co gioi tinh " + maGioiTinh + " la:" + kq);
	}

	/*
	 * ==============================CountNvByChucVu============================
	 * ==
	 */
	public void CountNvByChucVu(int maChucVu) {
		String kq = null;

		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_MACHUCVU);
			ps.setLong(1, maChucVu);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq = rs.getString(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("so nhan vien co chuc vu " + maChucVu + " la:" + kq);
	}

	/*
	 * ==============================CountNvByChuyenMon=========================
	 * ==
	 */
	public void CountNvByChuyenMon(String chuyenMon) {
		String kq = null;
		final String QUERY_NHANVIEN_BY_CHUYENMON = "select count(*) from dbo.nhanvien where ChuyenMon like N'"
				+ chuyenMon + "'";
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_CHUYENMON);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq = rs.getString(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("so nhan vien co Chuyen Mon " + chuyenMon + " la:" + kq);
	}

	/*
	 * ==============================CountNvByHocVi=============================
	 */
	public void CountNvByHocVi(int maHocVi) {
		String kq = null;

		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_HOCVI);
			ps.setLong(1, maHocVi);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq = rs.getString(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("so nhan vien co hoc vi " + maHocVi + " la:" + kq);
	}

	/*
	 * ===========================CountNvByPhongBan=========================
	 */
	public void CountNvByPhongBan(int maPhongBan) {
		String kq = null;

		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_PHONGBAN);
			ps.setLong(1, maPhongBan);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq = rs.getString(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("so nhan vien co o hong ban " + maPhongBan + " la:" + kq);
	}

	/*
	 * ===========================CountNvByNamTuyenDung=========================
	 */
	public List<CoutNamTuyenDung> CountNvByNamTuyenDung() throws ParseException {
		int namDau = CountNamDau();
		int namCuoi = CountNamCuoi();
		ArrayList<CoutNamTuyenDung> arr = new ArrayList<>();
		String kq = null;
		for (int i = namDau; i <= namCuoi; i++) {
			final String QUERY_NHANVIEN_BY_NAMTUYENDUNG = "	select count(*) from dbo.nhanvien where Ngaytuyendung >= '"
					+ i + "-1-1' and Ngaytuyendung<'" + i + "-12-31'";
			try {
				getConnection();
				PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_NAMTUYENDUNG);

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					kq = rs.getString(1);
				}
				getClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("so nhan vien co nam tuyen dung " + i + " la:" + kq);
			CoutNamTuyenDung cntd = new CoutNamTuyenDung(i, kq);
			arr.add(cntd);
		}
		System.out.println("Nhan vien theo nam tuyen dung: \n" + arr.toString() + "\n");
		return arr;
	}

	/*
	 * ===========================CountNvByNamTuyenDung=========================
	 */
	public int CountNamDau() throws ParseException {
		Date nam = null;
		final String QUERY_NHANVIEN_BY_NAMTUYENDUNG = "select top 1 percent NgayTuyenDung  from dbo.NhanVien order by NgayTuyenDung asc	";
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_NAMTUYENDUNG);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nam = rs.getDate(1);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(nam);
		System.out.println("nam cuoi la:" + cal.get(Calendar.YEAR));
		return cal.get(Calendar.YEAR);
	}

	/*
	 * ===========================CountNvByNamTuyenDung=========================
	 */
	public int CountNamCuoi() throws ParseException {
		Date nam = null;
		String kq = null;
		final String QUERY_NHANVIEN_BY_NAMTUYENDUNG = "select top 1 percent NgayTuyenDung  from dbo.NhanVien order by NgayTuyenDung desc	";
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_NAMTUYENDUNG);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nam = rs.getDate(1);
				
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(nam);
		System.out.println("nam cuoi la:" + cal.get(Calendar.YEAR));
		return cal.get(Calendar.YEAR);
	}

	public static void main(String[] args) throws ParseException {
		new BaoCaoNhanVien().getAllNhanvien();
		new BaoCaoNhanVien().CountNamCuoi();
		new BaoCaoNhanVien().CountNamDau();
		new BaoCaoNhanVien().CountNvByNamTuyenDung();
	}
}
