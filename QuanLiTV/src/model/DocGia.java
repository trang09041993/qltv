package model;

import java.sql.Date;

public class DocGia {
	private int idDocGia;
	private String tenDocGia;
	private String diaChiDG;
	private String dienThoaiDG;
	private String soCMT;
	private Date namSinh;
	private Date hanThe;
	
	public DocGia(int idDocGia, String tenDocGia, String diaChiDG, String dienThoaiDG, String soCMT, Date namSinh,
			Date hanThe) {
		super();
		this.idDocGia = idDocGia;
		this.tenDocGia = tenDocGia;
		this.diaChiDG = diaChiDG;
		this.dienThoaiDG = dienThoaiDG;
		this.soCMT = soCMT;
		this.namSinh = namSinh;
		this.hanThe = hanThe;
	}
	public Date getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}
	public Date getHanThe() {
		return hanThe;
	}
	public void setHanThe(Date hanThe) {
		this.hanThe = hanThe;
	}
	public int getIdDocGia() {
		return idDocGia;
	}
	public DocGia() {
		super();
	}
	public void setIdDocGia(int idDocGia) {
		this.idDocGia = idDocGia;
	}
	public String getTenDocGia() {
		return tenDocGia;
	}
	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
	}
	public String getDiaChiDG() {
		return diaChiDG;
	}
	public void setDiaChiDG(String diaChiDG) {
		this.diaChiDG = diaChiDG;
	}
	public String getDienThoaiDG() {
		return dienThoaiDG;
	}
	public void setDienThoaiDG(String dienThoaiDG) {
		this.dienThoaiDG = dienThoaiDG;
	}
	public String getSoCMT() {
		return soCMT;
	}
	public void setSoCMT(String soCMT) {
		this.soCMT = soCMT;
	}

}
