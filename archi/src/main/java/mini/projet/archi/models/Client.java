package mini.projet.archi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private String nom;
    private String email;
    private String mot_de_passe;
    private String telephone;
    private String adresse;

    public String getAdresse() {
        return adresse;
    }
    public String getEmail() {
        return email;
    }
    public Long getIdClient() {
        return id_client;
    }
    public String getMotDePasse() {
        return mot_de_passe;
    }
    public String getNom() {
        return nom;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setIdClient(Long id_client) {
        this.id_client = id_client;
    }
    public void setMotDePasse(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
}

