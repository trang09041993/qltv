package model;

import java.sql.Date;

public class thongke {
	private Date ngay;
	private int soLM;
	private int soST;
	private int soSM;
	private int tienCoc;
	private int tienPhat;
	private int thang;
	private String ten;
	
	public thongke(Date ngay, int soLM, int soST, int soSM, int tienCoc, int tienPhat, int thang, String ten) {
		super();
		this.ngay = ngay;
		this.soLM = soLM;
		this.soST = soST;
		this.soSM = soSM;
		this.tienCoc = tienCoc;
		this.tienPhat = tienPhat;
		this.thang = thang;
		this.ten = ten;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public thongke() {
		super();
	}
	
	public int getSoLM() {
		return soLM;
	}
	public void setSoLM(int soLM) {
		this.soLM = soLM;
	}
	public int getSoST() {
		return soST;
	}
	public void setSoST(int soST) {
		this.soST = soST;
	}
	public int getSoSM() {
		return soSM;
	}
	public void setSoSM(int soSM) {
		this.soSM = soSM;
	}
	public int getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(int tienCoc) {
		this.tienCoc = tienCoc;
	}
	public int getTienPhat() {
		return tienPhat;
	}
	public void setTienPhat(int tienPhat) {
		this.tienPhat = tienPhat;
	}

}
