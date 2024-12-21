package mini.projet.archi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import mini.projet.archi.enumeration.Disponibilite;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_voiture;
    private String modele;
    private Float prix;

    @Enumerated(EnumType.STRING)
    private Disponibilite disponibilite;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_disponibilite;

    private String photo;
    

    public long getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(long id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Disponibilite getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Disponibilite disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Date getDate_disponibilite() {
        return date_disponibilite;
    }

    public void setDate_disponibilite(Date date_disponibilite) {
        this.date_disponibilite = date_disponibilite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @ManyToMany
    @JoinTable(
        name = "voiture_option",
        joinColumns = @JoinColumn(name = "voiture_id"),
        inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private Set<Options> options = new HashSet<>();

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }
}