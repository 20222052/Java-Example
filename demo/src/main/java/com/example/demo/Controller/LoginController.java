package com.example.demo.Controller;

import com.example.demo.Model.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    // Danh sách account mẫu
    private List<Account> taiKhoanMau = new ArrayList<>();

    public LoginController() {
        // Khởi tạo dữ liệu mẫu
        taiKhoanMau.add(new Account(1, "admin", "0123456789", "admin@gmail.com", "123456"));
        taiKhoanMau.add(new Account(2, "user1", "0987654321", "user1@gmail.com", "111111"));
    }


    @GetMapping
    public String login() {
        return "Login";
    }

    @PostMapping("/")
    public String loginPost(HttpServletRequest request, Model model, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        for (Account acc : taiKhoanMau) {
            if (acc.getUserName().equals(username) && acc.getPassword().equals(password)) {
                session.setAttribute("account", acc); // Lưu vào session
                return "redirect:/";
            }
        }

        // Nếu sai thông tin
        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
        return "Login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa toàn bộ session
        return "redirect:/login";
    }
}
