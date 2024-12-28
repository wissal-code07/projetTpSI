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

public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Evaluationid;
    private int score;
    private String commentaires;
    private String status;

    // Méthode pour définir la soumission
    @Setter
    @ManyToOne
    private Soumission soumission;

    @ManyToOne
    private Utilisateur evaluateur;

    // Méthode pour mettre à jour le score
    public void updateScore(int newScore) {
        this.score = newScore;
    }
    // Méthode pour mettre à jour les commentaires
    public void updateComments(String newCommentaires) {
        this.commentaires = newCommentaires;
    }
    // Méthode pour mettre à jour le statut
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

}
