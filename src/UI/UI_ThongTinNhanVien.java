package UI;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.dao_khachhang;
import dao.dao_nhanvien;
import connectDB.ConnectDB;
public class UI_ThongTinNhanVien extends JPanel  implements ActionListener{
	DefaultTableModel modeltable;
	JTable table;
	JTextField txtTim;
	JButton btnTim, btnThem, btnSua, btnLoad, btnThoat;
	UI_KhachHang ui;
	public UI_ThongTinNhanVien() {
		
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//setBackground(Color.YELLOW);
		setLayout(new BorderLayout());
		
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Nhân Viên");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		
		String[] chuoi = {"Mã nhân viên","Tên nhân viên","Số điện thoại","Email","CMND","Địa chỉ","tinh trang","Ngày vào làm"};
		modeltable = new DefaultTableModel(chuoi,0);
		table = new JTable(modeltable);
		JScrollPane sc = new JScrollPane(table);
		add(sc,BorderLayout.CENTER);
		
		//SOUTH
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		add(pnSouth,BorderLayout.SOUTH);
	
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		pnRight.setPreferredSize(new Dimension(400,0));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		
			//LEFT
		//Nam - 2-6
		JLabel lblTim = new JLabel("Tìm kiếm");
		pnLeft.add(lblTim);
		txtTim = new JTextField(10);
		btnTim = new JButton("Tìm kiếm");
		pnLeft.add(txtTim);
		pnLeft.add(btnTim);
			//RIGHT
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/add.png"));
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("Icon/sua.png"));
		btnLoad = new JButton("Load");
		btnLoad.setIcon(new ImageIcon("Icon/open1.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		pnRight.add(btnThem);
		pnRight.add(btnSua);
		pnRight.add(btnLoad);
		pnRight.add(btnThoat);
		pnSouth.add(sp);
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLoad.addActionListener(this);
		btnThoat.addActionListener(this);
		
	
	txtTim.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(txtTim.getText().length()==0) {
				try {
					loadNV();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(txtTim.getText().length()>0) {
				try {
					timNV();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	});
	try {
		loadNV();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_ThongTinNhanVien frame = new UI_ThongTinNhanVien();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	protected void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			new UI_NhanVien().setVisible(true);
		}
		else if(o.equals(btnSua)) {
			new UI_NhanVien().setVisible(true);
			
		}
		else if(o.equals(btnThoat)) {
			setVisible(false);
			dispose();
		}
		else if(o.equals(btnLoad)) {
			dao_nhanvien dao_nv = new dao_nhanvien();
			try {
				modeltable= dao_nv.getallNV();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			table.setModel(modeltable);
			
		}
		
		
		
		
	}
	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	private void timNV() throws SQLException{
		dao_nhanvien dao_nv = new dao_nhanvien();
		modeltable = dao_nv.timKiem("%"+txtTim.getText()+"%", "%"+txtTim.getText()+"%");
		table.setModel(modeltable);
	}
	private void loadNV() throws SQLException {
		dao_nhanvien dao_nv = new dao_nhanvien();
		modeltable= dao_nv.getallNV();
		table.setModel(modeltable);
	}

}

