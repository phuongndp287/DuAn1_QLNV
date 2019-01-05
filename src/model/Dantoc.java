package model;

public class Dantoc {
	private int madantoc;
	private String tendantoc;
	

	public int getMadantoc() {
		return madantoc;
	}
	public void setMadantoc(int madantoc) {
		this.madantoc = madantoc;
	}
	public String getTendantoc() {
		return tendantoc;
	}
	public void setTendantoc(String tendantoc) {
		this.tendantoc = tendantoc;
	}
	public Dantoc(int madantoc, String tendantoc) {
		super();
		this.madantoc = madantoc;
		this.tendantoc = tendantoc;
	}
	public Dantoc() {
		super();
	}
	
}
