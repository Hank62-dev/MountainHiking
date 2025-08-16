# 🏔️ Mountain Hiking Challenge Registration

## 📌 Giới thiệu
Xin chào! Mình là **Võ Gia Huy**, thành viên **CLB F-code**, đây là project Java trong môn **LAB211 Assignment – OOP with Java**.  

Dự án **Mountain Hiking Challenge Registration** được xây dựng nhằm hỗ trợ quản lý thông tin đăng ký của sinh viên **FPT University** tham gia phong trào *"Because a Generation of Intellectuals Dares to Think and Do"*, được tài trợ bởi **Viettel** và **VNPT**.  

Mục tiêu của chương trình là cho phép sinh viên trên toàn quốc đăng ký tham gia thử thách chinh phục các đỉnh núi, đồng thời quản lý dữ liệu đăng ký một cách khoa học và áp dụng đầy đủ các nguyên lý **OOP (Abstraction, Encapsulation, Inheritance, Polymorphism).**

---

## ⚙️ Công nghệ sử dụng
- **Ngôn ngữ:** Java  
- **Paradigm:** Object-Oriented Programming (OOP)  
- **File Data:** CSV (MountainList.csv), Object File (registrations.dat)  

---

## 📖 Chức năng chính
Chương trình cung cấp các tính năng sau:

1. **New Registration** – Đăng ký mới cho sinh viên.  
2. **Update Registration** – Cập nhật thông tin đã đăng ký.  
3. **Display Registered List** – Hiển thị danh sách sinh viên đã đăng ký.  
4. **Delete Registration** – Xóa thông tin đăng ký.  
5. **Search by Name** – Tìm kiếm sinh viên theo tên.  
6. **Filter by Campus** – Lọc dữ liệu theo cơ sở (HCM, Hà Nội, Đà Nẵng, Cần Thơ, Quy Nhơn).  
7. **Statistics by Location** – Thống kê số lượng đăng ký theo từng đỉnh núi.  
8. **Save Data to File** – Lưu dữ liệu vào file `registrations.dat`.  
9. **Exit** – Thoát chương trình.  

---

## 🧾 Quy tắc & Ràng buộc
- **MSSV**: 8 ký tự, 2 ký tự đầu là mã cơ sở (SE, HE, DE, QE, CE).  
- **Tên**: từ 2–20 ký tự, không được bỏ trống.  
- **SĐT**: 10 số, phải thuộc nhà mạng Việt Nam.  
- **Email**: đúng chuẩn `example@domain.com`.  
- **Mã núi**: lấy từ file `MountainList.csv`.  
- **Học phí**:  
  - Mặc định: `6,000,000 VND`  
  - Giảm **35%** nếu SĐT thuộc Viettel hoặc VNPT.  

---


