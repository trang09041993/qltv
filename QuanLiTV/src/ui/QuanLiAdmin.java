package ui;



import javax.swing.JFrame;
import java.awt.Color;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;

import connect.NhanVienConnect;
import model.NhanVien;


import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLiAdmin extends Login {

	private JFrame frmPhnMmQun;
	private JTextField textTenDN;
	private JTextField textTenDayDu;
	private JComboBox<String> comboxVaiTro ;
	private JTable table;
	private DefaultTableModel dtmtable;
	private ArrayList<NhanVien> list=new ArrayList<NhanVien>();
	private int index=0;
	private JTextField textMatKhau;

	public void run() {
				try {
					QuanLiAdmin window = new QuanLiAdmin();
					window.frmPhnMmQun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public NhanVien getNV(){
		String tenDN=textTenDN.getText();
		String tenDD=textTenDayDu.getText();
		int maNV=0;
		String matKhau=textMatKhau.getText();
		String vaiTro=comboxVaiTro.getSelectedItem().toString();
		NhanVien nv=new NhanVien(maNV, tenDN, tenDD, matKhau, vaiTro);
		if(tenDN.equals("")||tenDD.equals("")) return null;
		else return nv;
	}
	
	public QuanLiAdmin() {
		initialize();
		loadNV();
	}

	private void loadNV(){
		list=NhanVienConnect.loadNV();
		dtmtable.setRowCount(0);
		for(NhanVien n:list){
			Vector<Object> vec= new Vector<Object>();
			vec.add(n.getMaNV());
			vec.add(n.getTenDangNhap());
			vec.add(n.getMatKhau());
			vec.add(n.getTenDayDu());
			vec.add(n.getChucVu());
			dtmtable.addRow(vec);
		}
	}
	private void initialize() {
	
		frmPhnMmQun = new JFrame();
		frmPhnMmQun.setTitle("Phần mềm quản lý thư viện-THPT Hồng Thái");
		frmPhnMmQun.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmPhnMmQun.getContentPane().setBackground(Color.WHITE);
		frmPhnMmQun.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 153, 153), 3));
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 183, 511);
		frmPhnMmQun.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin2017");
		lblAdmin.setForeground(new Color(255, 255, 204));
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdmin.setBounds(27, 33, 77, 14);
		panel.add(lblAdmin);
		
		JButton btnThayDoiTTCaNhan = new JButton("Sửa TTCN");
		btnThayDoiTTCaNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThayDoiTT().run();
			}
		});
		btnThayDoiTTCaNhan.setBackground(new Color(255, 255, 204));
		btnThayDoiTTCaNhan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThayDoiTTCaNhan.setForeground(new Color(0, 0, 204));
		btnThayDoiTTCaNhan.setBounds(27, 73, 131, 29);
		panel.add(btnThayDoiTTCaNhan);
		
		JButton btnQuanLiKhoSach = new JButton("Quản lí kho sách");
		btnQuanLiKhoSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLiKhoSach().run();
				
			}
		});
		btnQuanLiKhoSach.setForeground(new Color(0, 0, 204));
		btnQuanLiKhoSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLiKhoSach.setBackground(new Color(255, 255, 204));
		btnQuanLiKhoSach.setBounds(27, 157, 131, 29);
		panel.add(btnQuanLiKhoSach);
		
		JButton btnQuanLiDocGia = new JButton("Quản lí độc giả");
		btnQuanLiDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLiDocGia().run();
			}
		});
		btnQuanLiDocGia.setForeground(new Color(0, 0, 204));
		btnQuanLiDocGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLiDocGia.setBackground(new Color(255, 255, 204));
		btnQuanLiDocGia.setBounds(27, 215, 131, 29);
		panel.add(btnQuanLiDocGia);
		
		JButton btnQuanLiNhanVien = new JButton("Quản lí nhân viên");
		btnQuanLiNhanVien.setForeground(new Color(0, 0, 204));
		btnQuanLiNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLiNhanVien.setBackground(new Color(255, 255, 204));
		btnQuanLiNhanVien.setBounds(27, 274, 131, 29);
		panel.add(btnQuanLiNhanVien);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongKe.main(null);;
			}
		});
		btnThongKe.setForeground(new Color(0, 0, 204));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThongKe.setBackground(new Color(255, 255, 204));
		btnThongKe.setBounds(27, 333, 131, 29);
		panel.add(btnThongKe);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frmPhnMmQun, "Bạn thật sự muốn đăng xuất")==0)
					frmPhnMmQun.dispose();
			}
		});
		btnDangXuat.setForeground(new Color(0, 0, 204));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDangXuat.setBackground(new Color(255, 255, 204));
		btnDangXuat.setBounds(27, 445, 131, 29);
		panel.add(btnDangXuat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 129, 146, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 402, 131, 10);
		panel.add(separator_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		panel_1.setBorder(new LineBorder(new Color(153, 153, 153), 3));
		panel_1.setBounds(182, 0, 418, 511);
		frmPhnMmQun.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(91, 32, 202, 31);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 398, 251);
		panel_1.add(scrollPane);
		
		dtmtable=new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Mã NV", "Tài khoản", "Mật khẩu", "H\u1ECD t\u00EAn \u0111\u1EA7y \u0111\u1EE7", "Vai tr\u00F2"
				}
			);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index=table.getSelectedRow();
				textTenDN.setText(dtmtable.getValueAt(index, 1).toString());
				textMatKhau.setText(dtmtable.getValueAt(index, 2).toString());
				textTenDayDu.setText(dtmtable.getValueAt(index, 3).toString());
				comboxVaiTro.setSelectedItem(dtmtable.getValueAt(index, 4));
				
			}
		});
		table.setModel(dtmtable);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(153, 153, 153), 3));
		panel_2.setBackground(new Color(0, 51, 51));
		panel_2.setBounds(599, 0, 214, 511);
		frmPhnMmQun.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 51, 86, 14);
		panel_2.add(lblNewLabel_1);
		
		textTenDN = new JTextField();
		textTenDN.setBounds(10, 76, 181, 25);
		panel_2.add(textTenDN);
		textTenDN.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên đầy đủ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 116, 86, 14);
		panel_2.add(lblNewLabel_2);
		
		textTenDayDu = new JTextField();
		textTenDayDu.setBounds(10, 149, 175, 25);
		panel_2.add(textTenDayDu);
		textTenDayDu.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mật khẩu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 185, 97, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vai trò");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(10, 246, 55, 25);
		panel_2.add(lblNewLabel_5);
		
		comboxVaiTro = new JComboBox<String>();
		comboxVaiTro.setModel(new DefaultComboBoxModel<String>(new String[] {"Quản lý", "Nhân viên"}));
		comboxVaiTro.setBounds(10, 282, 105, 25);
		panel_2.add(comboxVaiTro);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 318, 213, 2);
		panel_2.add(separator_2);
		
		JButton btnThemTaiKhoan = new JButton("Thêm tài khoản");
		btnThemTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv=getNV();
				if(nv!=null){
					int i=NhanVienConnect.luuNV(nv);
					if(i>0){ JOptionPane.showMessageDialog(frmPhnMmQun, "Thêm NV thành công!");
					loadNV();
					}
					else JOptionPane.showMessageDialog(frmPhnMmQun, "Lỗi!");
				}
				else JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn chưa nhập đủ");
			}
		});
		btnThemTaiKhoan.setForeground(new Color(0, 0, 153));
		btnThemTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemTaiKhoan.setBounds(30, 343, 151, 25);
		panel_2.add(btnThemTaiKhoan);
		
		JButton btnThayDoiThongTin = new JButton("Thay đổi thông tin");
		btnThayDoiThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv=getNV();
				if(nv!=null){
					int i=NhanVienConnect.suaNV(nv,index);
					if(i>0){ JOptionPane.showMessageDialog(frmPhnMmQun, "Sửa NV thành công!");
					loadNV();}
					else JOptionPane.showMessageDialog(frmPhnMmQun, "Lỗi uadte!");
				}
				else JOptionPane.showMessageDialog(frmPhnMmQun, "Bạn chưa nhập đủ");
			}
		});
		btnThayDoiThongTin.setForeground(new Color(0, 0, 153));
		btnThayDoiThongTin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThayDoiThongTin.setBounds(30, 398, 151, 25);
		panel_2.add(btnThayDoiThongTin);
		
		JButton btnXoaTaiKhoan = new JButton("Xóa tài khoản");
		btnXoaTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(int) dtmtable.getValueAt(index, 0);
				int i=NhanVienConnect.xoaNV(id);
				if(i>0){ JOptionPane.showMessageDialog(frmPhnMmQun, "Xóa NV thành công!");
				loadNV();
				}
				else JOptionPane.showMessageDialog(frmPhnMmQun, "Lỗi!");
				
			}
		});
		btnXoaTaiKhoan.setForeground(new Color(0, 0, 153));
		btnXoaTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaTaiKhoan.setBounds(30, 447, 151, 25);
		panel_2.add(btnXoaTaiKhoan);
		
		textMatKhau = new JTextField();
		textMatKhau.setBounds(10, 215, 175, 25);
		panel_2.add(textMatKhau);
		textMatKhau.setColumns(10);
		frmPhnMmQun.setBounds(100, 100, 824, 550);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
