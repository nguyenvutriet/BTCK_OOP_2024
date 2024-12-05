package database;

public class job_title {
	private int MaCV;
	private String TenCV;
	public job_title(int maCV, String tenCV) {
		MaCV = maCV;
		TenCV = tenCV;
	}
	public int getMaCV() {
		return MaCV;
	}
	public void setMaCV(int maCV) {
		MaCV = maCV;
	}
	public String getTenCV() {
		return TenCV;
	}
	public void setTenCV(String tenCV) {
		TenCV = tenCV;
	}
	@Override
	public String toString() {
		return "job_title [MaCV=" + MaCV + ", TenCV=" + TenCV + "]";
	}
}
