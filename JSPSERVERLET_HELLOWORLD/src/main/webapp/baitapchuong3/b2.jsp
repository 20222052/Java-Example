<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Bảng Sinh viên</title>
  <!-- Nhúng Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    /* Thiết lập màu chữ, màu nền và màu viền tùy chỉnh */
    table.custom-table {
      background-color: #f0f8ff; /* màu nền bảng */
      color: #333; /* màu chữ */
      border: 2px solid #007bff; /* màu viền bảng */
    }

    table.custom-table th, table.custom-table td {
      border: 1px solid #007bff; /* màu viền ô */
    }

    table.custom-table th {
      background-color: #007bff; /* nền tiêu đề */
      color: white; /* chữ tiêu đề */
    }
  </style>
</head>
<body>
  <div class="container mt-4">
    <h2 class="text-center">Danh sách sinh viên</h2>
    <table class="table custom-table text-center">
      <thead>
        <tr>
          <th>STT</th>
          <th>Mã SV</th>
          <th>Họ và tên</th>
          <th>Quê quán</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>SV001</td>
          <td>Nguyễn Văn A</td>
          <td>Hà Nội</td>
        </tr>
        <tr>
          <td>2</td>
          <td>SV002</td>
          <td>Trần Thị B</td>
          <td>Đà Nẵng</td>
        </tr>
      </tbody>
    </table>
  </div>
</body>
</html>
