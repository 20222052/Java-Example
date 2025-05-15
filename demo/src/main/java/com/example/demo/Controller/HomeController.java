package com.example.demo.Controller;

import com.example.demo.Model.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(Model model, HttpSession session) {

        Object account = session.getAttribute("account");
        if (account == null) {
            // Chưa đăng nhập → chuyển hướng về trang login
            return "redirect:/Login";
        }

        List<Student> lst_std = new ArrayList<Student>();
        Student std = new Student(1, "Nguyễn văn Vũ", "02938345", "Hà Noi");
        lst_std.add(std);
        model.addAttribute("message", "Hello WorldHello WorldHello World");
        model.addAttribute("students", lst_std);
        return "Home";
    }
}
