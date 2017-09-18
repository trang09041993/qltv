package connect;

import java.sql.ResultSet;
import java.util.ArrayList;


import model.DocGia;
import model.PhieuMuon;
import model.Sach;
import model.thongke;

public class ThongKe {
	public static ArrayList<Sach> thongKeToanSach(){
		ArrayList<Sach> listSach=new ArrayList<Sach>();
		String sql="SELECT `masach`,`tensach`,`tacgia`,`soluong` FROM `sach`";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				Sach s=new Sach();
				s.setIdSach(rs.getInt(1));
				s.setTenSach(rs.getString(2));
				s.setTacGia(rs.getString(3));
				s.setSoLuong(rs.getInt(4));
				listSach.add(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach theo ten loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<Sach> thongKeToanSachTheo(int k){
		ArrayList<Sach> listSach=new ArrayList<Sach>();
		String sql1="SELECT `tacgia`,sum(`soluong`) FROM `sach` group by `tacgia`";
		String sql2="SELECT `nhaxuatban`,sum(`soluong`) FROM `sach` group by `nhaxuatban`";
		String sql3="SELECT `theloaisach`,sum(`soluong`) FROM `sach` group by `theloaisach`";
		MyConnect my=new MyConnect();
		try{
			if(k==1) my.ps=my.con.prepareStatement(sql1);
			if(k==2) my.ps=my.con.prepareStatement(sql2);
			if(k==3) my.ps=my.con.prepareStatement(sql3);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				Sach s=new Sach();
				s.setTenSach(rs.getString(1));
				s.setSoLuong(rs.getInt(2));
				listSach.add(s);
			}
			System.out.println("thongke sach theo cac chung năng ok");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach theo cac chung năng ten loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<Sach> thongKeToanSachTheoNam(int year){
		ArrayList<Sach> listSach=new ArrayList<Sach>();
		String sql="SELECT `masach`,`tensach`,`tacgia`,`soluong` FROM `sach` WHERE year(`ngaynhap`)=?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1, year);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				Sach s=new Sach();
				s.setIdSach(rs.getInt(1));
				s.setTenSach(rs.getString(2));
				s.setTacGia(rs.getString(3));
				s.setSoLuong(rs.getInt(4));
				listSach.add(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach theo nam loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<Sach> thongKeSachDM(){
		ArrayList<Sach> listSach=new ArrayList<Sach>();
		String sql="SELECT `masach`,`tensach`,`tacgia` FROM `sach` WHERE `soluong`>`soluongCON`";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				Sach s=new Sach();
				s.setIdSach(rs.getInt(1));
				s.setTenSach(rs.getString(2));
				s.setTacGia(rs.getString(3));
				listSach.add(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach dang muon  loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<PhieuMuon> thongKeSachDMTheoNgay(java.sql.Date date1, java.sql.Date date2){
		ArrayList<PhieuMuon> listSach=new ArrayList<PhieuMuon>();
		String sql="SELECT bangmuontra.`maphieumuon`,bangmuontra.`madocgia`,bangmuontra_chitiet.`masach`,sach.`tensach`,bangmuontra.`ngaymuon`,bangmuontra_chitiet.`tinhtrang` FROM bangmuontra,bangmuontra_chitiet,sach WHERE bangmuontra.`maphieumuon` = bangmuontra_chitiet.`maphieumuon` and sach.`masach`= bangmuontra_chitiet.`masach` and bangmuontra_chitiet.tinhtrang=? and ( bangmuontra.`ngaymuon`between ? and ?)";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1,"Đang mượn");
			my.ps.setDate(2, date1);
			my.ps.setDate(3, date2);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				PhieuMuon p=new PhieuMuon();
				p.setMaPhieuMuon(rs.getInt(1));
				p.setMaDocGia(rs.getInt(2));
				p.setIdSach(rs.getInt(3));
				p.setTenSach(rs.getString(4));
				p.setNgayMuon(rs.getDate(5));
				p.setTinhTrang(rs.getString(6));
				listSach.add(p);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach dang muon theo date  loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<PhieuMuon> thongKeSachDMTheoThang(int month){
		ArrayList<PhieuMuon> listSach=new ArrayList<PhieuMuon>();
		String sql="SELECT bangmuontra.`maphieumuon`,bangmuontra.`madocgia`,bangmuontra_chitiet.`masach`,sach.`tensach`,bangmuontra.`ngaymuon`,bangmuontra_chitiet.`tinhtrang` FROM bangmuontra,bangmuontra_chitiet,sach WHERE bangmuontra.`maphieumuon` = bangmuontra_chitiet.`maphieumuon` and sach.`masach`= bangmuontra_chitiet.`masach` and month( bangmuontra.`ngaymuon`)=?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,month);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				PhieuMuon p=new PhieuMuon();
				p.setMaPhieuMuon(rs.getInt(1));
				p.setMaDocGia(rs.getInt(2));
				p.setIdSach(rs.getInt(3));
				p.setTenSach(rs.getString(4));
				p.setNgayMuon(rs.getDate(5));
				p.setTinhTrang(rs.getString(6));
				listSach.add(p);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach dang muon theo date  loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<PhieuMuon> thongKeSachMat(){
		ArrayList<PhieuMuon> listSach=new ArrayList<PhieuMuon>();
		String sql="select bangmuontra_chitiet.`maphieumuon`,bangmuontra.`madocgia`,bangmuontra_chitiet.`masach`,sach.`tensach`,sach.`tacgia` from bangmuontra, bangmuontra_chitiet,sach where bangmuontra.`maphieumuon`=bangmuontra_chitiet.`maphieumuon` and bangmuontra_chitiet.`masach`=sach.`masach` and bangmuontra_chitiet.`tinhtrang`='Mất sách'";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				PhieuMuon s=new PhieuMuon();
				s.setMaPhieuMuon(rs.getInt(1));
				s.setMaDocGia(rs.getInt(2));
				s.setIdSach(rs.getInt(3));
				s.setTenSach(rs.getString(4));
				s.setTacGia(rs.getString(5));
				listSach.add(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach dang muon  loi");
		}
		my.disConnect();
		return listSach;
	}
	

	public static ArrayList<PhieuMuon> thongKeSachMatTheoThang(int month){
		ArrayList<PhieuMuon> listSach=new ArrayList<PhieuMuon>();
		String sql="select bangmuontra_chitiet.`maphieumuon`,bangmuontra.`madocgia`,bangmuontra_chitiet.`masach`,sach.`tensach`,sach.`tacgia` from bangmuontra, bangmuontra_chitiet,sach where bangmuontra.`maphieumuon`=bangmuontra_chitiet.`maphieumuon` and bangmuontra_chitiet.`masach`=sach.`masach` and bangmuontra_chitiet.`tinhtrang`='Mất sách' and month(bangmuontra_chitiet.`ngaytra`)=?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1, month);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				PhieuMuon s=new PhieuMuon();
				s.setMaPhieuMuon(rs.getInt(1));
				s.setMaDocGia(rs.getInt(2));
				s.setIdSach(rs.getInt(3));
				s.setTenSach(rs.getString(2));
				s.setTacGia(rs.getString(3));
				listSach.add(s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thongke sach dang muon  loi");
		}
		my.disConnect();
		return listSach;
	}
	
	public static ArrayList<DocGia> thongKeDG(){
		
		ArrayList<DocGia> listDG=new ArrayList<DocGia>();
		String sql1="SELECT * FROM docgia";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql1);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				DocGia d= new DocGia();
				d.setIdDocGia(rs.getInt(1));
				d.setTenDocGia(rs.getString(2));
				d.setNamSinh(rs.getDate(3));
				d.setDiaChiDG(rs.getString(4));
				d.setDienThoaiDG(rs.getString(5));
				d.setSoCMT(rs.getString(6));
				d.setHanThe(rs.getDate(7));
				listDG.add(d);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke DG theo ten loi");
		}
		my.disConnect();
		return listDG;
	}
	
	public static ArrayList<DocGia> thongKeDGQuaHan(){
		
		ArrayList<DocGia> listDG=new ArrayList<DocGia>();
		String sql1="SELECT * FROM `docgia` WHERE `hanthe`< now()";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql1);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				DocGia d= new DocGia();
				d.setIdDocGia(rs.getInt(1));
				d.setTenDocGia(rs.getString(2));
				d.setNamSinh(rs.getDate(3));
				d.setDiaChiDG(rs.getString(4));
				d.setDienThoaiDG(rs.getString(5));
				d.setSoCMT(rs.getString(6));
				d.setHanThe(rs.getDate(7));
				listDG.add(d);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke DG theo qua han loi");
		}
		my.disConnect();
		return listDG;
	}
	
	public static ArrayList<DocGia> thongKeDGDangMuon(){
		
		ArrayList<DocGia> listDG=new ArrayList<DocGia>();
		String sql1="select distinct docgia.`madocgia`, docgia.`tendocgia`, docgia.`namsinh`, docgia.`sodienthoai`, docgia.`cmt`,docgia.`hanthe`,docgia.`diachi` from docgia,bangmuontra where docgia.`madocgia`=bangmuontra.`madocgia`and bangmuontra.`soluongmuon` > bangmuontra.`soluongTra`";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql1);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				DocGia d= new DocGia();
				d.setIdDocGia(rs.getInt(1));
				d.setTenDocGia(rs.getString(2));
				d.setNamSinh(rs.getDate(3));
				d.setDienThoaiDG(rs.getString(4));
				d.setSoCMT(rs.getString(5));
				d.setHanThe(rs.getDate(6));
				d.setDiaChiDG(rs.getString(7));
				listDG.add(d);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke DG dang muon loi");
		}
		my.disConnect();
		return listDG;
	}
	
	public static ArrayList<thongke> thongketheoNgay(java.sql.Date d1, java.sql.Date d2){
		ArrayList<thongke> list=new ArrayList<thongke>();
		String sql="select bangmuontra.`ngaymuon`,count(bangmuontra.`ngaymuon`),sum(bangmuontra.`soluongmuon`),sum(bangmuontra.`soluongTra`),sum(bangmuontra.`tiencoc`),sum(bangphat.`sotienphat`) from bangmuontra left join bangphat on bangmuontra.`maphieumuon`=bangphat.`maphieumuon` where (bangmuontra.`ngaymuon` between ? and ?) group by bangmuontra.`ngaymuon`";
		
		MyConnect my=new MyConnect();
	
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setDate(1, d1);
			my.ps.setDate(2, d2);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				thongke k=new thongke();
				k.setNgay(rs.getDate(1));
				k.setSoLM(rs.getInt(2));
				k.setSoSM(rs.getInt(3));
				k.setSoST(rs.getInt(4));
				k.setTienCoc(rs.getInt(5));
				k.setTienPhat(rs.getInt(6));
				list.add(k);
			}
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke sach dang muon loi");
		}
		my.disConnect();
		
		return list;
	}
	
