package connect;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;



import model.PhieuMuon;



public class PhieuMuonConnect {
	
	public static int luuPhieu(PhieuMuon p){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="insert into bangmuontra(maphieumuon,madocgia,soluongmuon,soluongTra,ngaymuon,ngayhentra,tiencoc) value(?,?,?,?,?,?,?)";
		
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,p.getMaPhieuMuon());
			my.ps.setInt(2,p.getMaDocGia());
			my.ps.setInt(3, p.getSoLuong());
			my.ps.setInt(4,p.getSoTra());
			my.ps.setDate(5, p.getNgayMuon());
			my.ps.setDate(6, p.getNgayHenTra());
			my.ps.setInt(7, p.getTienCoc());
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("them phieu ok");
			}
			else{
				System.out.println("loi them phieu!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		my.disConnect();	
		return stt;
	}
	
	public static int timMaPM(int maDG,Date ngaymuon){
		int maphieu=0;
		String sql6="SELECT maphieumuon FROM bangmuontra WHERE madocgia=? and ngaymuon=?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql6);
			my.ps.setInt(1,maDG);
			my.ps.setDate(2,ngaymuon);
			ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				maphieu=rs.getInt(1);
				System.out.println("tim ma phieu ok");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim ma phieu theo ten phieu loi");
		}
		my.disConnect();
		return maphieu;
	}
	
	public static int luuPhieuCT(PhieuMuon p){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="insert into bangmuontra_chitiet(maphieumuon,masach,ngaytra,tinhtrang) value(?,?,?,?)";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1, p.getMaPhieuMuon());
			my.ps.setInt(2, p.getMaSachMuon());
			my.ps.setDate(3, p.getNgayTra());
			my.ps.setString(4,p.getTinhTrang());
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("them phieu vao bang chi tiet ok");
			}
			else{
				System.out.println("loi them phieu !");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("loi them phieu chi tiet!");
		}
		my.disConnect();	
		return stt;
	}
	
	public static ArrayList<PhieuMuon> timPhieu(int maDG){
		
		ArrayList<PhieuMuon> listPhieu=new ArrayList<PhieuMuon>();
		String sql6="SELECT * FROM bangmuontra inner join bangmuontra_chitiet on bangmuontra.maphieumuon=bangmuontra_chitiet.maphieumuon where bangmuontra.madocgia =?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql6);
			my.ps.setInt(1,maDG);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				PhieuMuon p=new PhieuMuon();
				p.setMaPhieuMuon(rs.getInt(1));
				p.setMaDocGia(rs.getInt(2));
				p.setSoLuong(rs.getInt(3));
				p.setSoTra(rs.getInt(4));
				p.setNgayMuon(rs.getDate(5));
				p.setNgayHenTra(rs.getDate(6));
				p.setTienCoc(rs.getInt(7));
				p.setMaSachMuon(rs.getInt(9));
				p.setTinhTrang(rs.getString(11));
				listPhieu.add(p);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim sach theo ten phieu loi");
		}
		my.disConnect();
		return listPhieu;
	}
	
	
	
	public static Date timNgayMuon(String text){
		Date day=null;
		String sql6="SELECT ngaymuon FROM bangmuontra_chitiet WHERE masach =?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql6);
			my.ps.setString(1,text);
			ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				day=rs.getDate(1);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim ngay theo ten phieu loi");
		}
		my.disConnect();
		return day;
	}
	
	public static int timTienCoc(int idDG){
		int tiencoc=0;
		String sql6="Select madocgia,sum(tiencoc) from bangmuontra group by madocgia having madocgia=?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql6);
			my.ps.setInt(1,idDG);
			ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				tiencoc=rs.getInt(2);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim tien coc theo ten phieu loi");
		}
		my.disConnect();
		return tiencoc;
	}
	
	public static int updateTinhTrangSach(String tinhtr,int masach,int maphieu){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE bangmuontra_chitiet SET tinhtrang=? WHERE maphieumuon=? and masach=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1,tinhtr);
			my.ps.setInt(2,maphieu);
			my.ps.setInt(3,masach);
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("update tinhtrang sach ok");
			}
			else{
				System.out.println("loi tinhtrang!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
	
}
