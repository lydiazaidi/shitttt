package mini.projet.archi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import mini.projet.archi.models.*;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {}