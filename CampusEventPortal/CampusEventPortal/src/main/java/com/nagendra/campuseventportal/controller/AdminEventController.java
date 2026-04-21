package com.nagendra.campuseventportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nagendra.campuseventportal.entity.Event;
import com.nagendra.campuseventportal.repository.EventRepository;

@Controller
public class AdminEventController {

    @Autowired
    private EventRepository eventRepository;

    // Show all events
    @GetMapping("/admin/events")
    public String viewEvents(Model model) {

        model.addAttribute("events", eventRepository.findAll());

        return "admin-events";
    }

    // Show add event form
    @GetMapping("/admin/add-event")
    public String showEventForm(Model model) {

        model.addAttribute("event", new Event());

        return "add-event";
    }

    // Save event
    @PostMapping("/admin/save-event")
    public String saveEvent(@ModelAttribute Event event) {

        eventRepository.save(event);

        return "redirect:/admin/events";
    }

    // Delete event
    @GetMapping("/admin/delete-event/{id}")
    public String deleteEvent(@PathVariable Long id) {

        eventRepository.deleteById(id);

        return "redirect:/admin/events";
    }
}