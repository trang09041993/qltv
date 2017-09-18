package model;

public class NhanVien {
	private int maNV;
	private String tenDangNhap;
	private String tenDayDu;
	private String matKhau;
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getTenDayDu() {
		return tenDayDu;
	}
	public void setTenDayDu(String tenDayDu) {
		this.tenDayDu = tenDayDu;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(int maNV, String tenDangNhap, String tenDayDu, String matKhau, String chucVu) {
		super();
		this.maNV = maNV;
		this.tenDangNhap = tenDangNhap;
		this.tenDayDu = tenDayDu;
		this.matKhau = matKhau;
		this.chucVu = chucVu;
	}
	public NhanVien(String tenDangNhap, String matKhau) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	private String chucVu;
	
	
}
