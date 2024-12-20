package mini.projet.archi.controllers;

import mini.projet.archi.models.Voiture;
import mini.projet.archi.services.VoitureService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voitures")
public class VoitureController {
    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    // Get all Voitures
    @GetMapping
    public String getAllVoitures(Model model) {
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("voitures", voitures);
        // Ensure a default Voiture object is added if needed
        model.addAttribute("voiture", new Voiture());
        return "voiture"; 
    }

    // Create or Update a Voiture
    @PostMapping
    public String createOrUpdateVoiture(@ModelAttribute Voiture voiture) {
        voitureService.saveVoiture(voiture);
        return "redirect:/voitures"; // After creating/updating, redirect to the list page
    }
    
    // Get Voiture for Update by ID
    @GetMapping("/{id}/edit")
    @ResponseBody
    public Voiture getVoitureForUpdate(@PathVariable Long id) {
        return voitureService.getVoitureById(id).orElse(null);
    }

    // Delete a Voiture by ID
    @GetMapping("/{id}/delete")
    public String deleteVoitureById(@PathVariable Long id) {
        voitureService.deleteVoitureById(id);
        return "redirect:/voitures"; // After deleting, redirect to the list page
    }
}