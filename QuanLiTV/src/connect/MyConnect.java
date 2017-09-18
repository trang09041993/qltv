package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyConnect {
	public Connection con;
	public PreparedStatement ps;
	//protected String DATABASE_LINK="jdbc:mysql://localhost/quanlitv?useUnicode=true&characterEncodeing=utf-8" ;
	protected String DATABASE_LINK="jdbc:mysql://localhost/quanlitv?"+"useUnicode=true&characterEncoding=UTF-8&autoReconnect=true?useUnicode=true&"+"characterEncoding=UTF-8&autoReconnect=true";
	public MyConnect()
	{
		try{
			con=DriverManager.getConnection(DATABASE_LINK,"root","");
			System.out.println("Kết nối thành công");
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Có lỗi xảy ra khi kết nối.Chi tiết");
			ex.printStackTrace();
		}
	}
	public void disConnect(){
		try{
			con.close();
			System.out.println("Ngắt kết nối thành công");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
// đây là kết nối vào mySql nhé