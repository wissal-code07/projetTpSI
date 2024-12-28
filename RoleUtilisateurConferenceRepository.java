package tp.isilB.conferenceles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import tp.isilB.conferenceles.entities.RoleUtilisateurConference;

public interface RoleUtilisateurConferenceRepository extends CrudRepository<RoleUtilisateurConference, Long> {

    // Trouver les rôles des utilisateurs par utilisateur et conférence
    List<RoleUtilisateurConferenceRepository> findByUserIdAndConferenceId(Long id, Long conferenceId);

    // Trouver les rôles des utilisateurs par conférence
    List<RoleUtilisateurConferenceRepository> findByConferenceId(Long conferenceId);

    // Trouver les rôles des utilisateurs par utilisateur
    List<RoleUtilisateurConferenceRepository> findByUserId(Long userId);
}
