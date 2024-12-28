package tp.isilB.conferenceles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.isilB.conferenceles.entities.Utilisateur;
import tp.isilB.conferenceles.services.ServiceUtilisateur;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")

public class ControlleurUtilisateur {

    @Autowired
    private ServiceUtilisateur userService;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
        Optional<Utilisateur> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Utilisateur createUser(@RequestBody Utilisateur user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable Long id, @RequestBody Utilisateur userDetails) {
        try {
            Utilisateur updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
