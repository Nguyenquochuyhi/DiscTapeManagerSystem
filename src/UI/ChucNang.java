package UI;

import java.awt.BorderLayout;
import java.io.IOException;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao.dao_bangdia;
import dao.dao_khachhang;
import dao.dao_nhanvien;


import entity.NhanVien;

public class ChucNang extends JFrame implements ActionListener,MouseListener{
	
	private JPanel pnWest;
	private JButton btnQLKH;
	private JButton btnQLNV;
	private JButton btnQuanLiBangDia;
	private JButton btnQLThue;
	private JButton btnChucNang;
	private JButton btnDangXuat;
	JLabel nButton1,nButton2,nButton3,nButton4, nButton5, nButton6,nButton7,nButton8, nButton9;
	JPanel pnCenter;
	JPanel pnCC;
	JPanel pnQLKH;
	JPanel pnQLBD;
	JPanel pnQLNV;
	JPanel pnQLThongKe;
	JPanel pnQLVe;
	JPanel pnQLDiaDanh;
	JPanel pnHDV;
	JPanel pnDangXuat;
	boolean flag = true;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	dao_nhanvien nhanVien_dao;
	UI_ThongTinNhanVien nv = new UI_ThongTinNhanVien();
	UI_ThongTinKhachHang kh = new UI_ThongTinKhachHang();
	UI_ThongTinBangDia bd = new UI_ThongTinBangDia();
	private JPanel pnTrangChu;
	private JLabel lblLogo;
	private JButton btnTrangChu;
	private JPanel pnThue;
	
	
	public static String maNhanVien;
	
