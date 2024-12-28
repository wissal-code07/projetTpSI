package tp.isilB.conferenceles.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;
    private String nom;
    private String prenom;
    private String role;
    @Column(name="infos", nullable=false, length=256)
    private String infos;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
    private Collection<Soumission> soumission;

    @OneToMany(mappedBy = "Utilisateur")
    private List<RoleUtilisateurConference> userConferenceRole;

    public Utilisateur(String nom, String prenom, String infos, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.infos = infos;
        this.role = role;
    }
}
