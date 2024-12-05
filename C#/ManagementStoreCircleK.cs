using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StoreCircleK
{
    public class ManagementStoreCircleK
    {
        static void Main(string[] args)
        {
            DataClasses1DataContext dcdc = new DataClasses1DataContext();

            //20 Câu lệnh với LinQ
            //1. Lấy ra thông tin nhân viên của Circle K (tên, giới tính, ngày sáng năm sinh, địa chỉ ở)
            Console.WriteLine("Cau 1: Thong tin nhan vien");
            var thongtin = dcdc.EMPLOYEEs.Select(x => new { x.HoTen, x.GioiTinh, x.NgaySinh, x.DiaChi });
            foreach (var t in thongtin)
            {
                Console.WriteLine($"Ten: {t.HoTen}, Gioi Tinh: : {t.GioiTinh}, Ngay Sinh: {t.NgaySinh}, Đia Chi: {t.DiaChi}");
            }
            Console.WriteLine("-----------------------------------------------");
            //2. Tìm nhân viên bán hàng
            Console.WriteLine("Cau 2: Nhan vien ban hang");
            var nhanvienbanhang = dcdc.EMPLOYEEs.Where(x => x.MaCV == 1).Select(x => new { x.HoTen });
            foreach ( var t in nhanvienbanhang)
            {
                Console.WriteLine($"{t.HoTen}");
            }
            Console.WriteLine("-----------------------------------------------");
            //3. lấy ra tên và số điện thoại của khách hàng có số lượt mua trên 5
            Console.WriteLine("Cau 3: tim khach hang co lan mua tren 5: ");
            var khachhang = dcdc.CUSTOMERs.Where(x => x.SoLanMua > 5).Select(x => new { x.HoTen, x.SDT });
            foreach ( var t in khachhang)
            {
                Console.WriteLine($"{t.HoTen} - {t.SDT}");
            }
            Console.WriteLine("-----------------------------------------------");
            //4. lấy ra lời phản hồi của khách hàng có mã khách hàng là 3 và lượt đánh giá từ 4 sao  
            Console.WriteLine("Cau 4: MaKH = 3 va danh gia tu 4 sao: ");
            var makh_danhgia = dcdc.FEEDBACKs.Where(x => x.MaKH == 3 && x.SoDiemDanhGia >= 4).Select(x => new { x.NgayPhanHoi, x.NoiDung });
            foreach(var t in makh_danhgia)
            {
                Console.WriteLine($"{t.NgayPhanHoi} - {t.NoiDung}");
            }
            Console.WriteLine("-----------------------------------------------");
            //5. lấy tên của khách hàng đã đánh giá 5 sao
            Console.WriteLine("Cau 5: Ten Khach hang danh gia 5 sao: ");
            var danhgia = dcdc.FEEDBACKs.Where(x => x.SoDiemDanhGia == 5).Select(x => new { x.MaKH });
            foreach ( var t in danhgia)
            {
                var ten = dcdc.CUSTOMERs.Where(s => s.MaKH == t.MaKH).Select(s => new { s.HoTen, s.SDT });
                foreach(var r in ten)
                {
                    Console.WriteLine($"{r.HoTen} - {r.SDT}");
                }
            }
            Console.WriteLine("-----------------------------------------------");
            //6. lấy ra tên và tổng số tiền mà khách hàng đã mua đồ tại Circle K
            Console.WriteLine("Cau 6: Ten va so tien: ");
            var tien = dcdc.INVOICEs.Select(x => new { x.MaKH, x.TongSoTien });
            foreach( var t in tien)
            {
                var ten = dcdc.CUSTOMERs.Where(s => s.MaKH == t.MaKH).Select(x => new { x.HoTen });
                foreach ( var r in ten)
                {
                    Console.WriteLine($"{r.HoTen} - {t.TongSoTien}");
                }
            }
            Console.WriteLine("-----------------------------------------------");
            //7.tìm những sản phẩm của Vinamilk có đơn giá trên 25000
            Console.WriteLine("Cau 7: San Pham cua Vinamilk co don gia tren 25000");
            var nhacungcap = dcdc.SUPPLIERs.Where(x => x.TenNCC.Equals("Vinamilk")).Select(y => new { y.MaNCC});
            foreach( var t in nhacungcap)
            {
                var sanpham = dcdc.PRODUCTs.Where(e => e.MaNCC == t.MaNCC && e.DonGia > 25000).Select(q => new { q.TenSP, q.DonGia });
                foreach( var r in sanpham)
                {
                    Console.WriteLine($"{r.TenSP} - {r.DonGia}");
                }
            }
            Console.WriteLine("-----------------------------------------------");
            //8. Đếm số lượng nhân viên trong Circle K
            Console.WriteLine("Cau 8: So luong nhan vien trong Circle K ");
            int soluongnhanvien = dcdc.EMPLOYEEs.Count();
            Console.WriteLine(soluongnhanvien);
            Console.WriteLine("-----------------------------------------------");
            //9. Tính tổng sản phẩm của mỗi nhà cung cấp
            Console.WriteLine("Cau 9: Tong san pham cua moi nha cung cap");
            var tongsanpham = dcdc.PRODUCTs.GroupBy(x => x.MaNCC).Select(y => new { mancc = y.Key, tong = y.Count() });
            foreach( var t in tongsanpham)
            {
                var tenncc = dcdc.SUPPLIERs.Where(v => v.MaNCC == t.mancc).Select(d => new { d.TenNCC });
                foreach( var r in tenncc)
                {
                    Console.WriteLine($"{r.TenNCC} - {t.tong}");
                }
            }
            Console.WriteLine("-----------------------------------------------");
            //10. tính tổng số tiền trung bình của các khách hàng 
             Console.WriteLine("Cau 10: Tinh tong so tien trung binh cua cac khach hang: ");
 	     double tong_invoice = (double) dcdc.INVOICEs.Sum(s => s.TongSoTien);
 	     int soluong = dcdc.CUSTOMERs.Count();
 	     Console.WriteLine(tong_invoice/soluong);
            Console.WriteLine("-----------------------------------------------");
            //11. Lấy ra những phiếu khuyến mãi được áp dụng trong thời gian hiện tại 
            Console.WriteLine("Cau 11: khuyen mai dang dien ra");
            var khuyenmai = dcdc.PROMOTIONs
                .Where(x => x.ThoiGianBatDau <= DateTime.Now && x.ThoiGianKetThuc >= DateTime.Now)
                .Select(x => new { x.NoiDung, x.MucGiamGia, x.ThoiGianBatDau, x.ThoiGianKetThuc });

            foreach (var km in khuyenmai)
            {
                Console.WriteLine($"Khuyen Mai: {km.NoiDung}, Giam Gia: {km.MucGiamGia}%, Bat Dau: {km.ThoiGianBatDau}, Ket Thuc: {km.ThoiGianKetThuc}");
            }
            Console.WriteLine("-----------------------------------------------");
            //12. tìm sản phẩm hết hạn trong 30 ngày tính từ ngày thời điểm hiện tại 
            Console.WriteLine("Cau 12: San pham het han trong 30 ngay");
            var today = DateTime.Now;
            var sapHetHan = dcdc.PRODUCTs
                .Where(x => x.HanSuDung <= today.AddDays(30))
                .Select(x => new { x.TenSP, x.HanSuDung, x.NoiSanXuat });

            foreach (var sp in sapHetHan)
            {
                Console.WriteLine($"Ten SP: {sp.TenSP}, Han SD: {sp.HanSuDung:d}, Noi SX: {sp.NoiSanXuat}");
            }
            Console.WriteLine("-----------------------------------------------");
            //13. Với mỗi Tên Công việc lấy ra tên của từng nhân viên trong đó 
            Console.WriteLine("Cau 13: Lay ra nhan vien cua tung cong viec");
            var congviec = dcdc.JOB_TITLEs.Select(x => new { x.TenCV, x.MaCV });
            foreach (var job in congviec) 
            {
                Console.WriteLine($"{job.TenCV}");
                var nhanvien = dcdc.EMPLOYEEs.Where(s => s.MaCV == job.MaCV).Select(e => new { e.HoTen });
                foreach ( var nv in nhanvien)
                {
                    Console.WriteLine($"{nv.HoTen}");
                }
            }
            Console.WriteLine("-----------------------------------------------");
            //14. Với mỗi nhà cung cấp tính tổng đơn giá của các sản phẩm của nhà cung cấp 
            Console.WriteLine("Cau 14: Don gia cua nha cung cap.");
            var cungcap = dcdc.PRODUCTs.GroupBy(x => x.MaNCC).Select(y => new { mancc = y.Key, tongdongia = y.Sum(r => r.DonGia)});
            var tennccap = dcdc.SUPPLIERs.Select(x => new { x.TenNCC, x.MaNCC });
            foreach (var supplier in tennccap) 
            {
                foreach (var cung in cungcap)
                {
                    if(supplier.MaNCC == cung.mancc)
                    {
                        Console.WriteLine($"{supplier.TenNCC} - {cung.tongdongia}");
                        break;
                    }
                }
             }
            Console.WriteLine("-----------------------------------------------");
            //15. lấy ra sản phẩm thuộc nhóm đồ uống và sắp xếp theo đơn giá giảm dần 
            Console.WriteLine("Cau 15: Sam phan do uong.");
            var noibang = dcdc.PRODUCTs.Join(dcdc.CATEGORies, a => a.MaNhom, b => b.MaNhom, (a, b) => new { a.TenSP, b.TenNhom, a.DonGia }).Where(s => s.TenNhom.Equals("Đo uong")).OrderByDescending(y => y.DonGia).Select(d => new { d.TenSP, d.DonGia });
            foreach (var supplier in noibang)
            {
                Console.WriteLine($"{supplier.TenSP} - {supplier.DonGia}");
            }
            Console.WriteLine("-----------------------------------------------");
            //16. lấy ra sản phẩm thuộc nhóm đồ ăn và sắp xếp theo đơn giá tăng dần 
            Console.WriteLine("Cau 16: Sam phan do an.");
            var noibang_A = dcdc.PRODUCTs.Join(dcdc.CATEGORies, a => a.MaNhom, b => b.MaNhom, (a, b) => new { a.TenSP, b.TenNhom, a.DonGia }).Where(s => s.TenNhom.Equals("Đo an")).OrderBy(y => y.DonGia).Select(d => new { d.TenSP, d.DonGia });
            foreach (var supplier in noibang_A)
            {
                Console.WriteLine($"{supplier.TenSP} - {supplier.DonGia}");
            }
            Console.WriteLine("-----------------------------------------------");
            //17. lấy ra thông tin khách hàng đã đánh giá và sắp xếp tăng dần theo số lần mua 
            Console.WriteLine("Cau 17: Thong tin khach hang danh gia va duoc sap xep theo so lan mua");
            var tt_khachhang = dcdc.CUSTOMERs.Join(dcdc.FEEDBACKs, tt => tt.MaKH, b => b.MaKH, (tt, b) => new { tt.HoTen, tt.SoLanMua,  b.NoiDung, b.SoDiemDanhGia }).Where(s => s.SoDiemDanhGia != null).OrderBy(y => y.SoLanMua).Select(d => new { d.HoTen, d.SoLanMua, d.NoiDung });
            foreach (var tt in tt_khachhang)
            {
                Console.WriteLine($"{tt.HoTen} - {tt.NoiDung} - {tt.SoLanMua}");
            }
            Console.WriteLine("-----------------------------------------------");
            //18. lấy ra thông tin khách hàng không đánh giá của hàng Circle K
            Console.WriteLine("Cau 18: Thong tin khach hang chua danh gia Circle K");
            var chua_phanhoi = from a in dcdc.CUSTOMERs join b in dcdc.FEEDBACKs on a.MaKH equals b.MaKH into ordergroup from b in ordergroup.DefaultIfEmpty() where (b.SoDiemDanhGia == null) select new { a.HoTen, a.SDT};
            foreach (var t in chua_phanhoi)
            {
                Console.WriteLine($"{t.HoTen} - {t.SDT}");
            }
            Console.WriteLine("-----------------------------------------------");
            //19. lấy ra thông tin khách hàng mua đơn dưới 100k kèm theo lời phải hồi 
            Console.WriteLine("Cau 19: Thong tin khach hang mua duoi 100000 va kem theo loi phan hoi");
            var donduoi100 = dcdc.INVOICEs.Where(s => s.TongSoTien <= 100000).Select(s => new { s.MaKH, s.TongSoTien });
            foreach (var s in donduoi100)
            {
                var thongtinkhachhang = dcdc.CUSTOMERs.Where(x => x.MaKH == s.MaKH).Select(y => new { y.HoTen });
                foreach (var o in thongtinkhachhang)
                {
                    var phanhoitukhachhang = dcdc.FEEDBACKs.Where(n => n.MaKH == s.MaKH).Select(a => new { a.NoiDung });
                    foreach (var q in phanhoitukhachhang)
                    {
                        Console.WriteLine($"{o.HoTen} - {q.NoiDung} - {s.TongSoTien}");
                    }
                }
            }
            Console.WriteLine("-----------------------------------------------");
            //20. Tính tổng số tiền của các hóa đơn theo khách hàng và sắp xếp theo thứ tự giảm dần của tổng tiền
            Console.WriteLine("Cau 20: Tong tien hoa don theo khach hang duoc sap xep giam dan");
            var tongTienTheoKhachHang = dcdc.INVOICEs.GroupBy(hd => hd.MaKH).Select(g => new{MaKH = g.Key, TongTien = g.Sum(hd => hd.TongSoTien) }).OrderByDescending(s => s.TongTien);

            foreach (var r in tongTienTheoKhachHang)
            {
                var khachHang = dcdc.CUSTOMERs.Where(kh => kh.MaKH == r.MaKH).Select(x => new { x.HoTen, x.SDT });
                foreach(var o in khachHang)
                {
                    Console.WriteLine($"{o.HoTen} - {o.SDT} - {r.TongTien}");
                }
            }
            Console.WriteLine("-----------------------------------------------");

            Console.ReadKey();
        }
    }
}
