package pl.dudekjunior.DutySchedule.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
