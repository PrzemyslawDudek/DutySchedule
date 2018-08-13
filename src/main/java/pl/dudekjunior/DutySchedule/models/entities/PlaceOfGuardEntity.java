package pl.dudekjunior.DutySchedule.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "place_of_guard")
public class PlaceOfGuardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
