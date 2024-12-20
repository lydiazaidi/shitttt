package mini.projet.archi.models;
import jakarta.persistence.*;
import mini.projet.archi.enumeration.Role;



@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_admin;
    private String nom;
    private String mot_de_passe;

    @Enumerated(EnumType.STRING)
    private Role role;
    public void setIdAdmin(Long id_admin) {
        this.id_admin = id_admin;
    }
    public void setMotDePasse(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Long getIdAdmin() {
        return id_admin;
    }
    public String getMotDePasse() {
        return mot_de_passe;
    }
    public String getNom() {
        return nom;
    }
    public Role getRole() {
        return role;
    }
    
}
