package tp.isilB.conferenceles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.isilB.conferenceles.entities.Evaluation;
import tp.isilB.conferenceles.services.ServiceEvaluation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluations")
public class ControlleurEvaluation {

    @Autowired
    private ServiceEvaluation evaluationService;

    @GetMapping
    public List<Evaluation> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable Long id) {
        Optional<Evaluation> evaluation = evaluationService.getEvaluationById(id);
        return evaluation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.createEvaluation(evaluation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable Long id, @RequestBody Evaluation evaluationDetails) {
        try {
            Evaluation updatedEvaluation = evaluationService.updateEvaluation(id, evaluationDetails);
            return ResponseEntity.ok(updatedEvaluation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
