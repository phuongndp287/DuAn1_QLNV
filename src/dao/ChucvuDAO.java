package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Chucvu;

public class ChucvuDAO extends DataDAO {

	private final String getAll = "select * from Chucvu";
	private final String getChucvufromID = "select * from Chucvu where machucvu=?";
	private final String insert = "insert into chucvu(machucvu,tenchucvu,hesophucap) values(?,?,?)";
	private final String delete = "delete from chucvu  where machucvu=?";
	private final String update = "update chucvu set machucvu = ?,tenchucvu = ?,hesophucap = ? where machucvu = ?";
	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}

	public ArrayList<Chucvu> getAllchucvu() {
		ArrayList<Chucvu> listchucvu = new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAll);
		

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Chucvu item = new Chucvu();
				item.setMachucvu(rs.getInt("machucvu"));
				item.setTenchucvu(rs.getString("tenchucvu"));
				item.setHesophucap(rs.getDouble("hesophucap"));

				listchucvu.add(item);

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listchucvu;
	}

	@Override
	public void getInsert() {
		// TODO Auto-generated method stub

	}
	

    public boolean getInsert(Chucvu chucvu) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, chucvu.getMachucvu());
            ps.setString(2, chucvu.getTenchucvu());
            ps.setDouble(3, chucvu.getHesophucap());
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
	 public boolean getUpdate(int machucvu, String tenchucvu, double hesophucap) {
	        boolean check = false;
	        try {
	            getConnection();
	            PreparedStatement ps = con.prepareStatement(update);
	            ps.setInt(1, machucvu);
	            ps.setString(2, tenchucvu);
	            ps.setDouble(3, hesophucap);
	            ps.setInt(4, machucvu);
	            
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
    public boolean getDelete(int machucvu) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setInt(1, machucvu);
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

	public Chucvu find(int machucvu) {
		Chucvu item = new Chucvu();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getChucvufromID);
			ps.setInt(1, machucvu);

			ResultSet rs = ps.executeQuery();

			if (rs != null && rs.next()) {

				item.setMachucvu(rs.getInt("machucvu"));
				item.setTenchucvu(rs.getString("tenchucvu"));
				item.setHesophucap(rs.getDouble("hesophucap"));

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

}
