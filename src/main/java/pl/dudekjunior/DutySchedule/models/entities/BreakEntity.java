package pl.dudekjunior.DutySchedule.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = " break")
public class BreakEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "break_number")
    private int breakNumber;
    @Column(name = "break_length")
    private int breakLength;
    @Column(name = "break_time")
    private String breakTime;

}
