package pl.dudekjunior.DutySchedule.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dudekjunior.DutySchedule.models.entities.PlaceOfGuardEntity;

@Repository
public interface PlaceOfGuardRepository extends CrudRepository<PlaceOfGuardEntity, Integer> {
}
