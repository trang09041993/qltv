package ui;



import javax.swing.JFrame;


import connect.NhanVienConnect;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThayDoiTT extends Login {

	private JFrame frame;
	private JTextField textSuaTen;
	private JTextField textSuaMatKhau;

	/**
	 * Launch the application.
	 */
	public void run() {
				try {
					ThayDoiTT window = new ThayDoiTT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	public NhanVien getNV(){
		String tenDN=textSuaTen.getText();
		String matKhau=textSuaMatKhau.getText();
		NhanVien nv=new NhanVien(tenDN, matKhau);
		if(tenDN.equals("")||matKhau.equals("")) return null;
		else return nv;
	}
	/**
	 * Create the application.
	 */
	public ThayDoiTT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 191, 216);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(10, 11, 111, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textSuaTen = new JTextField();
		textSuaTen.setBounds(10, 36, 136, 25);
		frame.getContentPane().add(textSuaTen);
		textSuaTen.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setBounds(10, 67, 65, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textSuaMatKhau = new JTextField();
		textSuaMatKhau.setBounds(10, 92, 136, 25);
		frame.getContentPane().add(textSuaMatKhau);
		textSuaMatKhau.setColumns(10);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv=getNV();
				if(nv!=null){
					int i=NhanVienConnect.tuSuaNV(nv, keys);
					if(i>0) {
						JOptionPane.showMessageDialog(frame, "Đã sửa!");
						frame.dispose();
					}
					else
						JOptionPane.showMessageDialog(frame, "Lỗi!");
				}
				else
					JOptionPane.showMessageDialog(frame, "Bạn chưa nhập đủ!");
			}
		});
		btnNewButton.setBounds(25, 137, 55, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(86, 137, 55, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
