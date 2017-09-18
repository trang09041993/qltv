package model;

import java.sql.Date;


public class PhieuMuon extends Sach{
	private int maPhieuMuon;
	private int maDocGia;
	private Date ngayMuon;
	private Date ngayHenTra;
	private int soLuong;
	private int soTra;
	public int getSoTra() {
		return soTra;
	}
	public void setSoTra(int soTra) {
		this.soTra = soTra;
	}
	private int maSachMuon;
	private int tienCoc;
	private String tenSach;
	private Date ngayTra;
	private String tinhTrang;
	
	
	
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getMaPhieuMuon() {
		return maPhieuMuon;
	}
	
	public PhieuMuon() {
		super();
	}

	public PhieuMuon(int maPhieuMuon, int maDocGia, Date ngayMuon, Date ngayHenTra, int soLuong, int soTra,
			int maSachMuon, int tienCoc, String tenSach, Date ngayTra, String tinhTrang) {
		super();
		this.maPhieuMuon = maPhieuMuon;
		this.maDocGia = maDocGia;
		this.ngayMuon = ngayMuon;
		this.ngayHenTra = ngayHenTra;
		this.soLuong = soLuong;
		this.soTra = soTra;
		this.maSachMuon = maSachMuon;
		this.tienCoc = tienCoc;
		this.tenSach = tenSach;
		this.ngayTra = ngayTra;
		this.tinhTrang = tinhTrang;
	}
	public void setMaPhieuMuon(int maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}
	public int getMaDocGia() {
		return maDocGia;
	}
	public void setMaDocGia(int maDocGia) {
		this.maDocGia = maDocGia;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public Date getNgayHenTra() {
		return ngayHenTra;
	}
	public void setNgayHenTra(Date ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getMaSachMuon() {
		return maSachMuon;
	}
	public void setMaSachMuon(int maSachMuon) {
		this.maSachMuon = maSachMuon;
	}
	public int getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(int tienCoc) {
		this.tienCoc = tienCoc;
	}

	
	
	

}
