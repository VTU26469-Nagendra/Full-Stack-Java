package com.nagendra.campuseventportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nagendra.campuseventportal.entity.Registration;
import com.nagendra.campuseventportal.repository.RegistrationRepository;

@Controller
public class AdminController {

    @Autowired
    private RegistrationRepository registrationRepository;

    // ✅ ADMIN LOGIN PAGE
    @GetMapping("/admin-login")
    public String showAdminLogin() {
        return "admin-login";
    }

    // ✅ ADMIN LOGIN LOGIC
    @PostMapping("/admin-login")
    public String adminLogin(@RequestParam String username,
                             @RequestParam String password) {

        if(username.equals("admin") && password.equals("admin123")) {
            return "redirect:/admin-dashboard";
        } else {
            return "redirect:/admin-login?error=true";
        }
    }

    // ✅ ADMIN DASHBOARD (NEW URL)
    @GetMapping("/admin-dashboard")
    public String adminDashboard(Model model) {

        List<Registration> registrations = registrationRepository.findAll();
        model.addAttribute("registrations", registrations);

        return "admin-dashboard";
    }

    // ❌ OLD URL (OPTIONAL - you can keep or remove)
    @GetMapping("/admin")
    public String oldAdminRedirect() {
        return "redirect:/admin-dashboard";
    }

    // ✅ DELETE FUNCTION
    @GetMapping("/admin/delete/{id}")
    public String deleteRegistration(@PathVariable int id) {

        registrationRepository.deleteById(id);

        return "redirect:/admin-dashboard";
    }
}