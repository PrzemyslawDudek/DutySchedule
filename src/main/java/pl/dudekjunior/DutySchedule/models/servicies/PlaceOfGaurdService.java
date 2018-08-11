package pl.dudekjunior.DutySchedule.models.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dudekjunior.DutySchedule.models.entities.PlaceOfGuardEntity;
import pl.dudekjunior.DutySchedule.models.repositories.PlaceOfGuardRepository;

@Service
public class PlaceOfGaurdService {

    private final PlaceOfGuardRepository placeOfGuardRepository;
    @Autowired
    public PlaceOfGaurdService(PlaceOfGuardRepository placeOfGuardRepository) {
        this.placeOfGuardRepository = placeOfGuardRepository;
    }

    public Iterable<PlaceOfGuardEntity> getAllPlaces(){
        return placeOfGuardRepository.findAll();
    }
}
