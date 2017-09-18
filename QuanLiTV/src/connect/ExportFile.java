package connect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import model.PhieuMuon;



public class ExportFile {
	public ExportFile() {
    }

    public void printTable(JTable table, File file) throws WriteException {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("First Sheet", 0);
            TableModel model = table.getModel();

            for (int i = 0; i < model.getColumnCount(); i++) {
                Label col = new Label(i, 0, model.getColumnName(i) + "\t");
                sheet.addCell(col);
            }
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                	if(model.getValueAt(i, j)==null){
               		 Label row = new Label(j, i + 1,"" + "\t");
                        sheet.addCell(row);
               	}
               
                	else{
                    Label row = new Label(j, i + 1, model.getValueAt(i, j).toString() + "\t");
                    sheet.addCell(row);
                    }
                	
                }
            }
            workbook.write();
            workbook.close();
        } catch (IOException e) {
        }
    }
    
    public static void ExportPhieu(PhieuMuon p, String ten) throws Exception {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("C:/Users/"+System.getProperty("user.name")+"/Desktop"));
        int save = chooser.showSaveDialog(null);
        if (save == JFileChooser.APPROVE_OPTION) 
        {
        	
			XWPFDocument d=new XWPFDocument();
        	File f=new File(chooser.getSelectedFile() + ".docx");
        	FileOutputStream out=new FileOutputStream(f);
        	
        	XWPFParagraph p1=d.createParagraph();
        	XWPFRun r1=p1.createRun();
        	r1.setText("PHIẾU MƯỢN SÁCH");
        	p1.setAlignment(ParagraphAlignment.CENTER);
        	r1.setFontSize(16);
        	r1.setBold(true);
        	
        	XWPFParagraph p2=d.createParagraph();
        	XWPFRun r2=p2.createRun();
        	r2.setText("MÃ PHIẾU:");
         	r2.addBreak();
        	r2.setText("TÊN ĐỘC GIẢ:");
         	r2.addBreak();
        	r2.setText("NGÀY MƯỢN:");
         	r2.addBreak();
        	r2.setText("NGÀY HẸN TRẢ:");
         	r2.addBreak();
        	r2.setText("TIỀN ĐẶT CỌC:");
         	r2.addBreak();
         	r2.setFontSize(16);
         	r2.setBold(true);
        	
         	
         	XWPFTable t=d.createTable();
         	t.setColBandSize(50);
         	t.setRowBandSize(30);
         	XWPFTableRow tr=t.getRow(0);
         	tr.getCell(0).setText("STT");
         	tr.addNewTableCell().setText("Mã sách");
         	tr.addNewTableCell().setText("Tên sách");
         	
         	for(int i=0;i<=5;i++){
         		XWPFTableRow tro=t.createRow();
         		tro.getCell(0).setText("111111111111111111111111");
         		tro.getCell(1).setText("2222222222");
         		tro.getCell(2).setText("33333");
         	}
         	
         	
         	
        	
        	XWPFParagraph p3=d.createParagraph();
        	XWPFRun r3=p3.createRun();
        	r3.setText("Hà Nội,   Ngày         "+"Tháng          "+"Năm           ");
         	r3.addBreak();
        	r3.setText("Độc giả kí               ");
        	r3.setText("                                                       ");
        	r3.setText("Thủ thư kí          ");
        	r3.setItalic(true);
        	p3.setAlignment(ParagraphAlignment.RIGHT);
        	
        	d.write(out);
        	out.close();
        	d.close();
	}
	}
}
