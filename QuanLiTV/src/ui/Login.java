package ui;



import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import connect.MyConnect;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;



import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Login extends QuanLiNguoiDung{

	private JFrame frmPhnMmQun;
	protected JTextField textTenDangNhap;
	private JPasswordField textMatKhau;
	protected static int keys;
	public String name;


	public void run() {
		try {
			Login window = new Login();
			window.frmPhnMmQun.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Login() {
		initialize();
	}

	private void initialize() {
		frmPhnMmQun = new JFrame();
		frmPhnMmQun.getContentPane().setIgnoreRepaint(true);
		frmPhnMmQun.setTitle("Phần mềm quản lý thư viện-THPT Hồng Thái");
		frmPhnMmQun.getContentPane().setBackground(new Color(0, 51, 51));
		frmPhnMmQun.getContentPane().setForeground(new Color(0, 128, 0));
		frmPhnMmQun.setBounds(200, 200, 587, 384);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhnMmQun.getContentPane().setLayout(null);
		
		JLabel lblHeThongQL = new JLabel("H\u1EC6 TH\u1ED0NG QU\u1EA2N L\u00DD TH\u01AF VI\u1EC6N S\u00C1CH");
		lblHeThongQL.setBackground(Color.WHITE);
		lblHeThongQL.setForeground(Color.WHITE);
		lblHeThongQL.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeThongQL.setBounds(118, 11, 290, 36);
		frmPhnMmQun.getContentPane().add(lblHeThongQL);
		
		JLabel lblDanhChoNV = new JLabel("D\u00E0nh Cho Nh\u00E2n Vi\u00EAn");
		lblDanhChoNV.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblDanhChoNV.setForeground(Color.WHITE);
		lblDanhChoNV.setBounds(10, 48, 166, 33);
		frmPhnMmQun.getContentPane().add(lblDanhChoNV);
		
		JLabel lblTenDangNhap = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblTenDangNhap.setIcon(new ImageIcon("C:\\Users\\tranght\\Documents\\Eclipse_project\\QuanLiTV\\hinhanh\\user.png"));
		lblTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenDangNhap.setForeground(Color.WHITE);
		lblTenDangNhap.setBounds(45, 82, 131, 35);
		frmPhnMmQun.getContentPane().add(lblTenDangNhap);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMatKhau.setIcon(new ImageIcon("C:\\Users\\tranght\\Documents\\Eclipse_project\\QuanLiTV\\hinhanh\\password.png"));
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setBounds(45, 132, 119, 33);
		frmPhnMmQun.getContentPane().add(lblMatKhau);
		
		textTenDangNhap = new JTextField("");
		textTenDangNhap.setToolTipText("Nhập tên đăng nhập");
		textTenDangNhap.setBounds(186, 84, 222, 32);
		frmPhnMmQun.getContentPane().add(textTenDangNhap);
		textTenDangNhap.setColumns(10);
		
		textMatKhau = new JPasswordField("");
		textMatKhau.setToolTipText("Nhập mật khẩu");
		textMatKhau.setBounds(186, 133, 222, 32);
		frmPhnMmQun.getContentPane().add(textMatKhau);
		
		JLabel lblDanhChoDG = new JLabel("D\u00E0nh Cho \u0110\u1ED9c Gi\u1EA3");
		lblDanhChoDG.setForeground(Color.WHITE);
		lblDanhChoDG.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblDanhChoDG.setBounds(10, 212, 125, 23);
		frmPhnMmQun.getContentPane().add(lblDanhChoDG);
		
		JButton btnTimKiemSach = new JButton("T\u00ECm Ki\u1EBFm");
		btnTimKiemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TimKiemSachDG().run();
				
			}
		});
		btnTimKiemSach.setIcon(new ImageIcon("C:\\Users\\tranght\\Documents\\Eclipse_project\\QuanLiTV\\hinhanh\\search.jpg"));
		btnTimKiemSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKiemSach.setForeground(Color.BLUE);
		btnTimKiemSach.setBounds(221, 252, 139, 36);
		frmPhnMmQun.getContentPane().add(btnTimKiemSach);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.setIconTextGap(0);
		btnDangNhap.setIcon(new ImageIcon("C:\\Users\\tranght\\Documents\\Eclipse_project\\QuanLiTV\\hinhanh\\dangnhap.png"));
		btnDangNhap.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

			if(textTenDangNhap.getText().equals("")||textMatKhau.getText().equals("")){
				JOptionPane.showMessageDialog(frmPhnMmQun," Bạn chưa nhập đủ dữ liệu","Lỗi",JOptionPane.ERROR_MESSAGE);
			}
			else{
				MyConnect my= new MyConnect();
				try{
					my.ps=my.con.prepareStatement("Select * from thongtintaikhoan where TaiKhoan=? and MatKhau=?");
					my.ps.setString(1,textTenDangNhap.getText());
					my.ps.setString(2,textMatKhau.getText());
					ResultSet rs=my.ps.executeQuery();
					if(rs.next()){
						if(textTenDangNhap.getText().equals("admin")&& textMatKhau.getText().equals("admin123")){
						new QuanLiAdmin().run();
						keys=rs.getInt(3);
						}
						else{
						QuanLiNguoiDung nd=new QuanLiNguoiDung();
						keys=rs.getInt(3);
						name=rs.getString(1);
						nd.run();
						nd.lblNhnVin.setText(name);
						}
					
						frmPhnMmQun.dispose();
						}
					else{
						JOptionPane.showMessageDialog(frmPhnMmQun," Tên đăng nhập hoặc mật khẩu chưa đúng","Thông báo",JOptionPane.ERROR_MESSAGE);
						textTenDangNhap.setText("");
						textMatKhau.setText("");
						textTenDangNhap.requestFocus();
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDangNhap.setForeground(Color.BLUE);
		btnDangNhap.setBounds(221, 176, 139, 36);
		frmPhnMmQun.getContentPane().add(btnDangNhap);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBounds(128, 62, 327, 9);
		frmPhnMmQun.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBounds(128, 224, 327, 2);
		frmPhnMmQun.getContentPane().add(separator_1);
	}
}
