package tp.isilB.conferenceles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.isilB.conferenceles.entities.Conference;
import tp.isilB.conferenceles.entities.RoleUtilisateurConference;
import tp.isilB.conferenceles.entities.Utilisateur;
import tp.isilB.conferenceles.repositories.RoleUtilisateurConferenceRepository;

import java.util.List;

@Service

public class ServiceRoleUtilisateurConference {

    @Autowired
    private RoleUtilisateurConferenceRepository userConferenceRoleRepository;
    public void assignRoleToUserInConference(Utilisateur user, Conference conference, String role) {
        RoleUtilisateurConference userConferenceRole = new RoleUtilisateurConference();
        userConferenceRole.setUser(user);
        userConferenceRole.setConference(conference);
        userConferenceRole.setRole(role);
        userConferenceRoleRepository.save(userConferenceRole);
    }

    public List<RoleUtilisateurConference> getUserRolesInConference(Long userId, Long conferenceId) {
        return userConferenceRoleRepository.findByUserIdAndConferenceId(userId, conferenceId);
    }

}
