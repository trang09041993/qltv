package connect;

import java.io.File;


import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Sach;

public class ImportExcel extends Sach{
	public ImportExcel(){
		
	}
	
	public Date DateDemo(String dateStr) {
			java.util.Date date=new java.util.Date();
			Date date1=new Date(0);
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            date = formatter.parse(dateStr);
	            date1=new Date(date.getTime());
	            
	           // System.out.println(formatter.format(date));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return date1;
	 
		}
	
	public void readFileSach(String excelPath)throws WriteException {
		MyConnect my=new MyConnect();
		//FileInputStream input=new FileInputStream(excelPath);
		File input=new File(excelPath);
		try {
			
			Workbook workbook=Workbook.getWorkbook(input);
			Sheet sheet=workbook.getSheet(0);
			int rows=sheet.getRows();
			for(int i=1;i<rows;i++){
				String nameS=sheet.getCell(0,i).getContents();
				String tacG=sheet.getCell(1,i).getContents();
				String nhaXB=sheet.getCell(2,i).getContents();
				String ngonN=sheet.getCell(3,i).getContents();
				String loaiS=sheet.getCell(4,i).getContents();
				String ngayN=sheet.getCell(5,i).getContents();
				Date date=DateDemo(ngayN);
			//	System.out.println(ngayN+date);
			//	Date date= new SimpleDateFormat(ngayN);
				int soT=Integer.parseInt(sheet.getCell(6,i).getContents());
				int soTien=Integer.parseInt(sheet.getCell(7,i).getContents());
				int soLu=Integer.parseInt(sheet.getCell(8,i).getContents());
				String sql = "insert into  sach(tensach,tacgia,nhaxuatban,ngonngu,theloaisach,ngaynhap,sotrang,giatien,soluong,soluongCON)"
						+ " value('"+nameS+"','"+tacG+"','"+nhaXB+"','"+ngonN+"','"+loaiS+"','"+date+"','"+soT+"','"+soTien+"','"+soLu+"','"+soLu+"')";
				try {
					my.ps=my.con.prepareStatement(sql);
					my.ps.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			my.con.commit();
			my.disConnect();
		workbook.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readFileDG(String excelPath)throws WriteException {
		MyConnect my=new MyConnect();
		File input=new File(excelPath);
		try {
			
			Workbook workbook=Workbook.getWorkbook(input);
			Sheet sheet=workbook.getSheet(0);
			int rows=sheet.getRows();
			for(int i=1;i<rows;i++){
				String name=sheet.getCell(0,i).getContents();
				String namSinh=sheet.getCell(1,i).getContents();
				String diaChi=sheet.getCell(2,i).getContents();
				String soDT=sheet.getCell(3,i).getContents();
				String soCMT=sheet.getCell(4,i).getContents();
				String hanThe=sheet.getCell(5,i).getContents();
				Date date=DateDemo(hanThe);
				String sql = "insert into  docgia(tendocgia,namsinh,diachi,sodienthoai,cmt,hanthe)"
						+ " value('"+name+"','"+namSinh+"','"+diaChi+"','"+soDT+"','"+soCMT+"','"+date+"')";
				try {
					my.ps=my.con.prepareStatement(sql);
					my.ps.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			my.con.commit();
			my.disConnect();
		workbook.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
