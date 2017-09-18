package model;

import java.sql.Date;

public class Sach extends PhieuPhat {
	private int idSach;
	private String tacGia;
	private String tenSach;
	private String tenNXB;
	private String ngonNgu;
	private String loaiSach;
	private Date ngayNhap;
	private int giaTien;
	private int soLuong;
	private int soTrang;
	private int soLuongCon;
	public Sach(int idSach, String tacGia, String tenSach, String tenNXB, String ngonNgu, String loaiSach,
			Date ngayNhap, int giaTien, int soLuong, int soTrang, int soLuongCon) {
		super();
		this.idSach = idSach;
		this.tacGia = tacGia;
		this.tenSach = tenSach;
		this.tenNXB = tenNXB;
		this.ngonNgu = ngonNgu;
		this.loaiSach = loaiSach;
		this.ngayNhap = ngayNhap;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
		this.soTrang = soTrang;
		this.soLuongCon = soLuongCon;
	}
	public int getSoLuongCon() {
		return soLuongCon;
	}
	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}
	public int getIdSach() {
		return idSach;
	}
	public void setIdSach(int idSach) {
		this.idSach = idSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTenNXB() {
		return tenNXB;
	}
	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public String getLoaiSach() {
		return loaiSach;
	}
	public void setLoaiSach(String loaiSach) {
		this.loaiSach = loaiSach;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public Sach() {
		super();
	}
	

}
