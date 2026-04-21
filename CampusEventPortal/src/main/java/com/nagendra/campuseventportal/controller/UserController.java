package com.nagendra.campuseventportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nagendra.campuseventportal.entity.User;
import com.nagendra.campuseventportal.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // ================= SIGNUP =================

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute User user, Model model) {

        User existingUser = userRepository.findByVtuNo(user.getVtuNo());

        if (existingUser != null) {
            model.addAttribute("error", "User already exists!");
            return "signup";
        }

        user.setRole("USER");

        // 🔐 Encrypt password before saving
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);

        return "redirect:/login";
    }

    // ================= LOGIN =================

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam int vtuNo,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        User user = userRepository.findByVtuNo(vtuNo);

        // 🔐 Match encrypted password
        if (user != null && encoder.matches(password, user.getPassword())) {

            session.setAttribute("loggedInUser", user);

            // Role-based login
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin-dashboard";
            }

            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Invalid VTU No or Password");
        return "login";
    }

    // ================= USER DASHBOARD =================

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }

        return "dashboard";
    }

    // ================= EVENT REGISTRATION =================

    @PostMapping("/register-event")
    public String registerEvent(@RequestParam String eventName,
                                HttpSession session,
                                Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("message", "Successfully registered for " + eventName);

        return "dashboard";
    }

    // ================= LOGOUT =================

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}