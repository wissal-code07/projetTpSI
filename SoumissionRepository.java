package tp.isilB.conferenceles.repositories;

import org.springframework.data.repository.CrudRepository;
import tp.isilB.conferenceles.entities.Utilisateur;
import tp.isilB.conferenceles.entities.Soumission;

import java.util.List;

public interface SoumissionRepository extends CrudRepository<Soumission, Long>{

    Soumission findByTitre(String titre);
    Soumission findByDescription(String description);


    Soumission findByTitreAndDescription(String nom, String description);
    Soumission findByTitreOrDescription(String nom, String description);

    // Trouver les soumissions par conférence
    List<Soumission> findByConferenceId(Long conferenceId);

    // Trouver les soumissions par état
    List<Soumission> findByState(String state);
}
