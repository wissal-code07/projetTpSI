package tp.isilB.conferenceles.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import tp.isilB.conferenceles.entities.Evaluation;

public interface EvaluationRepository extends CrudRepository<Evaluation, Long>{

    // Trouver les évaluations par soumission
    List<Evaluation> findBySoumissionId(Long soumissionId);
    // Trouver les évaluations par évaluateur
    List<Evaluation> findByEvaluateurId(Long evaluatorId);
}
