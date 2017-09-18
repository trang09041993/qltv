package ui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.DocGiaConnect;
import connect.ImportExcel;

import jxl.write.WriteException;
import model.DocGia;


import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class QuanLiDocGia{

	private JFrame frmPhnMmQun;
	private JTextField textTenDocGia;
	private JTextField textDienThoai;
	private JTextField textCMT;
	private JTextField textDiaChi;
	private JTable table;
	private JDateChooser dateNamSinh;
	private JDateChooser dateHanThe;
	private DefaultTableModel dtmTable;
	private JTextField textTimKiem;
	private JComboBox<String> comboxTimTrong = new JComboBox<String>();
	private JLabel lblTimKiem = new JLabel("Nhập vào thông tin tìm kiếm!");
	private ArrayList<DocGia> list=new ArrayList<DocGia>();
	private int index;
	
	public void run() {
				try {
					QuanLiDocGia window = new QuanLiDocGia();
					window.frmPhnMmQun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
		
	public Date dinhDangNgay(java.util.Date d){
		DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
		String s=df.format(d);
		java.util.Date d2=new java.util.Date();
		Date date=new Date(0);
		try{
			d2=df.parse(s);
			date=new Date(d2.getTime());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return date;
	}
	
	public void status(int soLuong,String textFiel){
		if(textFiel.length()==0){
			lblTimKiem.setText(" Hãy nhập vào thông tin tìm kiếm !");
		}
		if(textFiel.length()>0 && soLuong>0){
			lblTimKiem.setText("Tìm thấy "+soLuong+" sách cho " + "'"+textFiel+"'");
		}
		if(textFiel.length()>0&&soLuong==0){
			lblTimKiem.setText("Không tìm thấy "+"'"+textFiel+"'");
		}
	}
	public DocGia getDG(){
		int maDG=0;
		String tenDG=textTenDocGia.getText();
		Date namSinh=dinhDangNgay(dateNamSinh.getDate());
		String diaChi=textDiaChi.getText();
		String soDT=textDienThoai.getText();
		String soCMT=textCMT.getText();
		Date hanThe= dinhDangNgay(dateHanThe.getDate());
		DocGia d=new DocGia(maDG, tenDG, diaChi, soDT, soCMT, namSinh, hanThe);
		if(tenDG.equals("")||diaChi.equals("")||soDT.equals("")||soCMT.equals("")||namSinh.equals("")||hanThe.equals(""))
			return null;
		else return d;
	}
	
	public QuanLiDocGia() {
		initialize();
		loadDG();
	}
	
	private void loadDG(){
		list=DocGiaConnect.loadDG();
		dtmTable.setRowCount(0);
		for(DocGia dg:list){
			Vector<Object> vec=new Vector<Object>();
			vec.add(dg.getIdDocGia());
			vec.add(dg.getTenDocGia());
			vec.add(dg.getNamSinh());
			vec.add(dg.getDiaChiDG());
			vec.add(dg.getDienThoaiDG());
			vec.add(dg.getSoCMT());
			vec.add(dg.getHanThe());
			dtmTable.addRow(vec);
		}
	}

	private void initialize() {
		frmPhnMmQun = new JFrame();
		frmPhnMmQun.setTitle("Phần mềm quản lý thư viện-THPT Hồng Thái");
		frmPhnMmQun.setBounds(100, 100, 846, 550);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhnMmQun.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadDG();
			}
		});
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 846, 550);
		frmPhnMmQun.getContentPane().add(panel);
		
		JLabel lblQunLc = new JLabel("QUẢN LÝ ĐỘC GIẢ");
		lblQunLc.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLc.setForeground(new Color(255, 255, 204));
		lblQunLc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQunLc.setBounds(308, 21, 189, 24);
		panel.add(lblQunLc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(23, 56, 785, 211);
		panel.add(panel_1);
		
		JLabel lblTncGi = new JLabel("Tên độc giả");
		lblTncGi.setForeground(new Color(0, 51, 51));
		lblTncGi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTncGi.setBounds(425, 13, 76, 14);
		panel_1.add(lblTncGi);
		
		textTenDocGia = new JTextField();
		textTenDocGia.setColumns(10);
		textTenDocGia.setBounds(521, 9, 200, 23);
		panel_1.add(textTenDocGia);
		
		JLabel label_3 = new JLabel("Năm sinh");
		label_3.setForeground(new Color(0, 51, 0));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(425, 49, 68, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Địa chỉ");
		label_4.setForeground(new Color(0, 51, 0));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(425, 82, 52, 14);
		panel_1.add(label_4);
		
		JLabel lblinThoi = new JLabel("Điện thoại");
		lblinThoi.setForeground(new Color(0, 51, 51));
		lblinThoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblinThoi.setBounds(425, 118, 68, 14);
		panel_1.add(lblinThoi);
		
		JLabel lblCmt = new JLabel("CMT");
		lblCmt.setForeground(new Color(0, 51, 51));
		lblCmt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCmt.setBounds(425, 150, 68, 14);
		panel_1.add(lblCmt);
		
		JLabel label_7 = new JLabel("Hạn thẻ");
		label_7.setForeground(new Color(0, 51, 51));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(425, 186, 76, 14);
		panel_1.add(label_7);
		
		textDienThoai = new JTextField();
		textDienThoai.setColumns(10);
		textDienThoai.setBounds(522, 109, 170, 23);
		panel_1.add(textDienThoai);
		
		textCMT = new JTextField();
		textCMT.setColumns(10);
		textCMT.setBounds(522, 143, 170, 23);
		panel_1.add(textCMT);
		
		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(522, 77, 199, 23);
		panel_1.add(textDiaChi);
		
		dateNamSinh = new JDateChooser();
		dateNamSinh.setDateFormatString("yyyy-MM-dd");
		dateNamSinh.setBounds(522, 42, 122, 23);
		panel_1.add(dateNamSinh);
		
		dateHanThe = new JDateChooser();
		dateHanThe.setDateFormatString("yyyy-MM-dd");
		dateHanThe.setBounds(522, 177, 122, 23);
		panel_1.add(dateHanThe);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(new Color(204, 255, 204));
		panel_3.setBounds(0, 0, 381, 211);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("TÌM KIẾM ĐỘC GIẢ");
		label.setBounds(113, 5, 155, 20);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("Cụm từ tìm kiếm");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 43, 113, 20);
		panel_3.add(label_1);
		
		textTimKiem = new JTextField();
		/*textTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String search=textTimKiem.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(dtmTable);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
				
			}
		});*/
		textTimKiem.setColumns(10);
		textTimKiem.setBounds(123, 36, 242, 29);
		panel_3.add(textTimKiem);
		
		JLabel label_2 = new JLabel("Tìm trong");
		label_2.setBackground(new Color(0, 0, 0));
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 92, 75, 18);
		panel_3.add(label_2);
		
		
		comboxTimTrong.setModel(new DefaultComboBoxModel<String>(new String[] {"Mã độc giả", "Tên độc giả", "Năm sinh", "Số điện thoại", "Số CMT"}));
		comboxTimTrong.setBounds(123, 90, 120, 25);
		panel_3.add(comboxTimTrong);
		
		JLabel label_5 = new JLabel("Kết quả tìm kiếm");
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(3, 146, 120, 31);
		panel_3.add(label_5);
		
		
		lblTimKiem.setForeground(new Color(0, 0, 0));
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTimKiem.setBackground(Color.WHITE);
		lblTimKiem.setBounds(123, 151, 248, 20);
		panel_3.add(lblTimKiem);
		
		JButton btnCapNhatThongTin = new JButton("Sửa thông tin");
		btnCapNhatThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocGia d=getDG();
				if(d!=null){
					int i=DocGiaConnect.suaThongTinDG(d,index);
					if(i>0){
						JOptionPane.showMessageDialog(frmPhnMmQun, "Update DG thành công!");
						loadDG();
					}
					else{
					JOptionPane.showMessageDialog(frmPhnMmQun,"Lỗi update!");
					}
				}
				else{
					JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn chưa nhập đủ");
				}
			}
		});
		btnCapNhatThongTin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCapNhatThongTin.setBounds(206, 278, 117, 23);
		panel.add(btnCapNhatThongTin);
		
		JButton btnThemTaiKhoan = new JButton("Thêm ĐG");
		btnThemTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocGia d=getDG();
				if(d!=null){
					int i=DocGiaConnect.luuDG(d);
					if(i>0){
						JOptionPane.showMessageDialog(frmPhnMmQun, "Them DG thành công!");
						loadDG();
					}
					else{
					JOptionPane.showMessageDialog(frmPhnMmQun,"Lỗi them DG!");
					}
				}
				else{
					JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn chưa nhập đủ");
				}
			}
		});
		btnThemTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemTaiKhoan.setBounds(376, 278, 97, 23);
		panel.add(btnThemTaiKhoan);
		
		JButton btnTimKiemTaiKhoan = new JButton("Tìm kiếm ĐG");
		btnTimKiemTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new TimKiemDG().run();
					int k=0;
					DocGiaConnect dgc=new DocGiaConnect();
					ArrayList<DocGia> docgia=new ArrayList<DocGia>();
					if(comboxTimTrong.getSelectedItem().toString()=="Mã độc giả")
						docgia= dgc.timDG(textTimKiem.getText(),1);
					if(comboxTimTrong.getSelectedItem().toString()=="Tên độc giả")
						docgia= dgc.timDG(textTimKiem.getText(),2);
					if(comboxTimTrong.getSelectedItem().toString()=="Năm sinh")
						docgia= dgc.timDG(textTimKiem.getText(),3);
					if(comboxTimTrong.getSelectedItem().toString()=="Số điện thoại")
						docgia= dgc.timDG(textTimKiem.getText(),4);
					if(comboxTimTrong.getSelectedItem().toString()=="Số CMT")
						docgia= dgc.timDG(textTimKiem.getText(),5);

					dtmTable.setRowCount(0);
					for(DocGia dg:docgia){
						Vector<Object> vec=new Vector<Object>();
						vec.add(dg.getIdDocGia());
						vec.add(dg.getTenDocGia());
						vec.add(dg.getNamSinh());
						vec.add(dg.getDiaChiDG());
						vec.add(dg.getDienThoaiDG());
						vec.add(dg.getSoCMT());
						vec.add(dg.getHanThe());
						dtmTable.addRow(vec);
						k++;
					}
					status(k,textTimKiem.getText());
			}
		});
		btnTimKiemTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiemTaiKhoan.setBounds(61, 278, 105, 23);
		panel.add(btnTimKiemTaiKhoan);
		
		JButton btnXoaTaiKhoan = new JButton("Xóa ĐG");
		btnXoaTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=DocGiaConnect.xoaDG(index);
				if(i>0){
					JOptionPane.showMessageDialog(frmPhnMmQun, "Xoa DG thành công!");
				}
				else{
				JOptionPane.showMessageDialog(frmPhnMmQun,"Lỗi xóa!");
				}
			}
		});
		btnXoaTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaTaiKhoan.setBounds(667, 278, 97, 23);
		panel.add(btnXoaTaiKhoan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(30, 324, 778, 163);
		panel.add(scrollPane);
		
		dtmTable=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã DG", "H\u1ECD v\u00E0 t\u00EAn", "N\u0103m sinh", "\u0110\u1ECBa ch\u1EC9", " S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "S\u1ED1 CMT", "H\u1EA1n th\u1EBB"
				}
			);
		table = new JTable(dtmTable);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index=table.getSelectedRow();
				textTenDocGia.setText(dtmTable.getValueAt(index, 1).toString());
				textDiaChi.setText(dtmTable.getValueAt(index, 3).toString());
				textDienThoai.setText(dtmTable.getValueAt(index, 4).toString());
				textCMT.setText(dtmTable.getValueAt(index, 5).toString());
				String dateNamSinh=dtmTable.getValueAt(index, 2).toString();
				java.util.Date date1=null;
				try{
					date1=new SimpleDateFormat("yyyy-MM-dd").parse(dateNamSinh);
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				QuanLiDocGia.this.dateNamSinh.setDate(date1);
				String dateHanThe_str=dtmTable.getValueAt(index,6).toString();
				java.util.Date date=null;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(dateHanThe_str);
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				dateHanThe.setDate(date);
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton btnThmNhiug = new JButton("Thêm nhiều ĐG");
		btnThmNhiug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf=new JFileChooser();
				jf.setDialogTitle("Chọn file!!!");
				int rs=jf.showOpenDialog(null);
				if(rs==JFileChooser.APPROVE_OPTION){
					String excelpath=jf.getSelectedFile().getAbsolutePath();
					ImportExcel imEx=new ImportExcel();
					try {
						imEx.readFileDG(excelpath);
						JOptionPane.showMessageDialog(null, "OK");
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("loi import");
					}
					
					
				}
			}
		});
		btnThmNhiug.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThmNhiug.setBounds(509, 278, 128, 23);
		panel.add(btnThmNhiug);
		
	}
}
