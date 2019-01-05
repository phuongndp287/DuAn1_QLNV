package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Dantoc;

public class DantocDAO extends DataDAO {

	private final String getAll = "select * from Dantoc";
	private final String getDantocfromID = "select * from Dantoc where madantoc=?";
	private final String insert = "insert into Dantoc(madantoc,tenDantoc) values(?,?)";
	private final String delete = "delete from Dantoc  where maDantoc=?";
	private final String update = "update Dantoc set maDantoc = ?,tenDantoc = ? where maDantoc = ?";
	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}

	public ArrayList<Dantoc> getAlldantoc() {
		ArrayList<Dantoc> listDantoc = new ArrayList<>();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getAll);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Dantoc item = new Dantoc();
				item.setMadantoc(rs.getInt("maDantoc"));
				item.setTendantoc(rs.getString("tenDantoc"));
				listDantoc.add(item);

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDantoc;
	}

	@Override
	public void getInsert() {
		// TODO Auto-generated method stub

	}
	

    public boolean getInsert(Dantoc Dantoc) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, Dantoc.getMadantoc());
            ps.setString(2, Dantoc.getTendantoc());
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
	 public boolean getUpdate(int maDantoc, String tenDantoc) {
	        boolean check = false;
	        try {
	            getConnection();
	            PreparedStatement ps = con.prepareStatement(update);
	            ps.setInt(1, maDantoc);
	            ps.setString(2, tenDantoc);
	            ps.setInt(3, maDantoc);        
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
    public boolean getDelete(int maDantoc) {
        boolean check = false;
        try {
            getConnection();
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setInt(1, maDantoc);
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

	public Dantoc find(int maDantoc) {
		Dantoc item = new Dantoc();
		try {
			getConnection();
			PreparedStatement ps = con.prepareStatement(getDantocfromID);
			ps.setInt(1, maDantoc);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				item.setMadantoc(rs.getInt("maDantoc"));
				item.setTendantoc(rs.getString("tenDantoc"));	

			}
			getClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

}
