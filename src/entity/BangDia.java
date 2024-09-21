package entity;

import java.util.Objects;

public class BangDia {
	private String maBangDia;
	private String tenBangDia;
	private String theLoai;
	private String tinhTrang;
	private String hangSanXuat;
	private String ghiChu;
	
	public BangDia() {
		// TODO Auto-generated constructor stub
	}
	
	public BangDia(String maBangDia, String tenBangDia, String theLoai, String tinhTrang, String hangSanXuat,
			String ghiChu) {
		super();
		this.maBangDia = maBangDia;
		this.tenBangDia = tenBangDia;
		this.theLoai = theLoai;
		this.tinhTrang = tinhTrang;
		this.hangSanXuat = hangSanXuat;
		this.ghiChu = ghiChu;
	}

	public String getMaBangDia() {
		return maBangDia;
	}
	public void setMaBangDia(String maBangDia) {
		this.maBangDia = maBangDia;
	}
	public String getTenBangDia() {
		return tenBangDia;
	}
	public void setTenBangDia(String tenBangDia) {
		this.tenBangDia = tenBangDia;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maBangDia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangDia other = (BangDia) obj;
		return Objects.equals(maBangDia, other.maBangDia);
	}
	
	
	

}
