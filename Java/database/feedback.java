package database;

import java.sql.Date;

public class feedback {
	private int MaPH;
	private int MaKH;
	private Date NgayPhanHoi;
	private String NoiDung;
	private Integer SoDiemDanhGia;
	
	public int getMaPH() {
		return MaPH;
	}

	public void setMaPH(int maPH) {
		MaPH = maPH;
	}

	public int getMaKH() {
		return MaKH;
	}

	public void setMaKH(int maKH) {
		MaKH = maKH;
	}

	public Date getNgayPhanHoi() {
		return NgayPhanHoi;
	}

	public void setNgayPhanHoi(Date ngayPhanHoi) {
		NgayPhanHoi = ngayPhanHoi;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public Integer getSoDiemDanhGia() {
		return SoDiemDanhGia;
	}

	public void setSoDiemDanhGia(Integer soDiemDanhGia) {
		SoDiemDanhGia = soDiemDanhGia;
	}

	public feedback(int maPH, int maKH, Date ngayPhanHoi, String noiDung, Integer soDiemDanhGia) {
		super();
		MaPH = maPH;
		MaKH = maKH;
		NgayPhanHoi = ngayPhanHoi;
		NoiDung = noiDung;
		SoDiemDanhGia = soDiemDanhGia;
	}

	@Override
	public String toString() {
		return "feedback [MaPH=" + MaPH + ", MaKH=" + MaKH + ", NgayPhanHoi=" + NgayPhanHoi + ", NoiDung=" + NoiDung
				+ ", SoDiemDanhGia=" + SoDiemDanhGia + "]";
	}
}
