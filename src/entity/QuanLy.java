package entity;

import java.util.Objects;

public class QuanLy {
	private String maQL;
	private String tenQL;
	private String SDT;
	private String email;
	public QuanLy(String maQL, String tenQL, String sDT, String email) {
		super();
		this.maQL = maQL;
		this.tenQL = tenQL;
		SDT = sDT;
		this.email = email;
	}
	public String getMaQL() {
		return maQL;
	}
	public void setMaQL(String maQL) {
		this.maQL = maQL;
	}
	public String getTenQL() {
		return tenQL;
	}
	public void setTenQL(String tenQL) {
		this.tenQL = tenQL;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maQL);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuanLy other = (QuanLy) obj;
		return Objects.equals(maQL, other.maQL);
	}
	
	
	
}
