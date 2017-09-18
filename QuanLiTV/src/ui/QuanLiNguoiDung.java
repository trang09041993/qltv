package ui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


import javax.swing.JTextField;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


import connect.BangPhatConnect;
import connect.DocGiaConnect;

import connect.PhieuMuonConnect;
import connect.SachConnect;

import model.PhieuMuon;
import model.PhieuPhat;
import model.Sach;

import java.awt.event.ActionListener;
import java.sql.Date;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import java.awt.Rectangle;
import java.awt.Cursor;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class QuanLiNguoiDung extends QuanLiDocGia{

	private JFrame frmPhnMmQun;
	public JLabel lblNhnVin = new JLabel("Nhân viên");
	private JTextField textMaDG;
	private JTextField textMaSach;	
	private JTextField textMaDG_traS;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private DefaultTableModel dtmtableMS;
	private DefaultTableModel dtmtableMSP;
	private DefaultTableModel dtmtableTS;
	private DefaultTableModel dtmtableTSCT;
	private JList list;
	
	
	private int index;
	private String s0="Đang mượn";
	private String s1="Đã trả";
	private String s2="Mất sách";
	private String s3="Trả muộn";
	private int tongTienPhatSach=0;
	private int tongTienCocSach=0;
	private int tongTienDGTra=0;
	private String tenDG;
	private int soSachDM;
	private int maDG;
	private int maSach;
	private int index_jlist;
	private int maDG_traS;
	private ArrayList<Integer> listSachMuon=new ArrayList<Integer>();
	private DefaultListModel<String> model=new DefaultListModel<String>();
	private ArrayList<Sach> listSach=new ArrayList<Sach>();
	private ArrayList<Sach> listSachTra=new ArrayList<Sach>();
	private JComboBox comboxTienCoc=new JComboBox();
	
	
	public void run() {
				try {
					QuanLiNguoiDung window = new QuanLiNguoiDung();
					window.frmPhnMmQun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public QuanLiNguoiDung() {
		initialize();
	}
	
	public PhieuMuon getPhieu(){
		Calendar c=Calendar.getInstance();
		java.util.Date daymuon=new java.util.Date();
		Date ngayMuon=dinhDangNgay(daymuon);
		c.setTime(ngayMuon);
		c.add(Calendar.DAY_OF_YEAR, 14);
		Date ngayHenTra=dinhDangNgay(c.getTime());
		Date ngayTra=dinhDangNgay(c.getTime());
		int soLuong=list.getModel().getSize();
		int tienCoc=Integer.parseInt(comboxTienCoc.getSelectedItem().toString());
		int maPhieuMuon=0;
		int soTra=0;
		String tenSach="";
		String tinhTrang="";
		PhieuMuon p=new PhieuMuon(maPhieuMuon, maDG, ngayMuon, ngayHenTra, soLuong,soTra, maSach, tienCoc, tenSach, ngayTra, tinhTrang);
		if(maDG==0|| maSach==0) return null;
		else return p;
	}
	
	public int tienPhat(int maSach,String lydo,int soNgay){
		int tienPhat=0;
		int giaSach=0;
		giaSach=SachConnect.timGiaSach(maSach);
		try{
		if(lydo.equals("Trả muộn")) tienPhat=(5000 * soNgay);
		else if(lydo.equals("Trả muộn + Mất sách"))  tienPhat=(5000*soNgay+giaSach*2);
		else if(lydo.equals("Mất sách")) tienPhat=(giaSach*2);
		else tienPhat=0;
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("loi tinh gia tien");
		}
		return tienPhat;
	}

	private void initialize() {
		 JLabel lblTienCoc = new JLabel("");
		 JLabel lblTienPhat = new JLabel("");
		JLabel lblTienPhaiTra = new JLabel("");
		JLabel lblTenDG = new JLabel("");
		JLabel lblSachDangMuon = new JLabel("");
		
		list=new JList(model);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index_jlist=list.getSelectedIndex();
			}
		});
		dtmtableMS=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null},
			
				},
				new String[] {
					"Mã phiếu", "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Ng\u00F4n ng\u1EEF", "Lo\u1EA1i s\u00E1ch", "Gi\u00E1 ti\u1EC1n", "Số lượng còn"
				}
			);
		
		dtmtableMSP=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					
				},
				new String[] {
					"STT", "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "Ngày hẹn trả"
				}
			);
		
		frmPhnMmQun = new JFrame();
		frmPhnMmQun.setTitle("Phần mềm quản lý thư viện-THPT Hồng Thái");
		frmPhnMmQun.getContentPane().setBackground(new Color(0, 51, 51));
		frmPhnMmQun.setBounds(100, 100, 927, 550);
		frmPhnMmQun.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 172, 511);
		frmPhnMmQun.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnThayDoiTTCaNhan = new JButton("Thay đổi hồ sơ");
		btnThayDoiTTCaNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThayDoiTT().run();
			}
		});
		btnThayDoiTTCaNhan.setForeground(new Color(0, 0, 204));
		btnThayDoiTTCaNhan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThayDoiTTCaNhan.setBounds(18, 55, 133, 29);
		panel.add(btnThayDoiTTCaNhan);
		
		JButton btnQuanLiKhoSach = new JButton("Quản lý kho sách");
		btnQuanLiKhoSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLiKhoSach().run();			
			}
		});
		btnQuanLiKhoSach.setForeground(new Color(0, 0, 204));
		btnQuanLiKhoSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLiKhoSach.setBounds(16, 129, 135, 29);
		panel.add(btnQuanLiKhoSach);
		
		JButton btnQuanLiDocGia = new JButton("Quản lý độc giả");
		btnQuanLiDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLiDocGia().run();
			}
		});
		btnQuanLiDocGia.setForeground(new Color(0, 0, 153));
		btnQuanLiDocGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLiDocGia.setBounds(16, 187, 133, 29);
		panel.add(btnQuanLiDocGia);
		
		JButton btnQuanLiMuonTra = new JButton("Quản lý mượn trả");
		btnQuanLiMuonTra.setForeground(new Color(0, 0, 153));
		btnQuanLiMuonTra.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLiMuonTra.setBounds(16, 253, 133, 29);
		panel.add(btnQuanLiMuonTra);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongKe.main(null);
			}
		});
		btnThongKe.setForeground(new Color(0, 0, 153));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThongKe.setBounds(16, 310, 133, 29);
		panel.add(btnThongKe);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frmPhnMmQun, "Bạn thật sự muốn đăng xuất")==0)
					frmPhnMmQun.dispose();
			}
		});
		btnDangXuat.setForeground(new Color(0, 0, 204));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDangXuat.setBounds(18, 398, 133, 29);
		panel.add(btnDangXuat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 95, 114, 11);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 358, 112, 29);
		panel.add(separator_1);
		lblNhnVin.setBackground(Color.BLACK);
		lblNhnVin.setOpaque(true);
		
		
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNhnVin.setForeground(Color.WHITE);
		lblNhnVin.setBounds(16, 11, 114, 20);
		panel.add(lblNhnVin);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(174, 49, 727, 462);
		frmPhnMmQun.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		tabbedPane.addTab("Mượn sách", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		panel_3.setBounds(new Rectangle(1, 1, 0, 0));
		panel_3.setForeground(new Color(0, 0, 204));
		panel_3.setBackground(new Color(204, 255, 204));
		panel_3.setBounds(91, 11, 220, 258);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã độc giả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(5, 15, 84, 14);
		panel_3.add(lblNewLabel_1);
		
		textMaDG = new JTextField();
		textMaDG.setBounds(5, 37, 192, 25);
		panel_3.add(textMaDG);
		textMaDG.setColumns(10);
		
		JButton btnKiemTraDG = new JButton("Kiểm tra");
		btnKiemTraDG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				maDG=Integer.parseInt(textMaDG.getText());
				tenDG=DocGiaConnect.timTenDG(maDG);
				if(tenDG.equals("")){
					JOptionPane.showMessageDialog(frmPhnMmQun,"Bạn chưa đăng ký làm độc giả của thư viện!");
					soSachDM=0;
					lblSachDangMuon.setText("0");
				}
				else{
					lblTenDG.setText(tenDG);
					soSachDM=SachConnect.soSachDM(maDG);
					lblSachDangMuon.setText(Integer.toString(soSachDM));
					model.clear();
					listSachMuon.clear();
				}
			}
		});
		btnKiemTraDG.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKiemTraDG.setBounds(53, 71, 89, 23);
		panel_3.add(btnKiemTraDG);
		
		JLabel lblTncGi = new JLabel("Tên độc giả");
		lblTncGi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTncGi.setBounds(5, 105, 84, 14);
		panel_3.add(lblTncGi);
		
		lblTenDG.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenDG.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTenDG.setOpaque(true);
		lblTenDG.setLabelFor(frmPhnMmQun);
		lblTenDG.setBackground(Color.WHITE);
		lblTenDG.setBounds(5, 130, 192, 25);
		panel_3.add(lblTenDG);
		
		JLabel lblSLngSch = new JLabel("Số lượng sách đang mượn");
		lblSLngSch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSLngSch.setBounds(5, 178, 152, 14);
		panel_3.add(lblSLngSch);
		
		
		lblSachDangMuon.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSachDangMuon.setOpaque(true);
		lblSachDangMuon.setBackground(Color.WHITE);
		lblSachDangMuon.setBounds(5, 203, 192, 25);
		panel_3.add(lblSachDangMuon);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		panel_4.setBounds(394, 11, 220, 258);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Mã sách");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(5, 5, 67, 14);
		panel_4.add(lblNewLabel_3);
		
		textMaSach = new JTextField();
		textMaSach.setColumns(10);
		textMaSach.setBounds(5, 22, 192, 25);
		panel_4.add(textMaSach);
		
		JButton btnKiemTraSach = new JButton("Kiểm tra");
		btnKiemTraSach.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				maSach=Integer.parseInt(textMaSach.getText());
				listSach=SachConnect.timSach(textMaSach.getText(),6);
				table.setModel(dtmtableMS);
				table.getColumnModel().getColumn(0).setPreferredWidth(60);
				table.getColumnModel().getColumn(1).setPreferredWidth(60);
				table.getColumnModel().getColumn(2).setPreferredWidth(300);
				table.getColumnModel().getColumn(3).setPreferredWidth(150);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.getColumnModel().getColumn(5).setPreferredWidth(100);
				table.getColumnModel().getColumn(6).setPreferredWidth(100);
				table.getColumnModel().getColumn(7).setPreferredWidth(100);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				dtmtableMS.setRowCount(0);
				for(Sach s:listSach)
				{
					Vector<Object> vec=new Vector<Object>();
					vec.add("###");
					vec.add(s.getIdSach());
					vec.add(s.getTenSach());
					vec.add(s.getTacGia());
					vec.add(s.getNgonNgu());
					vec.add(s.getLoaiSach());
					vec.add(s.getGiaTien());
					vec.add(s.getSoLuongCon());
					dtmtableMS.addRow(vec);
					listSachMuon.add(s.getIdSach());
				}
			}
		});
		btnKiemTraSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKiemTraSach.setBounds(62, 53, 95, 23);
		panel_4.add(btnKiemTraSach);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int soluongcon=SachConnect.timSachConLai(maSach);
				if(soSachDM<=5&&soluongcon>0) model.addElement(textMaSach.getText());	
				else JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn đã mượn quá số sách quy định hoặc hết sách!");
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThem.setBounds(62, 80, 95, 23);
		panel_4.add(btnThem);
		
		JButton btnMuonSach = new JButton("Mượn sách");
		btnMuonSach.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e)
			{
				if((soSachDM+list.getModel().getSize())<=5)
				{
					int i=0,j=0,k=0;
					int sosachcon=0;
					int stt=1;
					PhieuMuon p=getPhieu();
					
					if(p!=null)
					{
						p.setSoTra(0);
						i=PhieuMuonConnect.luuPhieu(p);
						p.setMaPhieuMuon(PhieuMuonConnect.timMaPM(maDG,p.getNgayMuon()));
						
						for(int s1: listSachMuon){
							p.setMaSachMuon(s1);
							p.setTinhTrang(s0);
						  j=PhieuMuonConnect.luuPhieuCT(p);
						  	sosachcon=SachConnect.timSachConLai(s1);
						  	k=SachConnect.updateLuongSachCon(sosachcon-1,s1);
						  	
						}
					
						if(i>0&&j>0&&k>0){
							JOptionPane.showMessageDialog(frmPhnMmQun, "Mượn sách thành công");
							table.getColumnModel().getColumn(0).setPreferredWidth(60);
							table.getColumnModel().getColumn(1).setPreferredWidth(60);
							table.getColumnModel().getColumn(2).setPreferredWidth(300);
							table.getColumnModel().getColumn(3).setPreferredWidth(150);
							table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							table.setModel(dtmtableMSP);
							dtmtableMSP.setRowCount(0);
							XWPFDocument d=new XWPFDocument();
							File f=new File("e:/projec_NguyenThiHuyenTrang_KS2_K37/data_word/Muon_"+p.getMaPhieuMuon()+".docx");
				        	FileOutputStream out=null;
							try {
								out = new FileOutputStream(f);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				        	
							XWPFParagraph p0=d.createParagraph();
				        	XWPFRun r0=p0.createRun();
				        	r0.setText("Sở GD-DT Hà Nội");
				        	r0.addBreak();
				        	r0.setText("Trường THPT Hồng Thái");
				        	r0.setFontSize(13);
				        	r0.setBold(true);
							
							XWPFParagraph p1=d.createParagraph();
				        	XWPFRun r1=p1.createRun();
				        	r1.setText("PHIẾU MƯỢN SÁCH");
				        	r1.addBreak();
				        	r1.addBreak();
				        	r1.addBreak();
				        	p1.setAlignment(ParagraphAlignment.CENTER);
				        	r1.setFontSize(16);
				        	r1.setBold(true);
				        	
				        	XWPFParagraph p2=d.createParagraph();
				        	XWPFRun r2=p2.createRun();
				        	r2.setText("MÃ PHIẾU    	:	"+p.getMaPhieuMuon());
				         	r2.addBreak();
				        	r2.setText("TÊN ĐỘC GIẢ 	:	"+lblTenDG.getText());
				         	r2.addBreak();
				        	r2.setText("NGÀY MƯỢN  		:	"+p.getNgayMuon());
				         	r2.addBreak();
				        	r2.setText("NGÀY HẸN TRẢ	:	"+p.getNgayHenTra());
				         	r2.addBreak();
				        	r2.setText("TIỀN ĐẶT CỌC	:	"+p.getTienCoc()+"VND");
				         	r2.addBreak();
				         	r2.setFontSize(16);
				         	r2.setBold(true);
				        	
				         	XWPFTable t=d.createTable();
				         	t.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));;
				         	XWPFTableRow tr=t.getRow(0);
				         	tr.getCell(0).setText("STT");
				         	tr.addNewTableCell().setText("Mã sách");
				         	tr.addNewTableCell().setText("Tên sách");
				         	
							for(int s1: listSachMuon){
								Vector<Object> vec=new Vector<Object>();
								String tens=SachConnect.timTenSach(s1);
								vec.add(stt);
								vec.add(s1);
								vec.add(tens);
								vec.add(p.getNgayHenTra());
								dtmtableMSP.addRow(vec);
								XWPFTableRow tro=t.createRow();
				         		tro.getCell(0).setText(Integer.toString(stt));
				         		tro.getCell(1).setText(Integer.toString(s1));
				         		tro.getCell(2).setText(tens);
				         		stt++;
							}
							XWPFParagraph p3=d.createParagraph();
				        	XWPFRun r3=p3.createRun();
				        	r3.addBreak();
				        	r3.addBreak();
				        	r3.setText("Hà Nội - Ngày:"+p.getNgayMuon()+"                        				 ");
				         	r3.addBreak();
				         	r3.addBreak();
				        	r3.setText("Độc giả kí               ");
				        	r3.setText("                                                       ");
				        	r3.setText("Thủ thư kí          ");
				        	r3.setBold(true);
				        	r3.setFontSize(13);
				        	p3.setAlignment(ParagraphAlignment.RIGHT);
				        	
				        	try {
								d.write(out);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				        	try {
								out.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else JOptionPane.showMessageDialog(frmPhnMmQun, "Mượn sách thất bại");
				}
				else JOptionPane.showMessageDialog(frmPhnMmQun, "Chưa nhập đủ dữ liệu");
				}
				else
					JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn chỉ được mượn "+(5-soSachDM)+"quyển!");
			}
			
		});
		btnMuonSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMuonSach.setBounds(5, 224, 95, 23);
		panel_4.add(btnMuonSach);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.remove(index_jlist);
				listSachMuon.remove(index_jlist);
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHuy.setBounds(115, 224, 95, 23);
		panel_4.add(btnHuy);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(47, 105, 130, 70);
		panel_4.add(scrollPane_2);
		
		
		scrollPane_2.setViewportView(list);
		
		JLabel lblNewLabel_4 = new JLabel("Tiền cọc");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(5, 190, 53, 14);
		panel_4.add(lblNewLabel_4);
		
		
		comboxTienCoc.setModel(new DefaultComboBoxModel(new String[] {"50000", "100000", "150000", "200000", "250000"}));
		comboxTienCoc.setBounds(62, 186, 115, 20);
		panel_4.add(comboxTienCoc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 282, 650, 107);
		panel_1.add(scrollPane);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnInPhiuMn = new JButton("In phiếu mượn");
		btnInPhiuMn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInPhiuMn.setBounds(437, 400, 123, 23);
		panel_1.add(btnInPhiuMn);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(0, 51, 51));
		tabbedPane.addTab("Trả sách", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 255, 255));
		panel_5.setBounds(10, 11, 168, 412);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã độc giả");
		lblNewLabel_2.setBounds(11, 8, 69, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(lblNewLabel_2);
		
		textMaDG_traS = new JTextField();
		textMaDG_traS.setBounds(10, 25, 146, 25);
		textMaDG_traS.setBorder(new LineBorder(Color.BLACK));
		panel_5.add(textMaDG_traS);
		textMaDG_traS.setColumns(10);
		
		JButton btnKiemTra_traS = new JButton("Kiểm tra");
		btnKiemTra_traS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soNgay=0;
				Calendar c1=Calendar.getInstance();
				Calendar c2=Calendar.getInstance();
				String s1="";
				int tienphat=0;
				ArrayList<PhieuMuon> listP=new ArrayList<PhieuMuon>();
				
				maDG_traS=Integer.parseInt(textMaDG_traS.getText());
				listP=PhieuMuonConnect.timPhieu(maDG_traS);
				tongTienCocSach=PhieuMuonConnect.timTienCoc(maDG_traS);
				lblTienCoc.setText(Integer.toString(tongTienCocSach));
				
				dtmtableTS.setRowCount(0);
				dtmtableTSCT.setRowCount(0);	
				for(PhieuMuon p:listP ){
					p.setTenSach(SachConnect.timTenSach(p.getMaSachMuon()));
					Vector<Object> vec=new Vector<Object>();
					vec.add(p.getMaPhieuMuon());
					vec.add(p.getMaDocGia());
					vec.add(p.getMaSachMuon());
					vec.add(p.getTenSach());
					vec.add(p.getNgayMuon());
					vec.add(p.getNgayHenTra());
					dtmtableTS.addRow(vec);
					
					Vector<Object> vec1=new Vector<Object>();
					vec1.add(p.getMaSachMuon());
					vec1.add(p.getTinhTrang());
					p.setNgayTra(dinhDangNgay(c1.getTime()));
					vec1.add(p.getNgayTra());
					
					if(p.getTinhTrang().equals(s0))
					{
						c2.setTime(p.getNgayHenTra());
						soNgay=(int) ((c1.getTime().getTime()-c2.getTime().getTime())/(24 * 3600 * 1000));
						if(soNgay<=0) soNgay=0;
						vec1.add(soNgay);
						if(soNgay>0) s1="Trả muộn";
						else s1="";
						vec1.add(s1);
						tienphat=tienPhat(p.getMaSachMuon(),s1,soNgay);
						vec1.add(tienphat);
					}
					else{
					PhieuPhat p1=BangPhatConnect.timPhieu(p.getMaPhieuMuon(),p.getMaSachMuon());
						vec1.add(p1.getSoNgayTre());
						vec1.add(p1.getLyDoPhat());
						vec1.add(p1.getSoTienPhat());
					}
					dtmtableTSCT.addRow(vec1);
					
				}
			}
		});
		btnKiemTra_traS.setBounds(38, 55, 89, 23);
		btnKiemTra_traS.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(btnKiemTra_traS);
		
		JLabel lblMSch = new JLabel("Mã sách");
		lblMSch.setBounds(10, 86, 69, 14);
		lblMSch.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(lblMSch);
		
		JLabel lblMaSach_traS = new JLabel("");
		lblMaSach_traS.setBounds(10, 104, 146, 25);
		lblMaSach_traS.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMaSach_traS.setOpaque(true);
		lblMaSach_traS.setBackground(Color.WHITE);
		panel_5.add(lblMaSach_traS);
		
		JButton btnTraSach_traS = new JButton("Trả sách");
		btnTraSach_traS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dtmtableTSCT.getValueAt(index, 1).equals(s1)||dtmtableTSCT.getValueAt(index, 1).equals(s2)){
					JOptionPane.showMessageDialog(frmPhnMmQun, "Sách đã trả!");
				}
				else{
				Sach s=new Sach();
				int masach=0;
				int maDG=0;
				int sosachcon=0;
				int maphieu=0;
				int sosach=0;
				int tienphatsach=0;
				Calendar c=Calendar.getInstance();
				
				masach=Integer.parseInt(lblMaSach_traS.getText());
				maDG=Integer.parseInt(textMaDG_traS.getText());
				
				s.setIdSach(masach);
				s.setTenSach(SachConnect.timTenSach(masach));
				
				sosachcon=SachConnect.timSachConLai(masach);
				SachConnect.updateLuongSachCon(sosachcon+1,masach);
				maphieu=PhieuMuonConnect.timMaPM(maDG,(Date) dtmtableTS.getValueAt(index, 4)); 
				sosach=SachConnect.timLuongSachDaTra(maphieu);
				SachConnect.updateLuongSachTra(sosach+1, maphieu);
				PhieuMuonConnect.updateTinhTrangSach(s1,masach,maphieu);
				SachConnect.updateNgayTra(dinhDangNgay(c.getTime()), maphieu, masach);
				dtmtableTSCT.setValueAt(s1,index,1);
				tienphatsach=Integer.parseInt(dtmtableTSCT.getValueAt(index,5).toString());
				tongTienPhatSach+=tienphatsach;
				lblTienPhat.setText(Integer.toString(tongTienPhatSach));
				
				if(tienphatsach>0){
					PhieuPhat p=new PhieuPhat();
					p.setMaPhieuMuon(maphieu);
					p.setMaSach(masach);
					p.setSoNgayTre((int) dtmtableTSCT.getValueAt(index, 3));
					p.setLyDoPhat(dtmtableTSCT.getValueAt(index, 4).toString());
					p.setSoTienPhat(tienphatsach);
					BangPhatConnect.luuPhat(p);
					s.setLyDoPhat(dtmtableTSCT.getValueAt(index, 4).toString());
					s.setSoTienPhat(tienphatsach);
				}
				else{
					s.setLyDoPhat("");
					s.setSoTienPhat(tienphatsach);
				}
				listSachTra.add(s);
			}
			}
		});
		btnTraSach_traS.setBounds(38, 135, 89, 23);
		btnTraSach_traS.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(btnTraSach_traS);
		
		JButton btnMatSach_traS = new JButton("Mất sách");
		btnMatSach_traS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dtmtableTSCT.getValueAt(index, 1).equals(s1)||dtmtableTSCT.getValueAt(index, 1).equals(s2)){
					JOptionPane.showMessageDialog(frmPhnMmQun, "Sách đã trả!");
				}
				else{
					Sach s=new Sach();
				int masach=0;
				int maDG=0;
				int tienP1=0;
				int tienP=0;
				int tongTienPhatMotSach=0;
				int maphieu=0;
				int sosachcon=0;
				int soluong=0;
				String lyDo1="";
				
				masach=Integer.parseInt(lblMaSach_traS.getText());
				maDG=Integer.parseInt(textMaDG_traS.getText());
				
				s.setIdSach(masach);
				s.setTenSach(SachConnect.timTenSach(masach));
					
				lyDo1=dtmtableTSCT.getValueAt(index,4).toString();
				dtmtableTSCT.setValueAt(s2+"+"+lyDo1, index, 4);	
				
				tienP=tienPhat(masach,s2,0);
				tienP1=Integer.parseInt(dtmtableTSCT.getValueAt(index,5).toString());			
				tongTienPhatSach+=tienP;
				tongTienPhatMotSach=tienP1+tienP;
				dtmtableTSCT.setValueAt(tongTienPhatMotSach, index, 5);
				dtmtableTSCT.setValueAt(s2,index,1);
				
				PhieuMuonConnect.updateTinhTrangSach(s2,masach, maDG);
				sosachcon=SachConnect.timSachConLai(masach);
				SachConnect.updateLuongSachCon(sosachcon-1,masach);
				soluong=SachConnect.timSachCo(masach);
				SachConnect.updateLuongSach(soluong-1, masach);
				lblTienPhat.setText(Integer.toString(tongTienPhatSach));
				maphieu=PhieuMuonConnect.timMaPM(maDG,(Date) dtmtableTS.getValueAt(index, 4)); 
				
				PhieuPhat p=new PhieuPhat();
				p.setMaPhieuMuon(maphieu);
				p.setMaSach(masach);
				p.setSoNgayTre((int) dtmtableTSCT.getValueAt(index, 3));
				p.setLyDoPhat(dtmtableTSCT.getValueAt(index, 4).toString());
				p.setSoTienPhat(tongTienPhatMotSach);
				BangPhatConnect.luuPhat(p);
				s.setLyDoPhat(dtmtableTSCT.getValueAt(index, 4).toString());
				s.setSoTienPhat(tongTienPhatMotSach);
				listSachTra.add(s);
			}
			}
		});
		btnMatSach_traS.setBounds(38, 165, 89, 23);
		btnMatSach_traS.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_5.add(btnMatSach_traS);
		
		JLabel lblTinPht = new JLabel("Tiền phạt");
		lblTinPht.setBounds(10, 196, 64, 14);
		lblTinPht.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(lblTinPht);
		
		
		lblTienPhat.setBounds(11, 214, 146, 25);
		lblTienPhat.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTienPhat.setBackground(Color.WHITE);
		lblTienPhat.setOpaque(true);
		panel_5.add(lblTienPhat);
		
		JLabel lblNewLabel_5 = new JLabel("Tiền đặt cọc");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(11, 250, 69, 14);
		panel_5.add(lblNewLabel_5);
		
		
		lblTienCoc.setOpaque(true);
		lblTienCoc.setBackground(Color.WHITE);
		lblTienCoc.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTienCoc.setBounds(11, 267, 146, 25);
		panel_5.add(lblTienCoc);
		
		JLabel lblTinPhiTr = new JLabel("Tiền phải trả");
		lblTinPhiTr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTinPhiTr.setBounds(10, 305, 81, 14);
		panel_5.add(lblTinPhiTr);
		
		
		lblTienPhaiTra.setOpaque(true);
		lblTienPhaiTra.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTienPhaiTra.setBackground(Color.WHITE);
		lblTienPhaiTra.setBounds(10, 322, 146, 25);
		panel_5.add(lblTienPhaiTra);
		
		JButton btnNopTien = new JButton("OK");
		btnNopTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tongTienDGTra=tongTienPhatSach-tongTienCocSach;
				lblTienPhaiTra.setText(Integer.toString(tongTienDGTra));
				JOptionPane.showMessageDialog(frmPhnMmQun, "OK!");
				
				
				Calendar c=Calendar.getInstance();
				XWPFDocument d=new XWPFDocument();
				File f=new File("e:/projec_NguyenThiHuyenTrang_KS2_K37/data_word/TraSach_"+textMaDG_traS.getText()+".docx");
	        	FileOutputStream out=null;
				try {
					out = new FileOutputStream(f);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				XWPFParagraph p0=d.createParagraph();
	        	XWPFRun r0=p0.createRun();
	        	r0.setText("Sở GD-DT Hà Nội");
	        	r0.addBreak();
	        	r0.setText("Trường THPT Hồng Thái");
	        	r0.setFontSize(13);
	        	r0.setBold(true);

	        	
	        	XWPFParagraph p1=d.createParagraph();
	        	XWPFRun r1=p1.createRun();
	        	r1.setText("PHIẾU TRẢ SÁCH");
	        	p1.setAlignment(ParagraphAlignment.CENTER);
	        	r1.setFontSize(16);
	        	r1.setBold(true);
	        	
	        	XWPFParagraph p2=d.createParagraph();
	        	XWPFRun r2=p2.createRun();
	        	r2.setText("TÊN ĐỘC GIẢ 	:	"+DocGiaConnect.timTenDG(Integer.parseInt(textMaDG_traS.getText())));
	         	r2.addBreak();
	         	r2.setText("TIỀN ĐÃ CỌC		:	"+lblTienCoc.getText()+"VND");
	         	r2.addBreak();
	         	if(tongTienDGTra>0){
	        	r2.setText("TIỀN PHẢI NỘP	:	"+tongTienDGTra+"VND");
	         	r2.addBreak();
	         	r2.setText("TIỀN NHẬN LẠI	: 	0 VND");
	         	r2.addBreak();
	         	}
	         	else{
	         		r2.setText("TIỀN PHẢI NỘP	: 	0 VND");
		         	r2.addBreak();
		         	r2.setText("TIỀN NHẬN LẠI	:	"+(-tongTienDGTra)+" VND");
		         	r2.addBreak();
	         	}
	         	
	         	r2.setFontSize(14);
	         	r2.setBold(true);
	        	
	         	
	         	XWPFTable t=d.createTable();
	        	t.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));;			         
	         	XWPFTableRow tr=t.getRow(0);
	         	tr.getCell(0).setText("STT");
	         	tr.addNewTableCell().setText("Mã sách");
	         	tr.addNewTableCell().setText("Tên sách");
	        	tr.addNewTableCell().setText("Lý do phạt");
	         	tr.addNewTableCell().setText("Số tiền phạt");
	        	int stt=1;
	         
	        	
	        	
				for(Sach s1: listSachTra){
					XWPFTableRow tro=t.createRow();
	         		tro.getCell(0).setText(Integer.toString(stt++));
	         		tro.getCell(1).setText(Integer.toString(s1.getIdSach()));
	         		tro.getCell(2).setText(s1.getTenSach());
	         		tro.getCell(3).setText(s1.getLyDoPhat());
	         		tro.getCell(4).setText(Integer.toString(s1.getSoTienPhat()));
				}
				XWPFParagraph p3=d.createParagraph();
	        	XWPFRun r3=p3.createRun();
	        	r3.addBreak();
	        	r3.addBreak();
	        	r3.setText("Hà Nội - Ngày:"+c.getTime()+"                        	 ");
	         	r3.addBreak();
	         	r3.addBreak();
	        	r3.setText("Độc giả kí               ");
	        	r3.setText("                                                       ");
	        	r3.setText("Thủ thư kí          ");
	        	r3.setBold(true);
	        	r3.setFontSize(13);
	        	p3.setAlignment(ParagraphAlignment.RIGHT);
	        
	        	try {
					d.write(out);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	try {
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNopTien.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNopTien.setBounds(38, 358, 89, 23);
		panel_5.add(btnNopTien);
		
		JButton btnHuy_traS = new JButton("Hủy");
		btnHuy_traS.setBounds(38, 386, 87, 23);
		panel_5.add(btnHuy_traS);
		btnHuy_traS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTienPhat.setText("");
				lblTienPhaiTra.setText("");
				
			}
		});
		btnHuy_traS.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(Color.BLACK, 2));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(221, 11, 491, 177);
		panel_2.add(scrollPane_1);
		
		dtmtableTS = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"Mã phiếu", "M\u00E3 DG", "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "Ng\u00E0y m\u01B0\u1EE3n", "Ngày hẹn trả"
				}
			);
		table_1 = new JTable();
		table_1.setModel(dtmtableTS);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(200);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane_1.setViewportView(table_1);
				
		JButton btnThoat_traS = new JButton("Thoát");
		btnThoat_traS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frmPhnMmQun, "Bạn thật sự muốn thoát")==0)
					frmPhnMmQun.dispose();
			}
		});
		btnThoat_traS.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThoat_traS.setBounds(476, 389, 89, 23);
		panel_2.add(btnThoat_traS);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new LineBorder(Color.BLACK, 2));
		scrollPane_3.setBounds(221, 211, 491, 167);
		panel_2.add(scrollPane_3);
		
		dtmtableTSCT=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"M\u00E3 s\u00E1ch", "T\u00ECnh tr\u1EA1ng", "Ng\u00E0y tr\u1EA3", "S\u1ED1 ng\u00E0y tr\u1EA3 mu\u1ED9n", "L\u00FD do ph\u1EA1t", "S\u00F4 ti\u1EC1n ph\u1EA1t"
				}
			);
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index=table_2.getSelectedRow();
				TableModel modl=table_2.getModel();
				String maSo=modl.getValueAt(index, 0).toString();
				lblMaSach_traS.setText(maSo);
				
				
			}
		});
		
		table_2.setModel(dtmtableTSCT);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_3.setViewportView(table_2);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ MƯỢN - TRẢ SÁCH");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(408, 11, 253, 40);
		frmPhnMmQun.getContentPane().add(lblNewLabel);
		
		
	}
}
