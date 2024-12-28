package tp.isilB.conferenceles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.isilB.conferenceles.entities.Evaluation;
import tp.isilB.conferenceles.repositories.EvaluationRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class ServiceEvaluation {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getAllEvaluations() {
        List<Evaluation> evaluations = new ArrayList<>();
        evaluationRepository.findAll().forEach(evaluations::add);
        return evaluations;
    }

    public Optional<Evaluation> getEvaluationById(Long id) {

        return evaluationRepository.findById(id);
    }

    public Evaluation createEvaluation(Evaluation evaluation) {

        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(Long id, Evaluation evaluationDetails) {
        Optional<Evaluation> evaluation = evaluationRepository.findById(id);
        if (evaluation.isPresent()) {
            Evaluation eval = evaluation.get();
            eval.setScore(evaluationDetails.getScore());
            eval.setCommentaires(evaluationDetails.getCommentaires());
            eval.setStatus(evaluationDetails.getStatus());
            return evaluationRepository.save(eval);
        } else {
            throw new RuntimeException("Evaluation not found with id " + id);
        }
    }

    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }

}
