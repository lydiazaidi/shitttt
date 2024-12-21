package mini.projet.archi.controllers;

import mini.projet.archi.models.Options;
import mini.projet.archi.services.OptionsService; // Correct import

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/options")
public class OptionsController {

    private final OptionsService optionsService; // Correct field declaration

    public OptionsController(OptionsService optionsService) { // Correct constructor
        this.optionsService = optionsService;
    }

    @GetMapping
    public String getAllOptions(Model model) {
        List<Options> options = optionsService.getAllOptions();
        model.addAttribute("options", options);
        return "options"; // Ensure you have a Thymeleaf template named 'options.html'
    }
}