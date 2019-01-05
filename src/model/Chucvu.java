package model;

public class Chucvu {
private int machucvu;
private String tenchucvu;
private double hesophucap;

public int getMachucvu() {
	return machucvu;
}
public void setMachucvu(int machucvu) {
	this.machucvu = machucvu;
}
public String getTenchucvu() {
	return tenchucvu;
}
public void setTenchucvu(String tenchucvu) {
	this.tenchucvu = tenchucvu;
}
public double getHesophucap() {
	return hesophucap;
}
public void setHesophucap(double hesophucap) {
	this.hesophucap = hesophucap;
}

public Chucvu(int machucvu, String tenchucvu, double hesophucap) {
	super();
	this.machucvu = machucvu;
	this.tenchucvu = tenchucvu;
	this.hesophucap = hesophucap;
}
public Chucvu() {
	super();
}




}
