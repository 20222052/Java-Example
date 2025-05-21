package org.example.chuong4_bai4_registeraccount.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.chuong4_bai4_registeraccount.Model.User;
import org.example.chuong4_bai4_registeraccount.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String listAccount(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
//        if (session.getAttribute("user") != null) {
            model.addAttribute("users", userRepository.findAll());
            return "ListAccount";
//        }
//        redirectAttributes.addFlashAttribute("error", "Bạn cần phải đăng nhập");
//        return "redirect:/account/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return "redirect:/account/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            userRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Không thể xóa người dùng này!");
        }
        return "redirect:/account/";
    }

//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable int id) {
//            userRepository.deleteById(id);
//        return "redirect:/account/";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        List<User> users = userRepository.findAll();
        String password = user.getPassword();
        String username = user.getUsername();
        log.debug("POST /login - form data: username={}, password={}", user.getUsername(), user.getPassword());


        for (User u : users) {
            if (u.getUsername().equals(username) && passwordEncoder.matches(password, u.getPassword())) {
                log.debug("POST /login - form data: username={}, password={}", u.getUsername(), u.getPassword());
                model.addAttribute("users", users);
                session.setAttribute("user", u);
                redirectAttributes.addFlashAttribute("message", "Đăng nhập thành công!");
                return "redirect:/account/";
            }
        }
        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
        return "login"; // hoặc "register" nếu bạn không có trang login riêng
    }

    @GetMapping("/logout")
    public String register(RedirectAttributes redirectAttributes, HttpSession session) {
        session.removeAttribute("user");
        redirectAttributes.addFlashAttribute("message", "Đăng xuâất thành công");
        return "redirect:/account/login";
    }
}
