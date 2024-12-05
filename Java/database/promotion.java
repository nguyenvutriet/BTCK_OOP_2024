package database;

import java.sql.Date;

public class promotion {
	private int MaKM;
	private String NoiDung;
	private Date ThoiGianBatDau;
	private Date ThoiGianKetThuc;
	private String DoiTuongApDung;
	private double MucGiamGia;
	public promotion(int maKM, String noiDung, Date thoiGianBatDau, Date thoiGianKetThuc, String doiTuongApDung,
			double mucGiamGia) {
		MaKM = maKM;
		NoiDung = noiDung;
		ThoiGianBatDau = thoiGianBatDau;
		ThoiGianKetThuc = thoiGianKetThuc;
		DoiTuongApDung = doiTuongApDung;
		MucGiamGia = mucGiamGia;
	}
	public int getMaKM() {
		return MaKM;
	}
	public void setMaKM(int maKM) {
		MaKM = maKM;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public Date getThoiGianBatDau() {
		return ThoiGianBatDau;
	}
	public void setThoiGianBatDau(Date thoiGianBatDau) {
		ThoiGianBatDau = thoiGianBatDau;
	}
	public Date getThoiGianKetThuc() {
		return ThoiGianKetThuc;
	}
	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		ThoiGianKetThuc = thoiGianKetThuc;
	}
	public String getDoiTuongApDung() {
		return DoiTuongApDung;
	}
	public void setDoiTuongApDung(String doiTuongApDung) {
		DoiTuongApDung = doiTuongApDung;
	}
	public double getMucGiamGia() {
		return MucGiamGia;
	}
	public void setMucGiamGia(double mucGiamGia) {
		MucGiamGia = mucGiamGia;
	}
	@Override
	public String toString() {
		return "promotion [MaKM=" + MaKM + ", NoiDung=" + NoiDung + ", ThoiGianBatDau=" + ThoiGianBatDau
				+ ", ThoiGianKetThuc=" + ThoiGianKetThuc + ", DoiTuongApDung=" + DoiTuongApDung + ", MucGiamGia="
				+ MucGiamGia + "]";
	}
}
