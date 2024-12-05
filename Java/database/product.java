package database;

import java.sql.Date;

public class product {
	private int MaSP;
	private String TenSP;
	private double DonGia;
	private Date HanSuDung;
	private String NoiSanXuat;
	private int MaNhom;
	private int MaNCC;
	public product(int maSP, String tenSP, double donGia, Date hanSuDung, String noiSanXuat, int maNhom, int maNCC) {
		MaSP = maSP;
		TenSP = tenSP;
		DonGia = donGia;
		HanSuDung = hanSuDung;
		NoiSanXuat = noiSanXuat;
		MaNhom = maNhom;
		MaNCC = maNCC;
	}
	public int getMaSP() {
		return MaSP;
	}
	public void setMaSP(int maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public Date getHanSuDung() {
		return HanSuDung;
	}
	public void setHanSuDung(Date hanSuDung) {
		HanSuDung = hanSuDung;
	}
	public String getNoiSanXuat() {
		return NoiSanXuat;
	}
	public void setNoiSanXuat(String noiSanXuat) {
		NoiSanXuat = noiSanXuat;
	}
	public int getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(int maNhom) {
		MaNhom = maNhom;
	}
	public int getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}
	@Override
	public String toString() {
		return "product [MaSP=" + MaSP + ", TenSP=" + TenSP + ", DonGia=" + DonGia + ", HanSuDung=" + HanSuDung
				+ ", NoiSanXuat=" + NoiSanXuat + ", MaNhom=" + MaNhom + ", MaNCC=" + MaNCC + "]";
	}
}
