package tp.isilB.conferenceles.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Soumission {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int soumissionId;
    private String titre;
    private String description;//summary
    private String pdf;
    private String state;

    @ManyToMany
    private List<Utilisateur> auteurs;

    @ManyToOne
    private Conference conference;

    @OneToMany(mappedBy = "soumission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluations;

    public Soumission(String titre, String description, Utilisateur auteur){
        this.titre = titre;
        this.description=description;
        this.auteurs = List.of(auteur);
    }

    // Méthode pour ajouter un auteur
    public void addAuteur(Utilisateur auteur) {
        this.auteurs.add(auteur);
    }

    // Méthode pour enlever un auteur
    public void removeAuteur(Utilisateur auteur) {
        this.auteurs.remove(auteur);
    }

    // Méthode pour ajouter une évaluation
    public void addEvaluation(Evaluation evaluation) {
        this.evaluations.add(evaluation);
        evaluation.setSoumission(this);
    }

    // Méthode pour enlever une évaluation
    public void removeEvaluation(Evaluation evaluation) {
        this.evaluations.remove(evaluation);
        evaluation.setSoumission(null);
    }
}
