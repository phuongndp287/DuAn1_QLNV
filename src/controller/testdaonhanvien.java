package controller;

import dao.NhanvienDAO;
import dataaccsesshelper.Validate;
import model.Nhanvien;

public class testdaonhanvien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
NhanvienDAO nvdao= new NhanvienDAO();
Nhanvien nv = new Nhanvien(1,15,"Đăng",true,"19931212",1,"0123213","mail","cntt","20181212",3,true,4.0,2);
System.out.println(nvdao.getInsert(nv));
System.out.println(Validate.md5("123123"));
}

}
