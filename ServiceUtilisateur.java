package tp.isilB.conferenceles.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.isilB.conferenceles.entities.Utilisateur;
import tp.isilB.conferenceles.repositories.UtilisateurRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUtilisateur {

    @Autowired
    private UtilisateurRepository userRepository;

    public List<Utilisateur> getAllUsers() {

        return UtilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUserById(Long id) {

        return UtilisateurRepository.findById(id);
    }

    public Utilisateur createUser(Utilisateur user) {

        return UtilisateurRepository.save(user);
    }

    public Utilisateur updateUser(Long id, Utilisateur userDetails) {
        Optional<Utilisateur> user = UtilisateurRepository.findById(id);
        if (user.isPresent()) {
            Utilisateur usr = user.get();
            usr.setUsername(userDetails.getUsername()); // Update other fields as necessary
            return userRepository.save(usr);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}


