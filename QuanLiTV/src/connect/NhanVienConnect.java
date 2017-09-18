package connect;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhanVien;


public class NhanVienConnect extends MyConnect{

	public static int luuNV(NhanVien nv){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql = "insert into thongtintaikhoan(TaiKhoan,MatKhau,manhanvien,tendaydu,chucvu) value(?,?,?,?,?)";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1,nv.getTenDangNhap());
			my.ps.setString(2,nv.getMatKhau());
			my.ps.setInt(3,nv.getMaNV());
			my.ps.setString(4,nv.getTenDayDu());
			my.ps.setString(5,nv.getChucVu());
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("them NV ok");
			}
			else{
				System.out.println("loi!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
	
	public static ArrayList<NhanVien> loadNV(){
		ArrayList<NhanVien> listNV=new ArrayList<NhanVien>();
		MyConnect my=new MyConnect();
		String sql="SELECT * FROM thongtintaikhoan";
		try{
			my.ps=my.con.prepareStatement(sql);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				NhanVien n=new NhanVien();
				n.setTenDangNhap(rs.getString(1));
				n.setMatKhau(rs.getString(2));
				n.setMaNV(rs.getInt(3));
				n.setTenDayDu(rs.getString(4));
				n.setChucVu(rs.getString(5));
				listNV.add(n);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("load NV loi");
		}
		my.disConnect();
		return listNV;
	}
	
	public static int suaNV(NhanVien nv,int k){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE thongtintaikhoan SET TaiKhoan=?,MatKhau=?,tendaydu=?,chucvu=? WHERE manhanvien=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1,nv.getTenDangNhap());
			my.ps.setString(2,nv.getMatKhau());
			my.ps.setString(3,nv.getTenDayDu());
			my.ps.setString(4,nv.getChucVu());
			my.ps.setInt(5,k+1);
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("update thong tin ok");
			}
			else{
				System.out.println("loi!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stt;
	}
	
	public static int tuSuaNV(NhanVien nv,int k){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE thongtintaikhoan SET TaiKhoan=?,MatKhau=? WHERE manhanvien=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1,nv.getTenDangNhap());
			my.ps.setString(2,nv.getMatKhau());
			my.ps.setInt(3,k);
			stt=my.ps.executeUpdate();
			if(stt==1){
				System.out.println("update auto  ok");
			}
			else{
				System.out.println("loi update!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stt;
	}
	

	public static int xoaNV(int id){
		int stt=0;
		String sql="DELETE FROM thongtintaikhoan WHERE manhanvien=?";
		MyConnect my=new MyConnect();
		try{
		my.ps=my.con.prepareStatement(sql);
		my.ps.setInt(1, id);
		stt=my.ps.executeUpdate();
		if(stt>0){
			System.out.println("Xoa NV ok");
		}
		else{
			System.out.println("loi!");
		}
		my.con.close();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stt;
	}

}
