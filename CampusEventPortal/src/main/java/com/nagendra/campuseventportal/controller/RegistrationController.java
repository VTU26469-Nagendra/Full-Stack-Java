package com.nagendra.campuseventportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nagendra.campuseventportal.entity.Registration;
import com.nagendra.campuseventportal.repository.RegistrationRepository;

import jakarta.servlet.http.HttpServletResponse;

// PDF
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@Controller
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    // ✅ OPEN REGISTRATION PAGE
    @GetMapping("/register/{eventName}")
    public String showRegistrationForm(@PathVariable String eventName, Model model) {

        Registration registration = new Registration();
        registration.setEventName(eventName);

        model.addAttribute("registration", registration);

        return "register"; // 🔥 MUST match file name
    }

    // ✅ SAVE DATA
    @PostMapping("/register")
    public String saveRegistration(@ModelAttribute Registration registration) {

        registrationRepository.save(registration);

        return "redirect:/ticket/" + registration.getId();
    }

    // ✅ SHOW TICKET
    @GetMapping("/ticket/{id}")
    public String showTicket(@PathVariable Integer id, Model model) {

        Registration reg = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        model.addAttribute("registration", reg);

        return "ticket";
    }

    // ✅ DOWNLOAD PDF
    @GetMapping("/ticket/pdf/{id}")
    public void downloadTicketPdf(@PathVariable Integer id, HttpServletResponse response) throws Exception {

        Registration reg = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=ticket.pdf");

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Campus Event Portal Ticket"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Name: " + reg.getName()));
        document.add(new Paragraph("VTU No: " + reg.getVtuNo()));
        document.add(new Paragraph("Department: " + reg.getDepartment()));
        document.add(new Paragraph("Year: " + reg.getYear()));
        document.add(new Paragraph("Register Number: " + reg.getRegisterNumber()));
        document.add(new Paragraph("Event: " + reg.getEventName()));

        document.close();
    }
}