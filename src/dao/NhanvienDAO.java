package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Hocvi;
import model.Nhanvien;
import model.NhanvienPhongban;
import model.PhuCapDTO;

public class NhanvienDAO extends DataDAO {

	private final String getAll = "select * from Nhanvien";
	private final String getNhanvienfromID = "select * from Nhanvien where manhanvien=?";
	private final String insert = "insert into Nhanvien(maphongban,manhanvien,tennhanvien,gioitinh,ngaysinh,madantoc,dienthoai,email,chuyenmon,ngaytuyendung,MaChucvu,HopDongDaiHan,Hesoluong,MaHocVi) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String delete = "delete from Nhanvien  where manhanvien=?";
	private final String upDate = "Update Nhanvien set maphongban=?,tennhanvien=?,gioitinh=?,ngaysinh=?,madantoc=?,dienthoai=?,email=?,chuyenmon=?,ngaytuyendung=?,MaChucvu=?,HopDongDaiHan=?,Hesoluong=?,MaHocVi=? where manhanvien = ?";
	private final String getAllformPhongban = "select * from Nhanvien where maphongban=?";
//	private final String countfromnhanvien = "  select  count (*) as sonhanvien from nhanvien where NgayTuyenDung like '% ? %'";
	private final String countNhanvientheophongban = "  select MaPhongBan as maphongban, count (*) as sonhanvien  from nhanvien group by maphongban";
	private final String QUERY_NHANVIEN_BY_PHUCAP ="select DISTINCT  dbo.NhanVien.MaNhanVien,dbo.NhanVien.TenNhanVien, dbo.NhanVien.ChuyenMon, dbo.ChucVu.TenChucVu, dbo.HocVi.TenHocVi, dbo.ChucVu.HeSoPhuCap \r\n" + 
			"from dbo.NhanVien left join dbo.ChucVu on dbo.NhanVien.MaChucvu = dbo.ChucVu.MaChucvu left join dbo.HocVi on dbo.NhanVien.MaChucvu=dbo.ChucVu.MaChucVu where dbo.ChucVu.HeSoPhuCap>0 and dbo.NhanVien.MaHocVi=dbo.HocVi.MaHocVi";
	public ArrayList<Nhanvien> getAllNhanvienTheophongban(int maphongban) {
		ArrayList<Nhanvien> listNhanvien = new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAllformPhongban);
			ps.setInt(1, maphongban);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Nhanvien item = new Nhanvien();
				item.setMaphongban(rs.getInt("maphongban"));
				item.setManhanvien(rs.getInt("manhanvien"));
				item.setTennhanvien(rs.getString("tennhanvien"));
				item.setGioitinh(rs.getBoolean("gioitinh"));
				item.setNgaysinh(rs.getString("ngaysinh"));
				item.setMadantoc(rs.getInt("madantoc"));
				item.setDienthoai(rs.getString("dienthoai"));
				item.setEmail(rs.getString("email"));
				item.setChuyenmon(rs.getString("chuyenmon"));
				item.setNgaytuyendung(rs.getString("ngaytuyendung"));
				item.setMachucvu(rs.getInt("machucvu"));
				item.setHopdongdaihan(rs.getBoolean("hopdongdaihan"));
				item.setHesoluong(rs.getDouble("hesoluong"));
				item.setMahocvi(rs.getInt("mahocvi"));
				listNhanvien.add(item);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNhanvien;
	}

	public ArrayList<Nhanvien> getAllNhanvien() {
		ArrayList<Nhanvien> listNhanvien = new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAll);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Nhanvien item = new Nhanvien();
				item.setMaphongban(rs.getInt("maphongban"));
				item.setManhanvien(rs.getInt("manhanvien"));
				item.setTennhanvien(rs.getString("tennhanvien"));
				item.setGioitinh(rs.getBoolean("gioitinh"));
				item.setNgaysinh(rs.getString("ngaysinh"));
				item.setMadantoc(rs.getInt("madantoc"));
				item.setDienthoai(rs.getString("dienthoai"));
				item.setEmail(rs.getString("email"));
				item.setChuyenmon(rs.getString("chuyenmon"));
				item.setNgaysinh(rs.getString("ngaytuyendung"));
				item.setMachucvu(rs.getInt("machucvu"));
				item.setHopdongdaihan(rs.getBoolean("hopdongdaihan"));
				item.setHesoluong(rs.getDouble("hesoluong"));
				item.setMahocvi(rs.getInt("mahocvi"));
				listNhanvien.add(item);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNhanvien;
	}

	public ArrayList<NhanvienPhongban> getAllNhanvienPhongban() {
		ArrayList<NhanvienPhongban> listNhanvienPhongban = new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(countNhanvientheophongban);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanvienPhongban item = new NhanvienPhongban();
				item.setMaphongban(rs.getInt("maphongban"));
				item.setSonhanvien(rs.getInt("sonhanvien"));
				listNhanvienPhongban.add(item);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNhanvienPhongban;
	}

	@Override
	public void getInsert() {
		// TODO Auto-generated method stub

	}

	public boolean getInsert(Nhanvien nhanvien) {
		boolean check = false;
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, nhanvien.getMaphongban());
			ps.setInt(2, nhanvien.getManhanvien());
			ps.setString(3, nhanvien.getTennhanvien());
			ps.setBoolean(4, nhanvien.isGioitinh());
			ps.setString(5, nhanvien.getNgaysinh());
			ps.setInt(6, nhanvien.getMadantoc());
			ps.setString(7, nhanvien.getDienthoai());
			ps.setString(8, nhanvien.getEmail());
			ps.setString(9, nhanvien.getChuyenmon());
			ps.setString(10, nhanvien.getNgaytuyendung());
			ps.setInt(11, nhanvien.getMachucvu());
			ps.setBoolean(12, nhanvien.isHopdongdaihan());
			ps.setDouble(13, nhanvien.getHesoluong());
			ps.setInt(14, nhanvien.getMahocvi());
			int rs = ps.executeUpdate();
			if (rs > 0) {
				check = true;
			}
		} catch (Exception e) {
		}
		return check;
	}

