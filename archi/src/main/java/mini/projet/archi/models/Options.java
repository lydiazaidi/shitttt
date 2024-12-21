package mini.projet.archi.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "options")
public class Options {
    public Options() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double option_prix;

    @ManyToMany(mappedBy = "options")
    private Set<Voiture> voitures;
    public Options(String description, Double option_prix) {
        this.description = description;
        this.option_prix = option_prix;
    }
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getOption_prix() {
        return option_prix;
    }

    public void setOption_prix(Double option_prix) {
        this.option_prix = option_prix;
    }

    public Set<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(Set<Voiture> voitures) {
        this.voitures = voitures;
    }
}
