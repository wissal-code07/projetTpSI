package tp.isilB.conferenceles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.isilB.conferenceles.entities.Conference;
import tp.isilB.conferenceles.services.ServiceConference;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conferences")

public class ControlleurConference {

    @Autowired
    private ServiceConference conferenceService;

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id) {
        Optional<Conference> conference = conferenceService.getConferenceById(id);
        return conference.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Conference createConference(@RequestBody Conference conference) {
        return conferenceService.createConference(conference);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conference> updateConference(@PathVariable Long id, @RequestBody Conference conferenceDetails) {
        try {
            Conference updatedConference = conferenceService.updateConference(id, conferenceDetails);
            return ResponseEntity.ok(updatedConference);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }
}
