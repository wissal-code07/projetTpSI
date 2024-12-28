package tp.isilB.conferenceles.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import tp.isilB.conferenceles.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{

    Utilisateur findByNom(String nom);
    Utilisateur findByPrenom(String prenom);
    List<Utilisateur> findByInfos(String infos);

    Utilisateur findByNomAndPrenom(String nom, String prenom);
    Utilisateur findByNomOrPrenom(String nom, String prenom);
}
