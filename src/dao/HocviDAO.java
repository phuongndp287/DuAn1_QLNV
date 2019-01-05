package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Hocvi;

public class HocviDAO extends DataDAO {

	private final String getAll = "select * from Hocvi";
	private final String getHocvifromID = "select * from Hocvi where maHocvi=?";
	private final String insert = "insert into Hocvi(maHocvi,tenHocvi) values(?,?)";
	private final String delete = "delete from Hocvi  where maHocvi=?";
	private final String update = "update Hocvi set maHocvi = ?,tenHocvi = ? where maHocvi = ?";
	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}

	public ArrayList<Hocvi> getAllhocvi() {
		ArrayList<Hocvi> listHocvi = new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAll);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Hocvi item = new Hocvi();
				item.setMahocvi(rs.getInt("maHocvi"));
				item.setTenhocvi(rs.getString("tenHocvi"));
				listHocvi.add(item);

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listHocvi;
	}

	@Override
	public void getInsert() {
		// TODO Auto-generated method stub

	}
	

    public boolean getInsert(Hocvi Hocvi) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, Hocvi.getMahocvi());
            ps.setString(2, Hocvi.getTenhocvi());
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
	 public boolean getUpdate(int maHocvi, String tenHocvi) {
	        boolean check = false;
	        try {
	            getConnection();
	            PreparedStatement ps = con.prepareStatement(update);
	            ps.setInt(1, maHocvi);
	            ps.setString(2, tenHocvi);
	            ps.setInt(3, maHocvi);        
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
    public boolean getDelete(int maHocvi) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setInt(1, maHocvi);
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

	public Hocvi find(int maHocvi) {
		Hocvi item = new Hocvi();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getHocvifromID);
			ps.setInt(1, maHocvi);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				item.setMahocvi(rs.getInt("maHocvi"));
				item.setTenhocvi(rs.getString("tenHocvi"));	

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

}
