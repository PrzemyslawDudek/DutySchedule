package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.PlaceOfGuardEntity;
import pl.dudekjunior.DutySchedule.models.forms.PlaceForm;
import pl.dudekjunior.DutySchedule.models.repositories.PlaceOfGuardRepository;

@Service
public class PlaceOfGaurdService {

    private final PlaceOfGuardRepository placeOfGuardRepository;
    @Autowired
    public PlaceOfGaurdService(PlaceOfGuardRepository placeOfGuardRepository) {
        this.placeOfGuardRepository = placeOfGuardRepository;
    }

    Iterable<PlaceOfGuardEntity> getAllPlaces(){
        return placeOfGuardRepository.findAll();
    }

    public void addPlace(PlaceForm placeForm) {
        PlaceOfGuardEntity place = new PlaceOfGuardEntity();
        place.setName(placeForm.getName());
        placeOfGuardRepository.save(place);
    }
}
