package entity;

import java.util.Objects;

public class CTPhieuThue {

	private PhieuThue ctPhieuThue;
	private BangDia bangDia;
	private int soLuong;
	private float donGia;
	private int soNgayDuocMuon;
	
	public CTPhieuThue() {
		// TODO Auto-generated constructor stub
	}

	public PhieuThue getCtPhieuThue() {
		return ctPhieuThue;
	}

	public void setCtPhieuThue(PhieuThue ctPhieuThue) {
		this.ctPhieuThue = ctPhieuThue;
	}

	public BangDia getBangDia() {
		return bangDia;
	}

	public void setBangDia(BangDia bangDia) {
		this.bangDia = bangDia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public int getSoNgayDuocMuon() {
		return soNgayDuocMuon;
	}

	public void setSoNgayDuocMuon(int soNgayDuocMuon) {
		this.soNgayDuocMuon = soNgayDuocMuon;
	}

	public CTPhieuThue(PhieuThue ctPhieuThue, BangDia bangDia, int soLuong, float donGia, int soNgayDuocMuon) {
		super();
		this.ctPhieuThue = ctPhieuThue;
		this.bangDia = bangDia;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.soNgayDuocMuon = soNgayDuocMuon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bangDia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTPhieuThue other = (CTPhieuThue) obj;
		return Objects.equals(bangDia, other.bangDia);
	}
	
	
	
}
