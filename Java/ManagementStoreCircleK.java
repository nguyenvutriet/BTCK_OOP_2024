package mypack;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import database.JDBCUtil;
import database.category;
import database.customer;
import database.employee;
import database.feedback;
import database.invoice;
import database.job_title;
import database.product;
import database.promotion;
import database.supplier;
import database.user_account;

public class ManagementStoreCircleK {
	public static void main(String[] args) {
		try {
			//Bước 1: tạo kết nối
			Connection connection = new JDBCUtil().getConnection();
			System.out.println("Connection database Completed");
			
			//Bước 2 tạo đối tượng statement
			Statement st = connection.createStatement();
			
			//Bước 3: Thực thi câu lệnh sql
			//1. Bảng category
			List<category> Category = new ArrayList<category>();
			String table_category = "SELECT * FROM Category";
			ResultSet rs = st.executeQuery(table_category);
			while(rs.next()) {
				int maNhom = rs.getInt("MaNhom");
				String tenNhom = rs.getString("TenNhom");
				Category.add(new category(maNhom, tenNhom));
			}
			//2. Bảng Customer 
			List<customer> Customer = new ArrayList<customer>();
			String table_customer = "SELECT * FROM Customer";
			ResultSet rs_customer = st.executeQuery(table_customer);
			while(rs_customer.next()) {
				int makh = rs_customer.getInt("MaKH");
				String hoten = rs_customer.getString("HoTen");
				String sdt = rs_customer.getString("SDT");
				int solanmua = rs_customer.getInt("SoLanMua");
				Customer.add(new customer(makh, hoten, sdt, solanmua));
			}
			//3. Bảng Employee
			List<employee> Employee = new ArrayList<employee>();
			String table_employee = "SELECT * FROM Employee";
			ResultSet rs_employee = st.executeQuery(table_employee);
			while(rs_employee.next()) {
				int manv = rs_employee.getInt("MaNV");
				String hoten = rs_employee.getString("HoTen");
				String gioitinh = rs_employee.getString("GioiTinh");
				Date ngaysinh = rs_employee.getDate("NgaySinh");
				String diachi = rs_employee.getString("DiaChi");
				int macv = rs_employee.getInt("MaCV");
				Employee.add(new employee(manv, hoten, gioitinh, ngaysinh, diachi, diachi, macv));
			}
			//4. Bảng feedback
			List<feedback> Feedback = new ArrayList<feedback>();
			String table_feedback = "SELECT * FROM Feedback";
			ResultSet re_feedback = st.executeQuery(table_feedback);
			while(re_feedback.next()) {
				int maph = re_feedback.getInt("MaPH");
				int makh = re_feedback.getInt("MaKH");
				Date ngayphaihoi = re_feedback.getDate("NgayPhanHoi");
				String noidung = re_feedback.getString("NoiDung");
				int sodiemdanhgia = re_feedback.getInt("SoDiemDanhGia");
				Feedback.add(new feedback(maph, makh, ngayphaihoi, noidung, sodiemdanhgia));
			}
			//5. Bảng Invoice
			List<invoice> Invoice = new ArrayList<invoice>();
			String table_invoice = "SELECT * FROM Invoice";
			ResultSet rs_invoice = st.executeQuery(table_invoice);
			while(rs_invoice.next()) {
				int mahd = rs_invoice.getInt("MaHD");
				int makh = rs_invoice.getInt("MaKH");
				Date ngaylap = rs_invoice.getDate("NgayLap");
				double tongsotien = rs_invoice.getDouble("TongSoTien");
				Invoice.add(new invoice(mahd, makh, ngaylap, tongsotien));
			}
			//6. Bảng Job_Title
			List<job_title> Job_Title = new ArrayList<job_title>();
			String table_jobtitle = "SELECT * FROM Job_Title";
			ResultSet rs_jobtitle = st.executeQuery(table_jobtitle);
			while(rs_jobtitle.next()) {
				int macv = rs_jobtitle.getInt("MaCV");
				String tencv = rs_jobtitle.getString("TenCV");
				Job_Title.add(new job_title(macv, tencv));
			}
			//7. Bảng Product
			List<product> Product = new ArrayList<product>();
			String table_product = "SELECT * FROM Product";
			ResultSet rs_product = st.executeQuery(table_product);
			while(rs_product.next()) {
				int masp = rs_product.getInt("MaSP");
				String tensp = rs_product.getString("TenSP");
				double dongia = rs_product.getDouble("DonGia");
				Date hansudung = rs_product.getDate("HanSuDung");
				String noisanxuat = rs_product.getString("NoiSanXuat");
				int manhom = rs_product.getInt("MaNhom");
				int mancc = rs_product.getInt("MaNCC");
				Product.add(new product(masp, tensp, dongia, hansudung, noisanxuat, manhom, mancc));
			}
			//8. Bảng Promotion 
			List<promotion> Promotion = new ArrayList<promotion>();
			String table_promotion = "SELECT * FROM Promotion";
			ResultSet rs_promotion = st.executeQuery(table_promotion);
			while(rs_promotion.next()) {
				int makm = rs_promotion.getInt("MaKM");
				String noidung = rs_promotion.getString("NoiDung");
				Date thoigianbatdau = rs_promotion.getDate("ThoiGianBatDau");
				Date thoigianketthuc = rs_promotion.getDate("ThoiGianKetThuc");
				String doituongapdung = rs_promotion.getString("DoiTuongApDung");
				double mucgiamgia = rs_promotion.getDouble("MucGiamGia");
				Promotion.add(new promotion(makm, noidung, thoigianbatdau, thoigianketthuc, doituongapdung, mucgiamgia));
			}
			//9. Supplier
			List<supplier> Supplier = new ArrayList<supplier>();
			String table_supplier = "SELECT * FROM Supplier";
			ResultSet rs_supplier = st.executeQuery(table_supplier);
			while(rs_supplier.next()) {
				int mancc = rs_supplier.getInt("MaNCC");
				String tenncc = rs_supplier.getString("TenNCC");
				String diacchi = rs_supplier.getString("DiaChi");
				String sdt = rs_supplier.getString("SDT");
				String email = rs_supplier.getString("Email");
				Supplier.add(new supplier(mancc, tenncc, diacchi, sdt, email));
			}
			//10. User_Account
			List<user_account> User_Account = new ArrayList<user_account>();
			String table_useraccount = "SELECT * FROM User_Account";
			ResultSet rs_useraccount = st.executeQuery(table_useraccount);
			while(rs_useraccount.next()) {
				String tendangnhap = rs_useraccount.getString("TenDangNhap");
				String matkhau = rs_useraccount.getString("MatKhau");
				User_Account.add(new user_account(tendangnhap, matkhau));
			}
			
			//Bước 4: Xử lý các truy vấn. 
			//20 câu lệnh java lambada 
			//1. Lấy ra thông tin nhân viên của Circle K (tên, giới tính, ngày sáng năm sinh, địa chỉ ở)
			System.out.println("Cau 1: Thong tin nhan vien.");
			Employee.forEach(e -> System.out.println("Ho ten: " + e.getHoTen() + "- Gioi tinh: " + e.getGioiTinh() + "- Ngay sinh: " + e.getNgaySinh() + "- Dia chi: " + e.getDiaChi()));
			System.out.println("---------------------------------------------------");
			//2. Tìm nhân viên bán hàng
			System.out.println("Cau 2: Nhan vien ban hang.");
			//nhân viên bán hàng có MaCV = 1;
			int nhanvienbanhang = 1;
			Employee.stream()
					.filter(e -> e.getMaCV() == nhanvienbanhang)
					.forEach(s -> System.out.println(s.getHoTen()));
			System.out.println("---------------------------------------------------");
			//3. lấy ra tên và số điện thoại của khách hàng có số lượt mua trên 5
			System.out.println("Cau 3: Tim khach hang co so lan mua tren 5.");
			Customer.stream()
					.filter(c -> c.getSoLanMua() > 5)
					.forEach(c -> System.out.println(c.getHoTen() + " - " + c.getSDT()));
			System.out.println("---------------------------------------------------");
			//4. lấy ra lời phản hồi của khách hàng có mã khách hàng là 3 và lượt đánh giá từ 4 sao 
			System.out.println("Cau 4: MaKH = 3 va danh gia tu 4 sao .");
			Feedback.stream()
			  		.filter(f -> f.getMaKH() == 3 && f.getSoDiemDanhGia() >= 4)	
					.forEach(f -> System.out.println(f.getNgayPhanHoi() + " - " + f.getNoiDung()));
			System.out.println("---------------------------------------------------");
			//5. Lấy tên của khách hàng đã đánh giá 5 sao
			System.out.println("Cau 5: Ten khach hang danh gia 5 sao:");
			Feedback.stream()
			        .filter(f -> f.getSoDiemDanhGia() == 5) 
			        .flatMap(f -> Customer.stream() 
			                               .filter(c -> c.getMaKH() == f.getMaKH()) 
			                               .map(c -> new String[]{c.getHoTen(), c.getSDT()})) 
			        .distinct() 
			        .forEach(c -> System.out.println(c[0] + " - " + c[1])); 
			System.out.println("---------------------------------------------------");
			//6. In ra những hóa đơn kèm theo tên của người mua 
			System.out.println("Cau 6: Ten va so tien:");
			Invoice.stream()
			       .map(i -> new Object[]{i.getMaKH(), i.getTongSoTien()}) 
			       .forEach(i -> {          
				       Customer.stream()
				               .filter(c -> c.getMaKH() == (int) i[0]) 
				               .map(cs -> cs.getHoTen()) 
				               .forEach(h ->{
				            	   System.out.println(h + " - " + i[1]);
				               	});
			       });
			System.out.println("---------------------------------------------------");
			//7.tìm những sản phẩm của Vinamilk có đơn giá trên 25000
			System.out.println("Cau 7: San pham cua Vinamilk co don gia tren 25000");
			Supplier.stream()
			        .filter(s -> s.getTenNCC().equals("Vinamilk")) 
			        .map(s -> s.getMaNCC()) 
			        .forEach(ma -> {
			            Product.stream()
			                   .filter(p -> p.getMaNCC() == ma && p.getDonGia() > 25000)
			                   .forEach(p -> {
			                       System.out.println(p.getTenSP() + " - " + p.getDonGia());
			                   });
			        });
			System.out.println("---------------------------------------------------");
			// 8. Đếm số lượng nhân viên trong Circle K
			System.out.println("Cau 8: So luong nhan vien trong Circle K");
			long soluongnhanvien = Employee.stream().count(); 
			System.out.println(soluongnhanvien);
			System.out.println("---------------------------------------------------");
			//9. Tính tổng sản phẩm của mỗi nhà cung cấp
			System.out.println("Cau 9: Tong san pham cua moi nha cung cap");
			Map<Integer, Long> tongsanpham = Product.stream()
			    .collect(Collectors.groupingBy(p -> Integer.valueOf(p.getMaNCC()), Collectors.counting())); 
			tongsanpham.forEach((maNCC, tong) -> {
			    Supplier.stream()
			        .filter(s -> s.getMaNCC() == maNCC) 
			        .forEach(s -> System.out.println(s.getTenNCC() + " - " + tong));
			});
			System.out.println("---------------------------------------------------");
			//10. Tính tổng số tiền trung bình của các khách hàng
			System.out.println("Cau 10: Tinh tong so tien trung binh cua cac khach hang: ");
			double tongInvoice = Invoice.stream()
			    .mapToDouble(i -> i.getTongSoTien()).sum();  
			long soLuongKhachHang = Customer.stream().count();  
			System.out.println(tongInvoice / soLuongKhachHang);
			System.out.println("---------------------------------------------------");
			//11. Lấy ra những phiếu khuyến mãi được áp dụng trong thời gian hiện tại
			System.out.println("Cau 11: khuyen mai dang dien ra");
			java.util.Date currentDate = new java.util.Date();
			Promotion.stream()
			    .filter(pm -> !pm.getThoiGianBatDau().after(currentDate) && !pm.getThoiGianKetThuc().before(currentDate))
			    .forEach(pm -> System.out.println(pm.getMaKM() + " - "+ pm.getNoiDung() + " - " + pm.getMucGiamGia()));
			System.out.println("---------------------------------------------------");
			//12. Tìm sản phẩm hết hạn trong 30 ngày tính từ ngày thời điểm hiện tại
			System.out.println("Cau 12: San pham het han trong 30 ngay");
			java.util.Date today = new java.util.Date();
			Product.stream()
			    .filter(p -> p.getHanSuDung().before(new java.sql.Date(today.getTime() + (30L * 24 * 60 * 60 * 1000))))
			    .forEach(p -> System.out.println(p.getTenSP() + " - " + p.getHanSuDung() + " - " + p.getNoiSanXuat()));
			System.out.println("---------------------------------------------------");
			//13. Với mỗi Tên Công việc lấy ra tên của từng nhân viên trong đó
			System.out.println("Cau 13: Lay ra nhan vien cua tung cong viec");
			Job_Title.stream()
		    .forEach(job -> {
		        System.out.println(job.getTenCV() + ": ");
		        Employee.stream()
		            .filter(e -> e.getMaCV() == job.getMaCV())  
		            .forEach(e -> System.out.println(e.getHoTen()));  
		    });
			System.out.println("---------------------------------------------------");
			//14. Tính tổng đơn giá của các sản phẩm của mỗi nhà cung cấp
	        System.out.println("Cau 14: Don gia cua nha cung cap.");
	        Map<Integer, Double> tongdongia = Product.stream()
	            .collect(Collectors.groupingBy(
	            		p -> Integer.valueOf(p.getMaNCC()), 
	                Collectors.summingDouble(p -> p.getDonGia()) 
	            ));
	        Supplier.forEach(s -> {
	            Double tonggia = tongdongia.get(s.getMaNCC());
	            if (tonggia != null) {
	                System.out.println(s.getTenNCC() + " - " + tonggia);
	            }
	        });
	        System.out.println("---------------------------------------------------");
		    //15. Lấy ra sản phẩm thuộc nhóm "Đồ uống" và sắp xếp theo đơn giá giảm dần
		    System.out.println("Câu 15: San pham đo uong.");
		    Product.stream()
		         .filter(p -> Category.stream()
		                                    .anyMatch(ca -> ca.getMaNhom() == p.getMaNhom() && ca.getTenNhom().equals("Đo uong")))
		         .sorted((p1, p2) -> Double.compare(p2.getDonGia(), p1.getDonGia()))  
		         .forEach(p -> System.out.println(p.getTenSP() + " - " + p.getDonGia()));
		    System.out.println("---------------------------------------------------");
		    //16. lấy ra sản phẩm thuộc nhóm đồ ăn và sắp xếp theo đơn giá tăng dần
		    System.out.println("Câu 16: San pham do an.");
		    Product.stream()
	         .filter(p -> Category.stream()
	                                    .anyMatch(ca -> ca.getMaNhom() == p.getMaNhom() && ca.getTenNhom().equals("Đo an")))
	         .sorted((p1, p2) -> Double.compare(p1.getDonGia(), p2.getDonGia()))  
	         .forEach(p -> System.out.println(p.getTenSP() + " - " + p.getDonGia()));
		    System.out.println("---------------------------------------------------");
		    //17. Lấy ra thông tin khách hàng đã đánh giá và sắp xếp tăng dần theo số lần mua
		    System.out.println("Cau 17: Thong tin khach hang danh gia va sap xep theo so lan mua");
		    Feedback.stream()
		    .filter(f -> f.getSoDiemDanhGia() != null)  
		    .flatMap(f -> Customer.stream()  
		        .filter(c -> c.getMaKH() == f.getMaKH()) 
		        .map(c -> new Object[]{c.getHoTen(), c.getSoLanMua(), f.getNoiDung() }) 
		    )
		    .sorted((p1, p2) -> {
		    	Integer soLanMua1 = (Integer) p1[1];
		        Integer soLanMua2 = (Integer) p2[1];
		        return Integer.compare(soLanMua1, soLanMua2);
		    })
		    .forEach(tt -> System.out.println(tt[0] + " - " + tt[1] + " - " + tt[2]));  
		    System.out.println("---------------------------------------------------");
		    //18. lấy ra thông tin khách hàng không đánh giá của hàng Circle K
		    System.out.println("Cau 18: Thong tin khach hang chua danh gia Circle K.");
	        Customer.stream()
	                .filter(c -> Feedback.stream()
	                        .noneMatch(f -> f.getMaKH() == c.getMaKH() && f.getSoDiemDanhGia() != null))
	                .collect(Collectors.toList())
	        .forEach(c -> 
	                System.out.println(c.getHoTen() + " - " + c.getSDT()));
	        System.out.println("---------------------------------------------------");
	        // 19. Lấy ra thông tin khách hàng mua đơn dưới 100.000 kèm theo lời phản hồi
	        System.out.println("Cau 19: Thong tin khach hang mua duoi 100000 va kem theo loi phan hoi");
	        Invoice.stream()
	            .filter(i -> i.getTongSoTien() < 100000) 
	            .collect(Collectors.groupingBy(i -> i.getMaKH(), Collectors.summingDouble(i -> i.getTongSoTien()))) 
	            .entrySet().stream()
	            .flatMap(en -> Customer.stream()
	                .filter(c -> c.getMaKH() == en.getKey()) 
	                .flatMap(c -> Feedback.stream()
	                    .filter(f -> f.getMaKH() == c.getMaKH()) 
	                    .map(f -> new Object[]{c.getHoTen(), f.getNoiDung(), en.getValue()}))) 
	            		.forEach(r -> System.out.println(r[0] + " - " + r[1] + " - " + r[2]));
	        System.out.println("---------------------------------------------------");
	        // 20. Tính tổng số tiền của các hóa đơn theo khách hàng và sắp xếp theo thứ tự giảm dần của tổng tiền
	        System.out.println("Cau 20: Tong tien hoa don theo khach hang duoc sap xep giam dan");
	        Map<Integer, Double> tongTienTheoKhachHang = Invoice.stream()
	            .collect(Collectors.groupingBy(
	                i -> i.getMaKH(), 
	                Collectors.summingDouble(i -> i.getTongSoTien())
	            ));
	        tongTienTheoKhachHang.entrySet().stream()
	            .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()) 
	            .forEach(en -> {
	                int maKH = en.getKey();
	                double tongTien = en.getValue();
	                	                Customer.stream()
	                    .filter(c -> c.getMaKH() == maKH)
	                    .forEach(c -> {
	                        System.out.println(c.getHoTen() + " - " + c.getSDT() + " - " + tongTien);
	                    });
	            });
	        System.out.println("-----------------------------------------------");





			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//Bước 5: Đóng kết nối 
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