//	public int getsonhanvientheonam(int namtuyendung) {
//		int check = 0;
//		try {
//			getConnection();
//			PreparedStatement ps = con.prepareStatement(insert);
//			ps.setInt(1, namtuyendung);
//			ResultSet rs = ps.executeQuery();
//
//			check = rs.getInt(rs.getInt("sonhanvien"));
//		} catch (Exception e) {
//		}
//		return check;
//	}

	public boolean getUpDate(Nhanvien nhanvien) {
		boolean check = false;
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(upDate);
			ps.setInt(1, nhanvien.getMaphongban());
			ps.setString(2, nhanvien.getTennhanvien());
			ps.setBoolean(3, nhanvien.isGioitinh());
			ps.setString(4, nhanvien.getNgaysinh());
			ps.setInt(5, nhanvien.getMadantoc());
			ps.setString(6, nhanvien.getDienthoai());
			ps.setString(7, nhanvien.getEmail());
			ps.setString(8, nhanvien.getChuyenmon());
			ps.setString(9, nhanvien.getNgaytuyendung());
			ps.setInt(10, nhanvien.getMachucvu());
			ps.setBoolean(11, nhanvien.isHopdongdaihan());
			ps.setDouble(12, nhanvien.getHesoluong());
			ps.setInt(13, nhanvien.getMahocvi());
			ps.setInt(14, nhanvien.getManhanvien());
			ps.executeUpdate();
			getClose();
			check = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public void getDelete() {
		// TODO Auto-generated method stub

	}

	public boolean getDelete(int manhanvien) {
		boolean check = false;
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, manhanvien);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				check = true;
			}

			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public Object find() {
		// TODO Auto-generated method stub
		return null;
	}

	public Nhanvien find(int maNhanvien) {
		Nhanvien item = new Nhanvien();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getNhanvienfromID);
			ps.setInt(1, maNhanvien);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				item.setMaphongban(rs.getInt("maphongban"));
				item.setManhanvien(rs.getInt("manhanvien"));
				item.setTennhanvien(rs.getString("tennhanvien"));
				item.setGioitinh(rs.getBoolean("gioitinh"));
				item.setNgaysinh(rs.getString("ngaysinh"));
				item.setMadantoc(rs.getInt("madantoc"));
				item.setDienthoai(rs.getString("dienthoai"));
				item.setEmail(rs.getString("email"));
				item.setChuyenmon(rs.getString("chuyenmon"));
				item.setNgaytuyendung(rs.getString("ngaytuyendung"));
				item.setMachucvu(rs.getInt("machucvu"));
				item.setHopdongdaihan(rs.getBoolean("hopdongdaihan"));
				item.setHesoluong(rs.getDouble("hesoluong"));
				item.setMahocvi(rs.getInt("mahocvi"));

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public void getUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}
	public List<PhuCapDTO> getAllNhanVienByPhuCap() {
		String maNv;
		String tenNv;
		String chuyenMon;
		String chucVu;
		String hocVi;
		String heSoPC; 
		PhuCapDTO pcdto=new PhuCapDTO();
		List<PhuCapDTO> lstPC=new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY_NHANVIEN_BY_PHUCAP);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				maNv=rs.getString(1);
				tenNv=rs.getString(2);
				chuyenMon=rs.getString(3);
				chucVu=rs.getString(4);
				hocVi=rs.getString(5);
				heSoPC=rs.getString(6);
				
				lstPC.add(new PhuCapDTO(maNv,tenNv, chuyenMon, chucVu, hocVi, heSoPC));
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Get Nhan vien by phu cap:" + lstPC);
		return lstPC;
	}

}
