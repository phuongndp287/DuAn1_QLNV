package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Phongban;

public class PhongbanDAO extends DataDAO {

	private final String getAll = "select * from phongban";
	private final String getAllPHongbancoNV = "select distinct phongban.MaPhongBan,phongban.TenPhongBan\r\n" + 
			"from phongban inner join nhanvien on phongban.maphongban=nhanvien.maphongban;";
	private final String getPhongbanfromID = "select * from Phongban where maPhongban=?";
	private final String insert = "insert into Phongban(maPhongban,tenPhongban) values(?,?)";
	private final String delete = "delete from Phongban  where maPhongban=?";
	private final String update = "update Phongban set maPhongban = ?,tenPhongban = ? where maPhongban = ?";
	

	public ArrayList<Phongban> getAllphongban() {
		ArrayList<Phongban> listPhongban = new ArrayList<>();
	
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAll);
			ResultSet rs = ps.executeQuery();
			
		while(rs.next()){
				Phongban item = new Phongban();
				item.setMaphongban(rs.getInt("maPhongban"));
				item.setTenphongban(rs.getString("tenPhongban"));
				listPhongban.add(item);

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPhongban;
	}
	public ArrayList<Phongban> getAllphongbancoNhanvien() {
		ArrayList<Phongban> listPhongban = new ArrayList<>();
	
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAllPHongbancoNV);
			ResultSet rs = ps.executeQuery();
			
		while(rs.next()){
				Phongban item = new Phongban();
				item.setMaphongban(rs.getInt("maPhongban"));
				item.setTenphongban(rs.getString("tenPhongban"));
				listPhongban.add(item);

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPhongban;
	}

	@Override
	public void getInsert() {
		// TODO Auto-generated method stub

	}
	

    public boolean getInsert(Phongban Phongban) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, Phongban.getMaphongban());
            ps.setString(2, Phongban.getTenphongban());
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
	 public boolean getUpdate(int maPhongban, String tenPhongban) {
	        boolean check = false;
	        try {
	            getConnection();
	            PreparedStatement ps = con.prepareStatement(update);
	            ps.setInt(1, maPhongban);
	            ps.setString(2, tenPhongban);
	            ps.setInt(3, maPhongban);        
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
    public boolean getDelete(int maPhongban) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setInt(1, maPhongban);
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

	public Phongban find(int maPhongban) {
		Phongban item = new Phongban();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getPhongbanfromID);
			ps.setInt(1, maPhongban);

			ResultSet rs = ps.executeQuery();

			if (rs != null && rs.next()) {

				item.setMaphongban(rs.getInt("maPhongban"));
				item.setTenphongban(rs.getString("tenPhongban"));	

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

}
