package tp.isilB.conferenceles.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import tp.isilB.conferenceles.entities.Conference;
import tp.isilB.conferenceles.entities.Soumission;

public interface ConferenceRepository extends CrudRepository<Conference, Long> {

    // Trouver une conférence par titre
    List<Conference> findByTitle(String title);

    // Trouver des conférences par état
    List<Conference> findByState(String state);

    // Trouver des conférences dont la date de début est après une date spécifique
    List<Conference> findByStartDateAfter(LocalDate date);

    // Trouver des conférences dont la date de fin est avant une date spécifique
    List<Conference> findByEndDateBefore(LocalDate date);

    // Trouver des conférences par thématique
    List<Conference> findByThematic(String thematic);

    // Trouver des conférences par titre et état
    List<Conference> findByTitleAndState(String title, String state);

    // Trouver des conférences par thématique et date de début après une date spécifique
    List<Conference> findByThematicAndStartDateAfter(String thematic, LocalDate date);
}


