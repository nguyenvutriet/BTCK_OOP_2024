package database;

public class supplier {
	private int MaNCC;
	private String TenNCC;
	private String DiaChi;
	private String SDT;
	private String Email;
	public supplier(int maNCC, String tenNCC, String diaChi, String sDT, String email) {
		MaNCC = maNCC;
		TenNCC = tenNCC;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
	}
	public int getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}
	public String getTenNCC() {
		return TenNCC;
	}
	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "supplier [MaNCC=" + MaNCC + ", TenNCC=" + TenNCC + ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", Email="
				+ Email + "]";
	}
}
