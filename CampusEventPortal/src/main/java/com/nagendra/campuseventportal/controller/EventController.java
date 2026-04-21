package com.nagendra.campuseventportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nagendra.campuseventportal.entity.Event;
import com.nagendra.campuseventportal.repository.EventRepository;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // ================= ADD EVENT =================

    @GetMapping("/add-event")
    public String showEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "event-form";
    }

    @PostMapping("/save-event")
    public String saveEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/events";   // after saving → go to events page
    }

    // ================= VIEW EVENTS =================

    @GetMapping("/events")
    public String viewEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "event-list";   // this page shows all events
    }

    // ================= DELETE EVENT =================

    @GetMapping("/delete-event/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/events";
    }

    // ================= EDIT EVENT =================

    @GetMapping("/edit-event/{id}")
    public String editEvent(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);
        model.addAttribute("event", event);
        return "event-form";
    }
}