package mini.projet.archi.services;

import mini.projet.archi.models.Voiture;
import mini.projet.archi.repositories.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {
    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }
    

    // Create or Update a Voiture
    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    // Retrieve all Voitures
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    // Retrieve a Voiture by ID
    public Optional<Voiture> getVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

    // Delete a Voiture by ID
    public void deleteVoitureById(Long id) {
        voitureRepository.deleteById(id);
    }
    
}
