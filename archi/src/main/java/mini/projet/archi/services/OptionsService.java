package mini.projet.archi.services;

import mini.projet.archi.models.Options;
import mini.projet.archi.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsService {

    private final OptionRepository optionsRepository;

    @Autowired
    public OptionsService(OptionRepository optionsRepository) {
        this.optionsRepository = optionsRepository;
    }

    public List<Options> getAllOptions() {
        return optionsRepository.findAll();
    }

    public List<Options> getOptionsByIds(List<Long> ids) {
        return optionsRepository.findAllById(ids);
    }

    public void save(Options option) {
        optionsRepository.save(option);
    }
}