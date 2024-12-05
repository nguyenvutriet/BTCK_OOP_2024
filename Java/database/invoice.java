package database;

import java.sql.Date;

public class invoice {
	private int MaHD;
	private int MaKH;
	private Date NgayLap;
	private double TongSoTien;
	public invoice(int maHD, int maKH, Date ngayLap, double tongSoTien) {
		MaHD = maHD;
		MaKH = maKH;
		NgayLap = ngayLap;
		TongSoTien = tongSoTien;
	}
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public Date getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}
	public double getTongSoTien() {
		return TongSoTien;
	}
	public void setTongSoTien(double tongSoTien) {
		TongSoTien = tongSoTien;
	}
	@Override
	public String toString() {
		return "invoice [MaHD=" + MaHD + ", MaKH=" + MaKH + ", NgayLap=" + NgayLap + ", TongSoTien=" + TongSoTien + "]";
	}
}