	public ChucNang(String maNV) throws Exception {
	//public ChucNang() {
		setTitle("Chức năng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setSize(1200,700);
		setLocationRelativeTo(null);
		
		maNhanVien = maNV;
		nhanVien_dao = new dao_nhanvien();
		
		pnQLKH= new JPanel();
		pnQLKH = new UI_ThongTinKhachHang();
		pnQLBD = new JPanel();
		pnQLBD = new UI_ThongTinBangDia();
		pnQLNV = new JPanel();
		pnQLNV = new UI_ThongTinNhanVien();
		pnThue = new JPanel();
		pnThue = new QuanLiThueBang();
		pnQLVe = new JPanel();

		pnTrangChu = new JPanel();
		pnTrangChu = new TrangChu();
		
		//North
		JPanel pnNorth = new JPanel();
		
		pnNorth.setLayout(new BorderLayout());
		pnNorth.setBackground(Color.cyan);
		
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(new Color(204, 255, 255));
		pnTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTieuDe = new JLabel("Quản Lý Băng Đĩa");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnTieuDe.add(lblTieuDe);
		
		JPanel pnTTNhanVien = new JPanel();
		pnTTNhanVien.setBackground(new Color(204, 255, 255));
		pnTTNhanVien.setLayout(new GridLayout(2,1));
		JPanel pnMaNV = new JPanel();
		pnMaNV.setBackground(new Color(204, 255, 255));
		JLabel lblMaNV = new JLabel("Mã nhân viên: ");
		txtMaNV = new JTextField(10);
		txtMaNV.setText(maNhanVien);
		txtMaNV.setEditable(false);
		txtMaNV.setOpaque(false);
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);
		JPanel pnTenNV = new JPanel();
		pnTenNV.setBackground(new Color(204, 255, 255));
		JLabel lblTenNV = new JLabel("Tên nhân viên: ");
		txtTenNV = new JTextField(10);
//		txtTenNV.setText(nhanVien_dao.LayNhanVienTheoMa(maNhanVien).getTenNV().toString());
		txtTenNV.setOpaque(false);
		txtTenNV.setEditable(false);
		pnTenNV.add(lblTenNV);
		pnTenNV.add(txtTenNV);
		
		lblMaNV.setPreferredSize(lblTenNV.getPreferredSize());
		pnTTNhanVien.add(pnMaNV);
		pnTTNhanVien.add(pnTenNV);
		pnTTNhanVien.setBackground(Color.CYAN);
		pnNorth.add(pnTTNhanVien,BorderLayout.EAST);
		pnNorth.add(pnTieuDe,BorderLayout.CENTER);
		pnNorth.add(pnTieuDe,BorderLayout.CENTER);
		add(pnNorth,BorderLayout.NORTH);
	
		
		//Center
		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCC = new JPanel();
		pnCenter.add(pnTrangChu);
		add(pnCenter, BorderLayout.CENTER);
		
		//WEST
		pnWest = new JPanel();
		pnWest.setBackground(new Color(204, 255, 255));
		pnWest.setLayout(new BorderLayout());
		JLabel iconLabel = new JLabel(new ImageIcon("Icon/menu.png"));
		btnChucNang = new JButton("");
		btnChucNang.setLayout(new BorderLayout());
		btnChucNang.add(iconLabel,BorderLayout.CENTER);//Vinh 29-5
		btnChucNang.setPreferredSize(new Dimension(50,50));
		btnChucNang.setBackground(new Color(204, 255, 255));
		btnChucNang.setBorderPainted(false);
		btnChucNang.setFocusPainted(false);
		btnChucNang.setContentAreaFilled(false);
		btnChucNang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblLogo = new JLabel(ResizeImage("Icon/sun.png"));
		lblLogo.setPreferredSize(new Dimension(140,50));
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnChucNang.setPreferredSize(pnTTNhanVien.getPreferredSize());
		pnChucNang.add(btnChucNang);
		pnChucNang.add(lblLogo);
		pnChucNang.setBackground(new Color(204, 255, 255));
		pnNorth.add(pnChucNang,BorderLayout.WEST);
		
		JLabel iconLabel1 = new JLabel(new ImageIcon("Icon/qlkh.png"));
		nButton1 = new JLabel("Quản lý khách hàng", SwingConstants.CENTER);
		btnQLKH = new JButton("");
		btnQLKH.setLayout(new BorderLayout());
		btnQLKH.add(iconLabel1,BorderLayout.WEST);
		btnQLKH.add(nButton1,BorderLayout.CENTER);
		
		JLabel iconLabel2 = new JLabel(new ImageIcon("Icon/qlnv2.png"));
		nButton2 = new JLabel("Quản lý nhân viên", SwingConstants.CENTER);
		btnQLNV = new JButton("");
		btnQLNV.setLayout(new BorderLayout());
		btnQLNV.add(iconLabel2,BorderLayout.WEST);
		btnQLNV.add(nButton2,BorderLayout.CENTER);
		

		
		
		JLabel iconLabel4 = new JLabel(new ImageIcon("Icon/qltour.png"));
		nButton4 = new JLabel("Quản lý băng đĩa", SwingConstants.CENTER);
		btnQuanLiBangDia = new JButton("");
		btnQuanLiBangDia.setLayout(new BorderLayout());
		btnQuanLiBangDia.add(iconLabel4,BorderLayout.WEST);
		btnQuanLiBangDia.add(nButton4,BorderLayout.CENTER);
		
		JLabel iconLabel5 = new JLabel(new ImageIcon("Icon/ticket1.png"));
		nButton5 = new JLabel("Thuê băng đĩa", SwingConstants.CENTER);
		btnQLThue = new JButton("");
		btnQLThue.setLayout(new BorderLayout());
		btnQLThue.add(iconLabel5,BorderLayout.WEST);
		btnQLThue.add(nButton5,BorderLayout.CENTER);
		

		

		

		JLabel iconLabel8 = new JLabel(new ImageIcon("Icon/log-out.png"));
		nButton8 = new JLabel("Đăng xuất", SwingConstants.CENTER);
		nButton8.setForeground(Color.WHITE);
		btnDangXuat = new JButton("");
		btnDangXuat.setLayout(new BorderLayout());
		btnDangXuat.add(iconLabel8,BorderLayout.WEST);
		btnDangXuat.add(nButton8,BorderLayout.CENTER);
		JLabel iconLabel9 = new JLabel(new ImageIcon("Icon/house.png"));
		nButton9 = new JLabel("Trang Chủ", SwingConstants.CENTER);
		btnTrangChu = new JButton("");
		btnTrangChu.setLayout(new BorderLayout());
		btnTrangChu.add(iconLabel9,BorderLayout.WEST);
		btnTrangChu.add(nButton9,BorderLayout.CENTER);
		
		
		
		btnChucNang.setBackground(Color.WHITE);
		btnQLKH.setBackground(Color.WHITE);
		btnQLNV.setBackground(Color.WHITE);
		btnQuanLiBangDia.setBackground(Color.WHITE);
		btnQLThue.setBackground(Color.WHITE);
		btnTrangChu.setBackground(Color.WHITE);
		btnDangXuat.setBackground(new Color(255, 51, 0));
		JPanel pnCN = new JPanel();
		pnCN.setBackground(new Color(204, 255, 255));
		pnCN.add(btnTrangChu);
		pnCN.add(btnQLThue);
		pnCN.add(btnQuanLiBangDia);
		pnCN.add(btnQLKH);
		pnCN.add(btnQLNV);

		JPanel pnDX = new JPanel();
		pnDX.add(btnDangXuat);
		pnDX.setBackground(new Color(204, 255, 255));
		pnWest.add(pnCN, BorderLayout.CENTER);
		pnWest.add(pnDX,BorderLayout.SOUTH);
		pnWest.setPreferredSize(new Dimension(200,400));
		btnQLKH.setPreferredSize(new Dimension(180,50));
		btnQLNV.setPreferredSize(btnQLKH.getPreferredSize());
		btnQuanLiBangDia.setPreferredSize(btnQLKH.getPreferredSize());
		btnQLThue.setPreferredSize(btnQLKH.getPreferredSize());
		btnTrangChu.setPreferredSize(btnQLKH.getPreferredSize());
	
		btnDangXuat.setPreferredSize(btnQLKH.getPreferredSize());
		add(pnWest,BorderLayout.WEST);
		
		btnChucNang.addActionListener(this);
		btnQLKH.addActionListener(this);
		btnQuanLiBangDia.addActionListener(this);
		btnQLNV.addActionListener(this);
		btnQLThue.addActionListener(this);
		btnTrangChu.addActionListener(this);
		//Nam
		
		btnDangXuat.addActionListener(this);
		
		
		//btnChucNang.addMouseListener(this);
		btnQLKH.addMouseListener(this);
		btnQuanLiBangDia.addMouseListener(this);
		btnQLNV.addMouseListener(this);
		btnQLThue.addMouseListener(this);
		btnTrangChu.addMouseListener(this);
		lblLogo.addMouseListener(this);
	}

