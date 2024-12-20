package mini.projet.archi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import mini.projet.archi.enumeration.EtatCommande;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commande;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_commande;
    private Float montant_total;

    @Enumerated(EnumType.STRING)
    private EtatCommande etat_commande;

    public Date getDateCommande() {
        return date_commande;
    }
    public EtatCommande getEtatCommande() {
        return etat_commande;
    }
    public Long getIdCommande() {
        return id_commande;
    }
    public Float getMontantTotal() {
        return montant_total;
    }
    public void setDateCommande(Date date_commande) {
        this.date_commande = date_commande;
    }
    public void setEtatCommande(EtatCommande etat_commande) {
        this.etat_commande = etat_commande;
    }
    public void setIdCommande(Long id_commande) {
        this.id_commande = id_commande;
    }
    public void setMontantTotal(Float montant_total) {
        this.montant_total = montant_total;
    }

}
