package database;

public class category {
	private int MaNhom;
	private String TenNhom;
	public category(int maNhom, String tenNhom) {
		MaNhom = maNhom;
		TenNhom = tenNhom;
	}
	public int getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(int maNhom) {
		MaNhom = maNhom;
	}
	public String getTenNhom() {
		return TenNhom;
	}
	public void setTenNhom(String tenNhom) {
		TenNhom = tenNhom;
	}
	@Override
	public String toString() {
		return "category [MaNhom=" + MaNhom + ", TenNhom=" + TenNhom + "]";
	}
}
