package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connect.SachConnect;
import model.Sach;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JTable;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;


public class TimKiemSachDG{

	private JFrame frmPhnMmQun;
	private JTextField textTenSach;
	private JTable table;
	private DefaultTableModel dtmTable;
	
	private JLabel lblTimKiem;
	private JComboBox<String> comboxTimTrong;

	public void run() {
				try {
					TimKiemSachDG window = new TimKiemSachDG();
					window.frmPhnMmQun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public TimKiemSachDG() {
		initialize();
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

	private void initialize() {
		frmPhnMmQun = new JFrame();
		frmPhnMmQun.setTitle("Phần mềm quản lý thư viện-THPT Hồng Thái");
		frmPhnMmQun.getContentPane().setBackground(new Color(0, 51, 51));
		frmPhnMmQun.setBounds(200, 200, 846, 550);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhnMmQun.getContentPane().setLayout(null);
		
		JLabel lblTmKimSch = new JLabel("TÌM KIẾM SÁCH");
		lblTmKimSch.setForeground(new Color(255, 255, 204));
		lblTmKimSch.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmKimSch.setBounds(290, 21, 172, 30);
		frmPhnMmQun.getContentPane().add(lblTmKimSch);
		
		JLabel lblTenSach = new JLabel("Cụm từ tìm kiếm");
		lblTenSach.setForeground(new Color(255, 255, 204));
		lblTenSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenSach.setBounds(104, 87, 113, 20);
		frmPhnMmQun.getContentPane().add(lblTenSach);
		
		JLabel lblTheLoai = new JLabel("Tìm trong");
		lblTheLoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTheLoai.setForeground(new Color(255, 255, 204));
		lblTheLoai.setBounds(141, 140, 75, 18);
		frmPhnMmQun.getContentPane().add(lblTheLoai);
		
		textTenSach = new JTextField();
		textTenSach.setBounds(254, 84, 242, 29);
		frmPhnMmQun.getContentPane().add(textTenSach);
		textTenSach.setColumns(10);
		
		JButton btnTiemKiemSach = new JButton("Tìm kiếm");
		btnTiemKiemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k=0;
				SachConnect sc= new SachConnect();
				ArrayList<Sach> sach=new ArrayList<Sach>();
				if(comboxTimTrong.getSelectedItem().toString()=="Tên sách")
					sach= sc.timSach(textTenSach.getText(),1);
				if(comboxTimTrong.getSelectedItem().toString()=="Tác giả")
					sach= sc.timSach(textTenSach.getText(),2);
				if(comboxTimTrong.getSelectedItem().toString()=="Nhà xuất bản")
					sach= sc.timSach(textTenSach.getText(),3);
				if(comboxTimTrong.getSelectedItem().toString()=="Thể loại")
					sach= sc.timSach(textTenSach.getText(),4);
				if(comboxTimTrong.getSelectedItem().toString()=="Ngôn ngữ")
					sach= sc.timSach(textTenSach.getText(),5);

				dtmTable.setRowCount(0);
				for(Sach s:sach){
					Vector<Object> vec=new Vector<Object>();
					vec.add(s.getIdSach());
					vec.add(s.getTenSach());
					vec.add(s.getTacGia());
					vec.add(s.getSoTrang());
					vec.add(s.getTenNXB());
					vec.add(s.getNgonNgu());
					vec.add(s.getLoaiSach());
					vec.add(s.getSoLuongCon());
					dtmTable.addRow(vec);
					k++;
				}
				status(k,textTenSach.getText());
			}
		});
		btnTiemKiemSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTiemKiemSach.setBounds(561, 104, 95, 30);
		frmPhnMmQun.getContentPane().add(btnTiemKiemSach);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frmPhnMmQun, "Bạn thật sự muốn thoát")==0)
					frmPhnMmQun.dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThoat.setBounds(571, 442, 95, 30);
		frmPhnMmQun.getContentPane().add(btnThoat);
		
		JLabel lblKtQuTm = new JLabel("Kết quả tìm kiếm");
		lblKtQuTm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKtQuTm.setForeground(new Color(255, 255, 204));
		lblKtQuTm.setBounds(123, 175, 120, 31);
		frmPhnMmQun.getContentPane().add(lblKtQuTm);
		
		comboxTimTrong = new JComboBox<String>();
		comboxTimTrong.addItem("Tên sách");
		comboxTimTrong.addItem("Tác giả");
		comboxTimTrong.addItem("Nhà xuất bản");
		comboxTimTrong.addItem("Thể loại");
		comboxTimTrong.addItem("Ngôn ngữ");
		comboxTimTrong.setBounds(254, 140, 120, 20);
		frmPhnMmQun.getContentPane().add(comboxTimTrong);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(31, 220, 768, 198);
		frmPhnMmQun.getContentPane().add(scrollPane);
		
		dtmTable=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
					{null, null, null, null, null,null,null,null},
				},
				new String[] {
					"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "S\u1ED1 trang", "Nh\u00E0 xu\u1EA5t b\u1EA3n","Ngôn ngữ","Loại sách","Số lượng còn lại"
				}
			);
		table = new JTable(dtmTable);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		lblTimKiem = new JLabel("Nhập vào thông tin tìm kiếm!");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTimKiem.setForeground(Color.WHITE);
		lblTimKiem.setBackground(Color.WHITE);
		lblTimKiem.setBounds(253, 179, 352, 20);
		frmPhnMmQun.getContentPane().add(lblTimKiem);
		
		
		
				
		
		
		
		
	}
}
