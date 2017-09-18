package connect;


import java.sql.ResultSet;



import model.PhieuPhat;

public class BangPhatConnect {

	
	public static int luuPhat(PhieuPhat p){
		MyConnect my=new MyConnect();
		int stt=0;
		String sql="insert into bangphat(maphieumuon,masach,songaytre,lydophat,sotienphat) value(?,?,?,?,?)";
		try{
			my.ps=my.con.prepareStatement(sql);
			my.ps.setInt(1,p.getMaPhieuMuon());
			my.ps.setInt(2, p.getMaSach());
			my.ps.setInt(3, p.getSoNgayTre());
			my.ps.setString(4,p.getLyDoPhat() );
			my.ps.setInt(5, p.getSoTienPhat());
			stt=my.ps.executeUpdate();
			if(stt>0){
				System.out.println("them phieu phat ok");
			}
			else{
				System.out.println("loi them phieu phat!");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		my.disConnect();	
		return stt;
	}
	
	public static PhieuPhat timPhieu(int maPhieu,int maSach){
		
		
		String sql6="SELECT * FROM bangphat WHERE maphieumuon =? and masach=?";
		MyConnect my=new MyConnect();
		PhieuPhat p=new PhieuPhat();
		try{
			my.ps=my.con.prepareStatement(sql6);
			my.ps.setInt(1,maPhieu);
			my.ps.setInt(2, maSach);
			ResultSet rs=my.ps.executeQuery();
			if(rs.next()){
				p.setMaPhieuMuon(rs.getInt(1));
				p.setMaSach(rs.getInt(2));
				p.setSoNgayTre(rs.getInt(3));
				p.setLyDoPhat(rs.getString(4));
				p.setSoTienPhat(rs.getInt(5));
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("tim phieuphat theo ten phieu loi");
		}
		my.disConnect();
		return p;
	}
}
