package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

//import UI.NhapSuaThongTinTour;
import connectDB.ConnectDB;
import entity.BangDia;
import entity.KhachHang;






public class dao_bangdia {
	public DefaultTableModel getallBD() throws SQLException{
		String[] chuoi = {"Mã Băng đĩa","Tên băng đĩa","thể loại","tình trạng","hãng sản xuất","ghi chú"};
		DefaultTableModel tableModel = new DefaultTableModel(chuoi, 0);
		connectDB.ConnectDB.getInstance();
		Connection con = connectDB.ConnectDB.getConnection();
		String sql = "Select * FROM BangDia"; 
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			
			if(rs.getBoolean(3) == true) {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4),"mới", rs.getString(5), rs.getString(6)};
				tableModel.addRow(o);
			}
			else {
				Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4),"cũ", rs.getString(5), rs.getString(6)};
				tableModel.addRow(o);
			}

			
			
		}
		return tableModel;
	}
	public ArrayList<BangDia> getBangTheoMa(String maBangDia1){
		ArrayList<BangDia> dsBangDia = new ArrayList<BangDia>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from BangDia where maBangDia = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maBangDia1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maBangDia = rs.getString(1);
				String tenBangDia = rs.getString(2);
				String TheLoai = rs.getString(3);
				String TinhTrang = rs.getString(4);
				String hangSX = rs.getString(5);
				String GhiChu = rs.getString(6);
				BangDia bangdia = new BangDia(maBangDia,tenBangDia,TheLoai,TinhTrang,hangSX,GhiChu);
				dsBangDia.add(bangdia);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsBangDia;
		
	}
	

	public ArrayList<BangDia> sapXepGia(String tangGiam,String giaTriSapXep){
		ArrayList<BangDia> dsBangDia = new ArrayList<BangDia>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour  order by "+ giaTriSapXep +" " + tangGiam;
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String maBangDia = rs.getString(1);
				String tenBangDia = rs.getString(2);
				String TheLoai = rs.getString(3);
				String TinhTrang = rs.getString(4);
				String hangSX = rs.getString(5);
				String GhiChu = rs.getString(6);
				BangDia bangdia = new BangDia(maBangDia,tenBangDia,TheLoai,TinhTrang,hangSX,GhiChu);
				dsBangDia.add(bangdia);
			
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsBangDia;
	}
public boolean ThemBangDia(BangDia bangdia) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into BangDia values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, bangdia.getMaBangDia());
			preparedStatement.setString(2, bangdia.getTenBangDia());
			preparedStatement.setString(3, bangdia.getTheLoai());
			preparedStatement.setString(4, bangdia.getTinhTrang());
			preparedStatement.setString(5, bangdia.getHangSanXuat());
			preparedStatement.setString(6, bangdia.getGhiChu());
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0;
	}

	public int LayMaBangDiaLonNhat() {
		int mtln=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from BangDia";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maBangDia = rs.getString(1).substring(3);
				if(mtln<Integer.parseInt(maBangDia)) {
					mtln=Integer.parseInt(maBangDia);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mtln;
	}
	

	public boolean XoaBangDia(String maBD) {
		int k=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from BnagDia where maBangDia = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maBD);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
	private ArrayList<String> tachChuoiTim(String chuoiTim){
		ArrayList<String> chuoiTach = new ArrayList<String>();
		String chuoi = chuoiTim.trim();
		int t=0;
		for(int i =0;i<chuoi.length();i++) {
			if(i==chuoi.length()-1) {
				chuoiTach.add(chuoi.substring(t,i+1));
				break;
			}
			if(chuoi.codePointAt(i)==32) {		
				if(chuoi.substring(t,i).codePointAt(0)!=32)
				{				
					chuoiTach.add(chuoi.substring(t,i));
					t=i+1;
				}	
			}
		}
		
		return chuoiTach;
	}

}
