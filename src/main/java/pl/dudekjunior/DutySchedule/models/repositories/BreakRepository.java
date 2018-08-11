package pl.dudekjunior.DutySchedule.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dudekjunior.DutySchedule.models.entities.BreakEntity;

@Repository
public interface BreakRepository extends CrudRepository<BreakEntity, Integer> {
}
