package database;

public class user_account {
	private String TenDangNhap;
	private String MatKhau;
	public user_account(String tenDangNhap, String matKhau) {
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	@Override
	public String toString() {
		return "user_account [TenDangNhap=" + TenDangNhap + ", MatKhau=" + MatKhau + "]";
	}
}
