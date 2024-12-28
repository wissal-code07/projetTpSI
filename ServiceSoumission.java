package tp.isilB.conferenceles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.isilB.conferenceles.entities.Soumission;
import tp.isilB.conferenceles.repositories.SoumissionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ServiceSoumission {

    @Autowired
    private SoumissionRepository soumissionRepository;

    public List<Soumission> getAllSoumissions() {
        List<Soumission> soumissions = new ArrayList<>();
        soumissionRepository.findAll().forEach(soumissions::add);
        return soumissions;
    }

    public Optional<Soumission>getSoumissionById(Long id){
        return soumissionRepository.findById(id);
    }

    public Soumission createSoumission(Soumission soumission){
        return soumissionRepository.save(soumission);
    }

    public Soumission updateSoumission(Long id, Soumission soumissionDetails){
        Optional<Soumission>soumission = soumissionRepository.findById(id);
        if(soumission.isPresent()){
            Soumission sub = soumission.get();
            sub.setTitre(soumissionDetails.getTitre());
            sub.setDescription(soumissionDetails.getDescription());
            sub.setPdf(soumissionDetails.getPdf());

            return soumissionRepository.save(sub);

        }
        else {
            throw new RuntimeException("Submission not found with id " + id);
        }
    }

    public void deleteSubmission(Long id) {
        soumissionRepository.deleteById(id);
    }

}
