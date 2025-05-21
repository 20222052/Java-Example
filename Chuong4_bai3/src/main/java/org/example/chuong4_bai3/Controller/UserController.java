package org.example.chuong4_bai3.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.chuong4_bai3.Model.User;
import org.example.chuong4_bai3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("user") User user,
                              Model model,
                              RedirectAttributes redirectAttributes,
                              HttpSession session) {
        User userNew = userRepository.findByUsername(user.getUsername());

        if (userNew != null && userNew.getPassword().equals(user.getPassword())) {
            // Đăng nhập thành công: lưu user vào session
            session.setAttribute("userSession", userNew);
            return "redirect:/"; // hoặc trang chính sau khi đăng nhập
        } else {
            // Đăng nhập thất bại
            redirectAttributes.addFlashAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "redirect:/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userSession");
        return "redirect:/login";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
