package ui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.ImportExcel;
import connect.MyConnect;
import connect.SachConnect;

import jxl.write.WriteException;
import model.Sach;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLiKhoSach extends QuanLiDocGia{

	private JFrame frmPhnMmQun;
	private JTextField textTenSach;
	private JTextField textTacGia;
	private JTextField textGiaBia;
	private JTextField textNXB;
	private JTextField textSoLuong;
	private JTable table;
	private DefaultTableModel dtmTable;
	private JTextField textSoTrang;
	private JComboBox<String> comboxNgonNgu = new JComboBox<String>();
	private JComboBox<String> comboxTheLoai = new JComboBox<String>();
	JDateChooser dateSach;
	private JTextField textMaSach;
	private int index;

	public void run() {
		try {
			QuanLiKhoSach window = new QuanLiKhoSach();
				window.frmPhnMmQun.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
	public QuanLiKhoSach() {
		initialize();
		loadSach();
	}
	
	private void loadSach(){
		ArrayList<Sach> list=new ArrayList<Sach>();
		list=SachConnect.loadSach();
		dtmTable.setRowCount(0);
		for(Sach s:list){
			Vector<Object> vec= new Vector<Object>();
			vec.add(s.getIdSach());
			vec.add(s.getTenSach());
			vec.add(s.getTacGia());
			vec.add(s.getTenNXB());
			vec.add(s.getNgonNgu());
			vec.add(s.getLoaiSach());
			vec.add(s.getNgayNhap());
			vec.add(s.getSoTrang());
			vec.add(s.getGiaTien());
			vec.add(s.getSoLuong());
			dtmTable.addRow(vec);
		}
	}

	// lấy dữ liệu của sách
	public Sach getSach(){
		int masach=0;
		int soluongcon=0;
		String tenSach=textTenSach.getText();
		String tacGia=textTacGia.getText();
		String nhaXuatBan=textNXB.getText();
		Date ngayNhap=dinhDangNgay(dateSach.getDate());
		String giaBia1=textGiaBia.getText();
		int giaBia=Integer.parseInt(giaBia1);
		String soLuong1=textSoLuong.getText();
		int soLuong=Integer.parseInt(soLuong1);
		String soTrang1=textSoTrang.getText();
		int soTrang=Integer.parseInt(soTrang1);
		String theLoai=comboxTheLoai.getSelectedItem().toString();
		String ngonNgu=comboxNgonNgu.getSelectedItem().toString();
		Sach s=new Sach(masach,tacGia, tenSach, nhaXuatBan, ngonNgu, theLoai, ngayNhap, giaBia, soLuong, soTrang,soluongcon );
		if(tenSach.equals("")||tacGia.equals("")||nhaXuatBan.equals("")||ngayNhap.equals("")||
				giaBia1.equals("")||soLuong1.equals("")||soTrang1.equals("")) return null;
		else return s;
	}
	
	private void initialize() {
		frmPhnMmQun = new JFrame();
		frmPhnMmQun.setTitle("Phần mềm quản lý thư viện-THPT Hồng Thái");
		frmPhnMmQun.setBounds(100, 100, 862, 570);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhnMmQun.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadSach();
			}
		});
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 846, 550);
		frmPhnMmQun.getContentPane().add(panel);
		
		JLabel label = new JLabel("QUẢN LÝ KHO SÁCH");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 204));
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(304, 20, 249, 24);
		panel.add(label);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 55, 826, 195);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("Tên sách");
		label_2.setForeground(new Color(0, 51, 51));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(79, 20, 58, 14);
		panel_1.add(label_2);
		
		textTenSach = new JTextField();
		textTenSach.setColumns(10);
		textTenSach.setBounds(159, 20, 210, 23);
		panel_1.add(textTenSach);
		
		JLabel label_3 = new JLabel("Tác giả");
		label_3.setForeground(new Color(0, 51, 0));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(79, 49, 46, 14);
		panel_1.add(label_3);
		
		textTacGia = new JTextField();
		textTacGia.setColumns(10);
		textTacGia.setBounds(159, 49, 210, 23);
		panel_1.add(textTacGia);
		
		JLabel label_4 = new JLabel("Thể loại");
		label_4.setForeground(new Color(0, 51, 0));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(79, 79, 46, 14);
		panel_1.add(label_4);
		
		
		MyConnect my1=new MyConnect();
		try{
			my1.ps=my1.con.prepareStatement("select*from theloaisach");
			ResultSet rs=my1.ps.executeQuery();
			while(rs.next()){
				comboxTheLoai.addItem(rs.getString(1));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		comboxTheLoai.setBounds(159, 79, 102, 23);
		panel_1.add(comboxTheLoai);
		
		JLabel label_5 = new JLabel("Ngôn ngữ");
		label_5.setForeground(new Color(0, 51, 0));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(79, 113, 58, 14);
		panel_1.add(label_5);
		
		
		MyConnect my=new MyConnect();
		try{
			my.ps=my.con.prepareStatement("Select * from ngonngu");
			ResultSet rs=my.ps.executeQuery();
			while(rs.next()){
				comboxNgonNgu.addItem(rs.getString(1));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		comboxNgonNgu.setBounds(159, 113, 102, 23);
		panel_1.add(comboxNgonNgu);
		
		JLabel label_6 = new JLabel("Ngày nhập");
		label_6.setForeground(new Color(0, 51, 51));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(449, 20, 68, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Giá bìa");
		label_7.setForeground(new Color(0, 51, 51));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(449, 49, 46, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Nhà xuất bản");
		label_8.setForeground(new Color(0, 51, 51));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(449, 79, 76, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Số lượng");
		label_9.setForeground(new Color(0, 51, 51));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(449, 113, 68, 14);
		panel_1.add(label_9);
		
		JLabel lblSTrang = new JLabel("Số trang");
		lblSTrang.setForeground(new Color(0, 51, 51));
		lblSTrang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSTrang.setBounds(449, 151, 76, 14);
		panel_1.add(lblSTrang);
		
		textGiaBia = new JTextField();
		textGiaBia.setColumns(10);
		textGiaBia.setBounds(552, 45, 167, 23);
		panel_1.add(textGiaBia);
		
		textNXB = new JTextField();
		textNXB.setColumns(10);
		textNXB.setBounds(551, 75, 167, 23);
		panel_1.add(textNXB);
		
		textSoLuong = new JTextField();
		textSoLuong.setColumns(10);
		textSoLuong.setBounds(552, 110, 167, 23);
		panel_1.add(textSoLuong);
		
		textSoTrang = new JTextField();
		textSoTrang.setBounds(552, 147, 167, 23);
		panel_1.add(textSoTrang);
		textSoTrang.setColumns(10);
		
		dateSach = new JDateChooser();
		dateSach.setDateFormatString("yyyy-MM-dd");
		dateSach.setBounds(552, 15, 122, 23);
		panel_1.add(dateSach);
		
		JLabel lblSaxaSchBng = new JLabel("Sửa/Xóa Sách bằng ID");
		lblSaxaSchBng.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaxaSchBng.setBounds(79, 160, 136, 14);
		panel_1.add(lblSaxaSchBng);
		
		textMaSach = new JTextField();
		textMaSach.setBounds(235, 157, 86, 25);
		panel_1.add(textMaSach);
		textMaSach.setColumns(10);
		
		JButton btnSuaSach = new JButton("Sửa thông tin sách");
		btnSuaSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textMaSach.getText();
				int idsach=Integer.parseInt(id);
				Sach s=getSach();
				if(s!=null){
					int i=SachConnect.suaThongTinSach(s,idsach);
					if(i>0){
						JOptionPane.showMessageDialog(frmPhnMmQun, "Update sách thành công!");
						dtmTable.setRowCount(0);
						Vector<Object> vec= new Vector<Object>();
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getTacGia());
						vec.add(s.getTenNXB());
						vec.add(s.getNgonNgu());
						vec.add(s.getLoaiSach());
						vec.add(s.getNgayNhap());
						vec.add(s.getSoTrang());
						vec.add(s.getGiaTien());
						vec.add(s.getSoLuong());
						dtmTable.addRow(vec);
					}
					else{
					JOptionPane.showMessageDialog(frmPhnMmQun,"Lỗi update sách!");
					}
				}
				else{
					JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn chưa nhập đủ");
				}
				
			}
		});
		btnSuaSach.setBounds(57, 279, 144, 23);
		panel.add(btnSuaSach);

		JButton btnThemSach = new JButton("Thêm sách");
		btnThemSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sach s=getSach();
				if(s!=null){
					int i=SachConnect.luuSach(s);
					if(i>0){
						JOptionPane.showMessageDialog(frmPhnMmQun, "Thêm sách thành công!");
						dtmTable.setRowCount(0);
						Vector<Object> vec= new Vector<Object>();
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getTacGia());
						vec.add(s.getTenNXB());
						vec.add(s.getNgonNgu());
						vec.add(s.getLoaiSach());
						vec.add(s.getNgayNhap());
						vec.add(s.getSoTrang());
						vec.add(s.getGiaTien());
						vec.add(s.getSoLuong());
						dtmTable.addRow(vec);
					}
					else{
					JOptionPane.showMessageDialog(frmPhnMmQun,"Lỗi!");
					}
				}
				else{
					JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn chưa nhập đủ");
				}
		
			}
		});
		btnThemSach.setBounds(432, 279, 101, 23);
		panel.add(btnThemSach);
		
		JButton btnTimKiemSach = new JButton("Tìm sách");
		btnTimKiemSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TimKiemSachDG().run();
			}
		});
		btnTimKiemSach.setBounds(570, 279, 93, 23);
		panel.add(btnTimKiemSach);
	
		// xóa sách
		JButton btnXoaSach = new JButton("Xóa Sách");
		btnXoaSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textMaSach.getText();
				int idsach=Integer.parseInt(id);
				int i=SachConnect.xoaSach(idsach);
				if(i>0){
					JOptionPane.showMessageDialog(frmPhnMmQun, "Xoa sách thành công!");
				}
				else{
				JOptionPane.showMessageDialog(frmPhnMmQun,"Lỗi xóa sách!");
				}
				
			}
		});
		btnXoaSach.setBounds(706, 279, 93, 23);
		panel.add(btnXoaSach);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 336, 826, 185);
		panel.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 816, 173);
		panel_2.add(scrollPane);
		
		dtmTable=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "Ng\u00F4n ng\u1EEF", "Lo\u1EA1i s\u00E1ch", "Ng\u00E0y nh\u1EADp", "S\u1ED1 trang", "Gi\u00E1 ti\u1EC1n", "S\u1ED1 l\u01B0\u1EE3ng"
				}
			);
		table = new JTable(dtmTable);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index=table.getSelectedRow();
				textMaSach.setText(dtmTable.getValueAt(index,0).toString());
				textTenSach.setText(dtmTable.getValueAt(index,1).toString());
				textTacGia.setText(dtmTable.getValueAt(index, 2).toString());
				textNXB.setText(dtmTable.getValueAt(index, 3).toString());
				comboxNgonNgu.setSelectedItem(dtmTable.getValueAt(index,4));
				comboxTheLoai.setSelectedItem(dtmTable.getValueAt(index,5));
				String dateNN=dtmTable.getValueAt(index,6).toString();
				java.util.Date date=null;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(dateNN);
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				dateSach.setDate(date);
				textSoTrang.setText(dtmTable.getValueAt(index,7).toString());
				textGiaBia.setText(dtmTable.getValueAt(index,8).toString());
				textSoLuong.setText(dtmTable.getValueAt(index,9).toString());
			}
				
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		table.getColumnModel().getColumn(3).setMinWidth(16);
		table.getColumnModel().getColumn(6).setPreferredWidth(91);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		JButton btnThmNhiuSch = new JButton("Thêm nhiều sách");
		btnThmNhiuSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf=new JFileChooser();
				jf.setDialogTitle("Chọn file!!!");
				int rs=jf.showOpenDialog(null);
				if(rs==JFileChooser.APPROVE_OPTION){
					String excelpath=jf.getSelectedFile().getAbsolutePath();
					ImportExcel imEx=new ImportExcel();
					try {
						imEx.readFileSach(excelpath);
						JOptionPane.showMessageDialog(null, "OK");
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("loi import");
					}
					
					
				}
			}
		});
		btnThmNhiuSch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThmNhiuSch.setBounds(246, 279, 139, 23);
		panel.add(btnThmNhiuSch);
	}
}
