package tp.isilB.conferenceles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.isilB.conferenceles.entities.Soumission;
import tp.isilB.conferenceles.services.ServiceSoumission;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/submissions")

public class ControlleurSoumission {

    @Autowired
    private ServiceSoumission submissionService;

    @GetMapping
    public List<Soumission> getAllSubmissions() {
        return submissionService.getAllSoumissions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soumission> getSubmissionById(@PathVariable Long id) {
        Optional<Soumission> submission = submissionService.getSoumissionById(id);
        return submission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Soumission createSubmission(@RequestBody Soumission submission) {
        return submissionService.createSoumission(submission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soumission> updateSubmission(@PathVariable Long id, @RequestBody Soumission submissionDetails) {
        try { Soumission updatedSubmission = submissionService.updateSoumission(id, submissionDetails);
            return ResponseEntity.ok(updatedSubmission);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.noContent().build();
    }
}
