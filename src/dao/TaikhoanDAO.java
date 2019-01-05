package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Taikhoan;

public class TaikhoanDAO extends DataDAO {

	private final String getAll = "select * from Taikhoan";
	private final String getTaikhoanfromID = "select * from Taikhoan where tendangnhap=?";
	private final String insert = "insert into Taikhoan(manhanvien,tendangnhap,matkhau,isAdmin) values(?,?,?,?)";
	private final String delete = "delete from Taikhoan  where tendangnhap=?";
	private final String update = "update Taikhoan set manhanvien = ?,tendangnhap = ?,matkhau=?isAdmin=? where tendangnhap = ?";
	
	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Taikhoan> getAlltaikhoan() {
		ArrayList<Taikhoan> listTaikhoan = new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAll);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
				Taikhoan item = new Taikhoan();
				item.setManhanvien(rs.getInt("manhanvien"));
				item.setTendangnhap(rs.getString("tendangnhap"));
				item.setMatkhau(rs.getString("matkhau"));
				item.setAdmin(rs.getBoolean("isadmin"));
				listTaikhoan.add(item);
			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTaikhoan;
	}

	@Override
	public void getInsert() {
		// TODO Auto-generated method stub

	}
	

    public boolean getInsert(Taikhoan taikhoan) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, taikhoan.getManhanvien());
            ps.setString(2, taikhoan.getTendangnhap());
            ps.setString(3, taikhoan.getMatkhau());
            ps.setBoolean(4, taikhoan.isAdmin());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }

        } catch (Exception e) {
        }
        return check;
    }

	@Override
	public void getUpdate() {
		// TODO Auto-generated method stub

	}
	 public boolean getUpdate(int manhanvien, String tendangnhap,String matkhau,boolean isadmin) {
	        boolean check = false;
	        try {
	            getConnection();
	            PreparedStatement ps = con.prepareStatement(update);
	            ps.setInt(1, manhanvien);
	            ps.setString(2, tendangnhap);
	            ps.setString(3, matkhau);
	            ps.setBoolean(4, isadmin);   
	            ps.setString(5, tendangnhap);
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
    public boolean getDelete(String tendangnhap) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setString(1, tendangnhap);
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


	public Taikhoan find(String tendangnhap) {
		Taikhoan item = new Taikhoan();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getTaikhoanfromID);
			ps.setString(1, tendangnhap);

			ResultSet rs = ps.executeQuery();

				while(rs.next()) {

				item.setManhanvien(rs.getInt("manhanvien"));
				item.setTendangnhap(rs.getString("tendangnhap"));
				item.setMatkhau(rs.getString("matkhau"));
				item.setAdmin(rs.getBoolean("isadmin"));

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

}
