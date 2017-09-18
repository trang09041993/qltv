package connect;


import java.sql.ResultSet;
import java.util.ArrayList;

import model.DocGia;

public class DocGiaConnect extends MyConnect {
	
	public static int luuDG(DocGia d){
		//DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		MyConnect my=new MyConnect();
		int stt=0;
		String sql ="insert into docgia(tendocgia,namsinh,diachi,sodienthoai,cmt,hanthe) value(?,?,?,?,?,?)";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1,d.getTenDocGia());
			my.ps.setDate(2,d.getNamSinh());
			my.ps.setString(3,d.getDiaChiDG());
			my.ps.setString(4,d.getDienThoaiDG());
			my.ps.setString(5,d.getSoCMT());
			my.ps.setDate(6, d.getHanThe());
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("them DG ok");
			}
			else{
				System.out.println("loi them DG!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}

	public static int suaThongTinDG(DocGia d,int k){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="UPDATE docgia SET tendocgia=?,namsinh=?,diachi=?,sodienthoai=?,cmt=?,hanthe=? WHERE madocgia=?";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setString(1, d.getTenDocGia());
			my.ps.setDate(2,d.getNamSinh());
			my.ps.setString(3,d.getDiaChiDG());
			my.ps.setString(4,d.getDienThoaiDG());
			my.ps.setString(5,d.getSoCMT());
			my.ps.setDate(6, d.getHanThe());
			my.ps.setInt(7, k+1);
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("update DG ok");
			}
			else{
				System.out.println("update loi!");
			}
			my.con.close();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
	
	public static int xoaDG(int id){
		int stt=0;
		String sql="DELETE FROM docgia WHERE madocgia=?";
		MyConnect my=new MyConnect();
		try{
		my.ps=my.con.prepareStatement(sql);
		my.ps.setInt(1, id);
		stt=my.ps.executeUpdate();
		if(stt>0){
			System.out.println("Xoa DG ok");
		}
		else{
			System.out.println("loi xoa!");
		}
		my.con.close();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		my.disConnect();
		return stt;
	}
	
	public ArrayList<DocGia> timDG(String text, int k){
		
		ArrayList<DocGia> listDG=new ArrayList<DocGia>();
		String sql1="SELECT * FROM docgia WHERE madocgia like ?";
		String sql2="SELECT * FROM docgia WHERE tendocgia like ?";
		String sql3="SELECT * FROM docgia WHERE namsinh like ?";
		String sql4="SELECT * FROM docgia WHERE sodienthoai like ?";
		String sql5="SELECT * FROM docgia WHERE cmt like ?";
		MyConnect my=new MyConnect();
		try{
			if(k==1) my.ps=my.con.prepareStatement(sql1);
			if(k==2) my.ps=my.con.prepareStatement(sql2);
			if(k==3) my.ps=my.con.prepareStatement(sql3);
			if(k==4) my.ps=my.con.prepareStatement(sql4);
			if(k==5) my.ps=my.con.prepareStatement(sql5);
		
			my.ps.setString(1,"%"+text+"%");
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
			System.out.println("tim DG theo ten loi");
		}
		my.disConnect();
		return listDG;
	}
	
	public static String timTenDG(int id){
		String ten="";
		String sql="SELECT tendocgia FROM docgia WHERE madocgia=?";
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,id);
			ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				ten=rs.getString(1);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim DG theo ten loi");
		}
		my.disConnect();
		return ten;
		}
	
	public static ArrayList<DocGia> loadDG(){
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
			System.out.println("load DGloi");
		}
		my.disConnect();
		return listDG;
	}


}
