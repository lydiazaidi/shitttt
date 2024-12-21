package mini.projet.archi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mini.projet.archi.models.Options;
import mini.projet.archi.models.Voiture;
import mini.projet.archi.enumeration.Disponibilite;
import mini.projet.archi.services.OptionsService;
import mini.projet.archi.services.VoitureService;

import java.nio.file.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/voitures")
public class VoitureController {

    private final String uploadDir = Paths.get(System.getProperty("user.dir"), "uploads").toString(); // Absolute path

    @Autowired
    private VoitureService voitureService;

    @Autowired
    private OptionsService optionsService;

    @GetMapping
    public String listVoitures(Model model) {
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("voitures", voitures);
        return "voiture";
    }

    @GetMapping("/{id}/edit")
    public String editVoitureForm(@PathVariable Long id, Model model) {
        Voiture voiture = voitureService.getVoitureById(id).orElse(null);
        if (voiture == null) {
            return "redirect:/voitures?error=VoitureNotFound";
        }
        model.addAttribute("voiture", voiture);
        return "edit_voiture";
    }

    @PostMapping("/{id}")
    public String updateVoiture(
        @PathVariable Long id,
        @ModelAttribute Voiture voiture,
        @RequestParam List<String> optionDescriptions,
        @RequestParam List<Double> optionPrices,
        @RequestParam(value = "photo", required = false) String photoPath // classic method: pass path as a String
    ) {
        voiture.setId_voiture(id);

        // Save the photo path directly
        if (photoPath != null && !photoPath.isEmpty()) {
            voiture.setPhoto(photoPath); // Save the full path in the entity
        }

        // Process options
        voiture.setOptions(createOptionsSet(optionDescriptions, optionPrices));

        voitureService.saveVoiture(voiture);
        return "redirect:/voitures";
    }

    @PostMapping("/{id}/delete")
    public String deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoitureById(id);
        return "redirect:/voitures";
    }

    @PostMapping("/createVoiture")
    public String createVoiture(
        @RequestParam String modele,
        @RequestParam float prix,
        @RequestParam String disponibilite,
        @RequestParam(required = false) String date_disponibilite, // Optional date field
        @RequestParam String photo,
        @RequestParam List<String> optionDescriptions,
        @RequestParam List<Double> optionPrices
    ) {
        Voiture voiture = new Voiture();
        voiture.setModele(modele);
        voiture.setPrix(prix);
        voiture.setDisponibilite(Disponibilite.valueOf(disponibilite));
        if (date_disponibilite != null && !date_disponibilite.isEmpty()) {
            LocalDate localDate = LocalDate.parse(date_disponibilite);
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            voiture.setDate_disponibilite(date);
        }
        voiture.setPhoto(photo);

        // Process options
        Set<Options> optionsSet = new HashSet<>();
        IntStream.range(0, optionDescriptions.size()).forEach(i -> {
            Options option = new Options();
            option.setDescription(optionDescriptions.get(i));
            option.setOption_prix(optionPrices.get(i));
            optionsService.save(option);
            optionsSet.add(option);
        });
        voiture.setOptions(optionsSet);

        // Save voiture
        voitureService.saveVoiture(voiture);

        return "redirect:/voitures";
    }

    private Set<Options> createOptionsSet(List<String> descriptions, List<Double> prices) {
        Set<Options> optionsSet = new HashSet<>();
        IntStream.range(0, descriptions.size()).forEach(i -> {
            Options option = new Options();
            option.setDescription(descriptions.get(i));
            option.setOption_prix(prices.get(i));
            optionsService.save(option);
            optionsSet.add(option);
        });
        return optionsSet;
    }
}