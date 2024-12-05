package database;

public class customer {
	private int MaKH;
	private String HoTen;
	private String SDT;
	private int SoLanMua;
	public customer(int maKH, String hoTen, String sDT, int soLanMua) {
		MaKH = maKH;
		HoTen = hoTen;
		SDT = sDT;
		SoLanMua = soLanMua;
	}
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public int getSoLanMua() {
		return SoLanMua;
	}
	public void setSoLanMua(int soLanMua) {
		SoLanMua = soLanMua;
	}
	@Override
	public String toString() {
		return "customer [MaKH=" + MaKH + ", HoTen=" + HoTen + ", SDT=" + SDT + ", SoLanMua=" + SoLanMua + "]";
	}
}
