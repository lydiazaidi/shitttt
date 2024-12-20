package mini.projet.archi.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_stock;
    private Integer quantite;

    public void setIdStock(Long id_stock) {
        this.id_stock = id_stock;
    }
    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
    public Long getIdStock() {
        return id_stock;
    }
    public Integer getQuantite() {
        return quantite;
    }

}