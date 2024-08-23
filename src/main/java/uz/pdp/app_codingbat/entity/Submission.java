package uz.pdp.app_codingbat.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import uz.pdp.app_codingbat.entity.template.AbsLongEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "submission")
public class Submission extends AbsLongEntity {
    @Column(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    @Column(name = "problem_id", nullable = false)
    @ManyToOne
    private Problem problem;

    @Column(nullable = false)
    private String status;

    private String solution;

    private String massage;

    private String methodName;

    private Boolean answer = false;
}
