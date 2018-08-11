package pl.dudekjunior.DutySchedule.models.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "duty")
@Data
public class DutyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String day;
    @Column(name = "break_id")
    private int breakId;
    @Column(name = "place_id")
    private int placeId;
    @Column(name = "teacher_id")
    private int teacherId;
}
