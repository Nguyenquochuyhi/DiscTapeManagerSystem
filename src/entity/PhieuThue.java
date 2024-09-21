package entity;

import java.util.Date;
import java.util.Objects;


public class PhieuThue {
	private String maPhieuThue;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private Date ngayLap;
	
	public PhieuThue() {
		// TODO Auto-generated constructor stub
	}

	public PhieuThue(String maPhieuThue, NhanVien nhanVien, KhachHang khachHang, Date ngayLap) {
		super();
		this.maPhieuThue = maPhieuThue;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLap = ngayLap;
	}

	public String getMaPhieuThue() {
		return maPhieuThue;
	}

	public void setMaPhieuThue(String maPhieuThue) {
		this.maPhieuThue = maPhieuThue;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuThue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuThue other = (PhieuThue) obj;
		return Objects.equals(maPhieuThue, other.maPhieuThue);
	}
	
	

}
