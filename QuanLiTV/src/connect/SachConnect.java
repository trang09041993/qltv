package connect;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;



import model.Sach;


public class SachConnect extends MyConnect{
	
	public static int luuSach(Sach s){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql = "insert into  sach(masach,tensach,tacgia,nhaxuatban,ngonngu,theloaisach,ngaynhap,sotrang,giatien,soluong,soluongCON) value(?,?,?,?,?,?,?,?,?,?,?)";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,0);
			my.ps.setString(2,s.getTenSach());
			my.ps.setString(3,s.getTacGia());
			my.ps.setString(4,s.getTenNXB());
			my.ps.setString(5,s.getNgonNgu());
			my.ps.setString(6,s.getLoaiSach());
			my.ps.setDate(7, s.getNgayNhap());
			my.ps.setInt(8,s.getSoTrang());
			my.ps.setInt(9,s.getGiaTien());
			my.ps.setInt(10,s.getSoLuong());
			my.ps.setInt(11,s.getSoLuong());
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("them sach ok");
			}
			else{
				System.out.println("loi them sach!");
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}

		public static int suaThongTinSach(Sach s,int idS){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE sach SET tensach=?,tacgia=?,nhaxuatban=?,ngonngu=?,theloaisach=?,ngaynhap=?,sotrang=?,giatien=?,soluong=?,soluongCON=? WHERE masach=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1,s.getTenSach());
			my.ps.setString(2,s.getTacGia());
			my.ps.setString(3,s.getTenNXB());
			my.ps.setString(4,s.getNgonNgu());
			my.ps.setString(5,s.getLoaiSach());
			my.ps.setDate(6, s.getNgayNhap());
			my.ps.setInt(7,s.getSoTrang());
			my.ps.setInt(8,s.getGiaTien());
			my.ps.setInt(9,s.getSoLuong());
			my.ps.setInt(10,s.getSoLuong());
			my.ps.setInt(11,idS);
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("update sach ok");
			}
			else{
				System.out.println("loi update sach!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
		
	public static int xoaSach(int id){
		int stt=0;
		String sql="DELETE FROM sach WHERE 	masach=?";
		MyConnect my=new MyConnect();
		try{
		my.ps=my.con.prepareStatement(sql);
		my.ps.setInt(1, id);
		stt=my.ps.executeUpdate();
		if(stt>0){
			System.out.println("Xoa sach ok");
		}
		else{
			System.out.println("loi xoa sach!");
		}
		my.con.close();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
	
	
	public static ArrayList<Sach> timSach(String text, int k){
		ArrayList<Sach> listSach=new ArrayList<Sach>();
		String sql1="SELECT * FROM sach WHERE tensach like ?";
		String sql2="SELECT * FROM sach WHERE tacgia like ?";
		String sql3="SELECT * FROM sach WHERE nhaxuatban like ?";
		String sql4="SELECT * FROM sach WHERE theloaisach like ?";
		String sql5="SELECT * FROM sach WHERE ngonngu like ?";
		String sql6="SELECT * FROM sach WHERE masach like ?";
		MyConnect my=new MyConnect();
		try{
			if(k==6){
				my.ps=my.con.prepareStatement(sql6);
				my.ps.setInt(1,Integer.parseInt(text));
			}
			else{
				if(k==1) my.ps=my.con.prepareStatement(sql1);
				if(k==2) my.ps=my.con.prepareStatement(sql2);
				if(k==3) my.ps=my.con.prepareStatement(sql3);
				if(k==4) my.ps=my.con.prepareStatement(sql4);
				if(k==5) my.ps=my.con.prepareStatement(sql5);
				my.ps.setString(1,"%"+text+"%");
			}
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				Sach s=new Sach();
				s.setIdSach(rs.getInt(1));
				s.setTenSach(rs.getString(2));
				s.setTacGia(rs.getString(3));
				s.setTenNXB(rs.getString(4));
				s.setNgonNgu(rs.getString(5));
				s.setLoaiSach(rs.getString(6));
				s.setSoTrang(rs.getInt(8));
				s.setGiaTien(rs.getInt(9));
				s.setSoLuongCon(rs.getInt(11));
				
				listSach.add(s);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim sach theo ten loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<Sach> loadSach(){
		ArrayList<Sach> listSach=new ArrayList<Sach>();
		String sql1="SELECT * FROM sach";	
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql1);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				Sach s=new Sach();
				s.setIdSach(rs.getInt(1));
				s.setTenSach(rs.getString(2));
				s.setTacGia(rs.getString(3));
				s.setTenNXB(rs.getString(4));
				s.setNgonNgu(rs.getString(5));
				s.setLoaiSach(rs.getString(6));
				s.setNgayNhap(rs.getDate(7));
				s.setSoTrang(rs.getInt(8));
				s.setGiaTien(rs.getInt(9));
				s.setSoLuong(rs.getInt(10));
				
				listSach.add(s);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("load sach theo ten loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static int soSachDM(int idDG){
		String sql="SELECT sum(soluongmuon),sum(soluongTra) FROM bangmuontra group by madocgia having madocgia=?";
		int sosach=0;
		int dangmuon=0;
		int datra=0;
		MyConnect my= new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,idDG);
			ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				dangmuon=rs.getInt(1);
				datra=rs.getInt(2);
				sosach=dangmuon-datra;
			}
			if(sosach<0) return 0;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return sosach;
	}
	
	public static String timTenSach(int text){
		String sql6="SELECT tensach FROM sach WHERE masach like ?";
		MyConnect my=new MyConnect();
		String tenSach=null;
		try{
			 my.ps=my.con.prepareStatement(sql6);
			 my.ps.setInt(1,text);
			 ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				tenSach=rs.getString(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim sach theo ten loi");
		}
		my.disConnect();
		return tenSach;
	}
	
	public static int timGiaSach(int text){
			String sql6="SELECT giatien FROM sach WHERE masach like ?";
			MyConnect my=new MyConnect();
			int giaTien=0;
			try{
				 my.ps=my.con.prepareStatement(sql6);
				 my.ps.setInt(1,text);
				 ResultSet rs=my.ps.executeQuery();
				if(rs.next()){
					giaTien=rs.getInt(1);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("tim sach theo ten loi");
			}
			my.disConnect();
			return giaTien;
		}
	
	
	public static int timSachConLai(int masach){
		String sql6="SELECT soluongCON FROM sach WHERE masach like ?";
		MyConnect my=new MyConnect();
		int sosachcon=0;
		try{
			 my.ps=my.con.prepareStatement(sql6);
			 my.ps.setInt(1,masach);
			 ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				sosachcon=rs.getInt(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim so sach theo ten loi");
		}
		my.disConnect();
		return sosachcon;
	}
	
	public static int timSachCo(int masach){
		String sql6="SELECT soluong FROM sach WHERE masach like ?";
		MyConnect my=new MyConnect();
		int sosachcon=0;
		try{
			 my.ps=my.con.prepareStatement(sql6);
			 my.ps.setInt(1,masach);
			 ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				sosachcon=rs.getInt(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim so sach theo ten loi");
		}
		my.disConnect();
		return sosachcon;
	}
	
	public static int timSachDMTheoSach(){
		String sql6="SELECT soluong,soluongCON FROM sach";
		MyConnect my=new MyConnect();
		int sosachcon=0;
		int sosachbd=0;
		int sosachdangmuon=0;
		try{
			 my.ps=my.con.prepareStatement(sql6);
			 ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				
				sosachbd=rs.getInt(1);
				sosachcon=rs.getInt(2);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim so sach theo ten loi");
		}
		sosachdangmuon=sosachbd-sosachcon;
		my.disConnect();
		return sosachdangmuon;
	}
		
	public static int timLuongSachDaTra(int stt){
				String sql6="SELECT soluongTra FROM bangmuontra WHERE 	maphieumuon=?";
				MyConnect my=new MyConnect();
				int luongsach=0;
				try{
					 my.ps=my.con.prepareStatement(sql6);
					 my.ps.setInt(1,stt);
					 ResultSet rs=my.ps.executeQuery();
					if(rs.next()){
						luongsach=rs.getInt(1);
					}
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("tim luong sach theo ten loi");
				}
				my.disConnect();
				return luongsach;
	}
	public static int updateLuongSachCon(int sosach, int ma){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE sach SET soluongCON=? WHERE masach=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,sosach);
			my.ps.setInt(2,ma);
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("update luong sach con ok");
			}
			else{
				System.out.println("loi update luong sach con !");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
	
		public static int updateLuongSach(int n, int ma){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE sach SET soluong=? WHERE masach=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,n);
			my.ps.setInt(2,ma);
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("update luong sach ok");
			}
			else{
				System.out.println("loi update luong sach!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
	
		public static int updateLuongSachTra(int sosach, int maphieu){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE bangmuontra SET soluongTra=? WHERE maphieumuon=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,sosach);
			my.ps.setInt(2,maphieu);
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("update luong sach tra  ok");
			}
			else{
				System.out.println("loi update luong sach tra!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
		
		public static int updateNgayTra(Date date,int maphieu, int masach){
			MyConnect my=new MyConnect();
			int stt=0;
			String sql="UPDATE `bangmuontra_chitiet` SET `ngaytra`=? WHERE `maphieumuon`=? and `masach`=?";
			try{
				my.ps=my.con.prepareStatement(sql);
				my.ps.setDate(1,date);
				my.ps.setInt(2,maphieu);
				my.ps.setInt(3,masach);
				stt=my.ps.executeUpdate();
				if(stt>0){
					System.out.println("update ngay tra  ok");
				}
				else{
					System.out.println("loi update ngay tra!");
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









