Câu 1:
GroupId là id của nhóm dự án. Nói chung, nó là duy nhất trong một tổ chức.
ArtifactId là id của dự án. Nó chỉ định tên của dự án.

Câu 2:
Phải đảo ngược tên miền để dễ dàng nhóm các miền có cùng groupid.

Câu 3:
SpringBoot có 2 cơ chế để quản lý thư viện là Gradle và Maven.

Câu 4:
File pom.xml là nơi khai báo tất cả những gì liên quan đến dự án được cấu hình qua maven, như khai báo các dependency, version của dự án, tên dự án, repossitory …

Câu 5:
Các thẻ dependency là các thư viện được sử dụng trong dự án.

Câu 6:
Controller trong ứng dụng Spring Boot là nơi tiếp nhận request và trả về response cho client. Có thể hiểu controller chính là lớp trung gian giữa server của bạn và bên ngoài.

Câu 7:
@RequestMapping cấp class ánh xạ một đường dẫn hoặc mẫu request cụ thể lên controller, @RequestMapping cấp function để làm cho ánh xạ cụ thể hơn đối với các phương thức xử lý.
Các tham số khác ngoài value: HTTP Methods (GET, POST, PATCH, PUT, DELETE), produces, headers, params.

Câu 8:
@RequestResponse khi đặt trong hàm hứng request để yêu cầu kết quả phản hồi từ sever.

Câu 9:
@RequestParam và @PathVariable annotation đều được sử dụng để trích xuất dữ liệu từ request URL.
-	@RequestParam được dùng để trích xuất dữ liệu từ request query.
-	@PathVariable thì được dùng để trích xuất dữ liệu từ URL path.

Câu 10:
Thứ tự các thành phần đường dẫn @PathVariable không thể hoán đổi được.

Câu 11:
@Getmapping là chỉ báo thực hiện GET request, @PostMapping là chỉ báo thực hiện Post request.
GET và POST là hai loại yêu cầu HTTP khác nhau. GET được sử dụng để xem nội dung nào đó mà không cần thay đổi nội dung đó, trong khi POST được sử dụng để thay đổi nội dung nào đó.

Câu 12:
Trong các annotation @RequestMapping, @GetMapping, @PostMapping… có tham số produces = MediaType.XXXX để xác định các annotation request trên tạo ra giữ liệu kiểu gì.

Câu 13:
@RequestBody sẽ gửi thông tin bổ sung theo yêu cầu của máy chủ để xử lý Request Post hiện tại.

Câu 14: 
Cách để thay đổi cổng lắng nghe mặc định là điều chỉnh giá trị server.port trong application.properties hayapplication.yml tương ứng.
-	application.properties -> server.port=8081
-	application.yml -> server: port : 8081
Cả hai tệp đều được Spring Boot tải tự động nếu được đặt trong thư mục src / main / resources của ứng dụng Maven.