	public static void main(String[] args) throws Exception {
		new ChucNang(maNhanVien).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		//Nam
		if(object.equals(btnQLKH)) {
			try {
				loadKH();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Vinh
			btnQLKH.setBackground(new Color(153, 255, 153));

			btnQLNV.setBackground(Color.WHITE);
			btnQuanLiBangDia.setBackground(Color.WHITE);
			btnQLThue.setBackground(Color.WHITE);
			btnQLThue.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLKH,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
			
		}
		
		else if(object.equals(btnQuanLiBangDia)) {
			try {
				loadBD();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			btnQuanLiBangDia.setBackground(new Color(153, 255, 153));
			btnQLKH.setBackground(Color.WHITE);
			btnQLNV.setBackground(Color.WHITE);
			btnQLThue.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLBD,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		//Nam
		else if(object.equals(btnQLNV)) {
			try {
				loadNV();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Vinh
			btnQLNV.setBackground(new Color(153, 255, 153));
			btnQuanLiBangDia.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnQLThue.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLNV,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		else if(object.equals(btnChucNang)) {
			if (flag == true) {
				pnWest.setPreferredSize(new Dimension(68,400));
				btnQLKH.remove(nButton1);
				btnQLNV.remove(nButton2);
				btnQuanLiBangDia.remove(nButton4);
				btnQLThue.remove(nButton5);
				btnDangXuat.remove(nButton8);
				btnTrangChu.remove(nButton9);
				btnQLKH.setPreferredSize(new Dimension(60,50));
				btnQuanLiBangDia.setPreferredSize(new Dimension(60,50));
				btnQLNV.setPreferredSize(new Dimension(60,50));
				btnQLThue.setPreferredSize(new Dimension(60,50));
				btnDangXuat.setPreferredSize(new Dimension(60,50));
				btnTrangChu.setPreferredSize(new Dimension(60,50));
				pnWest.revalidate();
				flag = false; 
			}
			else if(flag == false){
				pnWest.setPreferredSize(new Dimension(200,400));
				btnQLKH.add(nButton1, BorderLayout.CENTER);
				btnQLNV.add(nButton2,BorderLayout.CENTER);
				btnQuanLiBangDia.add(nButton4,BorderLayout.CENTER);
				btnQLThue.add(nButton5,BorderLayout.CENTER);
				btnDangXuat.add(nButton8, BorderLayout.CENTER);
				btnTrangChu.add(nButton9,BorderLayout.CENTER);
				btnQLKH.setPreferredSize(new Dimension(180,50));
				btnQuanLiBangDia.setPreferredSize(new Dimension(180,50));
				btnQLNV.setPreferredSize(new Dimension(180,50));
				btnQLThue.setPreferredSize(new Dimension(180,50));
				btnDangXuat.setPreferredSize(new Dimension(180,50));
				btnTrangChu.setPreferredSize(new Dimension(180,50));
				pnWest.revalidate();
				flag = true;
			}
		}
		else if(object.equals(btnQLThue)) {
			btnQLThue.setBackground(new Color(153, 255, 153));
			btnQLNV.setBackground(Color.WHITE);
			btnQuanLiBangDia.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnTrangChu.setBackground(Color.WHITE);
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnThue,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		
		else if(object.equals(btnTrangChu)) {
			btnTrangChu.setBackground(new Color(153, 255, 153));
			btnQLNV.setBackground(Color.WHITE);
			btnQuanLiBangDia.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnQLThue.setBackground(Color.WHITE);

			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnTrangChu,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		
		//Nam
		else if(object.equals(btnDangXuat)) {
			
			JFrame f= new JFrame();
			int hoi=JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn đăng xuất?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoi==JOptionPane.YES_OPTION) {
				try {
					DangNhap dn = new DangNhap();
					dn.setVisible(true);
					dispose();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//Vinh
		Object obj = e.getSource();
		 if(obj.equals(lblLogo)) {
			 btnTrangChu.setBackground(Color.CYAN);
				btnQLNV.setBackground(Color.WHITE);
				btnQuanLiBangDia.setBackground(Color.WHITE);
				btnQLKH.setBackground(Color.WHITE);
				btnQLThue.setBackground(Color.WHITE);
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnTrangChu,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(flag==true)
		{
			if(obj.equals(btnQLKH)) {
				btnQLKH.setPreferredSize(new Dimension(200,70));
				btnQLKH.revalidate();
			}
			else if(obj.equals(btnQuanLiBangDia)) {
				btnQuanLiBangDia.setPreferredSize(new Dimension(200,70));
				btnQuanLiBangDia.revalidate();
			}
			
			else if(obj.equals(btnQLNV)) {
				btnQLNV.setPreferredSize(new Dimension(200,70));
				btnQLNV.revalidate();
			}
			else if(obj.equals(btnQLThue)) {
				btnQLThue.setPreferredSize(new Dimension(200,70));
				btnQLThue.revalidate();
			}
			
			//Vinh
			else if(obj.equals(btnTrangChu)) {
				btnTrangChu.setPreferredSize(new Dimension(200,70));
				btnTrangChu.revalidate();
			}
			//Nam
			
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(flag==true) {
			if(obj.equals(btnQLKH)) {
				btnQLKH.setPreferredSize(new Dimension(180,50));
				btnQLKH.revalidate();
			}
			else if(obj.equals(btnQuanLiBangDia)) {
				btnQuanLiBangDia.setPreferredSize(new Dimension(180,50));
				btnQuanLiBangDia.revalidate();
			}
			
			else if(obj.equals(btnQLNV)) {
				btnQLNV.setPreferredSize(new Dimension(180,50));
				btnQLNV.revalidate();
			}
			else if(obj.equals(btnQLThue)) {
				btnQLThue.setPreferredSize(new Dimension(180,50));
				btnQLThue.revalidate();
			}
			
			//Vinh
			else if(obj.equals(btnTrangChu)) {
				btnTrangChu.setPreferredSize(new Dimension(180,50));
				btnTrangChu.revalidate();
			}
			//Nam
			
		}
		
	}
	//Nam
	private void loadNV() throws SQLException {
		dao_nhanvien dao_nv = new dao_nhanvien();
		nv.modeltable= dao_nv.getallNV();
		nv.table.setModel(nv.modeltable);
	}
	private void loadKH() throws SQLException {
		dao_khachhang dao_kh = new dao_khachhang();
		kh.modeltable= dao_kh.getAllKH();
		kh.table.setModel(kh.modeltable);
	}
	private void loadBD() throws SQLException {
		dao_bangdia dao_bd = new dao_bangdia();
		bd.modeltable= dao_bd.getallBD();
		bd.table.setModel(bd.modeltable);
	}
	public ImageIcon ResizeImage(String ImagePath)
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(140, 120, Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
	     return image;
	 }
}