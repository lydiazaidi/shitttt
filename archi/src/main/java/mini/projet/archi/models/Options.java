package mini.projet.archi.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Float prix;

    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }
    public String getDescription() {
        return description;
    }
    public Long getId() {
        return id;
    }
    public Float getPrix() {
        return prix;
    }

}