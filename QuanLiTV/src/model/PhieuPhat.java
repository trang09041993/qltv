package model;



public class PhieuPhat {
	private int maPhieuMuon;
	private int maSach;
	private int soNgayTre;
	private String lyDoPhat;
	private int soTienPhat;
	public PhieuPhat() {
		super();
	}
	

	public int getMaPhieuMuon() {
		return maPhieuMuon;
	}


	public void setMaPhieuMuon(int maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}


	public int getMaSach() {
		return maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}
	
	
	public PhieuPhat(int maPhieuMuon, int maSach, int soNgayTre, String lyDoPhat, int soTienPhat) {
		super();
		this.maPhieuMuon = maPhieuMuon;
		this.maSach = maSach;
		this.soNgayTre = soNgayTre;
		this.lyDoPhat = lyDoPhat;
		this.soTienPhat = soTienPhat;
	}


	public int getSoNgayTre() {
		return soNgayTre;
	}
	public void setSoNgayTre(int soNgayTre) {
		this.soNgayTre = soNgayTre;
	}
	public String getLyDoPhat() {
		return lyDoPhat;
	}
	public void setLyDoPhat(String lyDoPhat) {
		this.lyDoPhat = lyDoPhat;
	}
	public int getSoTienPhat() {
		return soTienPhat;
	}
	public void setSoTienPhat(int soTienPhat) {
		this.soTienPhat = soTienPhat;
	}

}
