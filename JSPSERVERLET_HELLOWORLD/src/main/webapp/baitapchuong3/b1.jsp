<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Thẻ H1 với Bootstrap</title>
  <!-- Nhúng Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    /* Class tự tạo để chỉnh màu nền và màu chữ nếu không dùng class có sẵn */
    .custom-bg {
      background-color: yellow; /* Màu nền */
    }

    .custom-text-color {
      color: red; /* Màu chữ */
    }
  </style>
</head>
<body>
  <!-- Thẻ <h1> được căn giữa, viết hoa, chỉnh màu chữ và màu nền -->
  <h1 class="text-center text-uppercase custom-text-color custom-bg">
    Nguyễn Văn A
  </h1>
</body>
</html>