	public static ArrayList<thongke> thongketheothang(int month){
		ArrayList<thongke> list=new ArrayList<thongke>();
		String sql="select bangmuontra.`ngaymuon`,count(bangmuontra.`ngaymuon`),sum(bangmuontra.`soluongmuon`),sum(bangmuontra.`soluongTra`),sum(bangmuontra.`tiencoc`),sum(bangphat.`sotienphat`) from bangmuontra left join bangphat on bangmuontra.`maphieumuon`=bangphat.`maphieumuon` where month(bangmuontra.`ngaymuon`)=? group by bangmuontra.`ngaymuon`";
		
		MyConnect my=new MyConnect();
	
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,month);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				thongke k=new thongke();
				k.setNgay(rs.getDate(1));
				k.setSoLM(rs.getInt(2));
				k.setSoSM(rs.getInt(3));
				k.setSoST(rs.getInt(4));
				k.setTienCoc(rs.getInt(5));
				k.setTienPhat(rs.getInt(6));
				list.add(k);
			}
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke sach dang muon loi");
		}
		my.disConnect();
		
		return list;
	}
	
	public static ArrayList<thongke> thongketheoNam(int year){
		ArrayList<thongke> list=new ArrayList<thongke>();
		String sql="select month(bangmuontra.`ngaymuon`),count(bangmuontra.`ngaymuon`),sum(bangmuontra.`soluongmuon`),sum(bangmuontra.`soluongTra`),sum(bangmuontra.`tiencoc`),sum(bangphat.`sotienphat`) from bangmuontra left join bangphat on bangmuontra.`maphieumuon`=bangphat.`maphieumuon` where year(bangmuontra.`ngaymuon`)=? group by month(bangmuontra.`ngaymuon`)";
		
		MyConnect my=new MyConnect();
	
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,year);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				thongke k=new thongke();
				k.setThang(rs.getInt(1));
				k.setSoLM(rs.getInt(2));
				k.setSoSM(rs.getInt(3));
				k.setSoST(rs.getInt(4));
				k.setTienCoc(rs.getInt(5));
				k.setTienPhat(rs.getInt(6));
				list.add(k);
			}
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke sach dang muon loi");
		}
		my.disConnect();
		
		return list;
	}
		
	public static ArrayList<thongke> thongketheoCTthang(int month){
		ArrayList<thongke> list=new ArrayList<thongke>();
		String sql="select docgia.`madocgia`,docgia.`tendocgia`,count(month(bangmuontra.`ngaymuon`)),sum(bangmuontra.`soluongmuon`),sum(bangmuontra.`soluongTra`)from docgia left join bangmuontra on bangmuontra.`madocgia`=docgia.`madocgia` where month(bangmuontra.`ngaymuon`)=? group by bangmuontra.`madocgia`";
		MyConnect my=new MyConnect();
	
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,month);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				thongke k=new thongke();
				k.setTienCoc(rs.getInt(1));
				k.setTen(rs.getString(2));
				k.setSoLM(rs.getInt(3));
				k.setSoSM(rs.getInt(4));
				k.setSoST(rs.getInt(5));
				
				list.add(k);
			}
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke sach dang muon loi");
		}
		my.disConnect();
		
		return list;
	}
	
	public static ArrayList<thongke> thongketheoCTnam(int year){
		ArrayList<thongke> list=new ArrayList<thongke>();
		String sql="select docgia.`madocgia`,docgia.`tendocgia`,count(month(bangmuontra.`ngaymuon`)),sum(bangmuontra.`soluongmuon`),sum(bangmuontra.`soluongTra`)from docgia left join bangmuontra on bangmuontra.`madocgia`=docgia.`madocgia` where year(bangmuontra.`ngaymuon`)=? group by bangmuontra.`madocgia`";
		MyConnect my=new MyConnect();
	
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,year);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				thongke k=new thongke();
				k.setTienCoc(rs.getInt(1));
				k.setTen(rs.getString(2));
				k.setSoLM(rs.getInt(3));
				k.setSoSM(rs.getInt(4));
				k.setSoST(rs.getInt(5));
				
				list.add(k);
			}
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke sach dang muon loi");
		}
		my.disConnect();
		
		return list;
	}
	
	public static ArrayList<thongke> thongketheoCTSthang(int month){
		ArrayList<thongke> list=new ArrayList<thongke>();
		String sql="select sach.`masach`, sach.`tensach`, count(bangmuontra_chitiet.`masach`) from sach ,bangmuontra_chitiet , bangmuontra where sach.`masach`=bangmuontra_chitiet.`masach` and bangmuontra.`maphieumuon`=bangmuontra_chitiet.`maphieumuon` and month(bangmuontra.`ngaymuon`)=? group by bangmuontra_chitiet.`masach`";
		MyConnect my=new MyConnect();
	
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,month);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				thongke k=new thongke();
				k.setTienCoc(rs.getInt(1));
				k.setTen(rs.getString(2));
				k.setSoLM(rs.getInt(3));
				
				
				list.add(k);
			}
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke sach dang muon loi");
		}
		my.disConnect();
		
		return list;
	}
	
	public static ArrayList<thongke> thongketheoCTSnam(int month,int year){
		ArrayList<thongke> list=new ArrayList<thongke>();
		String sql="select sach.`masach`, count(bangmuontra_chitiet.`masach`) from sach ,bangmuontra_chitiet , bangmuontra where sach.`masach`=bangmuontra_chitiet.`masach` and bangmuontra.`maphieumuon`=bangmuontra_chitiet.`maphieumuon` and month(bangmuontra.`ngaymuon`)=? and year(bangmuontra.`ngaymuon`)=? group by bangmuontra_chitiet.`masach`";
		MyConnect my=new MyConnect();
	
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,month);
			my.ps.setInt(2,year);
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				thongke k=new thongke();
				k.setTienCoc(rs.getInt(1));
				k.setSoLM(rs.getInt(2));
				list.add(k);
			}
				
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("thong ke sach dang muon loi");
		}
		my.disConnect();
		
		return list;
	}
	
	
	
}
