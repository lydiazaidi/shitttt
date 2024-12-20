package mini.projet.archi.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ReservationTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_test;
    private String etat;

    public Date getDateTest() {
        return date_test;
    }
    public String getEtat() {
        return etat;
    }
    public Long getIdReservation() {
        return id_reservation;
    }
    public void setDateTest(Date date_test) {
        this.date_test = date_test;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public void setIdReservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }

}