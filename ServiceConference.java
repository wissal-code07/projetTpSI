package tp.isilB.conferenceles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.isilB.conferenceles.entities.Conference;
import tp.isilB.conferenceles.repositories.ConferenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceConference {

    @Autowired
    private ConferenceRepository conferenceRepository;
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Optional<Conference> getConferenceById(Long id) {
        return conferenceRepository.findById(id);
    }
    public Conference createConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public Conference updateConference(Long id, Conference conferenceDetails) {
        Optional<Conference> conference = conferenceRepository.findById(id);
        if (conference.isPresent()) {
            Conference conf = conference.get();
            conf.setTitle(conferenceDetails.getTitle());
            conf.setStartDate(conferenceDetails.getStartDate());
            conf.setEndDate(conferenceDetails.getEndDate());
            conf.setThematic(conferenceDetails.getThematic());
            conf.setState(conferenceDetails.getState());
            return conferenceRepository.save(conf);
        } else {
            throw new RuntimeException("Conference not found with id " + id);
        }
    }

    public void deleteConference(Long id) {

        conferenceRepository.deleteById(id);
    }
}
