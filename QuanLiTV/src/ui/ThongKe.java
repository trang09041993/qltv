package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;


import connect.ExportFile;

import jxl.write.WriteException;
import model.DocGia;
import model.PhieuMuon;
import model.Sach;
import model.thongke;

import javax.swing.JButton;
import javax.swing.JFileChooser;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ThongKe extends QuanLiDocGia{

	private JFrame frame;
	private JTable table;
	private DefaultTableModel dtmSach1;
	private DefaultTableModel dtmSach2;
	private DefaultTableModel dtmDG;
	private DefaultTableModel dtmMT;
	private DefaultTableModel dtmTK;
	private JTable table_1;
	private JTable table_2;
	private JComboBox comboxToanSachChon ;
	private JTable table_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe window = new ThongKe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThongKe() {
		initialize();
	}
	
	public void loadDG(ArrayList<DocGia> listDG){
		dtmDG.setRowCount(0);
		for(DocGia dg:listDG){
			Vector<Object> vec=new Vector<Object>();
			vec.add(dg.getIdDocGia());
			vec.add(dg.getTenDocGia());
			vec.add(dg.getNamSinh());
			vec.add(dg.getDiaChiDG());
			vec.add(dg.getDienThoaiDG());
			vec.add(dg.getSoCMT());
			vec.add(dg.getHanThe());
			dtmDG.addRow(vec);
		}
	}
	
	public void loadSL(ArrayList<thongke> list){
		dtmMT.setRowCount(0);
		for(thongke d:list){
			Vector<Object> vec=new Vector<Object>();
			vec.add(d.getNgay());
			vec.add(d.getSoLM());
			vec.add(d.getSoSM());
			vec.add(d.getSoST());
			vec.add(d.getTienCoc());
			vec.add(d.getTienPhat());
			dtmMT.addRow(vec);
		}
		
	}
	
	public void loadCT(ArrayList<thongke> list){
		dtmTK.setRowCount(0);
		for(thongke d:list){
			Vector<Object> vec=new Vector<Object>();
			vec.add(d.getTienCoc());
			vec.add(d.getTen());
			vec.add(d.getSoLM());
			vec.add(d.getSoSM());
			vec.add(d.getSoST());
			
			dtmTK.addRow(vec);
		}
		
	}
	public void loadCTS(ArrayList<thongke> list){
		dtmTK.setRowCount(0);
		for(thongke d:list){
			Vector<Object> vec=new Vector<Object>();
			vec.add(d.getTienCoc());
			vec.add(d.getTen());
			vec.add(d.getSoLM());
			
			
			dtmTK.addRow(vec);
		}
		
	}
	
	public void exportExcel(JTable table){
		ExportFile exf = new ExportFile();
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:/Users/"+System.getProperty("user.name")+"/Desktop"));
        int save = chooser.showSaveDialog(null);
        if (save == JFileChooser.APPROVE_OPTION) {
            try {
                File file = new File(chooser.getSelectedFile() + ".xls");
                exf.printTable(table, file);
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                   ex.printStackTrace();
                }

            } catch (WriteException ex) {
            	   ex.printStackTrace();
            }
        }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 888, 522);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 862, 483);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ THƯ VIỆN SÁCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(318, 11, 257, 38);
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(0, 40, 862, 443);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabbedPane.addTab("Sách", null, panel_1, null);
		panel_1.setLayout(null);
		
		JRadioButton rdToanSach = new JRadioButton("Toàn bộ sách");
		rdToanSach.setBackground(new Color(204, 255, 204));
		rdToanSach.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdToanSach.setBounds(41, 95, 109, 23);
		panel_1.add(rdToanSach);
		
		JRadioButton rdSachDangMuon = new JRadioButton("Sách được mượn");
		rdSachDangMuon.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdSachDangMuon.setBackground(new Color(204, 255, 204));
		rdSachDangMuon.setBounds(41, 20, 130, 23);
		panel_1.add(rdSachDangMuon);
		
		JRadioButton rdTuNgayS = new JRadioButton("Từ ngày");
		rdTuNgayS.setBackground(new Color(204, 255, 204));
		rdTuNgayS.setForeground(new Color(0, 0, 0));
		rdTuNgayS.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdTuNgayS.setBounds(205, 18, 87, 23);
		panel_1.add(rdTuNgayS);
		
		JDateChooser dateTuNgayS = new JDateChooser();
		dateTuNgayS.setDateFormatString("yyyy-MM-dd");
		dateTuNgayS.setBounds(298, 21, 114, 20);
		panel_1.add(dateTuNgayS);
		
		JRadioButton rdDenNgayS = new JRadioButton("Đến ngày");
		rdDenNgayS.setBackground(new Color(204, 255, 204));
		rdDenNgayS.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdDenNgayS.setBounds(466, 18, 89, 23);
		panel_1.add(rdDenNgayS);
		
		JDateChooser dateDenNgayS = new JDateChooser();
		dateDenNgayS.setDateFormatString("yyyy-MM-dd");
		dateDenNgayS.setBounds(567, 18, 109, 20);
		panel_1.add(dateDenNgayS);
		
		JRadioButton rdTheoThangS = new JRadioButton("Theo tháng");
		rdTheoThangS.setBackground(new Color(204, 255, 204));
		rdTheoThangS.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdTheoThangS.setBounds(203, 55, 89, 23);
		panel_1.add(rdTheoThangS);
		
		
		
		JRadioButton rdTheoNamS = new JRadioButton("Theo năm");
		rdTheoNamS.setBackground(new Color(204, 255, 204));
		rdTheoNamS.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdTheoNamS.setBounds(466, 55, 98, 23);
		panel_1.add(rdTheoNamS);
		
		JRadioButton rdSachMat = new JRadioButton("Sách bị mất");
		rdSachMat.setBackground(new Color(204, 255, 204));
		rdSachMat.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdSachMat.setBounds(41, 52, 120, 23);
		panel_1.add(rdSachMat);
		
		JMonthChooser cThangS = new JMonthChooser();
		cThangS.setBounds(297, 55, 98, 20);
		panel_1.add(cThangS);
		
		JYearChooser cNamS = new JYearChooser();
		cNamS.setBounds(567, 55, 47, 20);
		panel_1.add(cNamS);
		
		JRadioButton rdTheo = new JRadioButton("Theo");
		rdTheo.setBackground(new Color(204, 255, 204));
		rdTheo.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdTheo.setBounds(205, 95, 68, 23);
		panel_1.add(rdTheo);
		
		dtmSach1=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
				},
				new String[] {
					"STT", "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "Tác Giả", "S\u1ED1 L\u01B0\u1EE3ng"
				}
			);
		
		dtmSach2=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null,null},
				},
				new String[] {
					"STT","Mã phiếu mượn","Mã độc giả", "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "Ngày mượn", "Tình trạng"
				}
			);
		
		JButton btnThongKeSach = new JButton("Thống kê");
		btnThongKeSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Sach> listS=new ArrayList<Sach>();
				ArrayList<PhieuMuon> listS1=new ArrayList<PhieuMuon>();
				if(rdToanSach.isSelected()&& !rdTheo.isSelected()){
					int k=0;
					table.setModel(dtmSach1);
					listS=connect.ThongKe.thongKeToanSach();
					dtmSach1.setRowCount(0);
					for(Sach s:listS){
						Vector<Object> vec=new Vector<Object>();
						vec.add(++k);
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getTacGia());
						vec.add(s.getSoLuong());
						dtmSach1.addRow(vec);
					}
				}
				
				else if(rdToanSach.isSelected() && rdTheoNamS.isSelected()){
					int k=0;
					int year=cNamS.getYear();
					table.setModel(dtmSach1);
					listS=connect.ThongKe.thongKeToanSachTheoNam(year);
					dtmSach1.setRowCount(0);
					for(Sach s:listS){
						Vector<Object> vec=new Vector<Object>();
						vec.add(++k);
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getTacGia());
						vec.add(s.getSoLuong());
						dtmSach1.addRow(vec);
					}
					
				}
				
				else if(rdToanSach.isSelected()&& rdTheo.isSelected()  ){
					int k=0;
					if( comboxToanSachChon.getSelectedItem().toString()=="Tác giả" ){
					dtmSach1=new DefaultTableModel(
							new Object[][] {
								{null, null, null},
							},
							new String[] {
								"STT", "Tên tác giả", "Số lượng sách"
							}
						);
					table.setModel(dtmSach1);
					listS=connect.ThongKe.thongKeToanSachTheo(1);
					dtmSach1.setRowCount(0);
					
					}
					else if(comboxToanSachChon.getSelectedItem().toString().equals("Nhà xuất bản") ){
						dtmSach1=new DefaultTableModel(
								new Object[][] {
									{null, null, null},
								},
								new String[] {
									"STT", "Nhà xuất bản", "Số lượng sách"
								}
							);
						table.setModel(dtmSach1);
						listS=connect.ThongKe.thongKeToanSachTheo(2);
					}
					else if(comboxToanSachChon.getSelectedItem().toString().equals("Thể loại") ){
						dtmSach1=new DefaultTableModel(
								new Object[][] {
									{null, null, null},
								},
								new String[] {
									"STT", "Thể loại", "Số lượng sách"
								}
							);
						table.setModel(dtmSach1);
						listS=connect.ThongKe.thongKeToanSachTheo(3);
					}
					for(Sach s:listS){
						Vector<Object> vec=new Vector<Object>();
						vec.add(++k);
						vec.add(s.getTenSach());
						vec.add(s.getSoLuong());
						dtmSach1.addRow(vec);
					}
				}
				
				
				else if(rdSachDangMuon.isSelected() && rdTuNgayS.isSelected() && rdDenNgayS.isSelected()){
					int k=0;
					Date date1= dinhDangNgay(dateTuNgayS.getDate());
					Date date2=dinhDangNgay(dateDenNgayS.getDate());
					listS1=connect.ThongKe.thongKeSachDMTheoNgay(date1, date2);
					table.setModel(dtmSach2);
					dtmSach2.setRowCount(0);
					for(PhieuMuon s: listS1){
						Vector<Object> vec=new Vector<Object>();
						vec.add(++k);
						vec.add(s.getMaPhieuMuon());
						vec.add(s.getMaDocGia());
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getNgayMuon());
						vec.add(s.getTinhTrang());
						dtmSach2.addRow(vec);
					}
				}
				
				else if(rdSachDangMuon.isSelected() && rdTheoThangS.isSelected()){
					int k=0;
					int month=cThangS.getMonth();
					listS1=connect.ThongKe.thongKeSachDMTheoThang(month+1);
					table.setModel(dtmSach2);
					dtmSach2.setRowCount(0);
					for(PhieuMuon s: listS1){
						Vector<Object> vec=new Vector<Object>();
						vec.add(++k);
						vec.add(s.getMaPhieuMuon());
						vec.add(s.getMaDocGia());
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getNgayMuon());
						vec.add(s.getTinhTrang());
						dtmSach2.addRow(vec);
					}
				}
				
				else if(rdSachMat.isSelected()){
					int k=0;
					listS1=connect.ThongKe.thongKeSachMat();
					dtmSach2=new DefaultTableModel(
							new Object[][] {
								{null, null, null, null, null, null},
							},
							new String[] {
								"STT","Mã phiếu mượn","Mã độc giả", "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch","Tác giả"
							}
						);
					table.setModel(dtmSach2);
					dtmSach2.setRowCount(0);
					for(PhieuMuon s: listS1){
						Vector<Object> vec=new Vector<Object>();
						vec.add(++k);
						vec.add(s.getMaPhieuMuon());
						vec.add(s.getMaDocGia());
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getTacGia());
						dtmSach2.addRow(vec);
					}
				}
				
				else if(rdSachMat.isSelected()&& rdTheoThangS.isSelected()){
					int k=0;
					int month=cThangS.getMonth();
					listS1=connect.ThongKe.thongKeSachMatTheoThang(month);
					dtmSach2=new DefaultTableModel(
							new Object[][] {
								{null, null, null, null, null, null},
							},
							new String[] {
								"STT","Mã phiếu mượn","Mã độc giả", "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch","Tác giả"
							}
						);
					table.setModel(dtmSach2);
					dtmSach2.setRowCount(0);
					for(PhieuMuon s: listS1){
						Vector<Object> vec=new Vector<Object>();
						vec.add(++k);
						vec.add(s.getMaPhieuMuon());
						vec.add(s.getMaDocGia());
						vec.add(s.getIdSach());
						vec.add(s.getTenSach());
						vec.add(s.getTacGia());
						dtmSach2.addRow(vec);
					}
				}
				
				else JOptionPane.showMessageDialog(null,"Chưa có chức năng này" );
				
			}
		});
		btnThongKeSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongKeSach.setBounds(726, 28, 109, 50);
		panel_1.add(btnThongKeSach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 130, 808, 213);
		panel_1.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		JButton btnExportfile = new JButton("ExportFile");
		btnExportfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel(table);
				
			}
		});
		btnExportfile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExportfile.setBounds(737, 354, 110, 50);
		panel_1.add(btnExportfile);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 51, 51));
		separator.setBounds(41, 85, 612, 2);
		panel_1.add(separator);
		
		comboxToanSachChon = new JComboBox();
		comboxToanSachChon.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboxToanSachChon.setModel(new DefaultComboBoxModel(new String[] {"Tác giả", "Nhà xuất bản", "Thể loại"}));
		comboxToanSachChon.setBounds(290, 98, 87, 20);
		panel_1.add(comboxToanSachChon);
		
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 204));
		tabbedPane.addTab("Độc giả", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Toàn bộ độc giả");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<DocGia> listDG=new ArrayList<DocGia>();
				listDG=connect.ThongKe.thongKeDG();
				loadDG(listDG);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(100, 31, 153, 23);
		panel_2.add(btnNewButton);
		
		JButton btncGiQu = new JButton("Độc giả quá hạn thẻ");
		btncGiQu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<DocGia> listDG=new ArrayList<DocGia>();
				listDG=connect.ThongKe.thongKeDGQuaHan();
				loadDG(listDG);
			}
		});
		btncGiQu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btncGiQu.setBounds(318, 31, 153, 23);
		panel_2.add(btncGiQu);
		
		JButton btncGiang = new JButton("Độc giả đang mượn sách");
		btncGiang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<DocGia> listDG=new ArrayList<DocGia>();
				listDG=connect.ThongKe.thongKeDGDangMuon();
				loadDG(listDG);
			}
		});
		btncGiang.setFont(new Font("Tahoma", Font.BOLD, 11));
		btncGiang.setBounds(536, 31, 202, 23);
		panel_2.add(btncGiang);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(60, 90, 730, 239);
		panel_2.add(scrollPane_1);
		
		dtmDG=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"M\u00E3 DG", "H\u1ECD v\u00E0 t\u00EAn", "N\u0103m sinh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0110T", "S\u1ED1 CMT", "H\u1EA1n th\u1EBB"
				}
			);
		
		table_1 = new JTable();
		table_1.setModel(dtmDG);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnExportfile_1 = new JButton("ExportFile");
		btnExportfile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel(table_1);
			}
		});
		btnExportfile_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExportfile_1.setBounds(636, 354, 113, 34);
		panel_2.add(btnExportfile_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 204));
		tabbedPane.addTab("Mượn-Trả", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblThngKLt = new JLabel("Thống kê lượt mượn - trả sách");
		lblThngKLt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThngKLt.setBounds(278, 11, 232, 25);
		panel_3.add(lblThngKLt);
		
		JRadioButton rdTuNgayMT = new JRadioButton("Từ ngày");
		rdTuNgayMT.setBackground(new Color(204, 255, 204));
		rdTuNgayMT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdTuNgayMT.setBounds(173, 43, 80, 23);
		panel_3.add(rdTuNgayMT);
		
		JDateChooser dateTuMT = new JDateChooser();
		dateTuMT.setDateFormatString("yyyy-MM-dd");
		dateTuMT.setBounds(268, 47, 120, 20);
		panel_3.add(dateTuMT);
		
		JRadioButton rdDenNgayMT = new JRadioButton("Đến ngày");
		rdDenNgayMT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdDenNgayMT.setBackground(new Color(204, 255, 204));
		rdDenNgayMT.setBounds(449, 43, 80, 23);
		panel_3.add(rdDenNgayMT);
		
		JDateChooser dateDenMT = new JDateChooser();
		dateDenMT.setDateFormatString("yyyy-MM-dd");
		dateDenMT.setBounds(558, 46, 120, 20);
		panel_3.add(dateDenMT);
		
		JRadioButton rdTheoThangMT = new JRadioButton("Theo tháng");
		rdTheoThangMT.setBackground(new Color(204, 255, 204));
		rdTheoThangMT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdTheoThangMT.setBounds(174, 86, 94, 23);
		panel_3.add(rdTheoThangMT);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(268, 86, 98, 20);
		panel_3.add(monthChooser);
		
		JRadioButton rdTheoNamMT = new JRadioButton("Theo năm");
		rdTheoNamMT.setBackground(new Color(204, 255, 204));
		rdTheoNamMT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdTheoNamMT.setBounds(454, 86, 85, 23);
		panel_3.add(rdTheoNamMT);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(558, 86, 47, 20);
		panel_3.add(yearChooser);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(111, 144, 619, 196);
		panel_3.add(scrollPane_2);
		
		
		dtmMT=new DefaultTableModel(
				new Object[][] {
					{null,null, null, null, null, null},
				},
				new String[] {
					"Ngày||Tháng","Số lượt mượn", "Số sách mượn", "Số tiền coc", "Số sách trả", "S\u1ED1 ti\u1EC1n ph\u1EA1t"
				}
			);
		table_2 = new JTable();
		table_2.setModel(dtmMT);
		scrollPane_2.setViewportView(table_2);
		
		JButton btnExportfiel = new JButton("ExportFiel");
		btnExportfiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel(table_2);
			}
		});
		btnExportfiel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExportfiel.setBounds(612, 361, 107, 43);
		panel_3.add(btnExportfiel);
		
		JButton btnNewButton_1 = new JButton("Thống kê");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<thongke> list=new ArrayList<thongke>();
				if(rdTuNgayMT.isSelected() && rdDenNgayMT.isSelected()){
					Date d1= dinhDangNgay(dateTuMT.getDate());
					Date d2=dinhDangNgay(dateDenMT.getDate());
					list=connect.ThongKe.thongketheoNgay(d1, d2);
					loadSL(list);
				}
				else if(rdTheoThangMT.isSelected()){
					int month=monthChooser.getMonth();
					System.out.println(month);
					list=connect.ThongKe.thongketheothang(month+1);
					loadSL(list);
				}
				else if(rdTheoNamMT.isSelected()){
					dtmMT.setRowCount(0);
					int year=yearChooser.getYear();
					System.out.println(year);
					list=connect.ThongKe.thongketheoNam(year);
					for(thongke d:list){
						Vector<Object> vec=new Vector<Object>();
						vec.add(d.getThang());
						vec.add(d.getSoLM());
						vec.add(d.getSoSM());
						vec.add(d.getSoST());
						vec.add(d.getTienCoc());
						vec.add(d.getTienPhat());
						dtmMT.addRow(vec);
					}
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(733, 63, 114, 43);
		panel_3.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 255, 204));
		tabbedPane.addTab("Thống kê chi tiết", null, panel_4, null);
		panel_4.setLayout(null);
		
		dtmTK=new DefaultTableModel(
				new Object[][] {
					{ null, null, null, null, null},
				},
				new String[] {
					"M\u00E3 \u0111\u1ED9c gi\u1EA3", "T\u00EAn \u0111\u1ED9c gi\u1EA3", "S\u1ED1 l\u01B0\u1EE3t m\u01B0\u1EE3n", "S\u1ED1 s\u00E1ch m\u01B0\u1EE3n", "S\u1ED1 s\u00E1ch tr\u1EA3"
				}
			);
		
		JRadioButton rdDG_CT = new JRadioButton("Độc giả");
		rdDG_CT.setBackground(new Color(204, 255, 204));
		rdDG_CT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdDG_CT.setBounds(118, 26, 109, 23);
		panel_4.add(rdDG_CT);
		
		JRadioButton rdS_CT = new JRadioButton("Sách");
		rdS_CT.setBackground(new Color(204, 255, 204));
		rdS_CT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdS_CT.setBounds(118, 64, 109, 23);
		panel_4.add(rdS_CT);
		
		JRadioButton rdThang_CT = new JRadioButton("Thống kê theo tháng");
		rdThang_CT.setBackground(new Color(204, 255, 204));
		rdThang_CT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdThang_CT.setBounds(331, 26, 155, 23);
		panel_4.add(rdThang_CT);
		
		JRadioButton rdNam_CT = new JRadioButton("Thống kê theo năm");
		rdNam_CT.setBackground(new Color(204, 255, 204));
		rdNam_CT.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdNam_CT.setBounds(331, 64, 144, 23);
		panel_4.add(rdNam_CT);
		
		JMonthChooser monthChooser_1 = new JMonthChooser();
		monthChooser_1.setBounds(492, 26, 98, 20);
		panel_4.add(monthChooser_1);
		
		JYearChooser yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(490, 67, 47, 20);
		panel_4.add(yearChooser_1);
		
		JButton btnNewButton_2 = new JButton("Thống kê");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<thongke> list=new ArrayList<thongke>();
				if(rdDG_CT.isSelected() && rdThang_CT.isSelected()){
					int month=monthChooser_1.getMonth();
					table_3.setModel(dtmTK);
					list=connect.ThongKe.thongketheoCTthang(month+1);
					System.out.println(month);
					loadCT(list);
				}
				else if(rdDG_CT.isSelected()&& rdNam_CT.isSelected()){
					table_3.setModel(dtmTK);
					table_3.removeAll();
					int year=yearChooser_1.getYear();
					list=connect.ThongKe.thongketheoCTnam(year);
					loadCT(list);
				}
				else if(rdS_CT.isSelected() && rdThang_CT.isSelected()){
					table_3.removeAll();
					dtmTK=new DefaultTableModel(
							new Object[][] {
								{ null, null, null},
							},
							new String[] {
								"Mã sách", "Tên sách", "Số lượt mượn"
							}
						);
					table_3.setModel(dtmTK);
					int month=monthChooser_1.getMonth();
					list=connect.ThongKe.thongketheoCTSthang(month+1);
					loadCTS(list);
				}
				else if(rdS_CT.isSelected() && rdNam_CT.isSelected()){
					dtmTK.setRowCount(0);
					table_3.removeAll();
				
					int year=yearChooser_1.getYear();
					Calendar c=Calendar.getInstance();
					int yearNow=c.get(Calendar.YEAR);
					int monthNow=c.get(Calendar.MONTH);
					
					dtmTK=new DefaultTableModel(
							new Object[][] {
								{ null, null, null,null, null, null,null, null, null,null, null, null,null,null},
							},
							new String[] {
								"Mã sách", "Tên sách", "T 1","T2","T 3","T 4","T 5","T 6","T 7","T 8","T 9","T 10","T 11","T 12",
							}
						);
					table_3.setModel(dtmTK);
					ArrayList<Sach> ls=new ArrayList<Sach>();
					ls=connect.ThongKe.thongKeToanSach();
					int a=1;
					
					for(Sach s:ls){
						Vector<Object> vec=new Vector<Object>();
						vec.add(a++);
						vec.add(s.getTenSach());
						dtmTK.addRow(vec);
						}
					
					if(year<yearNow){
						for(int month=1;month<=12;month++){
							ArrayList<thongke> tk=new ArrayList<thongke>();
							tk=connect.ThongKe.thongketheoCTSnam(month+1, year);
							if(tk!=null){
							for(thongke l:tk){
								int q=0;
								for(int b=1+q;b<=ls.size();b++){
									if(b==l.getTienCoc()){
											dtmTK.setValueAt(l.getSoLM(),b,month+2);
											q=1;
										}					
								}
							}
						}
							
						}
					}
					else{
						for(int month=1;month<=monthNow;month++){
							ArrayList<thongke> tk=new ArrayList<thongke>();
							tk=connect.ThongKe.thongketheoCTSnam(month+1, year);
							if(tk!=null){
							for(thongke l:tk){
								int q=0;
								for(int b=1+q;b<=ls.size();b++){
									if(b==l.getTienCoc()){
											dtmTK.setValueAt(l.getSoLM(),b,month+2);
											q=1;
										}					
								}
							
							}			
						}
							
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Chưa có chức năng này" );
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(692, 38, 98, 36);
		panel_4.add(btnNewButton_2);
		
		
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(85, 114, 705, 206);
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
		
		
		scrollPane_3.setViewportView(table_3);
		
		JButton btnNewButton_3 = new JButton("Export File");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					exportExcel(table_3);
				}
				
			
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(681, 357, 109, 36);
		panel_4.add(btnNewButton_3);
	}
}
