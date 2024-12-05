package database;

import java.sql.Date;

public class employee {
	private int MaNV;
	private String HoTen;
	private String GioiTinh;
	private Date NgaySinh;
	private String DiaChi;
	private String SDT;
	private int MaCV;
	public employee(int maNV, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String sDT, int maCV) {
		MaNV = maNV;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		SDT = sDT;
		MaCV = maCV;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
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
	public int getMaCV() {
		return MaCV;
	}
	public void setMaCV(int maCV) {
		MaCV = maCV;
	}
	@Override
	public String toString() {
		return "employee [MaNV=" + MaNV + ", HoTen=" + HoTen + ", GioiTinh=" + GioiTinh + ", NgaySinh=" + NgaySinh
				+ ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", MaCV=" + MaCV + "]";
	}
}
