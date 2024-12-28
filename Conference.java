package tp.isilB.conferenceles.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long conferenceId;
    private String title;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String thematique;
    private String etat;

    @OneToMany(mappedBy = "conference")
    private List<Soumission> soumissions;

    // Méthode pour ajouter une soumission à la conférence
    public void addSoumission(Soumission soumission) {
        soumissions.add(soumission);
        soumission.setConference(this);
    }
    // Méthode pour enlever une soumission de la conférence
    public void removeSoumission(Soumission soumission) {
        soumissions.remove(soumission);
        soumission.setConference(null);
    }
}
