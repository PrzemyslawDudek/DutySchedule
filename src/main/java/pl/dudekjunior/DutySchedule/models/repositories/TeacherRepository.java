package pl.dudekjunior.DutySchedule.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dudekjunior.DutySchedule.models.entities.TeacherEntity;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Integer> {
}
