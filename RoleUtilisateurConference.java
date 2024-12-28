package tp.isilB.conferenceles.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleUtilisateurConference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateurId")
    private Utilisateur user;

    @ManyToOne
    @JoinColumn(name = "conference_id", referencedColumnName = "conferenceId")
    private Conference conference;
}
